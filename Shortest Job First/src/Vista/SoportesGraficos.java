package Vista;

import javax.swing.table.DefaultTableModel;

/**Clase SoportesGraficos: contiene las operaciones que ayudan al usuario
 * a interactuar mejor con la Clase RecursosGraficos.java
*/
public class SoportesGraficos{
    /**agregarFila: añade una Fila a la tabla en cuestion
     * @param modelo
     * @param registro
    */
    public void agregarFila(DefaultTableModel modelo, String [] registro){
        modelo.addRow(registro);
    }

    /**eliminarFila: elimina una fila de la tabla en cuestion
     * @param modelo
     * @param numeroFila
    */
    public void eliminarFila(DefaultTableModel modelo, int numeroFila){
        modelo.removeRow(numeroFila);
    }

    /**agregarColumna: crea una columna en la tabla en cuestion
     * @param modelo
     * @param nombreColumna
    */
    public void eliminarFila(DefaultTableModel modelo, String nombreColumna){
        modelo.addColumn(nombreColumna);
    }
}