# 📌 QuickSort con Interfaz Gráfica en Java

## 📝 Descripción
Este programa implementa el algoritmo **QuickSort** en Java con una interfaz gráfica construida en **Swing**.  
Permite al usuario:
- Ingresar la cantidad de números que desea ordenar.
- Generar dinámicamente los campos de entrada para esos números.
- Ordenar los números (enteros o decimales) usando QuickSort.
- Mostrar el resultado ordenado en pantalla, separado por `;`.

---

## 🎯 Funcionalidades
- **Generar campos:** según la cantidad ingresada, se crean etiquetas y cuadros de texto en una grilla ordenada.
- **Ordenar con QuickSort:** toma los valores ingresados, aplica el algoritmo y muestra el resultado.
- **Soporte para decimales:** acepta tanto enteros como números con punto decimal.
- **Visualización clara:** los resultados aparecen en un área de texto, separados por `;`.

---

## 🖥️ Interfaz
La ventana principal incluye:
- Campo para ingresar la cantidad de números.
- Botón **Generar campos** → crea los cuadros de texto.
- Botón **Ordenar con QuickSort** → ordena los números ingresados.
- Área de texto para mostrar el resultado ordenado.

Ejemplo de salida:
1.2 4.8 3.5
Arreglo ordenado:
1.2; 3.5; 4.8;


---

## 🚀 Requisitos
- **Java JDK 8 o superior** instalado.
- No requiere librerías externas (solo Swing, incluida en Java).

---

## ⚙️ Ejecución
1. Clonar o descargar el repositorio con el archivo `QuickSortGUI.java`.
2. Compilar el archivo con `javac QuickSortGUI.java`.
3. Ejecutar el programa con `java QuickSortGUI`.
4. Interactuar con la interfaz:
   - Ingresar la cantidad de números.
   - Generar los campos.
   - Escribir los valores (enteros o decimales).
   - Ordenar con QuickSort y ver el resultado separado por `;`.

---

## 📚 Ejemplo de uso
1. Ingresar la cantidad de números: `3`.
2. Presionar **Generar campos** → aparecen 3 cuadros de texto.
3. Escribir valores como `3.5`, `1.2`, `4.8`.
4. Presionar **Ordenar con QuickSort**.
5. El área de resultados mostrará:






# 📌 Programa Pila en C# .NET

## 📝 Descripción
Este proyecto implementa un **Tipo Abstracto de Datos (TAD) Pila** en C# utilizando .NET.  
La pila es una estructura de datos que sigue el principio **LIFO (Last In, First Out)**, donde el último elemento en entrar es el primero en salir.

---

## 🎯 Funcionalidades
- **Push:** Inserta un elemento en la pila.
- **Pop:** Extrae el último elemento insertado.
- **Peek:** Consulta el elemento en el tope sin eliminarlo.
- **EstaVacia / EstaLlena:** Verifica el estado de la pila.

---

## 📚 Ejemplo de uso
```csharp
Pila<int> pila = new Pila<int>(5);

pila.Push(10);
pila.Push(20);
pila.Push(30);

Console.WriteLine("Elemento en el tope: " + pila.Peek()); // 30
Console.WriteLine("Sacando: " + pila.Pop()); // 30
Console.WriteLine("Sacando: " + pila.Pop()); // 20
Console.WriteLine("Elemento en el tope: " + pila.Peek()); // 10

## 🚀 Requisitos
Tener instalado .NET SDK 6 o superior.

Verificar instalación con:

Código
dotnet --version
## ⚙️ Ejecución del programa
Crear un proyecto de consola en la carpeta deseada:

Código
dotnet new console -n TAD_Pila
Copiar el código de la clase Pila<T> y el Main dentro del archivo Program.cs generado.

Entrar a la carpeta del proyecto:

Código
cd TAD_Pila
Ejecutar el programa:

Código
dotnet run
## ✅ Resultado esperado
Al ejecutar el programa, la salida será:

Código
Elemento en el tope: 30
Sacando: 30
Sacando: 20
Elemento en el tope: 10