# 📌 Programa Fichas

## 📝 Descripción
El programa **`fichas.py`** es una aplicación sencilla en **Python con Tkinter** que simula un sistema de atención al cliente mediante fichas numeradas.  
Permite generar fichas consecutivas en memoria (sin base de datos) y reiniciar el conteo cuando sea necesario.

Este programa es útil para:
- Simular turnos de atención en una caja o ventanilla.
- Practicar conceptos básicos de **estructuras de datos (pilas)** y manejo de interfaces gráficas.
- Implementar un sistema ligero de control de fichas sin necesidad de almacenamiento externo.

---

## 🎯 Funcionalidades
- **Ficha inicial:** comienza en `A-0000`.
- **Botón "Pedir ficha":**
  - Incrementa el número de ficha.
  - Muestra el nuevo número en la ventana principal.
  - Abre una ventana emergente con el detalle de la ficha.
- **Botón "Reiniciar conteo":**
  - Vuelve el contador a `A-0000`.
  - Muestra un mensaje de confirmación.

---

## 🖥️ Interfaz
La ventana principal incluye:
- Título: *Ficha Atención al Cliente*  
- Etiqueta con el número de ficha actual.  
- Botón **Pedir ficha** (verde).  
- Botón **Reiniciar conteo** (rojo).  

Al pedir una ficha, se abre una ventana emergente con:
FICHA ATENCIÓN AL CLIENTE
A-0001
CAJA

Código

---

## 🚀 Requisitos
- Python 3.x instalado.
- Librería estándar **Tkinter** (incluida en Python).

---

## ⚙️ Instalación y ejecución

### 1. Clonar el repositorio desde Git
```bash
git clone https://github.com/usuario/fichas.git
cd fichas
2. Ejecutar el programa
bash
python fichas.py
📚 Ejemplo de uso
Al iniciar, verás la ficha actual como A-0000.

Presiona Pedir ficha → se generará A-0001 y aparecerá en una ventana emergente.

Cada vez que presiones el botón, el número aumentará (A-0002, A-0003, etc.).

Si presionas Reiniciar conteo, el contador volverá a A-0000.