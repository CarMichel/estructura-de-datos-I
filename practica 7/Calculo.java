import javax.swing.*;
import java.awt.*;

public class Calculo extends JFrame {
    private JTextField txtN, txtResSuma;
    private JTextField txtNumeroDigitos, txtResDigitos;
    private JTextField txtMCD1, txtMCD2, txtResMCD;
    private JTextField txtInvertir, txtResInvertir;
    private JTextField txtBase, txtExponente, txtResPotencia;
    private JTextField txtPrimo, txtResPrimo;

    public Calculo() {
        setTitle("Ejercicios Recursivos");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        // 1. Suma de N números naturales
        txtN = new JTextField(6);
        txtResSuma = new JTextField(10); txtResSuma.setEditable(false);
        JButton btnSuma = new JButton("Suma");
        agregarFila(panel, gbc, fila++, "Suma de primeros N:", txtN, btnSuma, txtResSuma);

        // 2. Contar dígitos
        txtNumeroDigitos = new JTextField(6);
        txtResDigitos = new JTextField(10); txtResDigitos.setEditable(false);
        JButton btnDigitos = new JButton("Contar");
        agregarFila(panel, gbc, fila++, "Contar dígitos:", txtNumeroDigitos, btnDigitos, txtResDigitos);

        // 3. MCD
        txtMCD1 = new JTextField(6);
        txtMCD2 = new JTextField(6);
        txtResMCD = new JTextField(10); txtResMCD.setEditable(false);
        JButton btnMCD = new JButton("MCD");
        agregarFila(panel, gbc, fila++, "Número 1:", txtMCD1, null, null);
        agregarFila(panel, gbc, fila++, "Número 2:", txtMCD2, btnMCD, txtResMCD);

        // 4. Invertir número
        txtInvertir = new JTextField(6);
        txtResInvertir = new JTextField(10); txtResInvertir.setEditable(false);
        JButton btnInvertir = new JButton("Invertir");
        agregarFila(panel, gbc, fila++, "Invertir número:", txtInvertir, btnInvertir, txtResInvertir);

        // 5. Potencia
        txtBase = new JTextField(6);
        txtExponente = new JTextField(6);
        txtResPotencia = new JTextField(10); txtResPotencia.setEditable(false);
        JButton btnPotencia = new JButton("Potencia");
        agregarFila(panel, gbc, fila++, "Base:", txtBase, null, null);
        agregarFila(panel, gbc, fila++, "Exponente:", txtExponente, btnPotencia, txtResPotencia);

        // 6. Verificar primo
        txtPrimo = new JTextField(6);
        txtResPrimo = new JTextField(10); txtResPrimo.setEditable(false);
        JButton btnPrimo = new JButton("Primo?");
        agregarFila(panel, gbc, fila++, "Número:", txtPrimo, btnPrimo, txtResPrimo);

        add(panel);

        // Funcionalidad botones
        btnSuma.addActionListener(e -> {
            int n = Integer.parseInt(txtN.getText());
            txtResSuma.setText(String.valueOf(sumaRecursiva(n)));
        });

        btnDigitos.addActionListener(e -> {
            int num = Integer.parseInt(txtNumeroDigitos.getText());
            txtResDigitos.setText(String.valueOf(contarDigitos(num)));
        });

        btnMCD.addActionListener(e -> {
            int a = Integer.parseInt(txtMCD1.getText());
            int b = Integer.parseInt(txtMCD2.getText());
            txtResMCD.setText(String.valueOf(mcd(a, b)));
        });

        btnInvertir.addActionListener(e -> {
            int num = Integer.parseInt(txtInvertir.getText());
            txtResInvertir.setText(String.valueOf(invertir(num, 0)));
        });

        btnPotencia.addActionListener(e -> {
            int base = Integer.parseInt(txtBase.getText());
            int exp = Integer.parseInt(txtExponente.getText());
            txtResPotencia.setText(String.valueOf(potencia(base, exp)));
        });

        btnPrimo.addActionListener(e -> {
            int num = Integer.parseInt(txtPrimo.getText());
            txtResPrimo.setText(esPrimo(num, 2) ? "Sí" : "No");
        });
    }

    // Método para agregar filas ordenadas
    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta, JTextField campo, JButton boton, JTextField resultado) {
        gbc.gridx = 0; gbc.gridy = fila;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        panel.add(campo, gbc);

        if (boton != null) {
            gbc.gridx = 2;
            panel.add(boton, gbc);
        }

        if (resultado != null) {
            gbc.gridx = 3;
            panel.add(resultado, gbc);
        }
    }

    // Funciones recursivas
    private int sumaRecursiva(int n) {
        if (n == 0) return 0;
        return n + sumaRecursiva(n - 1);
    }

    private int contarDigitos(int num) {
        if (num == 0) return 0;
        return 1 + contarDigitos(num / 10);
    }

    private int mcd(int a, int b) {
        if (b == 0) return a;
        return mcd(b, a % b);
    }

    private int invertir(int num, int invertido) {
        if (num == 0) return invertido;
        return invertir(num / 10, invertido * 10 + num % 10);
    }

    private int potencia(int base, int exp) {
        if (exp == 0) return 1;
        return base * potencia(base, exp - 1);
    }

    private boolean esPrimo(int num, int divisor) {
        if (num <= 2) return num == 2;
        if (num % divisor == 0) return false;
        if (divisor * divisor > num) return true;
        return esPrimo(num, divisor + 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculo().setVisible(true));
    }
}
