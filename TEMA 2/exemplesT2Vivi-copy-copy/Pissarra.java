import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Classe Pissarra: defineix una Pissarra sobre la que es poden 
 * dibuixar elements de tipus Cercle i Rectangle.
 * @author IIP
 * @version Curs 2019/20
 */
public class Pissarra extends JFrame { 
    // Elements per defecte de la Pissarra:
    private static int DIM_X = 200;
    private static int DIM_Y = 200;
    private static int NUM_MIN = 8;
    
    // Constants figures possibles
    private static final int DESCONEGUT = -1;
    private static final int CERCLE = 0;
    private static final int RECTANGLE = 1;   
     
    // Constants arrays de colors
    private static final String[] NOM_COLS = {"roig", "groc", "verd", 
                                              "blau", "taronja", "negre", 
                                              "blanc", "gris", "rosa"};
            
    private static final Color[] COLS = {Color.red, Color.yellow, Color.green, 
                                         Color.blue, Color.orange, Color.black, 
                                         Color.white, Color.gray, Color.pink};
             
    private static final Color COLOR_PER_DEFECTE = Color.black;
    
    // Atributs magatzem objectes gràfics
    private Object[] gOL = new Object[NUM_MIN];
    private int numGO = 0;
                
    /**
     * Crea una Pissarra per defecte en la que és possible
     * situar elements gràfics.
     */         
    public Pissarra() {
        super("La pissarra per defecte");
        setSize(DIM_X, DIM_Y);
        setContentPane(initPanel());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Crea una Pissarra amb cert títol i tamany en la que es 
     * possible situar elements gràfics.
     * @param titol String, el títol que te la Pissarra.
     * @param dimX int, dimensió horitzontal en píxels de la Pissarra.
     * @param dimY int, dimensió vertical en píxels de la Pissarra.
     */    
    public Pissarra(String titol, int dimX, int dimY) {
        super(titol);
        setSize(dimX, dimY);
        setContentPane(initPanel());    
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Afegeix un objecte gràfic a la Pissarra i el dibuixa.
     * @param o Object, l'objecte gràfic a ser mostrat.
     */
    public void add(Object o) {
        if (numGO == gOL.length) { dupMem(); }
        gOL[numGO++] = o;
        repaint();
    }
    
    /**
     * Redibuixa tots els elements gràfics que s'han afegit a la Pissarra.
     */
    public void dibuixaTot() {
        repaint();
    }
    
    private void dupMem() {
        Object[] aux = new Object[2 * gOL.length];
        for (int i = 0; i < gOL.length; i++) { aux[i] = gOL[i]; }
        gOL = aux;
    }
           
    private JPanel initPanel() {
        JPanel jp = new JPanel() {           
            // sobreescriptura de paintComponent
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                for (int i = 0; i < numGO; i++) {
                    int tipus = tipusClase(gOL[i]);
                                        
                    switch (tipus) {                         
                        case CERCLE: 
                            dibCercle(gOL[i], g); 
                            break;                        
                        case RECTANGLE: 
                            dibRectangle(gOL[i], g); 
                            break;                         
                        default: 
                            break;
                    } 
                    
                }                
            };            
        };
        return jp;
    }
    
    private int tipusClase(Object o) {
        if (o instanceof Cercle) { return CERCLE; }
        else if (o instanceof Rectangle) { return RECTANGLE; }       
        else { return DESCONEGUT; }
    }
    
    private Color elColor(String c) {
        int i = 0;
        for (; i < NOM_COLS.length 
             && !NOM_COLS[i].equalsIgnoreCase(c); i++) { ; }
        
        if (i >= NOM_COLS.length) { return COLOR_PER_DEFECTE; }
        else { return COLS[i]; }
    }    
    
    /* ***************************************************************** */
    /*             Mètodes per a dibuixar cada tipus de figura.          */
    /* ***************************************************************** */  
    private void dibCercle(Object o, Graphics g) {
        Cercle c = (Cercle) o;
        
        int rad = (int) Math.round(c.getRadi());
        int diametre = (int) Math.round(c.getRadi() * 2.0);
        int cX = c.getCentreX();
        int cY = c.getCentreY();
        
        g.setColor(elColor(c.getColor()));        
        g.fillOval(cX - rad, cY - rad, diametre, diametre); 
    }        
       
    private void dibRectangle(Object o, Graphics g) {
        Rectangle r = (Rectangle) o;
        
        int base = (int) Math.round(r.getBase());
        int altura = (int) Math.round(r.getAltura());
        int semibase = (int) Math.round(r.getBase() / 2.0);
        int semialtura = (int) Math.round(r.getAltura() / 2.0);        
        
        int esqX = r.getCentreX() - semibase;
        int esqY = r.getCentreY() - semialtura;
        
        g.setColor(elColor(r.getColor()));
        g.fillRect(esqX, esqY, base, altura);
    }    
} // de Pissarra
