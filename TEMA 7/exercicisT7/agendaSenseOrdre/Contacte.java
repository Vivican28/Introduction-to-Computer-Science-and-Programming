package agendaSenseOrdre;

/**
  * Classe Contacte: representa un contacte (basic) d'una agenda mitjançant dos
  * atributs de tipus String: el que representa el nom del contacte (nom),
  * i el que representa el telefon associat a aquest nom (telefon).
  * Es important notar que per accedir a un telefon de l'agenda es 
  * imprescindible cercar primer el nom a ell associat, de manera que el nom 
  * es pot considerar una clau d'acces a la informacio que conte una agenda.
  *
  * Per definir la funcionalitat (basica) d'un contacte --crear un contacte,
  * consultar o modificar les seues components, comprovar si un contacte es 
  * igual a un altre i toString-- la classe Contacte defineix els metodes 
  * que figuren a continuacio; cal notar que el seu codi es limita a manipular 
  * els atributs de la classe per implementar aquesta funcionalitat.
  * 
  * @author IIP
  * @version Curs 2019-20
  */
public class Contacte {
    private String telefon, nom;

    /**
     * Crea un Contacte a partir d'un telefon i un nom.
     * @param telefon String, un telefon.
     * @param nom String, un nom.
     */
    public Contacte(String n, String t) { 
        nom = n; telefon = t;
    }
    
    /**
     * Torna el telefon.
     * @return String, el telefon.
     */
    public String getTelefon() { return telefon; }
    
    /**
     * Torna el nom.
     * @return String, el nom.
     */
    public String getNom() { return nom; }
    
    /**
     * Actualitza el telefon.
     * @param nouTelefon String, el nou telefon.
     */
    public void setTelefon(String nouTelefon) {  telefon = nouTelefon; }
    
    /**
     * Actualitza el nom.
     * @param nouNom String, el nou nom.
     */
    public void setNom(String nouNom) {  nom = nouNom; }    
    
    /**
     * Sobreescriptura del metode toString de Object.
     * @return String, informacio del Contacte actual.
     */
    public String toString() { 
        return "Nom:     " + nom + "\nTelefon: " + telefon;
    }
        
    /**
     * Sobreescriptura del metode equals d'Object, per tal de comprovar 
     * si un contacte es igual a un altre donat. Recordant que el nom 
     * d'un contacte es la clau d'acces al telefon cercat, es considera 
     * que un contacte es igual a un altre si i nomes si el seu nom 
     * coincideix amb el de l'altre.
     * 
     * @param o Object, objecte a comparar amb el Contacte actual.
     * @return boolean, true si son iguals i false si no ho son.
     */
    public boolean equals(Object o) { 
        return o instanceof Contacte 
            && nom.equals(((Contacte) o).nom);
    }
    
} // de Contacte

