# Sistema de Gestión de Tráfico y Caché

## 📖 Descripción del Programa

Este proyecto implementa un motor de procesamiento de paquetes de red utilizando estructuras de datos clásicas en Java. El sistema simula cómo se reciben, almacenan y gestionan paquetes de red, manteniendo un historial de direcciones IP y un caché para identificar IPs seguras.

## 🎯 Objetivo

El sistema sirve para:

- Recepción de paquetes: encolar y procesar paquetes entrantes.
- Historial bidireccional: mantener un registro de las IPs procesadas en una lista doblemente enlazada, con recorrido hacia adelante y hacia atrás.
- Caché de confianza: almacenar IPs seguras en un HashMap para búsquedas inmediatas en tiempo constante.
- Sincronización y limpieza: garantizar integridad referencial eliminando IPs tanto del historial como del caché cuando se marcan como inseguras.

## 🛠️ Lenguaje elegido
Se eligió Java por su portabilidad, su robusta biblioteca estándar para estructuras de datos (Queue, HashMap, LinkedList) y la facilidad para mostrar resultados en consola.

## ▶️ Cómo compilar y ejecutar

1. Guarda el archivo como Main.java.
2. Abre la terminal y navega hasta la carpeta donde está el archivo.
3. Compila el programa con: javac Main.java
4. Ejecuta el programa con: java Main

## 📊 Ejemplo de salida en consola
Al ejecutar el programa, se muestran mensajes como:

```
Procesando paquete: 192.168.0.1 -> 10.0.0.5 (500 bytes)
IP añadida al historial: 192.168.0.1
IP añadida al caché: 192.168.0.1
Procesando paquete: 192.168.0.2 -> 10.0.0.6 (300 bytes)
IP añadida al historial: 192.168.0.2
IP añadida al caché: 192.168.0.2
...
Recorrido hacia adelante:
192.168.0.1
192.168.0.2
192.168.0.3
192.168.0.4
192.168.0.5
Recorrido hacia atrás:
192.168.0.5
192.168.0.4
192.168.0.3
192.168.0.2
192.168.0.1
IP encontrada en caché: 192.168.0.3
IP eliminada de caché: 192.168.0.2
IP eliminada del historial: 192.168.0.2
```

## ✅ Evaluación

- Cola implementada con 5 paquetes.
- Lista doble con recorrido en ambos sentidos y eliminación automática al superar 100 registros.
- HashMap con búsqueda O(1) y explicación de colisiones.
- Limpieza sincronizada entre historial y caché.
- Logs listos para capturas en el README.

## ✔️ Cumplimiento de los Requisitos

### 🧩 1. Módulo de Recepción (Queue)

- Clase Packet con atributos: sourceIP, destinationIP, payloadSize.
- Usa LinkedList<Packet> como cola.
- Demuestra enqueue y dequeue con al menos 5 paquetes.

```
static class Packet {
        String sourceIP;
        String destinationIP;
        int payloadSize;

        public Packet(String s, String d, int p) {
            sourceIP = s; destinationIP = d; payloadSize = p;
        }

        @Override
        public String toString() {
            return sourceIP + " -> " + destinationIP + " (" + payloadSize + " bytes)";
        }
    }
    ...
    // Cola de recepcion
        Queue<Packet> receptionQueue = new LinkedList<>();
        receptionQueue.add(new Packet("192.168.0.1","10.0.0.5",500));
        receptionQueue.add(new Packet("192.168.0.2","10.0.0.6",300));
    ...
    // Procesar paquetes
        while(!receptionQueue.isEmpty()){
            Packet p = receptionQueue.poll();
            System.out.println("Procesando paquete: " + p);
    ...
```


### 🔄 2. Registro de Historial Bidireccional (Lista Doblemente Enlazada)

- Implementa clase DoublyLinkedList con nodos que guardan IPs.
- Métodos: add(IP), removeOldest(), traverseForward(), traverseBackward().
- Regla: si supera 100 registros, elimina el más antiguo.

```
    // --- Nodo y Lista Doblemente Enlazada ---
    static class Node {
        String ip;
        Node next, prev;
        Node(String ip){ this.ip = ip; }
    }

    static class DoublyLinkedList {
        Node head, tail;
        int size = 0;

        void add(String ip){
            Node n = new Node(ip);
            if(tail!=null){ tail.next = n; n.prev = tail; }
            else head = n;
            tail = n;
            size++;
            if(size>100) removeOldest();
            System.out.println("IP añadida al historial: " + ip);
        }

        void removeOldest(){
            if(head!=null){ 
                System.out.println("Eliminando IP mas antigua: " + head.ip);
                head = head.next; 
                if(head!=null) head.prev=null; 
                size--; 
            }
        }

        void traverseForward(){
            System.out.println("Recorrido hacia adelante:");
            Node cur=head; 
            while(cur!=null){ 
                System.out.println(cur.ip); 
                cur=cur.next; 
            }
        }

        void traverseBackward(){
            System.out.println("Recorrido hacia atras:");
            Node cur=tail; 
            while(cur!=null){ 
                System.out.println(cur.ip); 
                cur=cur.prev; 
            }
        }
    }
```

### ⚡ 3. Motor de Búsqueda de Confianza (HashMap)

- Usa HashMap<String, Boolean> para marcar IPs seguras.
- Demuestra búsqueda en tiempo constante.
- Explica colisiones: en Java, HashMap maneja colisiones con listas enlazadas o árboles balanceados.

```
    public static void main(String[] args) {
        ...
    DoublyLinkedList history = new DoublyLinkedList();
        HashMap<String, Boolean> cache = new HashMap<>();

        // Procesar paquetes
        while(!receptionQueue.isEmpty()){
            Packet p = receptionQueue.poll();
            System.out.println("Procesando paquete: " + p);
            history.add(p.sourceIP);
            cache.put(p.sourceIP, true);
            System.out.println("IP añadida al cache: " + p.sourceIP);
        }
        ...
```

### 🧹 4. Sincronización y Limpieza

Método cleanIP(String ip) que:
1. Elimina la IP del HashMap.
2. Recorre la lista doble y elimina el nodo correspondiente.

```
    // --- Metodo de limpieza sincronizada ---
    static void cleanIP(String ip, HashMap<String,Boolean> cache, DoublyLinkedList history){
        if(cache.remove(ip)!=null){
            System.out.println("IP eliminada de cache: " + ip);
        }
        Node cur = history.head;
        while(cur!=null){
            if(cur.ip.equals(ip)){
                System.out.println("IP eliminada del historial: " + ip);
                if(cur.prev!=null) cur.prev.next=cur.next;
                else history.head=cur.next;
                if(cur.next!=null) cur.next.prev=cur.prev;
                else history.tail=cur.prev;
                history.size--;
                break;
            }
            cur=cur.next;
        }
    }
```

## 📊 Diagrama del Flujo del Sistema

```
                ┌─────────────────────┐
                │   Cola de Recepción │
                │  (Queue de Paquetes)│
                └───────────┬─────────┘
                            │
                            v
                ┌─────────────────────┐
                │ Historial de IPs    │
                │ (Lista Doble)       │
                └───────┬─────┬───────┘
                        │     │
             Recorrido ←─┘     └─→ Recorrido
             hacia atrás          hacia adelante

                            │
                            v
                ┌─────────────────────┐
                │ Caché de Confianza  │
                │ (HashMap de IPs)    │
                └───────────┬─────────┘
                            │
                            v
                ┌─────────────────────┐
                │ Sincronización y    │
                │ Limpieza            │
                │ (Eliminar IP en     │
                │ ambas estructuras)  │
                └─────────────────────┘

```
