public class Three {
    private Node root;

    public Three () {
        this.root = null;
    }

    public void Insert(int key){
        this.root = InsertHelper(this.root, key);
    }

    private Node InsertHelper(Node value ,int key) {

        if (value == null){
            root = new Node(key);
            return root;
        }
        if ( key < value.getKey() ) {
            value.setLeft(InsertHelper(value.getLeft(), key));
        } else if ( key > value.getKey()){
            value.setRight(InsertHelper(value.getRight(), key));
        } else {
            System.out.println("angkamu invalid mas");
        }
        return value;        
    }

    public void InOrder(){
        InOrder(root);
    }

    private void InOrder(Node value){

        if (value == null) {
            return;
        }

        InOrder(value.getLeft());
        System.out.print(value.getKey());
        InOrder(value.getRight());
    }

    public void PreOrder() {
        PreOrder(root);
    }
    private void PreOrder(Node value) {
        if (value == null) {
            return;
        }

        System.out.print(value.getKey());
        PreOrder(value.getLeft());
        PreOrder(value.getRight());
    }

    public void PostOrder() {
        PostOrder(root);
    }
    private void PostOrder(Node value) {
        if (value == null) {
            return;
        }
        PostOrder(value.getLeft());
        PostOrder(value.getRight());
        System.out.print(value.getKey());
    }
    public void displayAscii() {
        displayAscii(root, "", true);
    }

    private void displayAscii(Node value ,String prefix,boolean isLastchild ) {
        if (value == null) {
            return;
        }

        String connector = isLastchild ? "└──" : "├──";
        System.out.println(prefix + connector + value.getKey());
        String childPrefix = String.valueOf(prefix) + (isLastchild ? "    " : "│   ");

        if (value.getLeft() != null || value.getRight() != null) {
            displayAscii(value.getLeft(), childPrefix, false);
            displayAscii(value.getRight(), childPrefix, true);
        } else if (value.getLeft() != null) {
            displayAscii(value.getLeft(), childPrefix, true);
        } else if (value.getRight() != null) {
            displayAscii(value.getRight(), childPrefix, true);
        }
    }
        

}