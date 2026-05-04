import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HashDemo extends JFrame {
    private JTextField inputField;
    private JButton hashButton;

    public HashDemo() {
        setTitle("Hashing Demo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingrese un número:");
        inputField = new JTextField(10);
        hashButton = new JButton("Generar Hash");

        // Acción del botón
        hashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(inputField.getText());
                    int hash = funcionHash(numero);
                    JOptionPane.showMessageDialog(null,
                        "El hash generado es: " + hash,
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                        "Por favor ingrese un número válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(label);
        add(inputField);
        add(hashButton);

        setVisible(true);
    }

    // Función hash simple (ejemplo)
    private int funcionHash(int clave) {
        // Usamos módulo para distribuir valores en un rango
        int tamañoTabla = 10; 
        return clave % tamañoTabla;
    }

    public static void main(String[] args) {
        new HashDemo();
    }
}
