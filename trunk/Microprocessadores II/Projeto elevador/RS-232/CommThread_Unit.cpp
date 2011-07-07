//---------------------------------------------------------------------------
//TCommThread version 6.0 - 30/11/2005
//Luciano Vieira Koenigkan - e-mail: lucianovk@bol.com.br
#include <vcl.h>
#pragma hdrstop

#include "CommThread_Unit.h"
#pragma package(smart_init)
//---------------------------------------------------------------------------

//   Important: Methods and properties of objects in VCL can only be
//   used in a method called using Synchronize, for example:
//
//      Synchronize(UpdateCaption);
//
//   where UpdateCaption could look like:
//
//      void __fastcall Unit2::UpdateCaption()
//      {
//        Form1->Caption = "Updated in a thread";
//      }
//---------------------------------------------------------------------------

__fastcall TCommThread::TCommThread()
        : TThread(true),ReturnMethod(NULL)
{
        //Inicializando os atributos
        Connected=false;
        FreeOnTerminate = false;

        DeviceName="COM1";

        MyDCB.DCBlength=sizeof(DCB);
        MyDCB.BaudRate=9600;
        MyDCB.ByteSize=8;
        MyDCB.Parity=NOPARITY;
        MyDCB.StopBits=ONESTOPBIT;

        MyTimeouts.ReadIntervalTimeout=15;
        MyTimeouts.ReadTotalTimeoutMultiplier=1;
        MyTimeouts.ReadTotalTimeoutConstant=250;
        MyTimeouts.WriteTotalTimeoutMultiplier=1;
        MyTimeouts.WriteTotalTimeoutConstant=250;

        ReceiveQueue=32;
        TransmitQueue=9;

        MaxFails=100000;

        ReceiveInterval=1;
}
//---------------------------------------------------------------------------
__fastcall TCommThread::TCommThread(void(__closure *NewReturnMethod)(AnsiString))
        : TThread(true),ReturnMethod(NewReturnMethod)
{
        //Inicializando os atributos
        Connected=false;

        DeviceName="COM1";

        MyDCB.DCBlength=sizeof(DCB);
        MyDCB.BaudRate=9600;
        MyDCB.ByteSize=8;
        MyDCB.Parity=NOPARITY;
        MyDCB.StopBits=ONESTOPBIT;

        MyTimeouts.ReadIntervalTimeout=15;
        MyTimeouts.ReadTotalTimeoutMultiplier=1;
        MyTimeouts.ReadTotalTimeoutConstant=250;
        MyTimeouts.WriteTotalTimeoutMultiplier=1;
        MyTimeouts.WriteTotalTimeoutConstant=250;

        ReceiveQueue=32;
        TransmitQueue=9;

        MaxFails=100000;

        ReceiveInterval=1;
}
//---------------------------------------------------------------------------
void __fastcall TCommThread::Execute()
{
        unsigned long AvailableBytes;
        unsigned long ReadBytes;

        while(Terminated==false)
        {
                Sleep(ReceiveInterval);
                AvailableBytes=BytesAvailable();
                if(AvailableBytes>0)
                {
                        ReceivedData.SetLength(AvailableBytes);
                        if(ReadFile(DeviceHandle,(void*)ReceivedData.data(),AvailableBytes,&ReadBytes,NULL)==true)
                        {
                                if(ReadBytes>0)
                                {
                                        Synchronize(AfterReceiveData);
                                        ReceivedData="";
                                }//if
                        }//if
                }//if
        }
}
//---------------------------------------------------------------------------
bool TCommThread::Connect(void)
{
        Synchronize(Open);
        return(Connected);
}
//---------------------------------------------------------------------------

bool TCommThread::Disconnect(void)
{
        Synchronize(Close);
        return(!Connected);
}
//---------------------------------------------------------------------------
bool TCommThread::GetConnected(void)
{
        return(Connected);
}
//---------------------------------------------------------------------------
void __fastcall TCommThread::AfterReceiveData()
{
        ReturnMethod(ReceivedData);
}
//---------------------------------------------------------------------------

