import java.util.NoSuchElementException;

public class MyHashTable {

    // Node for separate chaining
    private static class HashNode {
        int key;
        int value;
        HashNode next;

        public HashNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private HashNode[] buckets;
    private int capacity;
    private int size;

    public MyHashTable(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }

    // Hash function mapping key to bucket index
    private int hash(int key) {
        return Math.floorMod(key, capacity);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Insert or update key-value pair
    public void put(int key, int value) {
        int bucketIndex = hash(key);
        HashNode head = buckets[bucketIndex];

        // Update if key exists
        HashNode current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Insert new entry at the head of the chain
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        buckets[bucketIndex] = newNode;
        size++;
    }

    // Retrieve value by key
    public int get(int key) {
        int bucketIndex = hash(key);
        HashNode current = buckets[bucketIndex];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    // Remove key-value pair
    public int remove(int key) {
        int bucketIndex = hash(key);
        HashNode current = buckets[bucketIndex];
        HashNode prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[bucketIndex] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        throw new NoSuchElementException("Key not found: " + key);
    }

    public boolean containsKey(int key) {
        int bucketIndex = hash(key);
        HashNode current = buckets[bucketIndex];
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void clear() {
        buckets = new HashNode[capacity];
        size = 0;
    }

    public void display() {
        System.out.println("--- Hash Table Contents ---");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            HashNode current = buckets[i];
            while (current != null) {
                System.out.print("[" + current.key + " : " + current.value + "] -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}