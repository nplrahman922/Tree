public class Node {
    private Node left;
    private Node right;
    private int key;
    private int deep_x;
    private int deep_y;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public int getKey() {
        return key;
    }
    public int setdeep_x (int deep_x) {
        this.deep_x = deep_x;
        return deep_x;
    }
    public int getdeep_x() {
        return deep_x;
    }
    public int setdeep_y (int deep_y) {
        this.deep_y = deep_y;
        return deep_y;
    }
    public int getdeep_y() {
        return deep_y;
    }        
}