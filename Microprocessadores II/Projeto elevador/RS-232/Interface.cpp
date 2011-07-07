//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "Interface.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TMain_Form *Main_Form;
//---------------------------------------------------------------------------

__fastcall TMain_Form::TMain_Form(TComponent* Owner)
        : TForm(Owner)
{
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::FormCreate(TObject *Sender)
{
        Serial = new TCommThread();
        Serial->ReturnMethod=ReturnMethod;
        AdjustDevicesNames(Serial->GetAvailableDevicesNames(true,false,NULL));
        AdjustInterface();
        Receive_Memo->Clear();
}
//---------------------------------------------------------------------------

void TMain_Form::ReturnMethod(AnsiString NewData)
{
        Receive_Memo->Text=Receive_Memo->Text+NewData;
}
//---------------------------------------------------------------------------

void TMain_Form::AdjustDevicesNames(TStringList* NewNames)
{
        if(NewNames->Count>0)
                DeviceName_ComboBox->Items=NewNames;
        else
        {
                DeviceName_ComboBox->AddItem("COM1",NULL);
                DeviceName_ComboBox->AddItem("COM2",NULL);
                DeviceName_ComboBox->AddItem("COM3",NULL);
                DeviceName_ComboBox->AddItem("COM4",NULL);
        }
        DeviceName_ComboBox->Text=Serial->GetDeviceName();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::Connect_ButtonClick(TObject *Sender)
{
		if(Serial->GetConnected()==true)
                Serial->Disconnect();
        else
                Serial->Connect();
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::Transmit_ButtonClick(TObject *Sender)
{
        if(Serial->TransmitData(Transmit_Edit->Text)==true)
                Transmit_Edit->Text="";
}
//---------------------------------------------------------------------------

void TMain_Form::AdjustInterface(void)
{
        BaudRate_ComboBox->Text=IntToStr(Serial->GetBaudRate());
        ByteSize_ComboBox->Text=IntToStr(Serial->GetByteSize());
        Parity_ComboBox->ItemIndex=Serial->GetParity();
        StopBits_ComboBox->ItemIndex=Serial->GetStopBits();
        if(Serial->GetConnected()==true)
                Connect_Button->Caption="Disconnect";
        else
                Connect_Button->Caption="Connect";
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::DeviceName_ComboBoxChange(TObject *Sender)
{
        Serial->SetDeviceName(DeviceName_ComboBox->Text);
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::BaudRate_ComboBoxChange(TObject *Sender)
{
        Serial->SetBaudRate(StrToInt(BaudRate_ComboBox->Text));
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::ByteSize_ComboBoxChange(TObject *Sender)
{
        Serial->SetByteSize(StrToInt(ByteSize_ComboBox->Text));
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::Parity_ComboBoxChange(TObject *Sender)
{
        Serial->SetParity(Parity_ComboBox->ItemIndex);
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::StopBits_ComboBoxChange(TObject *Sender)
{
        Serial->SetStopBits(StopBits_ComboBox->ItemIndex);
        AdjustInterface();
}
//---------------------------------------------------------------------------

void __fastcall TMain_Form::Exit_ButtonClick(TObject *Sender)
{
        if(Serial->GetConnected()==true)
                Serial->Disconnect();
        Close();
}
//---------------------------------------------------------------------------




