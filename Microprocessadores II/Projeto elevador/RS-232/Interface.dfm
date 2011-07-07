object Main_Form: TMain_Form
  Left = 502
  Top = 190
  Caption = 'Conex'#227'o com RS-232'
  ClientHeight = 216
  ClientWidth = 482
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object Name: TLabel
    Left = 8
    Top = 8
    Width = 28
    Height = 13
    Caption = 'Nome'
  end
  object Label1: TLabel
    Left = 88
    Top = 8
    Width = 51
    Height = 13
    Caption = 'Baud Rate'
  end
  object Label2: TLabel
    Left = 248
    Top = 8
    Width = 56
    Height = 13
    Caption = 'Bit paridade'
  end
  object Label3: TLabel
    Left = 328
    Top = 8
    Width = 42
    Height = 13
    Caption = 'Stop Bits'
  end
  object Label4: TLabel
    Left = 168
    Top = 8
    Width = 59
    Height = 13
    Caption = 'Tamanho bit'
  end
  object Label5: TLabel
    Left = 8
    Top = 56
    Width = 80
    Height = 13
    Caption = 'Dados recebidos'
  end
  object Label6: TLabel
    Left = 8
    Top = 176
    Width = 93
    Height = 13
    Caption = 'Dado a ser enviado'
  end
  object DeviceName_ComboBox: TComboBox
    Left = 8
    Top = 24
    Width = 65
    Height = 21
    ItemHeight = 13
    TabOrder = 0
    Text = 'COM1'
    OnChange = DeviceName_ComboBoxChange
  end
  object BaudRate_ComboBox: TComboBox
    Left = 88
    Top = 24
    Width = 65
    Height = 21
    ItemHeight = 13
    TabOrder = 1
    Text = '9600'
    OnChange = BaudRate_ComboBoxChange
    Items.Strings = (
      '110'
      '110'
      '300'
      '1200'
      '2400'
      '4800'
      '9600'
      '19200'
      '38400'
      '57600'
      '115200')
  end
  object Parity_ComboBox: TComboBox
    Left = 248
    Top = 24
    Width = 65
    Height = 21
    ItemHeight = 13
    TabOrder = 2
    Text = 'no'
    OnChange = Parity_ComboBoxChange
    Items.Strings = (
      'no'
      'odd'
      'even'
      'mark'
      'space')
  end
  object StopBits_ComboBox: TComboBox
    Left = 328
    Top = 24
    Width = 65
    Height = 21
    ItemHeight = 13
    TabOrder = 3
    Text = '1'
    OnChange = StopBits_ComboBoxChange
    Items.Strings = (
      '1'
      '1.5'
      '2')
  end
  object ByteSize_ComboBox: TComboBox
    Left = 168
    Top = 24
    Width = 65
    Height = 21
    ItemHeight = 13
    TabOrder = 4
    Text = '8'
    OnChange = ByteSize_ComboBoxChange
    Items.Strings = (
      '4'
      '5'
      '6'
      '7'
      '8')
  end
  object Receive_Memo: TMemo
    Left = 8
    Top = 72
    Width = 385
    Height = 89
    TabOrder = 5
  end
  object Connect_Button: TButton
    Left = 408
    Top = 21
    Width = 75
    Height = 25
    Caption = 'Conectar'
    TabOrder = 6
    OnClick = Connect_ButtonClick
  end
  object Transmit_Edit: TEdit
    Left = 8
    Top = 192
    Width = 385
    Height = 21
    TabOrder = 7
  end
  object Transmit_Button: TButton
    Left = 408
    Top = 189
    Width = 75
    Height = 25
    Caption = 'Enviar'
    TabOrder = 8
    OnClick = Transmit_ButtonClick
  end
  object Exit_Button: TButton
    Left = 408
    Top = 152
    Width = 75
    Height = 25
    Caption = 'Sair'
    TabOrder = 9
    OnClick = Exit_ButtonClick
  end
end
