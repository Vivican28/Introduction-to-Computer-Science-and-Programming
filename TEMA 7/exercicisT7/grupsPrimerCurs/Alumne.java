package grupsPrimerCurs;

import java.util.Scanner;
/**
 * Classe Alumne que representa a un alumne.
 * 
 * @author IIP
 * @version Curs 2019-20
 */
public class Alumne {
    private long dni;
    private double nota;
    private String nom;
    private boolean assistencia;
    private char grup;
    
    /**
     * Crea un objecte Alumne, el nom i dni del qual s'introdueixen per teclat.
     */
    public Alumne(Scanner tec) {        
        System.out.println("Introdueix les dades d'un alumne");
        System.out.print("Nom: "); nom = tec.nextLine();
        System.out.print("Dni: "); dni = tec.nextLong();
        assistencia = true;
        nota = 0;
        grup = ' ';
    }
    
    /**
     * Crea un objecte Alumne, a partir de les dades de 
     * nom, dni, grup i nota donades.
     */
    public Alumne(String n, long d, char g, double not) {
        nom = n;
        dni = d;
        assistencia = true;
        nota = not;
        grup = g;
    }
    
    /** 
     * Torna el dni de l'alumne.
     * @return long, el dni.
     */
    public long getDni() { return dni; }
    
    /** 
     * Torna la nota de l'alumne.
     * @return double, la nota.
     */
    public double getNota() { return nota; }
    
    /** 
     * Torna el nom de l'alumne.
     * @return String, el nom.
     */
    public String getNom() { return nom; }
    
    /** 
     * Torna l'assistència de l'alumne.
     * @return boolean, true si ha assistit o false en cas contrari.
     */
    public boolean getAssistencia() { return assistencia; }
    
    /** 
     * Torna el grup de matrícula de l'alumne.
     * @return char, el grup.
     */
    public char getGrup() { return grup; }
    
    /** 
     * Actualitza la nota de l'alumne.
     * @param d double.
     */
    public void setNota(double d) { nota = d; }
    
    /** 
     * Actualitza l'assitència de l'alumne.
     * @param a boolean.
     */
    public void setAssistencia(boolean a) { assistencia = a; }
    
    /** 
     * Actualitza el grup de matrícula de l'alumne.
     * @param g char.
     */
    public void setGrup(char g) { grup = g; }
    
    /**
     * Torna un String amb les dades de l'alumne.
     * @return String.
     */
    public String toString() {
        return "Nom: " + nom + "\tDni: " + dni 
            + "\nGrup: " + grup + "  Nota: " + nota 
            + "  Assistència: " + (assistencia ? "sí" : "no") + "\n"; 
    }
}
