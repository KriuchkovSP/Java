public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }
    
    public void addLeft(Node node) {
        this.left = node;
    }

    public void addRight(Node node) {
        this.right = node;
    }

    public int getValue() {
        return this.value;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public void preOrder(String sp) {
        if (this != null) {
            if (sp.equals(")") && (left != null) && (right != null)) {
                System.out.printf(String.format("%d", value));
            } else if(sp.equals(")")) {
                System.out.printf(String.format("%d%s", value, sp));
            } else {
                System.out.printf(String.format("%s%d,", sp, value));
            }
            if (left != null) {
                left.preOrder("(");
            } else if (right != null){
                System.out.printf("(nil,");
            }
            if (right != null) {
                right.preOrder(")");
            } else if (left != null){
                System.out.printf(",nil),");
            }
        }
    }

    public void reversePreOrder(String sp) {
        if (this != null) {
            System.out.printf(sp + value);
            if (right != null) {
                right.reversePreOrder(" ");
            }
            if (left != null) {
                left.reversePreOrder(" ");
            }
        }
    }
    
    public void inOrder(String sp) {
        if (this != null) {
            if (left != null) {
                left.inOrder(" ");
            }
            System.out.printf(sp + value);
            if (right != null) {
                right.inOrder(" ");
            }
        }
    }

    public void reverseInOrder(String sp) {
        if (this != null) {
            if (right != null) {
                right.reverseInOrder(" ");
            }
            System.out.printf(sp + value);
            if (left != null) {
                left.reverseInOrder(" ");
            }
        }
    }

    public void postOrder(String sp) {
        if (this != null) {
            if (left != null) {
                left.postOrder(" ");
            }
            if (right != null) {
                right.postOrder(" ");
            }
            System.out.printf(sp + value);
        }
    }

    public void reversePostOrder(String sp) {
        if (this != null) {
            if (right != null) {
                right.postOrder(" ");
            }
            if (left != null) {
                left.postOrder(" ");
            }
            System.out.printf(sp + value);
        }
    }

}