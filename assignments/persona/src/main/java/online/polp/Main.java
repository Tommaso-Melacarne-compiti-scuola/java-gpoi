package online.polp;

public class Main {
    public static void main(String[] args) {
        // Test costruttore e getters
        Persona p = new Persona("Mario", "Rossi", "RSSMRA85T10A562S");

        if (!p.getNome().equals("Mario")) {
            System.out.println("Expected nome 'Mario', got '" + p.getNome() + "'");
        }

        if (!p.getCognome().equals("Rossi")) {
            System.out.println("Expected cognome 'Rossi', got '" + p.getCognome() + "'");
        }

        if (!p.getCodice().equals("RSSMRA85T10A562S")) {
            System.out.println("Expected codice 'RSSMRA85T10A562S', got '" + p.getCodice() + "'");
        }


        // Test validazione codice fiscale
        try {
            new Persona("Mario", "Rossi", "INVALID");
            System.out.println("Expected IllegalArgumentException for invalid codice");
        } catch (IllegalArgumentException e) {
        }


        // Test toString
        String expected = "NOME:Mario COGNOME:Rossi CF:RSSMRA85T10A562S";
        if (!p.toString().equals(expected)) {
            System.out.println("Expected toString '" + expected + "', got '" + p.toString() + "'");
        }


        // Test isOmonimo con lo stesso nome
        Persona p2 = new Persona("Mario", "Bianchi", "BNCMRA85T10A562S");
        if (!p.isOmonimo(p2)) {
            System.out.println("Expected isOmonimo true for same nome");
        }

        
        // Test isOmonimo con nome diverso
        Persona p3 = new Persona("Luca", "Rossi", "RSSMCA85T10A562S");
        if (p.isOmonimo(p3)) {
            System.out.println("Expected isOmonimo false for different nome");
        }

        System.out.println("Tests done");
    }
}