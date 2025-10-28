public class Node {
    private Node left;
    private Node right;
    private int key;

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
        
}