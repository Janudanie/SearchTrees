public class AVLTree {
    Node root;





    private int height(Node N) {
        if (N == null) return 0;
        return N.height;
        }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getBalance(Node N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }


    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public Node insert(Node node, int key) {

        //First Node created
        if (node == null)return (new Node(key));

        //Insert a new node, abort if duplicate
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        else return node;

        //Update height of node
        node.height = 1 + max(height(node.left),height(node.right));

        //Check the balance of the node
        int balance = getBalance(node);

        // Left left problem
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right problem
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // left right problem
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left problem
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        // tree is balanced.
        return node;
    }
}