bool TCommThread::TransmitChar(char c)
{
        unsigned long CEnviados;
        CEnviados=0;
        if(Connected==true)
        {
                if(WriteFile(DeviceHandle,&c,1,&CEnviados,NULL)!=0)
                        return(true);
                else
                        return(false);
        }//if
        else
                return(false);
}
//---------------------------------------------------------------------------
int TCommThread::BytesAvailable(void)
{
        if(Connected==true)
        {
                COMSTAT TempStat;
                DWORD TempDword;

                if(ClearCommError(DeviceHandle,&TempDword,&TempStat)==true)
                {
                        return(TempStat.cbInQue);
                }//if
                else
                        return(0);
        }//if
        else
                return(0);
}
//---------------------------------------------------------------------------
bool TCommThread::TransmitData(AnsiString Data)
{
        int i;
        int Fails;

        i=1;
        Fails=0;

        while((i<=Data.Length())&&(Data.Length()>0)&&(Fails<MaxFails))
        {
                if(TransmitChar(Data[i])==true)
                {
                        i++;
                        Fails=0;
                }
                else
                {
                        Fails++;
                }
        }
        if(Fails<MaxFails)
                return(true);
        else
                return(false);
}
//---------------------------------------------------------------------------

void __fastcall TCommThread::Close()
{
        if(Connected==true)
        {

                //back to original setings
                SetCommState(DeviceHandle,&OriginalDCB);
                SetCommTimeouts(DeviceHandle,&OriginalTimeouts);

                if(CloseHandle(DeviceHandle)!=0)
                {
                        Connected=false;
                }//if
                else
                {
                        SetCommState(DeviceHandle,&MyDCB);
                        SetCommTimeouts(DeviceHandle,&MyTimeouts);
                }
                
        }//if
}
//---------------------------------------------------------------------------
void __fastcall TCommThread::Open()
{
        if(Connected==false)
        {
                //Open device
                DeviceHandle=CreateFile(        DeviceName.c_str(),
                                                GENERIC_READ|GENERIC_WRITE,
                                                FILE_SHARE_DELETE,
                                                NULL,
                                                OPEN_EXISTING,
                                                FILE_ATTRIBUTE_TEMPORARY|FILE_FLAG_DELETE_ON_CLOSE,
                                                NULL
                                        );

                if(DeviceHandle!=INVALID_HANDLE_VALUE)
                {
                        //Make backup and set DCB of open device
                        GetCommState(DeviceHandle,&OriginalDCB);
                        SetCommState(DeviceHandle,&MyDCB);

                        //Make backup and set COMMTIMEOUTS of open device
                        GetCommTimeouts(DeviceHandle,&OriginalTimeouts);
                        SetCommTimeouts(DeviceHandle,&MyTimeouts);

                        SetupComm(DeviceHandle,1024*ReceiveQueue,1024*TransmitQueue);

                        //Resume Thread
                        if(this->Suspended)
                                Resume();
                        Connected=true;
                }//if
        }//if
}
//---------------------------------------------------------------------------
void TCommThread::SetDeviceName(AnsiString NewDeviceName)
{
        if(Connected==true)
        {
                Disconnect();
                DeviceName=NewDeviceName;
                Connect();
        }
        else
                DeviceName=NewDeviceName;
}
//---------------------------------------------------------------------------
AnsiString TCommThread::GetDeviceName(void)
{
        return(DeviceName);
}
//---------------------------------------------------------------------------
HANDLE TCommThread::GetDeviceHandle(void)
{
        return(DeviceHandle);
}
//---------------------------------------------------------------------------
int TCommThread::GetReceiveQueue(void)
{
        return(ReceiveQueue);
}
//---------------------------------------------------------------------------

void TCommThread::SetReceiveQueue(int NewReceiveQueue)
{
        if(Connected==true)
        {
                Disconnect();
                ReceiveQueue=NewReceiveQueue;
                Connect();
        }
        else
                ReceiveQueue=NewReceiveQueue;

}
//---------------------------------------------------------------------------

void TCommThread::SetReturnMethod(void(__closure *NewReturnMethod)(AnsiString))
{
        if(Connected==true)
        {
                Disconnect();
                ReturnMethod=NewReturnMethod;
                Connect();
        }
        else
                ReturnMethod=NewReturnMethod;


}
//---------------------------------------------------------------------------

