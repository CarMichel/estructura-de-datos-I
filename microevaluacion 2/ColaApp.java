import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColaApp extends JFrame {
    private Queue<Cliente> cola;
    private JTextField ing_nombre;
    private JComboBox<String> comboOperacion;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private int contadorCaja = 1;
    private int contadorPlataforma = 1;
    private int contadorReclamos = 1;

    // Clase interna para guardar datos del cliente
    private static class Cliente {
        String posicion;
        String nombre;
        String tipoOperacion;

        Cliente(String posicion, String nombre, String tipoOperacion) {
            this.posicion = posicion;
            this.nombre = nombre;
            this.tipoOperacion = tipoOperacion;
        }
    }

    public ColaApp() {
        cola = new LinkedList<>();

        setTitle("Sistema de Atencion al Cliente (Cola)");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.add(new JLabel("Nombre del cliente:"));
        ing_nombre = new JTextField(15);
        panelEntrada.add(ing_nombre);

        panelEntrada.add(new JLabel("Tipo de operación:"));
        comboOperacion = new JComboBox<>(new String[]{"Caja", "Plataforma", "Reclamos"});
        panelEntrada.add(comboOperacion);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar cliente");
        JButton btnAtender = new JButton("Atender cliente");
        JButton btnReiniciar = new JButton("Reiniciar cola");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnAtender);
        panelBotones.add(btnReiniciar);
        add(panelBotones, BorderLayout.SOUTH);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"Posicion", "Nombre", "Tipo Operacion"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Ajustar ancho de columnas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(40);   // Posicion
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);  // Nombre
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);  // Tipo Operacion

        // Eventos
        btnAgregar.addActionListener(e -> agregarCliente());
        btnAtender.addActionListener(e -> atenderCliente());
        btnReiniciar.addActionListener(e -> reiniciarCola());

        actualizarTabla();
    }

    private void agregarCliente() {
        String nombre = ing_nombre.getText().trim();
        String tipo = (String) comboOperacion.getSelectedItem();

        if (!nombre.isEmpty()) {
            String posicion = generarPosicion(tipo);
            Cliente cliente = new Cliente(posicion, nombre, tipo);
            cola.add(cliente);

            ing_nombre.setText("");
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String generarPosicion(String tipo) {
        switch (tipo) {
            case "Caja":
                return "A-" + String.format("%03d", contadorCaja++);
            case "Plataforma":
                return "B-" + String.format("%03d", contadorPlataforma++);
            case "Reclamos":
                return "C-" + String.format("%03d", contadorReclamos++);
            default:
                return "X-000";
        }
    }

    private void atenderCliente() {
        if (!cola.isEmpty()) {
            Cliente cliente = cola.poll();
            JOptionPane.showMessageDialog(this, "Se atendió a: " + cliente.nombre + " (" + cliente.tipoOperacion + ")", 
                                          "Atención", JOptionPane.INFORMATION_MESSAGE);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "No hay clientes en la cola.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void reiniciarCola() {
        cola.clear();
        contadorCaja = 1;
        contadorPlataforma = 1;
        contadorReclamos = 1;
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "La cola ha sido vaciada.", "Reinicio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        int i = 1;
        for (Cliente cliente : cola) {
            if (i > 10) break;
            modeloTabla.addRow(new Object[]{cliente.posicion, cliente.nombre, cliente.tipoOperacion});
            i++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColaApp app = new ColaApp();
            app.setVisible(true);
        });
    }
}

