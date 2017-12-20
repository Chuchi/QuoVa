package com.adviento.mibalde;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by oficina on 28/10/2016.
 */
public class Tiempos {



    //Constructor Vacio
      public Tiempos() {
      }

    ;

    //  Constantes para la conversion de tiempos entre Java y MicroSoft
    private static final long Ticks_Hasta_1Enero1970 = 621355968000000000L;
    private static final long Millis_Hasta_1Enero1970 = 62135596800000L;
    // Provisional
    private static final long Ticks_Ajuste_seis_horas = 216000000000L;
    private static final String TiempoGlobal="dd-MM-yy  HH:mm:ss";
    private static final String SoloFecha="dd-MM-yy";
    private static final String SoloHora="HH:mm:ss";


    public static long TiempoActualTicks() {

        return ( (System.currentTimeMillis()*10000) + Ticks_Hasta_1Enero1970);
    }

    public static long ConversorDeTicksAMillis(long tiempomicrosoftTICKS) {

             return ( tiempomicrosoftTICKS - Ticks_Hasta_1Enero1970)/10000;
            }

    public static long ConversorDeMillisATicks(long tiempoMILLIS) {

        return ( (tiempoMILLIS*10000) + Ticks_Hasta_1Enero1970);
    }

    public static String ConversorTicksAFechaLOCAL (long ticks){

        Date cambio = new Date(ConversorDeTicksAMillis(ticks));
        SimpleDateFormat cac = new SimpleDateFormat(SoloFecha, Locale.getDefault());
        return cac.format(cambio);
    }
    public static String ConversorTicksAHoraLOCAL (long ticks){

        Date cambio = new Date(ConversorDeTicksAMillis(ticks));
        SimpleDateFormat cac = new SimpleDateFormat(SoloHora, Locale.getDefault());
        return cac.format(cambio);
    }

    public static String ConversorMillisAFechaLOCAL (long MILLIS){

        Date cambio = new Date(MILLIS);
        SimpleDateFormat cac = new SimpleDateFormat(SoloFecha, Locale.getDefault());
        return cac.format(cambio);
    }
    public static String ConversorMillisAHoraLOCAL (long MILLIS){

        Date cambio = new Date(MILLIS);
        SimpleDateFormat cac = new SimpleDateFormat(SoloHora, Locale.getDefault());
        return cac.format(cambio);
    }

    public static void main(String[] args) {

    }
}


