import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuickSortGUI extends JFrame {
    private JTextField cantidadField;       
    private JPanel numerosPanel;            
    private JButton generarButton, ordenarButton; 
    private JTextArea resultadoArea;        
    private JTextField[] camposNumeros;     

    public QuickSortGUI() {
        setTitle("QuickSort con Interfaz");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: ingresar cantidad de numeros
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Cantidad de numeros:"));
        cantidadField = new JTextField(5);
        topPanel.add(cantidadField);

        generarButton = new JButton("Generar campos");
        topPanel.add(generarButton);

        add(topPanel, BorderLayout.NORTH);

        // Panel central: aqui se mostraran los campos de entrada
        numerosPanel = new JPanel();
        add(numerosPanel, BorderLayout.CENTER);

        // Panel inferior: boton de ordenar y area de resultados
        JPanel bottomPanel = new JPanel(new BorderLayout());
        ordenarButton = new JButton("Ordenar con QuickSort");
        bottomPanel.add(ordenarButton, BorderLayout.NORTH);

        resultadoArea = new JTextArea(5, 40);
        resultadoArea.setEditable(false);
        bottomPanel.add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);

        // Accion del boton "Generar campos"
        generarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int cantidad = Integer.parseInt(cantidadField.getText()); // lee la cantidad de numeros a insertar
                    numerosPanel.removeAll(); // limpia el panel antes de agregar nuevos campos
                    numerosPanel.setLayout(new GridLayout(cantidad, 2, 5, 5)); // filas = cantidad, columnas = 2
                    camposNumeros = new JTextField[cantidad]; // crea un arreglo de campos de texto para guardar las referencias a cada cuadro de entrada
                    for (int i = 0; i < cantidad; i++) { //Genera las etiquetas y los campos de texto dentro de la grilla
                        numerosPanel.add(new JLabel("Num " + (i + 1) + ":"));
                        camposNumeros[i] = new JTextField(5);
                        numerosPanel.add(camposNumeros[i]);
                    }
                    //Refresca el panel para que los nuevos campos aparezcan en la ventana
                    numerosPanel.revalidate(); 
                    numerosPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido en cantidad.");
                }
            }
        });

        // Accion del boton "Ordenar con QuickSort"
        ordenarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Crear un arreglo de enteros con la misma longitud que los campos de texto
                    double[] arr = new double[camposNumeros.length]; // arreglo de decimales
                    // Recorrer cada campo de texto y convertir su contenido a numero entero
                    for (int i = 0; i < camposNumeros.length; i++) {
                        arr[i] = Double.parseDouble(camposNumeros[i].getText());
                    }
                    // Aplicar el algoritmo QuickSort al arreglo
                    quickSort(arr, 0, arr.length - 1);
                    // Limpiar el area de resultados y mostrar el texto inicial
                    resultadoArea.setText("Arreglo ordenado:\n");
                    // Recorrer el arreglo ya ordenado y mostrar cada numero en el area de resultados
                    for (double  num : arr) {
                        resultadoArea.append(num + "; ");
                    }
                } catch (Exception ex) {
                    // Si ocurre un error (por ejemplo, un campo vacio o no numerico), mostrar advertencia
                    JOptionPane.showMessageDialog(null, "Complete todos los campos con numeros validos.");
                }
            }
        });

    }

    // QuickSort: funcion recursiva que ordena un arreglo de numeros decimales (double)
    public static void quickSort(double[] arr, int low, int high) {
        // Condicion base: si el indice inicial es menor que el final, significa que hay elementos por ordenar
        if (low < high) {
            // Llamamos a partition para colocar el pivote en su posicion correcta
            int pi = partition(arr, low, high); 
            
            // Ordenamos recursivamente la parte izquierda del arreglo (antes del pivote)
            quickSort(arr, low, pi - 1);        
            
            // Ordenamos recursivamente la parte derecha del arreglo (despues del pivote)
            quickSort(arr, pi + 1, high);       
        }
    }

    // Partition: organiza los elementos alrededor de un pivote y devuelve su posicion final
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // Elegimos el ultimo elemento como pivote
        int i = (low - 1);        // indice que marcara la posicion de los elementos menores al pivote

        // Recorremos todos los elementos desde 'low' hasta 'high - 1'
        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) { 
                i++; // avanzamos el indice de los menores
                // Intercambiamos arr[i] con arr[j] para colocarlo en la parte izquierda
                double temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp;
            }
        }

        // Finalmente colocamos el pivote en su posicion correcta (despues de los menores)
        double temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp;

        // Retornamos la posicion final del pivote
        return i + 1;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuickSortGUI().setVisible(true);
        });
    }
}
