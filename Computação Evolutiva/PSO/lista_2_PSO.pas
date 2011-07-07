unit lista_2_PSO;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, unit2, ComCtrls;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    Edit1: TEdit;
    Button1: TButton;
    Label2: TLabel;
    Edit2: TEdit;
    Label3: TLabel;
    Label4: TLabel;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    ProgressBar1: TProgressBar;
    procedure Button1Click(Sender: TObject);
    function Minimo:integer;
    procedure AtualizaVelocidade;
    procedure AtualizaPosicao;
  private
    { Private declarations }
  public
    { Public declarations }
  end;

  particula = Class
    const
      KCalMin = 2000;//Kcal
      ProtMin = 65;  //gramas
      CalcMin = 800; //miligramas
    class var n,gBest:integer;
    private
    //Posição
      Qarroz:integer;
      Qovos:integer;
      Qleite:integer;
      Qfeijao:integer;
    //velocidade
      Vel:array [0..3] of integer;//velocidade das vars:Qarroz,Qovos,Qleite,Qfeijao
    //Melhor valor da particula
      pBest:array [0..3] of integer;//melhor de pos da particula
      Fitness:integer;
    Constructor Create;
    procedure RandPart;
    function Restricao:boolean;
    function FObjetivo:integer;
  End;

const
  alfa1 = 2;
  alfa2 = 2;

var
  Form1: TForm1;
  part:array of particula;
  gBest:array [0..3] of integer;

implementation

{$R *.dfm}

Function Particula.Restricao:boolean;
var
  Kcal:integer;
  Prot:integer;
  Calc:integer;
begin
  kCal := 205*Qarroz + 160*Qovos + 160*Qleite + 260*Qfeijao;
  Prot := 32*Qarroz + 13*Qovos + 8*Qleite + 14*Qfeijao;
  Calc := 12*Qarroz + 54*Qovos + 285*Qleite + 80*Qfeijao;
  if ((Kcal < KCalMin) or (Prot < ProtMin) or (Calc < CalcMin)) then Result := True
  else Result := False;

end;

Function Particula.FObjetivo:integer;
begin
  Result := Qarroz * 14 + Qovos * 13 + Qleite * 9 + Qfeijao * 19;
end;

procedure particula.RandPart;
begin
  //inicializa particula
  Randomize;
  repeat
    Qarroz := random(14);
    Qfeijao := random(14);
    Qleite := random(14);
    Qovos := random(14);
  until not(restricao);

end;

procedure TForm1.AtualizaVelocidade;
var
i:integer;
begin
  for I := 0 to strtoint(form1.Edit1.Text) - 1 do begin

      //velocidade var arroz
      part[i].Vel[0] := part[i].Vel[0] + alfa1 * (part[i].pBest[0] - part[i].Qarroz)
                                       + alfa2 * (gBest[0] - part[i].Qarroz);


      //velocidade var ovos
      part[i].Vel[1] := part[i].Vel[1] + alfa1 * (part[i].pBest[1] - part[i].Qovos)
                                       + alfa2 * (gBest[1] - part[i].Qovos);
      //velocidade var leite
      part[i].Vel[2] := part[i].Vel[2] + alfa1 * (part[i].pBest[2] - part[i].Qleite)
                                       + alfa2 * (gBest[2] - part[i].Qleite);
      //velocidade var feijao
      part[i].Vel[3] := part[i].Vel[3] + alfa1 * (part[i].pBest[3] - part[i].Qfeijao)
                                       + alfa2 * (gBest[3] - part[i].Qfeijao);
  end;

end;

procedure TForm1.AtualizaPosicao;
var
i:integer;
begin
  for I := 0 to strtoint(form1.Edit1.Text) - 1 do begin
      //velocidade var arroz
      part[i].Qarroz := part[i].Qarroz + part[i].vel[0];
      //velocidade var ovos
      part[i].Qovos := part[i].Qovos + part[i].vel[1];
      //velocidade var leite
      part[i].Qleite := part[i].Qleite + part[i].vel[2];
      //velocidade var feijao
      part[i].Qfeijao := part[i].Qfeijao + part[i].vel[3];
      if ((part[i].Restricao) or ((part[i].FObjetivo < 0))) then part[i].RandPart;
      //se o fitness atual for melhor q o anterior, o armazena.
      if (part[i].Fitness > part[i].FObjetivo) then begin
        part[i].pBest[0] := part[i].Qarroz;
        part[i].pBest[1] := part[i].Qovos;
        part[i].pBest[2] := part[i].Qleite;
        part[i].pBest[3] := part[i].Qfeijao;
        part[i].Fitness := part[i].FObjetivo;
    end;
  end;




end;

Constructor Particula.Create;
begin
  RandPart;
  Fitness := FObjetivo;

  pBest[0] := Qarroz;
  pBest[1] := Qovos;
  pBest[2] := Qleite;
  pBest[3] := Qfeijao;

  Vel[0] := 0;
  Vel[1] := 0;
  Vel[2] := 0;
  Vel[3] := 0;
end;


function TForm1.Minimo:integer;
  var
  j,min,index:integer;
  begin
    min := 100000;
    index := 0;
    for j := 0 to strtoint(Edit1.Text) - 1 do begin
      if (min > part[j].FObjetivo) then begin
        min:= part[j].Fitness;
        index := j;
      end;
   end;
   Result := index;

end;

procedure TForm1.Button1Click(Sender: TObject);
var
  i,geracoes,index:integer;

begin
  geracoes := 0;
  ProgressBar1.Max := strtoint(Edit2.Text);
  form2.Chart1.Series[0].Clear;
  SetLength(part,strtoint(Edit1.Text));
  //cria particulas
  for I := 0 to strtoint(Edit1.Text) - 1 do begin
    part[i] := particula.Create;
  end;

  while geracoes < strtoint(Edit2.Text) - 1 do begin
    index := Minimo;

    AtualizaVelocidade;
    AtualizaPosicao;

    inc(geracoes);

    ProgressBar1.Position := geracoes;

    form2.Chart1.Series[0].AddXY(geracoes,part[index].Fitness);

  end;

  index := Minimo;

  form2.Chart1.Series[0].AddXY(geracoes,part[index].Fitness);

  Form2.Chart1.SaveToBitmapFile('PSO.bmp');

  label3.Caption := 'Quantidade Arroz:' + inttostr(part[index].pBest[0]);
  label4.Caption := 'Quantidade Ovos:' + inttostr(part[index].pBest[1]);
  label5.Caption := 'Quantidade Leite:' + inttostr(part[index].pBest[2]);
  label6.Caption := 'Quantidade Feijão:' + inttostr(part[index].pBest[3]);
  label7.Caption := 'Total:' + inttostr(part[index].Fitness);

  Form2.Show;


end;

end.
