import tkinter as tk
from tkinter import messagebox

class FichasApp:
    def __init__(self, root):       # init es el constructor se ejecuta cuando se abre la aplicacion
        self.root = root
        self.root.title("Fichas")

        # Contador de fichas en memoria, empieza con 0 para que luego se incrementa
        self.contador = 0

        # Titulo principal
        self.label_titulo = tk.Label(root, text="Ficha Atencion al Cliente", font=("Arial", 14, "bold"))
        self.label_titulo.pack(pady=10)

        # Mostrar numero de ficha actual
        self.label_ficha = tk.Label(root, text=f"Nro de ficha actual: A-{self.contador:04d}", font=("Arial", 12)) #mostrar el numero con 4 digitos "04d"
        self.label_ficha.pack(pady=10)

        # Boton pedir ficha
        self.btn_pedir = tk.Button(root, text="Pedir ficha", command=self.pedir_ficha, width=20, bg="#4CAF50", fg="white")
        self.btn_pedir.pack(pady=5)

        # Boton reiniciar conteo
        self.btn_reiniciar = tk.Button(root, text="Reiniciar conteo", command=self.reiniciar, width=20, bg="#f44336", fg="white")
        self.btn_reiniciar.pack(pady=5)

    def pedir_ficha(self):
        # Incrementar contador
        self.contador += 1
        nro_ficha = f"A-{self.contador:04d}"

        # Actualizar etiqueta principal
        self.label_ficha.config(text=f"Nro de ficha actual: {nro_ficha}")

        # Crear ventana emergente con la ficha
        ventana_ficha = tk.Toplevel(self.root)
        ventana_ficha.title("Ficha Atencion al Cliente")

        tk.Label(ventana_ficha, text="FICHA ATENCIoN AL CLIENTE", font=("Arial", 14, "bold")).pack(pady=10)
        tk.Label(ventana_ficha, text=nro_ficha, font=("Arial", 16)).pack(pady=10)
        tk.Label(ventana_ficha, text="CAJA", font=("Arial", 12)).pack(pady=10)

    def reiniciar(self):
        # Reiniciar contador
        self.contador = 0
        self.label_ficha.config(text=f"Nro de ficha actual: A-{self.contador:04d}")
        messagebox.showinfo("Reinicio", "El contador ha sido reiniciado a A-0000")

# Programa principal
if __name__ == "__main__": # asegura que el programa se ejecute solo si lo abrimos directamente 
    root = tk.Tk() #crea la ventana principal
    app = FichasApp(root) #inicializa la aplicacion
    root.mainloop() #mantiene la ventana abierta esperando interaccion
