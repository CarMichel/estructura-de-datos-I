import javax.swing.*;
import java.awt.*;

// Clase Nodo: representa cada elemento de la lista simple
class Nodo {
    int dato;        // valor del nodo
    Nodo siguiente;  // referencia al siguiente nodo

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

// Clase ListaSimple: maneja la lista enlazada con recursividad
class ListaSimple {
    Nodo cabeza; // primer nodo de la lista

    // f001_insertar_final: inserta un nodo al final de la lista
    public void f001_insertar_final(int valor) {
        cabeza = f002_insertar_recursivo(cabeza, valor);
    }

    // f002_insertar_recursivo: recorre la lista hasta el final y agrega el nuevo nodo
    private Nodo f002_insertar_recursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor); // caso base: lista vacía o final alcanzado
        }
        actual.siguiente = f002_insertar_recursivo(actual.siguiente, valor);
        return actual;
    }

    // f003_mostrar: devuelve todos los elementos de la lista como texto
    public String f003_mostrar() {
        return f004_mostrar_recursivo(cabeza);
    }

    // f004_mostrar_recursivo: recorre la lista y concatena los valores
    private String f004_mostrar_recursivo(Nodo actual) {
        if (actual == null) return ""; // caso base: fin de la lista
        return actual.dato + "; " + f004_mostrar_recursivo(actual.siguiente);
    }
}

// Clase principal con interfaz gráfica
public class micro3 extends JFrame {
    private JTextField txtValor;
    private JTextArea txtResultado;
    private ListaSimple lista;

    public micro3() {
        setTitle("Lista Simple con Recursividad");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lista = new ListaSimple();

        // Panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Campo para ingresar valor
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Valor:"), gbc);

        txtValor = new JTextField(10);
        gbc.gridx = 1;
        panel.add(txtValor, gbc);

        // Botón insertar
        JButton btnInsertar = new JButton("Insertar al final");
        gbc.gridx = 2;
        panel.add(btnInsertar, gbc);

        // Botón mostrar
        JButton btnMostrar = new JButton("Mostrar lista");
        gbc.gridx = 3;
        panel.add(btnMostrar, gbc);

        // Área de resultados
        txtResultado = new JTextArea(10, 40);
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 4;
        panel.add(scroll, gbc);

        add(panel);

        // Acción botón insertar
        btnInsertar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(txtValor.getText());
                lista.f001_insertar_final(valor); // inserta con recursividad
                txtValor.setText("");
                JOptionPane.showMessageDialog(this, "Valor insertado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        });

        // Acción botón mostrar
        btnMostrar.addActionListener(e -> {
            txtResultado.setText(lista.f003_mostrar()); // muestra con recursividad
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new micro3().setVisible(true));
    }
}
