public class Program4 {
    
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] table;

    public Program4() {
        table = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = table[index];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Program4 map = new Program4();
        map.put(1, 10);
        map.put(2, 20);
        map.put(1001, 30);  // Will collide with key 1 if SIZE = 1000

        System.out.println("Key 1: " + map.get(1));      // Output: 10
        System.out.println("Key 2: " + map.get(2));      // Output: 20
        System.out.println("Key 1001: " + map.get(1001)); // Output: 30

        map.remove(2);
        System.out.println("Key 2 after removal: " + map.get(2)); // Output: -1
    }
}

