

public class app_hw {
    public static void main(String[] args) {

        Node n1 = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        
    
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
    
        Node n7 = new Node(7);
        Node n9 = new Node(9);
        Node n11 = new Node(11);
        Node n20 = new Node(20);

        
        n1.addLeft(n2);
        n1.addRight(n3);

        n2.addLeft(n4);
        n4.addLeft(n7);
        n4.addRight(n9);

        n3.addLeft(n5);
        n3.addRight(n6);

        n6.addLeft(n11);
        n6.addRight(n20);
        
        // NLR Pre-order
        // 1 2 4 7 9 3 5 6 11 20
        n1.preOrder("NLR: ");
        System.out.println();
        
        // NRL Reverse pre-order
        // 1 3 6 20 11 5 2 4 9 7
        n1.reversePreOrder("NRL: ");
        System.out.println();
        
        //LNR in-order
        // 7 4 9 2 1 5 3 11 6 20
        System.out.printf("LNR:");
        n1.inOrder(" ");
        System.out.println();

        //RNL Reverse in-order
        // 20 6 11 3 5 1 2 9 4 7
        System.out.printf("RNL:");
        n1.reverseInOrder(" ");
        System.out.println();

        //LRN post-oreder
        // 7 9 4 2 5 11 20 6 3 1
        System.out.printf("LRN:");
        n1.postOrder(" ");
        System.out.println();

        //RLN Reverse post-oreder
        // 5 11 20 6 3 7 9 4 2 1
        System.out.printf("RLN:");
        n1.reversePostOrder(" ");
        System.out.println();
     }

}
