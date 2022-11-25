import java.util.ArrayList;

public class app_hw {
    public static void main(String[] args) {

        Node n1 = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        
    
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
    
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);
    
        n1.add(n2);
        n1.add(n3);
        n1.add(new Node(34));
        n1.add(new Node(341));
        n1.add(new Node(342));
    
        n2.add(n4);
        n4.add(n7);
        n4.add(n8);
        n4.add(n9);
    
        n3.add(n5);
        n3.add(n6);
        n6.add(n11);
        n6.add(n20);
    
        NodeBin nb1 = new NodeBin(1);

        NodeBin nb2 = new NodeBin(2);
        NodeBin nb3 = new NodeBin(3);

        NodeBin nb4 = new NodeBin(4);
        NodeBin nb5 = new NodeBin(5);
        NodeBin nb6 = new NodeBin(6);

        NodeBin nb7 = new NodeBin(7);
        NodeBin nb9 = new NodeBin(9);
        NodeBin nb11 = new NodeBin(11);
        NodeBin nb20 = new NodeBin(20);
        
        nb1.addLeft(nb2);
        nb1.addRight(nb3);

        nb2.addLeft(nb4);
        nb4.addLeft(nb7);
        nb4.addRight(nb9);

        nb3.addLeft(nb5);
        nb3.addRight(nb6);

        nb6.addLeft(nb11);
        nb6.addRight(nb20);
        
        // NLR Pre-order
        // 1 2 4 7 9 3 5 6 11 20
        preOrder(n1, "");
        preOrderBin(nb1, "NLR : ");
        System.out.println();
        // NRL Reverse pre-order
        // 1 3 6 20 11 5 2 4 9 7
        reversePreOrder(n1, "");
        reversePreOrderBin(nb1, "NRL : ");
        System.out.println();
     }

    static void preOrderBin(NodeBin root, String sp) {
        if (root != null) {
            System.out.printf(sp + root.getValue());
            if (root.getLeft() != null) {
                preOrderBin(root.getLeft(), " ");
            }
            if (root.getRight() != null) {
                preOrderBin(root.getRight(), " ");
            }
        }
    }

    static void reversePreOrderBin(NodeBin root, String sp) {
        if (root != null) {
            System.out.printf(sp + root.getValue());
            if (root.getRight() != null) {
                reversePreOrderBin(root.getRight(), " ");
            }
            if (root.getLeft() != null) {
                reversePreOrderBin(root.getLeft(), " ");
            }
        }
    }

    static void preOrder(Node root, String sp) {
        if (root != null) {
            System.out.println(sp + root.getValue());
            for (Node c : root.nodes) {
            preOrder(c, sp + "  ");
            }
        }
    }
    
    static void reversePreOrder(Node root, String sp) {
        if (root != null) {
            System.out.println(sp + root.getValue());
            for (int i = root.nodes.size() - 1; i >= 0; i--) {
                reversePreOrder(root.nodes.get(i), sp + "  ");
            }
        }
    }  
}

class NodeBin {
    int value;
    NodeBin left;
    NodeBin right;

    public NodeBin(int value) {
        this.value = value;
    }
    
    public void addLeft(NodeBin node) {
        this.left = node;
    }

    public void addRight(NodeBin node) {
        this.right = node;
    }

    public int getValue() {
        return this.value;
    }

    public NodeBin getLeft() {
        return this.left;
    }

    public NodeBin getRight() {
        return this.right;
    }
}

class Node {
    int value;

    public Node(int value) {
        this.value = value;
    }
    
    ArrayList<Node> nodes = new ArrayList<>();
    
    public void add(Node node) {
        nodes.add(node);
    }

    public int getValue() {
        return this.value;
    }
}