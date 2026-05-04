# Hashing Demo en Java

Este proyecto es una aplicación sencilla en **Java Swing** que permite ingresar un número y obtener su **hash** mediante una función hash básica.

---

## 📌 ¿Para qué sirve?
El programa muestra cómo funciona el **hashing** en estructuras de datos:
- Convierte una clave (número ingresado) en un índice dentro de un rango fijo.
- Permite entender la lógica detrás de las **tablas hash**.
- Ejemplo práctico para estudiantes de **Estructura de Datos I**.

---

## ⚙️ ¿Cómo ejecutar el programa?
1. Clona o descarga el repositorio:
   ```bash
   git clone https://github.com/CarMichel/estructura-de-datos-I.git
2. Compila el archivo:

bash
javac HashDemo.java
3. Ejecuta el programa:

bash
java HashDemo
## 🖥️ ¿Cómo usar el programa?
1. Ingresa un número en el campo de texto.

2. Haz clic en el botón Generar Hash.

3. Se mostrará un mensaje con el hash calculado.

## 🔑 Funcionamiento de la función hash
La función hash utilizada es:

java
private int funcionHash(int clave) {
    int tamañoTabla = 10;
    return clave % tamañoTabla;
}

Esto significa que el hash es el resto de dividir la clave entre 10.
Ejemplo:

Clave: 5858

Cálculo: 5858 % 10 = 8

Resultado: 8

## 📊 Diagrama de ejecución

[ Número ingresado ] ---> [ Función Hash ] ---> [ Índice en la tabla ]
Ejemplo con clave 5858:

5858 ---> % 10 ---> 8

## 📌 Nodo cabeza en tablas hash
En una tabla hash con encadenamiento, cada posición puede tener una lista enlazada.
El nodo cabeza es el primer elemento de esa lista, que apunta a los demás nodos en caso de colisiones.

[ Índice 8 ] ---> [ Nodo cabeza ] ---> [ Nodo siguiente ] ---> ...