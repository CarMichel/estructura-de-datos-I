import tkinter as tk
from tkinter import messagebox

class FichasApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Fichas con Pila")

        # Pila de fichas (lista en Python)
        self.pila = []
        self.contador = 0

        # Título principal
        self.label_titulo = tk.Label(root, text="Ficha Atención al Cliente (Pila)", font=("Arial", 14, "bold"))
        self.label_titulo.pack(pady=10)

        # Mostrar número de ficha actual (cima de la pila)
        self.label_ficha = tk.Label(root, text="Nro de ficha actual: A-0000", font=("Arial", 12))
        self.label_ficha.pack(pady=10)

        # Botón pedir ficha (push)
        self.btn_pedir = tk.Button(root, text="Pedir ficha (push)", command=self.pedir_ficha, width=20, bg="#4CAF50", fg="white")
        self.btn_pedir.pack(pady=5)

        # Botón atender ficha (pop)
        self.btn_atender = tk.Button(root, text="Atender ficha (pop)", command=self.atender_ficha, width=20, bg="#2196F3", fg="white")
        self.btn_atender.pack(pady=5)

        # Botón reiniciar pila
        self.btn_reiniciar = tk.Button(root, text="Reiniciar pila", command=self.reiniciar, width=20, bg="#f44336", fg="white")
        self.btn_reiniciar.pack(pady=5)

    def pedir_ficha(self):
        # Generar nueva ficha y apilarla
        self.contador += 1
        nro_ficha = f"A-{self.contador:04d}"
        self.pila.append(nro_ficha)  # push

        # Actualizar etiqueta con la cima de la pila
        self.label_ficha.config(text=f"Nro de ficha actual: {nro_ficha}")

        # Ventana emergente con la ficha
        ventana_ficha = tk.Toplevel(self.root)
        ventana_ficha.title("Ficha Atención al Cliente")
        tk.Label(ventana_ficha, text="FICHA ATENCIÓN AL CLIENTE", font=("Arial", 14, "bold")).pack(pady=10)
        tk.Label(ventana_ficha, text=nro_ficha, font=("Arial", 16)).pack(pady=10)
        tk.Label(ventana_ficha, text="CAJA", font=("Arial", 12)).pack(pady=10)

    def atender_ficha(self):
        if self.pila:
            ficha = self.pila.pop()  # pop (última ficha)
            messagebox.showinfo("Atención", f"Se atendió la ficha: {ficha}")
            # Mostrar la nueva cima de la pila
            if self.pila:
                self.label_ficha.config(text=f"Nro de ficha actual: {self.pila[-1]}")
            else:
                self.label_ficha.config(text="Nro de ficha actual: A-0000")
        else:
            messagebox.showwarning("Aviso", "No hay fichas en la pila.")

    def reiniciar(self):
        self.pila.clear()
        self.contador = 0
        self.label_ficha.config(text="Nro de ficha actual: A-0000")
        messagebox.showinfo("Reinicio", "La pila ha sido vaciada y reiniciada.")

# Programa principal
if __name__ == "__main__":
    root = tk.Tk()
    app = FichasApp(root)
    root.mainloop()
