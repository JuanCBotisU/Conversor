package Model;

import java.util.HashMap;

public record MonedaRecord(String result, HashMap<String, Double> conversion_rates) {
}
