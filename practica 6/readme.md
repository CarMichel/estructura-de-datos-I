# 📋 Sistema de Atención con Lista Ordenada

## 🎯 ¿Para qué sirve el programa?
Este programa simula un **sistema de atención al cliente** usando una **lista ordenada** como estructura de datos.  
Permite:
- Registrar clientes con su nombre y tipo de operación (*Caja*, *Plataforma*, *Reclamos*).  
- Insertar automáticamente cada cliente en la lista en orden alfabético por nombre.  
- Visualizar los clientes en una **grilla interactiva** siempre ordenada.  
- Eliminar clientes seleccionados o reiniciar la lista completa.

---

## 🔄 Uso de lista ordenada
- Se utiliza una **`LinkedList`** de objetos `Cliente`.  
- Cada vez que se agrega un cliente, se inserta en la posición correcta según el orden alfabético.  
- La lista se mantiene ordenada en todo momento, sin necesidad de ordenar al final.  
- Esto refleja cómo un sistema puede organizar automáticamente la información para facilitar la gestión.

💡 Extensión posible: ordenar por **tipo de operación** (Caja, Plataforma, Reclamos) o por prioridad (ej. tercera edad).

---

## ⚙️ Requisitos para ejecutar
1. Tener instalado **Java JDK 23** o superior.  
   - Verifica con: `"javac -version"`
2. Un editor o IDE (Visual Studio Code recomendado).  
3. El archivo `l_orden.java` con el código del programa.

---

## 🖥️ Cómo ejecutar desde Git Bash
1. clona ele repositorio
2. Ubícate en la carpeta del proyecto
3. Compila el programa:  
   `"javac l_orden.java"`
4. Ejecuta el programa:  
   `"java l_orden"`

---

## 🧑‍💻 Cómo usar el programa
1. Ingresa el **nombre del cliente** en el campo de texto.  
2. Selecciona el **tipo de operación** en el combo box (*Caja, Plataforma, Reclamos*).  
3. Haz clic en **Agregar cliente**.  
   - El cliente se insertará automáticamente en la lista en orden alfabético.  
4. La grilla mostrará los clientes ordenados con su nombre y tipo de operación.  
5. Usa los botones:  
   - **Eliminar cliente** → borra el cliente seleccionado en la tabla.  
   - **Reiniciar lista** → vacía toda la lista.  

---

## 📌 Ejemplo de funcionamiento
| Nombre | Tipo Operación |
|--------|----------------|
| Ana    | Caja           |
| Carlos | Plataforma     |
| Pedro  | Reclamos       |

