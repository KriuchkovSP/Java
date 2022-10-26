public class app {
    static int position = 0;
    static int[] storage = new int[11];

    static void print() {
        for (int i = 0; i < storage.length; i++){
            System.out.printf((storage[i] + " "));
        }
        System.out.println();
    }
    static void clear() {

    }
    static void shift() {
        for (int i = 0; i <= position; i++){
            storage[i] = storage[i + 1];
        }
        storage[position++] = 0;
        position--;
    }

    static void add(int item) {
        storage[position++] = item;
    }

    static int remove() {
        int el = storage[0];
        shift();
        return el;
    }

    public static void main(String[] args) {
        print();
        add(1);
        print();
        add(2);
        print();
        add(3);
        print();
    }
}
