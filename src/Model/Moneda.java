package Model;

import java.util.HashMap;

public class Moneda {
    String result;
    HashMap<String, Double> conversion_rates;
    public  Moneda (MonedaRecord monedaRecord){
        this.result = monedaRecord.result();
        this.conversion_rates = monedaRecord.conversion_rates();



    }
    public Double conversion(String base, String conversion, Double cantidad){
        return (conversion_rates.get(conversion)/conversion_rates.get(base))*cantidad;
    }
}
