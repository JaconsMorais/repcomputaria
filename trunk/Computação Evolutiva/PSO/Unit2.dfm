object Form2: TForm2
  Left = 0
  Top = 0
  AutoSize = True
  Caption = 'Form2'
  ClientHeight = 369
  ClientWidth = 525
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Chart1: TChart
    Left = 0
    Top = 0
    Width = 525
    Height = 369
    Legend.Visible = False
    Title.Text.Strings = (
      '')
    BottomAxis.Title.Caption = 'Gera'#231#245'es'
    LeftAxis.Title.Caption = 'Total'
    View3D = False
    TabOrder = 0
    object Series1: TFastLineSeries
      Marks.Arrow.Visible = True
      Marks.Callout.Brush.Color = clBlack
      Marks.Callout.Arrow.Visible = True
      Marks.Callout.Length = 0
      Marks.Frame.Visible = False
      Marks.Transparent = True
      Marks.Visible = False
      LinePen.Color = clRed
      TreatNulls = tnDontPaint
      XValues.Name = 'X'
      XValues.Order = loAscending
      YValues.Name = 'Y'
      YValues.Order = loNone
    end
  end
end
