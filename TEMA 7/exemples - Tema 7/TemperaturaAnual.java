/**
 * Classe TemperaturaAnual: classe que permet representar 
 * les mesures de temperatura mitjana en una zona geografica 
 * per a cada dia d'un any.
 * 
 * @author IIP 
 * @version Curs 2019-20
 */
public class TemperaturaAnual {
    public static final int[] NUM_DIES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // NUM_DIES[0] = 0 i NUM_DIES[i] = nº dies del mes i, 1 <= i <= 12
    private double[][] temp; 
    
    /** 
     * Constructor d'un objecte TemperaturaAnual.
     */
    public TemperaturaAnual() {
        temp = new double[13][];
        // temp[0] = null i temp[i] representa el mes i, 1 <= i <= 12
        for (int i = 1; i < temp.length; i++) {
            temp[i] = new double[NUM_DIES[i] + 1];
            // el nº d’elements de temp[i] = NUM_DIES[i] + 1, 1 <= i <= 12
        }
        // temp[i][j] representarà la temperatura mitjana 
        // del dia j del mes i.    
    }
    
    /**
     * Torna la temperatura mitjana d'un dia i un mes donats (vàlids).
     * @param m int, el mes.
     * @param d int, el dia.
     * @return double, la temperatura.
     */
    public double getTempMitjana(int m, int d) { return temp[m][d]; }
    
    /**
     * Actualitza la temperatura mitjana d'un dia i un mes donats (vàlids).
     * @param m int, el mes.
     * @param d int, el dia.
     * @param t double, la temperatura.
     */
    public void setTempMitjana(int m, int d, double t) { temp[m][d] = t; }
    
    /**
     * Mostra la temperatura enregistrada cada dia de l’any.
     * Estratègia: recorregut iteratiu ascendent.
     */
    public void mostrarTemp() {
        for (int i = 1; i < temp.length; i++) {
            System.out.println("Mes: " + i);
            for (int j = 1; j < temp[i].length; j++) {
                System.out.print("Dia: " + j);
                System.out.println(" Temp: " + temp[i][j]);
            }
        }
    }  
    
    /**
     * Mostra quina és la primera mesura mínima i quan es va produir.
     * Estratègia: recorregut iteratiu ascendent.
     */
    public void mostrarPrimeraMiniDia() {
        double tempMin = Double.MAX_VALUE;
        int mesMin = 0, diaMin = 0;
        for (int i = 1; i < temp.length; i++) {
            for (int j = 1; j < temp[i].length; j++) {
                if (temp[i][j] < tempMin) { 	
                    tempMin = temp[i][j];
                    mesMin = i;
                    diaMin = j;
                }
            }
        }
        System.out.print("Mes: " + mesMin + " Dia: " + diaMin);
        System.out.println(" Temp: " + tempMin);
    }

    /**
     * Mostra la primera data en què es van enregistrar 40º.
     * Estratègia: cerca linial iterativa ascendent.
     */
    public void mostrarPrimerDia40() {   
        int i = 1, j = 0; 
        boolean trobat = false;
        while (i < temp.length && !trobat) {
            j = 1;
            while (j < temp[i].length && !trobat) {
                trobat = (temp[i][j] == 40);
                j++;
            }
            i++;
        }
        if (trobat) {
            System.out.print("40º mesurat el dia " + (j - 1));
            System.out.println(" del mes " + (i - 1));
        }
        else { System.out.println("Cap dia amb 40º"); }
    }
}