int TCommThread::GetTransmitQueue(void)
{
        return(TransmitQueue);
}
//---------------------------------------------------------------------------

void TCommThread::SetTransmitQueue(int NewTransmitQueue)
{
        if(Connected==true)
        {
                Disconnect();
                TransmitQueue=NewTransmitQueue;
                Connect();
        }
        else
                TransmitQueue=NewTransmitQueue;
}
//---------------------------------------------------------------------------

void TCommThread::SetMaxFails(int NewMaxFails)
{
        if(Connected==true)
        {
                Disconnect();
                MaxFails=NewMaxFails;
                Connect();
        }
        else
                MaxFails=NewMaxFails;
}
//---------------------------------------------------------------------------

int TCommThread::GetMaxFails(void)
{
        return(MaxFails);
}
//---------------------------------------------------------------------------

int TCommThread::GetBaudRate(void)
{
        return(MyDCB.BaudRate);
}
//---------------------------------------------------------------------------

void TCommThread::SetBaudRate(int NewBaudRate)
{
        if(Connected==true)
        {
                Disconnect();
                MyDCB.BaudRate=NewBaudRate;
                Connect();
        }
        else
                MyDCB.BaudRate=NewBaudRate;
}
//---------------------------------------------------------------------------

int TCommThread::GetByteSize(void)
{
        return(MyDCB.ByteSize);
}
//---------------------------------------------------------------------------

void TCommThread::SetByteSize(int NewByteSize)
{
        if(Connected==true)
        {
                Disconnect();
                MyDCB.ByteSize=NewByteSize;
                Connect();
        }
        else
                MyDCB.ByteSize=NewByteSize;

}
//---------------------------------------------------------------------------

int TCommThread::GetParity(void)
{
        return(MyDCB.Parity);
}
//---------------------------------------------------------------------------

void TCommThread::SetParity(int NewParity)
{
        if(Connected==true)
        {
                Disconnect();
                MyDCB.Parity=NewParity;
                Connect();
        }
        else
                MyDCB.Parity=NewParity;
}
//---------------------------------------------------------------------------

int TCommThread::GetStopBits(void)
{
        return(MyDCB.StopBits);
}
//---------------------------------------------------------------------------

void TCommThread::SetStopBits(int NewStopBits)
{
        if(Connected==true)
        {
                Disconnect();
                MyDCB.StopBits=NewStopBits;
                Connect();
        }
        else
                MyDCB.StopBits=NewStopBits;
}
//---------------------------------------------------------------------------

int TCommThread::GetReadIntervalTimeout(void)
{
        return(MyTimeouts.ReadIntervalTimeout);
}
//---------------------------------------------------------------------------

void TCommThread::SetReadIntervalTimeout(int NewReadIntervalTimeout)
{
        if(Connected==true)
        {
                Disconnect();
                MyTimeouts.ReadIntervalTimeout=NewReadIntervalTimeout;
                Connect();
        }
        else
                MyTimeouts.ReadIntervalTimeout=NewReadIntervalTimeout;
}
//---------------------------------------------------------------------------

int TCommThread::GetReadTotalTimeoutMultiplier(void)
{
        return(MyTimeouts.ReadTotalTimeoutMultiplier);
}
//---------------------------------------------------------------------------

void TCommThread::SetReadTotalTimeoutMultiplier(int NewReadTotalTimeoutMultiplier)
{
        if(Connected==true)
        {
                Disconnect();
                MyTimeouts.ReadTotalTimeoutMultiplier=NewReadTotalTimeoutMultiplier;
                Connect();
        }
        else
                MyTimeouts.ReadTotalTimeoutMultiplier=NewReadTotalTimeoutMultiplier;
}
//---------------------------------------------------------------------------

int TCommThread::GetReadTotalTimeoutConstant(void)
{
        return(MyTimeouts.ReadTotalTimeoutConstant);
}
//---------------------------------------------------------------------------

