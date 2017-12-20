package com.adviento.mibalde;

import android.util.JsonReader;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oficina on 20/12/2017.
 */

public class Utilidades  {

    public Utilidades(){};

    private String LectorRespuestasSTRING(HttpURLConnection conexion) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(conexion.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        } catch (Exception e) {
            // Log.i(TAG, "Error reading InputStream");
            result = null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // Log.i(TAG, "Error closing InputStream");
                }
            }
        }

        return result;
    }

    public  ArrayList<Punto> LectorJsonArrayDePuntos(HttpURLConnection conexion) throws IOException {

            JsonReader reader = new JsonReader(new InputStreamReader(conexion.getInputStream()));
        try {
             return SacaPuntosDeArray(reader);
                 } finally {
                    reader.close();
                  }
    }

    public ArrayList<Punto> SacaPuntosDeArray(JsonReader reader) throws IOException {
        ArrayList<Punto> listado = new ArrayList<Punto>();

        reader.beginArray();
        while (reader.hasNext()) {
            listado.add(LeePunto(reader));
        }
        reader.endArray();
        return listado;
    }

    public Punto LeePunto(JsonReader reader) throws IOException {

        Punto karol=new Punto();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "Id":
                    karol.Id = reader.nextString();
                    break;
                case "TempoJson":
                    karol.Tempo = Long.getLong(reader.nextString());
                    break;
                case "Latitud":
                    karol.Latitud = (reader.nextDouble());
                    break;
                case "Longuitud":
                    karol.Longuitud = (reader.nextDouble());
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return karol;
    }

    public List<Double> readDoublesArray(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }
    }


