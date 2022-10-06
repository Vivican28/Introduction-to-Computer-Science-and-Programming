/**
 * Classe PrimerPrograma: programa de prova de les classes Cercle, 
 * Rectangle i Pissarra
 * @author IIP
 * @version Curs 2019/20
 */ 
public class PrimerPrograma {
    // No s'usen objectes d'aquesta classe
    private PrimerPrograma() { }  
    
    public static void main(String[] args) {       
        // Crear meuaPissarra per a dibuixar, donant-li nom i dimensio
        Pissarra meuaPissarra = new Pissarra("ESPAI DIBUIX", 300, 300);
        
        // Crear un Cercle c1 de radi 50, groc, amb centre en (100,100)
        Cercle c1 = new Cercle(50, "groc", 100, 100);
        // Afegir-lo a la Pissarra i dibuixar-lo
        meuaPissarra.add(c1);
        
        // Crear un Rectangle r1 de 30 per 30, blau, amb centre en (125,125)
        Rectangle r1 = new Rectangle(30, 30, "blau", 125, 125);
        // Afegir-lo a la Pissarra i dibuixar-lo
        meuaPissarra.add(r1);  
        
        // Crear un Rectangle r2 de 100 per 10, roig, amb centre en (50,155)
        Rectangle r2 = new Rectangle(100, 10, "roig", 50, 155);
        // Afegir-lo a la Pissarra i dibuixar-lo
        meuaPissarra.add(r2);         
    }	
}
