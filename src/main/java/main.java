import java.lang.reflect.Array;

public class main {

    public static void main(String[] args) {


        AVLTree tree = new AVLTree();





        for(int x = 1 ; x< 10 ; x ++){
            tree.root = tree.insert(tree.root, x);
        }






        /* Tree looks like this */
        /*
                 4
               /   \
              2      6
            /  \   /   \
           1   3   5   8
                     /   \
                     7   9
         */
		System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }






}
