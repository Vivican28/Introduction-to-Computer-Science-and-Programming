import java.util.Locale;
/**
 * Classe TestTelescopi: classe programa que prova la 
 * classe Telescopi (Exercicis - P4 i P6).
 *
 * @author IIP
 * @version Curs 2019-20
 */
public class TestTelescopi {
    private TestTelescopi() { }
    
    public static void main(String[] args) {
        // Crear un Telescopi de di�metre 76.2, 
        // dist�ncia focal 165.1 i dist�ncia focal ocular 20.32,
        // cridant al constructor amb 3 par�metres
        Telescopi t1 = new Telescopi(76.2, 165.1, 20.32);
       
        // Crear un Telescopi de di�metre 76.2 
        // i dist�ncia focal i ocular est�ndard,
        // cridant al constructor amb 1 par�metre que correspon al di�metre
        Telescopi t2 = new Telescopi(76.2);
       
        // Crear un Telescopi est�ndard,
        // cridant al constructor per defecte, sense par�metres
        Telescopi t3 = new Telescopi();
       
        // Mostrar per pantalla els augments i la relaci� focal de cada telescopi
        System.out.printf(Locale.US, "\nTelescopi 1 --> Augments: %.2f", t1.augments());  
        System.out.printf(Locale.US, "\n            --> Relaci� focal: %.2f", t1.relacioFocal());
        System.out.printf(Locale.US, "\nTelescopi 2 --> Augments: %.2f", t2.augments());  
        System.out.printf(Locale.US, "\n            --> Relaci� focal: %.2f", t2.relacioFocal());
        System.out.printf(Locale.US, "\nTelescopi 3 --> Augments: %.2f", t3.augments());  
        System.out.printf(Locale.US, "\n            --> Relaci� focal: %.2f\n", t3.relacioFocal());
        System.out.println();
        
        // Mostrar per pantalla les caracter�stiques dels telescopis       
        System.out.println("Telescopi 1: " + t1);  
                    // recorda s'est� invocant al m�tode toString()
                    // �s a dir, ac� t1 �s equivalent a t1.toString()
        System.out.println("Telescopi 2: " + t2);  
                    // ac� t2 �s equivalent a t2.toString()
        System.out.println("Telescopi 3: " + t3);  
                    // ac� t3 �s equivalent a t3.toString()
       
        // Crear un Telescopi de di�metre 76.2, dist�ncia focal 165.1 
        // i dist�ncia focal ocular 20.32,
        // cridant al constructor general (amb 3 par�metres)
        Telescopi t4 = new Telescopi(76.2, 165.1, 20.32);
        System.out.println("Telescopi 4: " + t4 + "\n");  
       
        // Comprovar la igualtat amb equals: 
        // t1 i t4 s�n iguals per� t1 i t2 no, i t1 i t3 no
        System.out.println("t1 i t4 s�n iguals? " + t1.equals(t4)); 
                           // mostra true pq els valors dels atributs de 
                           // l'objecte referenciat per t1 s�n iguals als 
                           // valors dels atributs de l'objecte referenciat 
                           // per t4 (dos objectes diferents en el heap per� 
                           // amb valors id�ntics dels seus atributs)
        System.out.println("t1 i t2 s�n iguals? " + t1.equals(t2));
        System.out.println("t1 i t3 s�n iguals? " + t1.equals(t3)); 
                           // mostra false pq els valors dels atributs de
                           // l'objecte referenciat per t1 s�n diferents dels 
                           // valors dels atributs de l'objecte referenciat 
                           // per t2(t3) (objectes diferents en el heap 
                           // amb valors tamb� diferents dels seus atributs)
       
        // Comprovar la igualtat amb el comparador == 
        System.out.println("t1 == t4? " + (t1 == t4));  
                       // mostra false pq t1 i t4 s�n refer�ncies distintes
                       // (refer�ncies a objectes en adreces de mem�ria diferents del heap)
        System.out.println("t1 == t2? " + (t1 == t2));                                 
        System.out.println("t1 == t3? " + (t1 == t3));  
                      // mostra false pq t1 i t2(t3) s�n refer�ncies distintes
                      // (refer�ncies a objectes en adreces de mem�ria diferents del heap)
                                        
        System.out.println("t1 i \"t2\" s�n iguals? " + t1.equals("t2"));  
                      // mostra false pq "t2" �s un String (no un Telescopi) i
                      // la instrucci� del m�tode equals: 
                      // o instanceof Telescopi s'avalua a false  
                                             
        // Qu� succeeix si NO s'ha usat instanceof en el m�tode equals?
        // L'error d'execuci� ClassCastException que es produeix �s f�cil d'explicar:
        // l'String "t2" �S UN Object, i la conversi� de tipus String (par�metre real) 
        // a Object (par�metre formal) �s autom�tica. 
        // PER� l'String "t2" NO �S UN Telescopi i la conversi� for�ada, via casting, 
        // que es produeix en el cos del m�tode equals, �s impossible.
    }
}
