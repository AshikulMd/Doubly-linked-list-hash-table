public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   DEMO 1: DOUBLY LINKED LIST");
        System.out.println("==============================================");

        MyDoublyLinkedList dll = new MyDoublyLinkedList();

        System.out.println("Adding elements: 10, 20, 30");
        dll.add(10);
        dll.add(20);
        dll.add(30);

        System.out.print("Forward traversal:  ");
        dll.displayForward();

        System.out.print("Backward traversal: ");
        dll.displayBackward();

        System.out.println("\nInserting 15 at index 1...");
        dll.insert(1, 15);
        System.out.print("Updated List: ");
        dll.displayForward();

        System.out.println("Element at index 2: " + dll.get(2));
        System.out.println("Removing element at index 2 (value " + dll.get(2) + ")...");
        dll.remove(2);

        System.out.print("List after removal: ");
        dll.displayForward();

        System.out.println("Search for 30 (index): " + dll.search(30));
        System.out.println("Contains 20? " + dll.contains(20));

        System.out.println("\n==============================================");
        System.out.println("   DEMO 2: HASH TABLE (SEPARATE CHAINING)");
        System.out.println("==============================================");

        MyHashTable table = new MyHashTable(5);

        System.out.println("Inserting Key-Value Pairs:");
        System.out.println("  put(101, 95)  -> Hash slot = 101 % 5 = 1");
        System.out.println("  put(102, 88)  -> Hash slot = 102 % 5 = 2");
        System.out.println("  put(106, 92)  -> Hash slot = 106 % 5 = 1 (Collision handled!)");

        table.put(101, 95);
        table.put(102, 88);
        table.put(106, 92);

        System.out.println();
        table.display();

        System.out.println("\nValue for key 102: " + table.get(102));
        System.out.println("Contains key 106? " + table.containsKey(106));

        System.out.println("Removing key 101...");
        table.remove(101);

        System.out.println();
        table.display();
    }
}