package online.polp;

import java.util.regex.Pattern;

public class Persona {
    private static final Pattern codiceRegex = Pattern.compile("^(?:[A-Z][AEIOUX][AEIOUX]|[B-DF-HJ-NP-TV-Z]{2}[A-Z]){2}(?:[\\dLMNP-V]{2}(?:[A-EHLMPR-T](?:[04LQ][1-9MNP-V]|[15MR][\\dLMNP-V]|[26NS][0-8LMNP-U])|[DHPS][37PT][0L]|[ACELMRT][37PT][01LM]|[AC-EHLMPR-T][26NS][9V])|(?:[02468LNQSU][048LQU]|[13579MPRTV][26NS])B[26NS][9V])(?:[A-MZ][1-9MNP-V][\\dLMNP-V]{2}|[A-M][0L](?:[1-9MNP-V][\\dLMNP-V]|[0L][1-9MNP-V]))[A-Z]$\r\n", Pattern.CASE_INSENSITIVE);

    private String nome;
    private String cognome;
    private String codice;

    /**
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale 
     * (trasformato in automatico in maiuscolo).
     * 
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata un'eccezione.
     * CONTROLLO sul CODICE FISCALE:
     * Il codice deve contenere 16 caratteri alfanumerici
     * Il codice non deve contenere spazi
     * I primi 6 caratteri devono essere delle consonanti
     * Settimo e ottavo carattere devono essere numeri
     * Consulta la Documentazione ufficiale String
     * 
     * @param nome stringa qualsiasi da assegnare come nome di un nuovo oggetto Persona
     * @param cognome stringa qualsiasi da assegnare come cognome di un nuovo oggetto Persona
     * @param codice stringa che rappresenta il nuovo codice fiscale dell'oggetto Persona
     */
    public Persona(String nome, String cognome, String codice) throws IllegalArgumentException {
        String codiceUppercase = codice.toUpperCase();
        
        if (!codiceRegex.matcher(codiceUppercase).find()) {
            throw new IllegalArgumentException("Il codice fiscale non è valido");
        }

        this.nome = nome;
        this.cognome = cognome;
        this.codice = codiceUppercase;
    }

    /**
     * restituisce una Stringa contenente il nome della persona
     * 
     * @return il nome di un oggetto Persona
     */
    public String getNome() {
        return nome;
    }

    
    /**
     * assegna una Stringa come nome di una persona
     * 
     * @param nome Stringa da assegnare come nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * restituisce una Stringa contenente il cognome della persona
     * 
     * @return il cognome di un oggetto Persona
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * assegna una Stringa come cognome di una persona
     * 
     * @param cognome nuova stringa da assegnare come cognome a un oggetto Persona già esistente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * restituisce una Stringa contenente il codice fiscale della persona
     * 
     * @return il codice fiscale di un oggetto Persona
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Restituisce una rappresentazione testuale di un oggetto Persona,
     * nel seguente formato "NOME:xx COGNOME:xx CF:xx"
     */
    @Override
    public String toString() {
        return "NOME:" + nome + " COGNOME:" + cognome + " CF:" + codice;
    }

    /**
     * Il metodo stabilisce se due persone sono omonime;
     * Restituisce un booleano: VERO se le due persone hanno lo stesso nome (senza distinzione di maiuscole e minuscole) altrimenti FALSO
     * 
     * @param p oggetto Persona
     * @return Vero se le due persone confrontate hanno lo stesso nome, altrimenti falso
     */
    public boolean isOmonimo(Persona p) {
        return this.nome.equals(p.nome);
    }
}
