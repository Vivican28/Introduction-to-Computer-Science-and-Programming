
/**
 * Write a description of class Astre here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Astre {
   //atributs de classe públic i constants
   public static final int ESTEL = 0;
   public static final int NEBULOSA = 1;
   public static final int GALAXIA = 2;
   // atributs d'instància privats
   private String nom;
   private int tipus;
   private double brillantor, distancia;
   
   public Astre(String n, int t, double b, double d) {
       nom = n; tipus = t; brillantor = b; distancia = d;
   }
   public Astre() {
       this("Sirius", ESTEL, -1.42, 8.7);
       // Que es el mateix que posar
       // nom = "Sirius"; tipus = ESTEL;
       // brillantor = -1.42; distancia = 8.7;
   }
   public double getBrillantor() { return brillantor; }
   
   public void setBrillantor( double novabrillantor )  {
       brillantor = novabrillantor;
   }
    
   public boolean equals(Object o) {
       return o instanceof Astre
           && this.tipus == ((Astre) o).tipus
           && this.nom.equals((Astre) o)
           // Important: el nom es compara amb equals
           && this.brillantor == ((Astre) o).brillantor
           && this.distancia == ((Astre) o).distancia;
   }
   public String toString() {
       double brill = Math.round(brillantor);
       double dist = Math.round(distancia);
       return nom + ":" + tipus + "(" + brill + ", " + dist + ")";
   }
   
   public double magnitudAbsoluta() {
       return brillantor + 5 * Math.log10(distancia);
   }
   public int mesBrillant(Astre o) {
       double absolutThis = this.magnitudAbsoluta();
       double absolut0 = o.magnitudAbsoluta();
       int valor;
       if (absolutThis > absolut0) {
           return 1;
       }
       else if (absolutThis == absolut0) {
           return 0;
       }
       else {
           return -1;
       }
   }
   public String visibleAmb() {
       if (this.brillantor < 5) {
           return "a simple vista";
       }
       else if (this.brillantor >= 5 && this.brillantor < 7) {
           return "amb prismatics";
       }
       else if (this.brillantor >= 7 && this.brillantor <= 25) {
           return "amb telescopi";
       }
       else {
           return "amb grans telescopis";
        }
   }
   
}
