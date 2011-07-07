object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'PSO - Particle Swarm Optimization'
  ClientHeight = 202
  ClientWidth = 447
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 40
    Top = 40
    Width = 50
    Height = 13
    Caption = 'Part'#237'culas:'
  end
  object Label2: TLabel
    Left = 40
    Top = 80
    Width = 49
    Height = 13
    Caption = 'Gera'#231#245'es:'
  end
  object Label3: TLabel
    Left = 192
    Top = 16
    Width = 89
    Height = 13
    Caption = 'Quantidade Arroz:'
  end
  object Label4: TLabel
    Left = 192
    Top = 48
    Width = 88
    Height = 13
    Caption = 'Quantidade Ovos:'
  end
  object Label5: TLabel
    Left = 192
    Top = 80
    Width = 86
    Height = 13
    Caption = 'Quantidade Leite:'
  end
  object Label6: TLabel
    Left = 192
    Top = 112
    Width = 92
    Height = 13
    Caption = 'Quantidade Feij'#227'o:'
  end
  object Label7: TLabel
    Left = 192
    Top = 144
    Width = 28
    Height = 13
    Caption = 'Total:'
  end
  object Edit1: TEdit
    Left = 96
    Top = 37
    Width = 65
    Height = 21
    TabOrder = 0
    Text = '50'
  end
  object Button1: TButton
    Left = 40
    Top = 144
    Width = 75
    Height = 25
    Caption = 'Button1'
    TabOrder = 1
    OnClick = Button1Click
  end
  object Edit2: TEdit
    Left = 95
    Top = 77
    Width = 66
    Height = 21
    TabOrder = 2
    Text = '100000'
  end
  object ProgressBar1: TProgressBar
    Left = 0
    Top = 185
    Width = 449
    Height = 17
    Smooth = True
    TabOrder = 3
  end
end
