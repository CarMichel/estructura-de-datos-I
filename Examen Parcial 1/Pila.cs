using System;

namespace TAD_Ejemplo
{
    // Definición del TAD Pila
    public class Pila<T>
    {
        private T[] elementos;   // Arreglo interno para almacenar los datos
        private int tope;        // Índice del último elemento
        private int capacidad;   // Capacidad máxima de la pila

        // Constructor: inicializa la pila con una capacidad dada
        public Pila(int capacidad)
        {
            this.capacidad = capacidad;
            elementos = new T[capacidad];
            tope = -1; // pila vacía
        }

        // Método para verificar si la pila está vacía
        public bool EstaVacia()
        {
            return tope == -1;
        }

        // Método para verificar si la pila está llena
        public bool EstaLlena()
        {
            return tope == capacidad - 1;
        }

        // Método Push: insertar un elemento en la pila
        public void Push(T elemento)
        {
            if (EstaLlena())
            {
                Console.WriteLine("La pila está llena, no se puede insertar.");
                return;
            }
            elementos[++tope] = elemento;
        }

        // Método Pop: sacar el último elemento de la pila
        public T Pop()
        {
            if (EstaVacia())
            {
                Console.WriteLine("La pila está vacía, no se puede extraer.");
                return default(T);
            }
            return elementos[tope--];
        }

        // Método Peek: ver el último elemento sin sacarlo
        public T Peek()
        {
            if (EstaVacia())
            {
                Console.WriteLine("La pila está vacía.");
                return default(T);
            }
            return elementos[tope];
        }
    }

    // Programa principal para probar el TAD
    class Program
    {
        static void Main(string[] args)
        {
            Pila<int> pila = new Pila<int>(5); // pila de enteros con capacidad 5

            pila.Push(10);
            pila.Push(20);
            pila.Push(30);

            Console.WriteLine("Elemento en el tope: " + pila.Peek()); // 30

            Console.WriteLine("Sacando: " + pila.Pop()); // 30
            Console.WriteLine("Sacando: " + pila.Pop()); // 20

            Console.WriteLine("Elemento en el tope: " + pila.Peek()); // 10
        }
    }
}
