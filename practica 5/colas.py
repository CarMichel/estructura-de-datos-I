import tkinter as tk
from tkinter import ttk, messagebox
from collections import deque

class ColaApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Sistema de Atención con Cola")

        # Cola de clientes
        self.cola = deque()

        # Título
        tk.Label(root, text="Atención al Cliente (Cola FIFO)", font=("Arial", 14, "bold")).pack(pady=10)

        # Entrada para nombre
        frame_input = tk.Frame(root)
        frame_input.pack(pady=5)
        tk.Label(frame_input, text="Nombre del cliente:").pack(side=tk.LEFT)
        self.entry_nombre = tk.Entry(frame_input)
        self.entry_nombre.pack(side=tk.LEFT, padx=5)

        # Botones
        frame_buttons = tk.Frame(root)
        frame_buttons.pack(pady=10)
        tk.Button(frame_buttons, text="Agregar cliente", command=self.agregar_cliente, bg="#4CAF50", fg="white").pack(side=tk.LEFT, padx=5)
        tk.Button(frame_buttons, text="Atender cliente", command=self.atender_cliente, bg="#2196F3", fg="white").pack(side=tk.LEFT, padx=5)
        tk.Button(frame_buttons, text="Reiniciar cola", command=self.reiniciar_cola, bg="#f44336", fg="white").pack(side=tk.LEFT, padx=5)

        # Tabla (grilla) para mostrar los primeros 10 clientes
        self.tree = ttk.Treeview(root, columns=("posicion", "nombre"), show="headings", height=10)
        self.tree.heading("posicion", text="Posición")
        self.tree.heading("nombre", text="Nombre")
        self.tree.column("posicion", width=80, anchor="center")
        self.tree.column("nombre", width=200, anchor="center")
        self.tree.pack(pady=10)

        # Actualizar tabla al inicio
        self.actualizar_tabla()

    def agregar_cliente(self):
        nombre = self.entry_nombre.get().strip()
        if nombre:
            self.cola.append(nombre)
            self.entry_nombre.delete(0, tk.END)
            self.actualizar_tabla()
        else:
            messagebox.showwarning("Aviso", "Debe ingresar un nombre.")

    def atender_cliente(self):
        if self.cola:
            cliente = self.cola.popleft()
            messagebox.showinfo("Atención", f"Se atendió a: {cliente}")
            self.actualizar_tabla()
        else:
            messagebox.showwarning("Aviso", "No hay clientes en la cola.")

    def reiniciar_cola(self):
        self.cola.clear()
        self.actualizar_tabla()
        messagebox.showinfo("Reinicio", "La cola ha sido vaciada.")

    def actualizar_tabla(self):
        # Limpiar tabla
        for item in self.tree.get_children():
            self.tree.delete(item)

        # Mostrar los primeros 10 clientes
        for i, cliente in enumerate(list(self.cola)[:10], start=1):
            self.tree.insert("", "end", values=(i, cliente))

# Programa principal
if __name__ == "__main__":
    root = tk.Tk()
    app = ColaApp(root)
    root.mainloop()
