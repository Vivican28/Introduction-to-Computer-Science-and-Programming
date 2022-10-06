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
        // Crear un Telescopi de diàmetre 76.2, 
        // distància focal 165.1 i distància focal ocular 20.32,
        // cridant al constructor amb 3 paràmetres
        Telescopi t1 = new Telescopi(76.2, 165.1, 20.32);
       
        // Crear un Telescopi de diàmetre 76.2 
        // i distància focal i ocular estàndard,
        // cridant al constructor amb 1 paràmetre que correspon al diàmetre
        Telescopi t2 = new Telescopi(76.2);
       
        // Crear un Telescopi estàndard,
        // cridant al constructor per defecte, sense paràmetres
        Telescopi t3 = new Telescopi();
       
        // Mostrar per pantalla els augments i la relació focal de cada telescopi
        System.out.printf(Locale.US, "\nTelescopi 1 --> Augments: %.2f", t1.augments());  
        System.out.printf(Locale.US, "\n            --> Relació focal: %.2f", t1.relacioFocal());
        System.out.printf(Locale.US, "\nTelescopi 2 --> Augments: %.2f", t2.augments());  
        System.out.printf(Locale.US, "\n            --> Relació focal: %.2f", t2.relacioFocal());
        System.out.printf(Locale.US, "\nTelescopi 3 --> Augments: %.2f", t3.augments());  
        System.out.printf(Locale.US, "\n            --> Relació focal: %.2f\n", t3.relacioFocal());
        System.out.println();
        
        // Mostrar per pantalla les característiques dels telescopis       
        System.out.println("Telescopi 1: " + t1);  
                    // recorda s'està invocant al mètode toString()
                    // és a dir, ací t1 és equivalent a t1.toString()
        System.out.println("Telescopi 2: " + t2);  
                    // ací t2 és equivalent a t2.toString()
        System.out.println("Telescopi 3: " + t3);  
                    // ací t3 és equivalent a t3.toString()
       
        // Crear un Telescopi de diàmetre 76.2, distància focal 165.1 
        // i distància focal ocular 20.32,
        // cridant al constructor general (amb 3 paràmetres)
        Telescopi t4 = new Telescopi(76.2, 165.1, 20.32);
        System.out.println("Telescopi 4: " + t4 + "\n");  
       
        // Comprovar la igualtat amb equals: 
        // t1 i t4 són iguals però t1 i t2 no, i t1 i t3 no
        System.out.println("t1 i t4 són iguals? " + t1.equals(t4)); 
                           // mostra true pq els valors dels atributs de 
                           // l'objecte referenciat per t1 són iguals als 
                           // valors dels atributs de l'objecte referenciat 
                           // per t4 (dos objectes diferents en el heap però 
                           // amb valors idèntics dels seus atributs)
        System.out.println("t1 i t2 són iguals? " + t1.equals(t2));
        System.out.println("t1 i t3 són iguals? " + t1.equals(t3)); 
                           // mostra false pq els valors dels atributs de
                           // l'objecte referenciat per t1 són diferents dels 
                           // valors dels atributs de l'objecte referenciat 
                           // per t2(t3) (objectes diferents en el heap 
                           // amb valors també diferents dels seus atributs)
       
        // Comprovar la igualtat amb el comparador == 
        System.out.println("t1 == t4? " + (t1 == t4));  
                       // mostra false pq t1 i t4 són referències distintes
                       // (referències a objectes en adreces de memòria diferents del heap)
        System.out.println("t1 == t2? " + (t1 == t2));                                 
        System.out.println("t1 == t3? " + (t1 == t3));  
                      // mostra false pq t1 i t2(t3) són referències distintes
                      // (referències a objectes en adreces de memòria diferents del heap)
                                        
        System.out.println("t1 i \"t2\" són iguals? " + t1.equals("t2"));  
                      // mostra false pq "t2" és un String (no un Telescopi) i
                      // la instrucció del mètode equals: 
                      // o instanceof Telescopi s'avalua a false  
                                             
        // Què succeeix si NO s'ha usat instanceof en el mètode equals?
        // L'error d'execució ClassCastException que es produeix és fàcil d'explicar:
        // l'String "t2" ÉS UN Object, i la conversió de tipus String (paràmetre real) 
        // a Object (paràmetre formal) és automàtica. 
        // PERÒ l'String "t2" NO ÉS UN Telescopi i la conversió forçada, via casting, 
        // que es produeix en el cos del mètode equals, és impossible.
    }
}
