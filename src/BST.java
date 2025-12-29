public class BST {
    Node root;

    BST() {
        this.root = null;
    }

    public void insert(int v) {
        if (root == null) { //tree is null so root become the new node
            root = new Node(v);
            return;
        }
        Node cur = root;  //This pointer will be used to traverse down the tree to find the correct insertion spot
        while (true) {
            if (v < cur.val) {  // Go Left Subtree
                if (cur.left == null) {
                    cur.left = new Node(v);
                    return;
                }
                cur = cur.left;
                ; //If the left child is not empty, the cur pointer moves down to the left child, and the loop repeats, checking the new current node
            }else{  //Go Right Subtree
                if (cur.right == null) {
                    cur.right = new Node(v);
                    return;
                }
                cur = cur.right;  // If the right child is not empty, the cur pointer moves down to the right child, and the loop repeats.
            }
        }
    }

    public boolean search(int v) {
        Node cur = root;
        while (cur != null) {
            if(v==cur.val) return true;     //found the value
            if(v<cur.val){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return false;
    }
    public void delete(int v) {
        root = deleteRec(root, v);
    }

    public Node deleteRec(Node node, int key) {
        if (node == null) return null; // no node to delete because empty
        if (key < node.val) {
            node.left = deleteRec(node.left, key); // Go Left subtree
        } else if (key > node.val) {               // Go Left subtree
            node.right = deleteRec(node.right, key);
        } else {   // node to delete found // key == node.val
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right; // if right child exist
            if (node.right == null) return node.left; // if left child exist
            Node succ = minNode(node.right); //35
            node.val = succ.val; // copy successor value
            node.right = deleteRec(node.right, succ.val); // delete successor node
        }
        return node;
    }

    public Node minNode(Node node) {
        Node cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }


}














