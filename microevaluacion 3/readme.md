# micro3.java - Lista Simple con Recursividad

## 📌 ¿Para qué sirve el programa?
Este programa implementa una **lista simple enlazada** en Java, utilizando **recursividad** para:
- Insertar elementos al final de la lista.
- Mostrar todos los elementos de la lista.

Cuenta con una **interfaz gráfica (Swing)** que permite:
- Ingresar valores.
- Insertarlos en la lista.
- Visualizar los elementos almacenados.

---

## ▶️ ¿Cómo ejecutar el programa?
1. Clona el repositorio en tu computadora:
   git clone https://github.com/CarMichel/estructura-de-datos-I.git
2. Ingresa a la carpeta del proyecto:
   cd estructura-de-datos-I
3. Compila el archivo micro3.java:
   javac micro3.java
4. Ejecuta el programa:
   java micro3

---

## 🖥️ ¿Cómo usar el programa?
1. Ingresa un número en el campo de texto.
2. Presiona el botón **"Insertar al final"** para añadirlo a la lista.
3. Presiona el botón **"Mostrar lista"** para visualizar todos los elementos insertados.
4. Los elementos se mostrarán en el área de texto de la interfaz.

---

## Diagrama de ejecución del programa

```plaintext
Usuario (Interfaz gráfica)
   |
   +--> Botón "Insertar al final"
   |        |
   |        v
   |   f001_insertar_final(valor)
   |        |
   |        v
   |   f002_insertar_recursivo(actual, valor)
   |        |
   |        +--> Caso base: actual == null 
   |        |        → Se crea un nuevo Nodo
   |        |        → Aquí se DETIENE la recursividad
   |        |        → Se detiene porque ya llegamos al final
   |        |          de la lista y no hay más nodos que recorrer.
   |        |
   |        +--> Caso recursivo:
   |                 Avanza al siguiente nodo
   |                 Vuelve a llamar f002_insertar_recursivo
   |        |
   |        Resultado: el nuevo nodo queda enlazado al final
   |
   |
   +--> Botón "Mostrar lista"
            |
            v
       f003_mostrar()
            |
            v
       f004_mostrar_recursivo(cabeza)
            |
            +--> Caso base: actual == null 
            |        → Fin de la lista alcanzado
            |        → Aquí se DETIENE la recursividad
            |        → Se detiene porque ya no existen más nodos
            |          que recorrer en la lista.
            |
            +--> Caso recursivo:
                     Concatena el dato del nodo actual
                     Avanza al siguiente nodo
                     Vuelve a llamar f004_mostrar_recursivo
            |
            Resultado: se construye la cadena de valores de la lista
```
---

## ¿Cómo funciona el nodo cabeza?

El **nodo cabeza** es la referencia al **primer nodo** de la lista.
- Si la lista está vacía, `cabeza = null`.
- Al insertar el primer elemento, `cabeza` apunta a ese nodo.
- Los siguientes elementos se enlazan desde la cabeza hacia adelante.
- Para mostrar la lista, el recorrido comienza siempre desde la cabeza.

### Diagrama del nodo cabeza

```plaintext
cabeza
   |
   v
+-------+    +-------+    +-------+    +-------+
|  10   | -> |  20   | -> |  30   | -> | null  |
+-------+    +-------+    +-------+    +-------+
```

- `cabeza` apunta al nodo con valor 10.
- El nodo 10 apunta al nodo 20.
- El nodo 20 apunta al nodo 30.
- El nodo 30 apunta a null, indicando el fin de la lista.

