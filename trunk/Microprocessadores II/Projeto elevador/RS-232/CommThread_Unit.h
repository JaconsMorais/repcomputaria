//---------------------------------------------------------------------------
//TCommThread version 6.0 - 30/11/2005
//Luciano Vieira Koenigkan - e-mail: lucianovk@bol.com.br

#ifndef CommThread_UnitH
#define CommThread_UnitH
//---------------------------------------------------------------------------
#include <Classes.hpp>
#include <Registry.hpp>
//---------------------------------------------------------------------------
class TCommThread : public TThread
{
private:
        HANDLE DeviceHandle;
        bool Connected;
        AnsiString DeviceName;
        DCB MyDCB;
        DCB OriginalDCB;
        COMMTIMEOUTS MyTimeouts;
        COMMTIMEOUTS OriginalTimeouts;
        int ReceiveQueue;
        int TransmitQueue;
        AnsiString ReceivedData;
        int MaxFails;
        bool Disconnecting;
        int ReceiveInterval;
        void __fastcall AfterReceiveData();
        bool TransmitChar(char c);
        int BytesAvailable(void);
        void __fastcall Close();
        void __fastcall Open();
protected:
        void __fastcall Execute();
public:
        __fastcall TCommThread(void(__closure *NewReturnMethod)(AnsiString));
        __fastcall TCommThread();
        void(__closure *ReturnMethod)(AnsiString);
        bool Connect(void);
        bool Disconnect(void);
        bool GetConnected(void);
        bool TransmitData(AnsiString Data);
        void SetDeviceName(AnsiString NewDeviceName);
        AnsiString GetDeviceName(void);
        HANDLE GetDeviceHandle(void);
        int GetReceiveQueue(void);
        void SetReceiveQueue(int NewReceiveQueue);
        int GetTransmitQueue(void);
        void SetTransmitQueue(int NewTransmitQueue);
        void SetMaxFails(int NewMaxFails);
        int GetMaxFails(void);
        int GetBaudRate(void);
        void SetBaudRate(int NewBaudRate);
        int GetByteSize(void);
        void SetByteSize(int NewByteSize);
        int GetParity(void);
        void SetParity(int NewParity);
        int GetStopBits(void);
        void SetStopBits(int NewStopBits);
        int GetReadIntervalTimeout(void);
        void SetReadIntervalTimeout(int NewReadIntervalTimeout);
        int GetReadTotalTimeoutMultiplier(void);
        void SetReadTotalTimeoutMultiplier(int NewReadTotalTimeoutMultiplier);
        int GetReadTotalTimeoutConstant(void);
        void SetReadTotalTimeoutConstant(int NewReadTotalTimeoutConstant);
        int GetWriteTotalTimeoutMultiplier(void);
        void SetWriteTotalTimeoutMultiplier(int NewWriteTotalTimeoutMultiplier);
        int GetWriteTotalTimeoutConstant(void);
        void SetWriteTotalTimeoutConstant(int NewWriteTotalTimeoutConstant);
        void SetReturnMethod(void(__closure *NewReturnMethod)(AnsiString));
        AnsiString GetAvailableData(void);
        void SetReceiveInterval(int NewReceiveInterval);
        int GetReceiveInterval(void);
        TStringList* TCommThread::GetAvailableDevicesNames(bool IncludeSerial, bool IncludeParallel, TStringList * AvaiableDeviceNames);
};
//---------------------------------------------------------------------------
#endif
