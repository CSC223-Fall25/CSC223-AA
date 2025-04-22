package csc223.aa;

public class BST{

    public BSTNode root; 

    public BST(){
        this.root = null;
    }

    public void insert(int value){
        if (this.root == null){
            this.root = new BSTNode(value);
            return;
        }
        inserthelper(value, this.root);
    }
    
    private void inserthelper(int value, BSTNode curr){
        if (value < curr.data){ 
            if (curr.left == null){
                curr.left = new BSTNode(value);
            } 

            else{
                inserthelper(value, curr.left);
            }
        } 
        else{
            if (curr.right == null){
                curr.right = new BSTNode(value);
            } 

            else{
                inserthelper(value, curr.right);
            }
        }
    }

    public void delete(int value){
        root = deleteHelper(root, value);
    }
    
    private BSTNode deleteHelper(BSTNode node, int value){
        if (node == null) {
            // Base case: Value not found
            return null;  
        }

        if (value < node.data){
            node.left = deleteHelper(node.left, value);
        } 
        else if (value > node.data){
            node.right = deleteHelper(node.right, value);
        } 

        else{
            // Case 1 - No child
            if (node.left == null && node.right == null){
                return null;
            }
            // Case 2 - One child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
    
            // Case 3 - Two children
            node.data = findMin(node.right);
            node.right = deleteHelper(node.right, node.data);
        }
        return node;
    }

    private int findMin(BSTNode node){
        while (node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public boolean search(int value){
        return searchhelper(value,this.root);
    }

    private boolean searchhelper(int value, BSTNode curr){
        if (curr == null){  
            return false;
        }
    
        if (curr.data == value){  
            return true;
        }
    
        if (curr.data < value) {
            return searchhelper(value, curr.right);
        } else {
            return searchhelper(value, curr.left);
        }
    }

    public void update(int oldValue, int newValue){
        if (search(oldValue)){
            delete(oldValue); 
            insert(newValue);
        }
    }
    
    public String inOrder(){
        StringBuilder result = new StringBuilder();
        inOrderHelper(this.root, result);
        return result.toString().trim();
    }
    
    private void inOrderHelper(BSTNode node, StringBuilder result){
        if (node == null) return;
        inOrderHelper(node.left, result);
        result.append(node.data);
        result.append(" ");
        inOrderHelper(node.right, result);
    }
    
    public BSTNode sortedArrayToBST(int[] values){
        return sortedArrayToBSTHelper(values, 0, values.length - 1);
    }
    
    private BSTNode sortedArrayToBSTHelper(int[] values, int left, int right){
        if (left > right) return null;
    
        int mid = left + (right - left) / 2;
        BSTNode node = new BSTNode(values[mid]);
    
        node.left = sortedArrayToBSTHelper(values, left, mid - 1);
        node.right = sortedArrayToBSTHelper(values, mid + 1, right);
    
        return node;
    }
}
