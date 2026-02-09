package online.polp;

public class Main {
    public static void main(String[] args) {
        // Test costruttore e getter
        Temperatura t = new Temperatura(25.0);

        if (t.getValoreCelsius() != 25.0) {
            System.out.println("Expected valoreCelsius '25.0', got '" + t.getValoreCelsius() + "'");
        }


        // Test aumenta
        t.aumenta(5.0);
        if (t.getValoreCelsius() != 30.0) {
            System.out.println("Expected valoreCelsius '30.0' after aumenta, got '" + t.getValoreCelsius() + "'");
        }


        // Test diminuisci
        t.diminuisci(10.0);
        if (t.getValoreCelsius() != 20.0) {
            System.out.println("Expected valoreCelsius '20.0' after diminuisci, got '" + t.getValoreCelsius() + "'");
        }


        // Test conversione Fahrenheit
        Temperatura t2 = new Temperatura(0.0);
        if (t2.inFahrenheit() != 32.0) {
            System.out.println("Expected Fahrenheit '32.0' for 0°C, got '" + t2.inFahrenheit() + "'");
        }


        // Test conversione Kelvin
        if (Math.abs(t2.inKelvin() - 273.15) > 0.01) {
            System.out.println("Expected Kelvin '273.15' for 0°C, got '" + t2.inKelvin() + "'");
        }


        // Test toString
        Temperatura t3 = new Temperatura(25.0);
        String expected = "Temperatura: 25.00 °C - 77.00 °F - 298.15 K";
        if (!t3.toString().equals(expected)) {
            System.out.println("Expected toString '" + expected + "', got '" + t3.toString() + "'");
        }

        System.out.println("Tests done");
    }
}