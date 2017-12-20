package com.adviento.mibalde;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RutinaDiaria {
// Esta clase permite realizar una tarea todos los dias a una hora determinada. Los argumentos requeridos son -- Hora de ejecutar tarea y una tarea (Runnable)
        private final Runnable TareaDiaria ;
        private final int hora;
        private final int minuto;
        private final int segundo;



        public RutinaDiaria(Calendar momentoX, Runnable tareita)

        {
            this.TareaDiaria = tareita;
            this.hora = momentoX.get(Calendar.HOUR_OF_DAY);
            this.minuto = momentoX.get(Calendar.MINUTE);
            this.segundo = momentoX.get(Calendar.SECOND);

        }

        public void start()
        {
            ComenzarTemporizador();
        }

        private void ComenzarTemporizador()
        {
            Timer pepes =new Timer();
            TimerTask alea = new TimerTask() {
                @Override
                public void run() {
                    TareaDiaria.run();
                    ComenzarTemporizador();
                }
            };
            pepes.schedule(alea,SiguienteTiempoEjecucion());
        }


        private Date SiguienteTiempoEjecucion()
        {
            Calendar TiempoInicio = Calendar.getInstance();
            Calendar Ahora = Calendar.getInstance();
            TiempoInicio.set(Calendar.HOUR_OF_DAY, hora);
            TiempoInicio.set(Calendar.MINUTE, minuto);
            TiempoInicio.set(Calendar.SECOND, segundo);
            TiempoInicio.set(Calendar.MILLISECOND, 0);

            if(TiempoInicio.before(Ahora) || TiempoInicio.equals(Ahora))
            {
                TiempoInicio.add(Calendar.DATE, 1);
            }
            return TiempoInicio.getTime();
        }
    }

