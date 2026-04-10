# 📌 Programa Fichas con Pila (Python + Tkinter)

## 📝 Descripción
Este programa implementa un sistema de **fichas de atención al cliente** utilizando la estructura de datos **pila (LIFO)** en Python con interfaz gráfica creada en **Tkinter**.  
Cada ficha se apila en memoria y la última que se genera es la primera que se atiende.

Es ideal para:
- Comprender cómo funcionan las **pilas** en programación.
- Simular un sistema básico de fichas con lógica **Last In, First Out**.
- Practicar el uso de **Tkinter** para interfaces gráficas.

## 🎯 Funcionalidades
- **Pedir ficha (push):** genera una nueva ficha y la apila en la pila.
- **Atender ficha (pop):** desapila la última ficha agregada y muestra un mensaje con el número atendido.
- **Reiniciar pila:** vacía la pila y reinicia el contador a `A-0000`.
- **Visualización:** la etiqueta principal muestra siempre la ficha que está en la cima de la pila.

## 🖥️ Interfaz
La ventana principal incluye:
- Título: *Ficha Atención al Cliente (Pila)*  
- Etiqueta con el número de ficha actual (cima de la pila).  
- Botones:
  - **Pedir ficha (push)** → agrega una ficha a la pila.
  - **Atender ficha (pop)** → quita la última ficha de la pila.
  - **Reiniciar pila** → vacía la pila y reinicia el contador.

Al pedir una ficha, se abre una ventana emergente con:
FICHA ATENCIÓN AL CLIENTE
A-0001
CAJA

## 🚀 Requisitos
- Python 3.x instalado.
- Librería estándar **Tkinter** (incluida en Python).
- No requiere base de datos ni librerías externas.

## ⚙️ Instalación y ejecución

### 1. Clonar el repositorio desde Git

### 2. Ejecutar el programa
python fichas.py

