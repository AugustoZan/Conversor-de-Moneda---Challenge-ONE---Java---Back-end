package Convertidor_De_Monedas;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class ConvertidorRequest {
    public static double obtenerValorDolar() {
        try {
            // URL de la API
            URL url = new URL("https://v6.exchangerate-api.com/v6/adba79f02c3c9770a6ee3b7f/latest/USD");

            // Abrir conexión HTTP
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            // Método de solicitud (GET)
            con.setRequestMethod("GET");

            // Obtener la respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Convertir la respuesta JSON a un objeto Java
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

            // Obtener el valor del dólar
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double usd = conversionRates.get("USD").getAsDouble();

            return usd;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0; // Devuelve un valor predeterminado en caso de error
        }
    }
//En las demás funciones se realiza la misma lógica, variando el valor que se busca obtener
    public static double obtenerValorPesoArgentino() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/adba79f02c3c9770a6ee3b7f/latest/USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error al obtener el valor del peso argentino: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Obtener el valor del peso argentino
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                double pesoArg = conversionRates.get("ARS").getAsDouble();

                return pesoArg;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public static double obtenerValorRealBrasilenio() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/adba79f02c3c9770a6ee3b7f/latest/USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error al obtener el valor del Real Brasileño: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Obtener el valor del Real Brasileño
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                double realBrasileño = conversionRates.get("BRL").getAsDouble();

                return realBrasileño;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public static double obtenerValorPesoColombiano() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/adba79f02c3c9770a6ee3b7f/latest/USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error al obtener el valor del Peso Colombiano: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Obtener el valor del Peso Colombiano
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                double pesoColombiano = conversionRates.get("COP").getAsDouble();

                return pesoColombiano;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
    public static double obtenerValorPesoMexicano() {
        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/adba79f02c3c9770a6ee3b7f/latest/USD");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("Error al obtener el valor del Peso Mexicano: " + responseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();

                // Obtener el valor del Peso Mexicano
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                double pesoMexicano = conversionRates.get("MXN").getAsDouble();

                return pesoMexicano;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}