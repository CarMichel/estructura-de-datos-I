# 📋 Sistema de Atención al Cliente (Cola FIFO)

## 🎯 ¿Para qué sirve el programa?
Este programa simula un **sistema de atención al cliente** usando una **cola (FIFO)**.  
Permite:
- Registrar clientes con su nombre y tipo de operación (*Caja*, *Plataforma*, *Reclamos*).  
- Asignarles un **código único** (ejemplo: `A-001`, `B-001`, `C-001`).  
- Atender clientes en orden de llegada.  
- Reiniciar la cola cuando sea necesario.  
- Visualizar los primeros 10 clientes en una **grilla interactiva**.

---

## 🔄 Uso de colas
- Se utiliza una **estructura de datos tipo cola (FIFO: First In, First Out)**.  
- Los clientes se agregan al final de la cola y se atienden por el inicio.  
- Esto refleja el comportamiento real de una fila en un banco o institución.  

💡 Además, se puede extender la funcionalidad para manejar **pilas (LIFO: Last In, First Out)**, por ejemplo, para dar prioridad a personas de la tercera edad (el último en llegar sería atendido primero).

---

## ⚙️ Requisitos para ejecutar
1. Tener instalado **Java JDK 23** o superior.  
   - Verifica con: `"javac -version"`
2. Un editor o IDE (Visual Studio Code recomendado).  
3. El archivo `ColaApp.java` con el código del programa.

---

## 🖥️ Cómo ejecutar desde Git Bash
1. Descarga el repositorio
   `"git clone ..."`
2. Ubícate en la carpeta del proyecto, por ejemplo:  
   `"cd /c/UCATEC/est-datos/microevaluacion2"`
3. Compila el programa:  
   `"javac ColaApp.java"`
4. Ejecuta el programa:  
   `"java ColaApp"`

---

## 🧑‍💻 Cómo usar el programa
1. Ingresa el **nombre del cliente** en el campo de texto.  
2. Selecciona el **tipo de operación** en el combo box:  
   - Caja → código `A-###`  
   - Plataforma → código `B-###`  
   - Reclamos → código `C-###`  
3. Haz clic en **Agregar cliente**.  
4. La grilla mostrará el cliente con su posición, nombre y tipo de operación.  
5. Usa los botones:  
   - **Atender cliente** → atiende al primero en la cola.  
   - **Reiniciar cola** → vacía toda la cola.  

---

## 📌 Ejemplo de funcionamiento
| Posición | Nombre | Tipo Operación |
|----------|--------|----------------|
| A-001    | Juan   | Caja           |
| B-001    | María  | Plataforma     |
| C-001    | Pedro  | Reclamos       |

---