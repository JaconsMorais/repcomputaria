//---------------------------------------------------------------------------

#ifndef Interface
#define Interface
//---------------------------------------------------------------------------
#include <Classes.hpp>
#include <Controls.hpp>
#include <StdCtrls.hpp>
#include <Forms.hpp>
#include "CommThread_Unit.h"
//---------------------------------------------------------------------------
class TMain_Form : public TForm
{
__published:   // IDE-managed Components
        TComboBox *DeviceName_ComboBox;
        TComboBox *BaudRate_ComboBox;
        TComboBox *Parity_ComboBox;
        TComboBox *StopBits_ComboBox;
        TComboBox *ByteSize_ComboBox;
        TLabel *Name;
        TLabel *Label1;
        TLabel *Label2;
        TLabel *Label3;
        TLabel *Label4;
        TMemo *Receive_Memo;
        TButton *Connect_Button;
        TLabel *Label5;
        TEdit *Transmit_Edit;
        TLabel *Label6;
        TButton *Transmit_Button;
        TButton *Exit_Button;
        void __fastcall FormCreate(TObject *Sender);
        void __fastcall Connect_ButtonClick(TObject *Sender);
        void __fastcall Transmit_ButtonClick(TObject *Sender);
        void __fastcall DeviceName_ComboBoxChange(TObject *Sender);
        void __fastcall BaudRate_ComboBoxChange(TObject *Sender);
        void __fastcall ByteSize_ComboBoxChange(TObject *Sender);
        void __fastcall Parity_ComboBoxChange(TObject *Sender);
        void __fastcall Exit_ButtonClick(TObject *Sender);
        void __fastcall StopBits_ComboBoxChange(TObject *Sender);
private:
        TCommThread* Serial;   // User declarations
public:      // User declarations
        __fastcall TMain_Form(TComponent* Owner);
        void ReturnMethod(AnsiString NewData);
        void AdjustDevicesNames(TStringList* NewNames);
        void AdjustInterface(void);
};
//---------------------------------------------------------------------------
extern PACKAGE TMain_Form *Main_Form;
//---------------------------------------------------------------------------
#endif
