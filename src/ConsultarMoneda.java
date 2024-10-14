import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public Moneda buscaMoneda(String tipo){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/4627ea374c1d223bc6fecfc8/latest/"+tipo);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        System.out.println( "direccion"+direccion);

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa Moneda.");
        }
    }

    // Método para convertir de base a cualquier otra moneda
    public double convertirUSD(Moneda moneda, String codigoMoneda, double montoUSD) {
        // Obtener la tasa de conversión de USD a la moneda especificada
        Double tasa = moneda.conversion_rates().get(codigoMoneda);

        if (tasa == null) {
            throw new IllegalArgumentException("No se encontró la tasa de conversión para la moneda: " + codigoMoneda);
        }

        // Realizar la conversión
        return montoUSD * tasa;
    }

    // Método para convertir de una moneda extranjera a base
    public double convertirABase(Moneda moneda, String codigoMoneda, double montoMonedaExtranjera) {
        // Obtener la tasa de conversión de la moneda especificada a USD
        Double tasa = moneda.conversion_rates().get(codigoMoneda);

        if (tasa == null) {
            throw new IllegalArgumentException("No se encontró la tasa de conversión para la moneda: " + codigoMoneda);
        }

        // Realizar la conversión a USD
        return montoMonedaExtranjera / tasa;
    }

}


