package com.adviento.mibalde;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class Temporin {
    public static void main(String arglist[]) {

     long pepe =System.currentTimeMillis();
        String TiempoGlobal="yyyy-MM-dd HH:mm:ss";
        String SoloFecha="yyyy-MM-dd";
        String SoloHora="HH:mm:ss";


        Date cambio = new Date(pepe);


        SimpleDateFormat cac = new SimpleDateFormat(SoloHora, Locale.getDefault());
        System.out.println(cac.format(cambio));
        System.out.println(ConversorTicksAFechaLOCAL(pepe));

    }
    public static  long TicksAMillis(long ticks){ return ticks/10000L;
    }
    public static  long TickActual(){ return System.currentTimeMillis()*10000L;
    }
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

   public static String ConversorTicksAFechaLOCAL (long ticks){
       String TiempoGlobal="yyyy-MM-dd HH:mm:ss";
       String SoloFecha="yyyy-MM-dd";
       String SoloHora="HH:mm:ss";

       Date cambio = new Date(ticks);
       SimpleDateFormat cac = new SimpleDateFormat(SoloHora, Locale.getDefault());

       return cac.format(cambio);
       }

}