void TCommThread::SetReadTotalTimeoutConstant(int NewReadTotalTimeoutConstant)
{
        if(Connected==true)
        {
                Disconnect();
                MyTimeouts.ReadTotalTimeoutConstant=NewReadTotalTimeoutConstant;
                Connect();
        }
        else
                MyTimeouts.ReadTotalTimeoutConstant=NewReadTotalTimeoutConstant;
}
//---------------------------------------------------------------------------

int TCommThread::GetWriteTotalTimeoutMultiplier(void)
{
        return(MyTimeouts.WriteTotalTimeoutMultiplier);
}
//---------------------------------------------------------------------------

void TCommThread::SetWriteTotalTimeoutMultiplier(int NewWriteTotalTimeoutMultiplier)
{
        if(Connected==true)
        {
                Disconnect();
                MyTimeouts.WriteTotalTimeoutMultiplier=NewWriteTotalTimeoutMultiplier;
                Connect();
        }
        else
                MyTimeouts.WriteTotalTimeoutMultiplier=NewWriteTotalTimeoutMultiplier;
}
//---------------------------------------------------------------------------
int TCommThread::GetWriteTotalTimeoutConstant(void)
{
        return(MyTimeouts.WriteTotalTimeoutConstant);
}
//---------------------------------------------------------------------------

void TCommThread::SetWriteTotalTimeoutConstant(int NewWriteTotalTimeoutConstant)
{
        if(Connected==true)
        {
                Disconnect();
                MyTimeouts.WriteTotalTimeoutConstant=NewWriteTotalTimeoutConstant;
                Connect();
        }
        else
                MyTimeouts.WriteTotalTimeoutConstant=NewWriteTotalTimeoutConstant;
}
//---------------------------------------------------------------------------

AnsiString TCommThread::GetAvailableData(void)
{
        unsigned long AvailableBytes;
        unsigned long ReadBytes;

        ReceivedData="";
        AvailableBytes=BytesAvailable();
        if(AvailableBytes>0)
        {
                ReceivedData.SetLength(AvailableBytes);
                if(ReadFile(DeviceHandle,(void*)ReceivedData.data(),AvailableBytes,&ReadBytes,NULL)==true)
                {
                        if(ReadBytes>0)
                        {
                                return(ReceivedData);
                        }//if
                }//if
        }
        return("");
}
//---------------------------------------------------------------------------

void TCommThread::SetReceiveInterval(int NewReceiveInterval)
{
        ReceiveInterval=NewReceiveInterval;
}
//---------------------------------------------------------------------------

int TCommThread::GetReceiveInterval(void)
{
        return ReceiveInterval;
}
//---------------------------------------------------------------------------

TStringList* TCommThread::GetAvailableDevicesNames(bool IncludeSerial, bool IncludeParallel, TStringList * AvaiableDevicesNames)
{
        TRegistry       *Registro = new TRegistry();
        TStringList     *StringsTemp = new TStringList();
        int Indice;
        if (AvaiableDevicesNames!=NULL)
                AvaiableDevicesNames->Clear();
        else
                AvaiableDevicesNames = new TStringList();

        Registro->RootKey=HKEY_LOCAL_MACHINE;

        if(IncludeSerial==true)
        {
                StringsTemp->Clear();

                Registro->OpenKey("hardware\\devicemap\\serialcomm",false);
                Registro->GetValueNames(StringsTemp);

                for (Indice=0;Indice<StringsTemp->Count;Indice++)
                        AvaiableDevicesNames->Add(Registro->ReadString(StringsTemp->Strings[Indice]));
                Registro->CloseKey();
        }

        if(IncludeParallel==true)
        {
                StringsTemp->Clear();

                Registro->OpenKey("hardware\\devicemap\\parallel ports",false);
                Registro->GetValueNames(StringsTemp);

                for (Indice=0;Indice<StringsTemp->Count;Indice++)
                        AvaiableDevicesNames->Add(ExtractFileName(Registro->ReadString(StringsTemp->Strings[Indice])));
                Registro->CloseKey();
        }
        AvaiableDevicesNames->Sort();
        delete Registro;
        delete StringsTemp;
        return AvaiableDevicesNames;

}
//---------------------------------------------------------------------------

