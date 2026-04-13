import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;

public class l_orden extends JFrame {
    private LinkedList<Cliente> listaClientes;
    private JTextField ing_nombre;
    private JComboBox<String> comboOperacion;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    // Clase interna para representar un cliente
    private static class Cliente implements Comparable<Cliente> {
        String nombre;
        String tipoOperacion;

        Cliente(String nombre, String tipoOperacion) {
            this.nombre = nombre;
            this.tipoOperacion = tipoOperacion;
        }

        // Ordenar por nombre alfabeticamente
        @Override
        public int compareTo(Cliente otro) {
            return this.nombre.compareToIgnoreCase(otro.nombre);
        }
    }

    public l_orden() {
        listaClientes = new LinkedList<>();

        setTitle("Sistema de Atencion con Lista Ordenada");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 5, 5));
        panelEntrada.add(new JLabel("Nombre del cliente:"));
        ing_nombre = new JTextField(15);
        panelEntrada.add(ing_nombre);

        panelEntrada.add(new JLabel("Tipo de operacion:"));
        comboOperacion = new JComboBox<>(new String[]{"Caja", "Plataforma", "Reclamos"});
        panelEntrada.add(comboOperacion);

        add(panelEntrada, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregar = new JButton("Agregar cliente");
        JButton btnEliminar = new JButton("Eliminar cliente");
        JButton btnReiniciar = new JButton("Reiniciar lista");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnReiniciar);
        add(panelBotones, BorderLayout.SOUTH);

        // Tabla
        modeloTabla = new DefaultTableModel(new Object[]{"Nombre", "Tipo Operacion"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER);

        // Eventos
        btnAgregar.addActionListener(e -> agregarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());
        btnReiniciar.addActionListener(e -> reiniciarLista());

        actualizarTabla();
    }

    private void agregarCliente() {
        String nombre = ing_nombre.getText().trim();
        String tipo = (String) comboOperacion.getSelectedItem();

        if (!nombre.isEmpty()) { //validacion para evitar agregar clientes sin nombre
            Cliente nuevo = new Cliente(nombre, tipo);

            // Insertar en la lista manteniendo orden
            int i = 0;
            //compare to srive para ordenar alfabeticamente
            while (i < listaClientes.size() && listaClientes.get(i).compareTo(nuevo) < 0) { //comparar el nuevo cliente con los existentes para encontrar la posicion correcta
                i++; //cuando encuentra el lugar correcto se detiene
            }
            listaClientes.add(i, nuevo); //inserta el cliente en la posicion adecuada

            ing_nombre.setText(""); //limpia el campo de texto y actualiza la tabla para mostrar el nuevo cliente
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarCliente() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            listaClientes.remove(fila);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente en la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void reiniciarLista() {
        listaClientes.clear();
        actualizarTabla();
        JOptionPane.showMessageDialog(this, "La lista ha sido vaciada.", "Reinicio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0); //elimina todas las filas anteriores para evitar duplicados 
        for (Cliente cliente : listaClientes) { //recorre la lista de clientes
            modeloTabla.addRow(new Object[]{cliente.nombre, cliente.tipoOperacion}); //agrega cada cliente a la tabla
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            l_orden app = new l_orden();
            app.setVisible(true);
        });
    }
}
