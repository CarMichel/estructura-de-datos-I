# 🎟️ Sistema de Atención con Cola (Python + Tkinter)

## 📝 Descripción
Este programa implementa un **sistema de atención al cliente** utilizando una **cola (FIFO)** en Python con interfaz gráfica creada en **Tkinter**.  
La aplicación permite agregar clientes, atenderlos en orden de llegada y visualizar los primeros 10 en espera dentro de una **grilla (tabla)**.

Es ideal para:
- Comprender cómo funcionan las **colas** en programación.
- Simular un sistema básico de turnos de atención.
- Practicar el uso de **Tkinter** para interfaces gráficas.


## 🎯 Funcionalidades
- **Agregar cliente:** se ingresa un nombre y se añade al final de la cola.
- **Atender cliente:** se elimina el primero de la cola y se muestra un mensaje con el nombre atendido.
- **Reiniciar cola:** vacía toda la cola y reinicia la tabla.
- **Visualización:** muestra en una tabla los primeros 10 clientes en espera.

## 🖥️ Interfaz
La ventana principal incluye:
- Campo de texto para ingresar el nombre del cliente.
- Botones:
  - **Agregar cliente** (verde).
  - **Atender cliente** (azul).
  - **Reiniciar cola** (rojo).
- Una **tabla (grilla)** que muestra los primeros 10 clientes en la cola con su posición.

Ejemplo de tabla:

| Posición | Nombre   |
|----------|----------|
| 1        | Juan     |
| 2        | María    |
| 3        | Pedro    |
| ...      | ...      |

## 🚀 Requisitos
- Python 3.x instalado.
- Librería estándar **Tkinter** (incluida en Python).
- No requiere base de datos ni librerías externas.

## ⚙️ Instalación y ejecución

### 1. Clonar el repositorio desde Git

### 2. Ejecutar el programa

python cola_app.py


## 📚 Ejemplo de uso
Escribe el nombre de un cliente en el campo de texto.

Presiona Agregar cliente → aparecerá en la tabla.

Presiona Atender cliente → se eliminará el primero de la cola y se mostrará un mensaje.

Presiona Reiniciar cola → la tabla quedará vacía.