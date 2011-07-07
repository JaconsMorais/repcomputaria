/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atarefatorcompevolutiva.util;

import java.util.Date;

/**
 *
 * @author Thales
 */
public class Validadores {
    public static boolean validaData(String dia, String mes, String ano){
        try{
            int diaValido = Integer.parseInt(dia);
            int mesValido = Integer.parseInt(mes);
            int anoValido = Integer.parseInt(ano);

            switch(mesValido){
                case 1:
                    if(diaValido > 31) return false;
                    break;
                case 2:
                    if(anoValido % 4 == 0){
                        if(anoValido % 100 == 0 && anoValido % 400 == 0){
                            if(diaValido > 29) return false;
                        }else if(anoValido % 100 == 0 && anoValido % 400 != 0){
                            if(diaValido > 28) return false;
                        }else if(anoValido % 100 != 0){
                            if(diaValido > 29) return false;
                        }
                    }else{
                        if(diaValido > 28) return false;
                    }
                    break;
                case 3:
                    if(diaValido > 31) return false;
                    break;
                case 4:
                    if(diaValido > 30) return false;
                    break;
                case 5:
                    if(diaValido > 31) return false;
                    break;
                case 6:
                    if(diaValido > 30) return false;
                    break;
                case 7:
                    if(diaValido > 31) return false;
                    break;
                case 8:
                    if(diaValido > 31) return false;
                    break;
                case 9:
                    if(diaValido > 30) return false;
                    break;
                case 10:
                    if(diaValido > 31) return false;
                    break;
                case 11:
                    if(diaValido > 30) return false;
                    break;
                case 12:
                    if(diaValido > 31) return false;
                    break;
            }
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public static boolean validaDataInicialFinal(Date dataInicio, Date dataFinal){
        if(dataFinal.getTime() - dataInicio.getTime() < 0)
            return false;

        return true;
    }

    public static boolean validaTotalHoras(String totalHoras){
        try{
            Double.parseDouble(totalHoras);
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public static boolean validaHorasTrabalhadas(String horasTrabalhadas){
        try{
            Double.parseDouble(horasTrabalhadas);
        }catch(Exception e){
            return false;
        }

        return true;
    }

    public static boolean validaNomeTarefa(String nomeTarefa){
        if(nomeTarefa.equals(""))
            return false;
        return true;
    }
}
