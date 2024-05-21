import Model.Moneda;
import Model.MonedaRecord;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String base;
        Double cantidad;
        String convertir;
        Moneda moneda = null;
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);

        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://v6.exchangerate-api.com/v6/77c606d61cf96383b249ec5d/latest/USD")).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            MonedaRecord monedaRecord = gson.fromJson(response.body(), MonedaRecord.class);
            moneda = new Moneda(monedaRecord);
            System.out.println(moneda);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("ARS - Peso argentino");
        System.out.println("BOB - Boliviano boliviano");
        System.out.println("BRL - Real brasileño");
        System.out.println("USD - Dólar estadounidense");
        System.out.print("Ingrese el tipo de moneda que desea convertir: ");
        base = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        cantidad = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("ARS - Peso argentino");
        System.out.println("BOB - Boliviano boliviano");
        System.out.println("BRL - Real brasileño");
        System.out.println("USD - Dólar estadounidense");
        System.out.println("Ingresa a que moneda quieres hacer la conversion:");
        convertir = scanner.nextLine();
        if(moneda != null){
            System.out.print(moneda.conversion(base, convertir,cantidad));
        }


    }
}