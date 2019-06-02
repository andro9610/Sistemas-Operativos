/**Algoritmos de planificacion
 * 
 * Este aplicativo tiene como finalidad mostrar graficamente el comportamiento
 * de diferentes formas de planificacion de procesos, actualmente posee:
 * - FCFS (First Come, First Served)
 * - SJF (Shortest Job First)
 * 
 * Para el calculo y la graficacion requiere:
 * - La cantidad de procesos
 * - El tiempo de rafaga de cada proceso
 * 
 * Como resultado retorna:
 * - Tabla de tiempos calculados
 * - Diagrama de Gantt de los procesos, segun la politica de planificacion
 *   de procesos que se escoja
 * 
 * Integrantes:
 * 
 * Miguel Rojas - 20132020059
 * Andres Tovar - 20142020071
 * 
 * Fecha de presentacion:
 * 
 * 30 de Mayo de 2019
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Planificador {

    public Proceso p;
    public ArrayList<Proceso> listaprocesosA = new ArrayList<Proceso>();
    public ArrayList<Proceso> listaprocesosB = new ArrayList<Proceso>();
    
    Tabla tl = new Tabla();

    /**Inicializar: recibe la cantidad de procesos a calcular, tomando el tiempo
     * de rafaga de cada uno de ellos
    */
    public void inicializar() {
        int pro;
        pro = Integer.parseInt(JOptionPane.showInputDialog("Inserte la cantidad de procesos"));
        for (int i = 0; i < pro; i++) {
            int cont = 1 + i;
            p = new Proceso();
            p.setNombre("P"+ cont);
            p.setLlegada(i);
            p.setRafaga(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la rafaga del proceso "+p.getNombre())));
            listaprocesosA.add(p);
        }

    }

    /**ejecutarFcfs: Tiene el contenido del algoritmo Fcfs*/
    public void ejecutarFcfs() {

        this.inicializar();

        Iterator it = listaprocesosA.iterator();
        int time = 0;
        int contador = 0;
        while (it.hasNext()) {
            Proceso p = (Proceso) it.next();

            if (p.getLlegada() == contador) {
                /**Se realizan los calculos segun las formulas dads en clase*/
                p.setComienzo(time);
                p.setFin(p.getComienzo() + p.getRafaga());
                p.setRetorno(p.getFin() - p.getLlegada());
                p.setEspera(p.getRetorno() - p.getRafaga());
                time = p.getFin();

            }
            contador++;
        }
    }
    /**ejecutarSjf: Tiene el contenido del algoritmo Sjf*/
    public void ejecutarSjf() {
        this.inicializar();
        Iterator it = listaprocesosA.iterator();

        int time = 0;
        int contador = 0;
        for (int i = 0; i < 1; i++) {
            Proceso p = listaprocesosA.get(i);

            p.setComienzo(time);
            p.setFin(p.getComienzo() + p.getRafaga());
            p.setRetorno(p.getFin() - p.getLlegada());
            p.setEspera(p.getRetorno() - p.getRafaga());
            time = p.getFin();
            listaprocesosB.add(p);
            listaprocesosA.remove(i);
            
        }

        
        

        Collections.sort(listaprocesosA, new Comparator<Proceso>() {

            @Override
            public int compare(Proceso p1, Proceso p2) {
                return new Integer(p1.getRafaga()).compareTo(new Integer(p2.getRafaga()));
            }
        });
        for (int i = 0; i < listaprocesosA.size(); i++) {
             Proceso p = listaprocesosA.get(i);

            p.setComienzo(time);
            p.setFin(p.getComienzo() + p.getRafaga());
            p.setRetorno(p.getFin() - p.getLlegada());
            p.setEspera(p.getRetorno() - p.getRafaga());
            time = p.getFin();
            listaprocesosB.add(p);
            
            

        }
        Collections.sort(listaprocesosB, new Comparator<Proceso>() {

            @Override
            public int compare(Proceso p1, Proceso p2) {
                return new Integer(p1.getLlegada()).compareTo(new Integer(p2.getLlegada()));
            }
        });
    }

    public void mostrarSiguiente() {
            Iterator it = listaprocesosA.iterator();
            while (it.hasNext()) {
                Proceso p = (Proceso) it.next();
                tl.Agregar(p.getLlegada(), p.getNombre(), p.getRafaga(), p.getComienzo(), p.getFin(), p.getRetorno(), p.getEspera());
            }
            tl.setVisible(true);
        }
}
