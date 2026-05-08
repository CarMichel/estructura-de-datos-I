import java.util.*;

public class Main {

    // --- Clase Packet (para la Cola) ---
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

    // --- MAIN ---
    public static void main(String[] args) {
        // Cola de recepcion
        Queue<Packet> receptionQueue = new LinkedList<>();
        receptionQueue.add(new Packet("192.168.0.1","10.0.0.5",500));
        receptionQueue.add(new Packet("192.168.0.2","10.0.0.6",300));
        receptionQueue.add(new Packet("192.168.0.3","10.0.0.7",200));
        receptionQueue.add(new Packet("192.168.0.4","10.0.0.8",100));
        receptionQueue.add(new Packet("192.168.0.5","10.0.0.9",400));

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

        // Recorridos
        history.traverseForward();
        history.traverseBackward();

        // Busqueda en cache
        String searchIP = "192.168.0.3";
        if(cache.containsKey(searchIP)){
            System.out.println("IP encontrada en cache: " + searchIP);
        }

        // Limpieza sincronizada
        cleanIP("192.168.0.2", cache, history);

        // Verificar integridad
        history.traverseForward();
    }
}
