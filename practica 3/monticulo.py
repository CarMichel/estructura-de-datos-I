import tkinter as tk
from tkinter import messagebox

# -------------------------------
# Funcion para construir el heap
# -------------------------------
def heapify(arr, n, i):
    largest = i
    left = 2 * i + 1
    right = 2 * i + 2

    # Verificar hijo izquierdo
    if left < n and arr[left] > arr[largest]:
        largest = left

    # Verificar hijo derecho
    if right < n and arr[right] > arr[largest]:
        largest = right

    # Si el mayor no es la raiz, intercambiar
    if largest != i:
        arr[i], arr[largest] = arr[largest], arr[i]
        heapify(arr, n, largest)

# -------------------------------
# Funcion principal de Heap Sort
# -------------------------------
def heap_sort(arr):
    n = len(arr)

    # Construir Max Heap
    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)

    # Extraer elementos uno por uno
    for i in range(n - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        heapify(arr, i, 0)

    return arr

# -------------------------------
# Funcion para generar los campos
# -------------------------------
def generar_campos():
    try:
        cantidad = int(entry_cantidad.get())
    except ValueError:
        messagebox.showerror("Error", "Por favor ingresa un numero valido")
        return

    # Limpiar campos anteriores
    for widget in frame_campos.winfo_children():
        widget.destroy()

    global entradas
    entradas = []

    # Crear los campos de entrada segun la cantidad
    for i in range(cantidad):
        lbl = tk.Label(frame_campos, text=f"Dato {i+1}:")
        lbl.grid(row=i, column=0, padx=5, pady=5)
        ent = tk.Entry(frame_campos)
        ent.grid(row=i, column=1, padx=5, pady=5)
        entradas.append(ent)

    # Boton para ordenar
    btn_ordenar = tk.Button(frame_campos, text="Ordenar con Heap Sort", command=ordenar)
    btn_ordenar.grid(row=cantidad, column=0, columnspan=2, pady=10)

# -------------------------------
# Funcion para ordenar los datos
# -------------------------------
def ordenar():
    try:
        datos = [int(ent.get()) for ent in entradas]
    except ValueError:
        messagebox.showerror("Error", "Todos los datos deben ser numeros")
        return

    resultado = heap_sort(datos)
    messagebox.showinfo("Resultado", f"Lista ordenada: {resultado}")

# -------------------------------
# Interfaz grafica principal
# -------------------------------
root = tk.Tk()
root.title("Heap Sort (Monticulo)")

root.geometry("200x400")

# Campo para cantidad de datos
lbl_cantidad = tk.Label(root, text="Cantidad de datos:")
lbl_cantidad.pack(pady=5)
entry_cantidad = tk.Entry(root)
entry_cantidad.pack(pady=5)

btn_generar = tk.Button(root, text="Generar campos", command=generar_campos)
btn_generar.pack(pady=5)

frame_campos = tk.Frame(root)
frame_campos.pack(pady=10)

root.mainloop()
