
/**
* Write a description of class dibujarRectangulo here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class dibujarRectangulo {
     /** PRECONDICIÓN: base y altura MAYORES que 1; margen MAYOR o IGUAL que 0
     * CAP CCDIJ4ai
     *  Dado un cierto margen (izquierdo), una base y una altura, 
     *  devuelve el dibujo (String) del correspondiente rectángulo 
     *  realizado con asteriscos (y espacios en blanco).
     *
     *  En concreto, si margen = 0, el lado izquierdo del rectángulo  
     *  aparecerá "pegado" al borde izquierdo del área donde se dibuje;  
     *  sino, aparecerá "separado" margen blancos de él.
     */
    public static String dibujarRectangulo(int base, int altura, int margen) {
        String rectangulo = "";
        rectangulo += "\n";
        for (int i = 0; i < altura; i++) {
            for(int k = 0; k < margen; k++) {
                rectangulo += " ";
            }
            for (int j = 0; j < base; j++) {
                rectangulo += "*";
            }
            rectangulo += "\n";
        }
        
        return rectangulo;
    }
    
    /** Lo mismo pero ejecutable mediante un void */
    
    public static void rectangle(int base, int altura) {
        System.out.println();
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    /** PRECONDICIÓN: base IMPAR y MAYOR QUE 3
     *  CAP CCDIK4ai
     *  Dada una base, devuelve el dibujo (String) del 
     *  correspondiente triángulo isósceles realizado 
     *  con asteriscos (y espacios en blanco).
     */
    public static String dibujarTriangulo(int base) {
        String triangulo = "";
        int altura = (base + 1) / 2;
        
        for (int k = 1; k <= altura; k++) {
            for (int i = 1; i <= altura - k; i++) {
                triangulo += " ";
            }
            for (int j = 0; j < 2 * k - 1; j++) {
                triangulo += "*";
            }
            triangulo += "\n";
            
        }
        return triangulo;
    }
    
    public static void triangleRect(int base) {
        System.out.println();
        for (int i = 1; i < base; i++) {
           for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }    
    }
    
    /** PRECONDICIÓN: baseArbol IMPAR MAYOR o IGUAL que 7
     * CAP CCDIL4ai
     *  Devuelve el dibujo (String) de un Árbol de Navidad compuesto por ... 
     *  (1) Un triángulo (árbol) de base baseArbol 
     *  (2) Un rectángulo (maceta) de base 3, altura 2 y CENTRADO en el  
     *      MEDIO de la base del triángulo
     */
     public static String dibujarArbolNavidad(int baseArbol) {
        //PASO 1: obtener el dibujo de un triángulo de base baseArbol
        String arbol = dibujarTriangulo(baseArbol); 
        
        // Como el rectángulo (maceta) de base 3 y altura 2 que compone 
        // el Árbol de Navidad debe estar centrado en el medio de la base 
        // del triángulo, su margen tiene que ser MAYOR QUE 0
        int margenR = (baseArbol - 3) / 2;
        
        //PASO 2: obtener el dibujo de un rectángulo de base 3, altura 2 
        //        y margenR
        String rectangulo = dibujarRectangulo(3, 2, margenR); 
        
        //PASO 3: obtener el dibujo del Árbol de Navidad a partir de los del
        //triángulo (árbol) y rectángulo (maceta)
        String arbolNavidad = arbol + rectangulo;
        
        return arbolNavidad;
     }
}
