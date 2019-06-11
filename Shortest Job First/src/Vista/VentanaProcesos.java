package Vista;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaProcesos{

    private RecursosGraficos herramientasGraficas;
    private SoportesGraficos herramientasSoporte;
    
    public JButton botonIniciar;
    public JButton botonBloquear;
    public JButton botonDesbloquear;
    public JButton botonAgregarProceso;

    /**crearVentana: crea la ventana Principal de la aplicacion*/
    
    public void crearVentana(){
        herramientasGraficas = new RecursosGraficos();
        herramientasSoporte = new SoportesGraficos();
        JFrame ventanaPrincipal = herramientasGraficas.crearVentana("Shortest Job First", "../Recursos/iconoPrograma.png", 1366, 768);
        ventanaPrincipal.add(crearPanelProcesosListos());
        ventanaPrincipal.add(crearPanelProcesosBloqueados());
        ventanaPrincipal.add(crearPanelProcesosEjecucion());
        ventanaPrincipal.add(crearPanelBotones());
        ventanaPrincipal.add(crearPanelGantt());

        ventanaPrincipal.setVisible(true);
    }
    /**crearPanelProcesosListos: crea un panel con el contenido de la tabla de procesos listos
     * @return panelProcesosListos (JPanel)
     */
    private JPanel crearPanelProcesosListos(){
        JPanel panelProcesosListos = herramientasGraficas.agregarPanel(10,10,330,290);

        /**Añadido de elementos al Panel */
        panelProcesosListos.add(crearTablaListos());

        /**Personalizacion del panel */
        panelProcesosListos.setBorder(BorderFactory.createTitledBorder("Procesos Listos (Seccion Critica)"));
        panelProcesosListos.setLayout(new BorderLayout());
        return panelProcesosListos;
    }
    
    /**crearPanelProcesosBloqueados: crea un panel con el contenido de la tabla de procesos bloqueados
     * @return panelProcesosBloqueados (JPanel)
     */    
    private JPanel crearPanelProcesosBloqueados(){
        JPanel panelProcesosBloqueados = herramientasGraficas.agregarPanel(350,10,330,290);

        /**Añadido de elementos al Panel */
        panelProcesosBloqueados.add(crearTablaBloqueados());

        /**Personalizacion del panel */
        panelProcesosBloqueados.setBorder(BorderFactory.createTitledBorder("Procesos Bloqueados"));
        panelProcesosBloqueados.setLayout(new BorderLayout());
        return panelProcesosBloqueados;
    }

    /**crearPanelEjecucion: crea un panel con el contenido de la tabla de procesos en ejecucion
     * @return panelProcesosEjecucion (JPanel)
     */    
    private JPanel crearPanelProcesosEjecucion(){
        JPanel panelProcesosEjecucion = herramientasGraficas.agregarPanel(680,10,660,290);

        /**Añadido de elementos al Panel */
        panelProcesosEjecucion.add(crearTablaEjecucion());

        /**Personalizacion del panel */
        panelProcesosEjecucion.setBorder(BorderFactory.createTitledBorder("Procesos ejecutados"));
        panelProcesosEjecucion.setLayout(new BorderLayout());
        return panelProcesosEjecucion;
    }

    /**crearPanelBotones: crea la botonera de la aplicacion */
    private JPanel crearPanelBotones(){
        JPanel panelBotones = herramientasGraficas.agregarPanel(10,320,1326,50);

        /**creacion de botones */
        botonIniciar = herramientasGraficas.crearBoton("Iniciar", 10, 10, 100, 25, herramientasGraficas.obtenerColor("verdeClaro"));
        botonBloquear = herramientasGraficas.crearBoton("Bloquear", 115, 10, 100, 25, herramientasGraficas.obtenerColor("verdeClaro"));
        botonDesbloquear = herramientasGraficas.crearBoton("Desbloquear", 220, 10, 140, 25, herramientasGraficas.obtenerColor("verdeClaro"));
        botonAgregarProceso = herramientasGraficas.crearBoton("Agregar Proceso", 370, 10, 160, 25, herramientasGraficas.obtenerColor("verdeClaro"));
        /**Agregacion de los botones al JPanel */
        panelBotones.add(botonIniciar);
        panelBotones.add(botonBloquear);
        panelBotones.add(botonDesbloquear);
        panelBotones.add(botonAgregarProceso);

        return panelBotones;
    }


    /**crearPanelGantt: crea el panel que contendra el diagrama de Gantt
     * @return panelGantt (JPanel)
     */
    private JPanel crearPanelGantt(){
        JPanel panelGantt = herramientasGraficas.agregarPanel(10, 300, 1366, 900);
        panelGantt.setBackground(herramientasGraficas.obtenerColor("verdeClaro"));
        return panelGantt;
    }
    
    /**crearTablaListos: crea una tabla que muestra los procesos listos para su ejecucion
     * @return tablaProcesos (JTable)
     */
    private JTable crearTablaListos(){
        String [] nombresColumnas = {"Proceso","Prioridad","T. Llegada","T. Rafaga"};
        String [][] datosTabla = {
             {"Proceso","Prioridad","T. Llegada","T. Rafaga"}
        };
        DefaultTableModel modeloProcesosListos = herramientasGraficas.crearModelo(datosTabla,nombresColumnas);
        JTable tablaProcesos = herramientasGraficas.crearTabla(modeloProcesosListos,10,20,300,260);
        return tablaProcesos;
    }
    
    /**crearTablaBloqueados: crea una tabla que muestra los procesos que se "Bloquean" en
     * el procesador
     * @return tablaBloqueadors (JTable)
     */
    private JTable crearTablaBloqueados(){
        String [] nombresColumnas = {"Proceso","Prioridad","T. Llegada","T. Rafaga"};
        String [][] datosTabla = {
             {"Proceso","Prioridad","T. Llegada","T. Rafaga"}
        };
        DefaultTableModel modeloProcesosBloqueados = herramientasGraficas.crearModelo(datosTabla,nombresColumnas);
        JTable tablaBloqueados = herramientasGraficas.crearTabla(modeloProcesosBloqueados,10,20,300,260);
        return tablaBloqueados;
    }
    
    /**crearTablaEjecucion: crea la tabla con los procesos que actualmente estan en ejecucion
     * @return tablaEjecucion (JTable)
     */
    private JTable crearTablaEjecucion(){
        String [] nombresColumnas = {"Proceso","Prioridad","T. Llegada","T. Rafaga","T. Comienzo","T. Final","T. Retorno","T. Espera"};
        String [][] datosTabla = {
             {"Proceso","Prioridad","T. Llegada","T. Rafaga","T. Comienzo","T. Final","T. Retorno","T. Espera"}
        };
        DefaultTableModel modeloProcesosEjecucion = herramientasGraficas.crearModelo(datosTabla,nombresColumnas);
        JTable tablaEjecucion = herramientasGraficas.crearTabla(modeloProcesosEjecucion,10,20,630,260);
        
        herramientasSoporte.agregarFila(modeloProcesosEjecucion,nombresColumnas);
        return tablaEjecucion;
    }
}