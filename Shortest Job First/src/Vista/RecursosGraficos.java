package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**Clase RecursosGraficos: Contiene todas las librerias para hacer que la interfaz
 * sea mas sencilla de implementar*/
public class RecursosGraficos {

    /**Creacion del objeto ventana*/
    /**crearVentana: Crea una ventana
     * @param tituloVentana
     * @param rutaIconoAplicacion 
     * @param alto
     * @param ancho
     * 
     * @return ventana (JFrame)
     */
    public JFrame crearVentana(String tituloVentana, String rutaIconoAplicacion, int alto, int ancho){
        JFrame ventana = new JFrame(tituloVentana);
        /**Parametros basicos de la ventana*/
        ventana.setSize(alto,ancho);
        ventana.setUndecorated(false);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        /**Personalizacion de la ventana*/
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource(rutaIconoAplicacion));
        Image Image = ImageIcon.getImage();
        ventana.setIconImage(Image);
        return ventana;
    }
    
    /**añadirPanel: Añade JButtons JLabels y textFields a La ventana
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @return panel*/
    public JPanel agregarPanel(int posX, int posY, int ancho, int alto){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(posX, posY, ancho, alto);
        panel.setSize(ancho, alto);
        return panel;
    }
    
    /**crearBoton: utilidad para crear botones
     * @param textoBoton
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @param colorBoton
     * @return boton (JButton)(Sin ActionListener)
     */
    public JButton crearBoton(String textoBoton,int posX, int posY, int ancho, int alto,Color colorBoton){
        JButton boton = new JButton(textoBoton);
        /**Personalizacion del boton*/
        boton.setBackground(colorBoton);
        boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        boton.setBounds(new Rectangle(posX, posY, ancho, alto));
        return boton;
    }
    
    /**crearTexto: Utilidad para crear texto
     * @param mensaje
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @return: texto(JLabel);
     */
    public JLabel crearTexto(String mensaje,int posX, int posY, int ancho, int alto, Color colorTexto){
        JLabel texto = new JLabel(mensaje);
        texto.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        texto.setForeground(colorTexto);
        texto.setBounds(new Rectangle(posX, posY, ancho, alto));
        return texto;
    }
    
    /**crearInput: Utilidad para crear input de tipo JTextField
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @return campoTexto (JTextField)
     */
    public JTextField crearInput(int posX, int posY, int ancho, int alto){
        JTextField campoTexto = new JTextField();
        campoTexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        campoTexto.setBounds(new Rectangle(posX, posY, ancho, alto));
        campoTexto.setSize(ancho, alto);
        return campoTexto;
    }
    
    /**crearAreaTexto: Utilidad para crear input de tipo JTextArea
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @param colorFondo
     * @return areaTexto (JTextArea)
     */
    public JTextArea crearAreaTexto(int posX, int posY, int ancho, int alto, Color colorFondo){
        JTextArea areaTexto = new JTextArea();
        areaTexto.setBounds(posX, posY, ancho, alto);
        areaTexto.setBackground(colorFondo);
        areaTexto.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        areaTexto.setBorder(BorderFactory.createLineBorder(Color.black));
        return areaTexto;
    }

    /**obtenerColor: Retorna un objeto de tipo color segun lo que se le indique
     * @param nombreColor
     * @return pintura (Color)
    */
    public Color obtenerColor(String nombreColor){
        Color pintura = null;
        switch(nombreColor){
            case("verdeClaro"):
                pintura = new Color(0, 170, 72);
            case("violetaClaro"):
                pintura = new Color(172, 0, 184);
            case("grisOscuro"):
                pintura = new Color(35, 35, 35);
            case("grisClaro"):
                pintura = new Color(219, 219, 219);
        }
        return pintura;
    }

    /**crearTabla: crea una tabla con las dimensiones dadas
     * @param datosTabla (Arreglo bidimensional)
     * @param nombresColumnas
     * @param posX
     * @param posY
     * @param ancho
     * @param alto
     * @return JTable con Scroll
    */
    public JTable crearTabla(DefaultTableModel estructuraTabla, int posX,int posY,int ancho,int alto){        
        /**Creacion de la tabla */
        JTable tabla = new JTable(estructuraTabla);
        tabla.setBounds(posX, posY, ancho, alto);
        /**Añadido de complementos a la tabla */
        return tabla;
    }

    /**crearModelo: crea una estructura para las tablas del aplicativo
     * @param datosTabla
     * @param nombresColumnas
     * @return estructuraTabla
     */
    public DefaultTableModel crearModelo(String[][] datosTabla, String [] nombresColumnas){
        DefaultTableModel estructuraTabla = new DefaultTableModel( datosTabla, nombresColumnas);
        return estructuraTabla;
    }
}