package csc223.aa;

import java.util.LinkedList;
import java.util.Queue;

public class Treeclass implements Tree{

    private TreeNode root; 

    public Treeclass() {
        this.root = null;
    }

    @Override
    public String levelorder(){
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            result.append(current.data);

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }

        return result.toString();
    }

    @Override
    public String preorder(){
        StringBuilder result = new StringBuilder();
        preorderHelper(root, result);
        return result.toString();
    }

    private void preorderHelper(TreeNode node, StringBuilder result){
        if (node != null) {
            result.append(node.data); 
            preorderHelper(node.left, result); 
            preorderHelper(node.right, result);  
        }
    }

    @Override
    public String inorder(){
        StringBuilder result = new StringBuilder();
        inorderHelper(root, result);
        return result.toString();
    }

    private void inorderHelper(TreeNode node, StringBuilder result){
        if (node != null) {
            inorderHelper(node.left, result);  
            result.append(node.data);  
            inorderHelper(node.right, result); 
        }
    }

    @Override
    public String postorder(){
        StringBuilder result = new StringBuilder();
        postorderHelper(root, result);
        return result.toString();
    }

    private void postorderHelper(TreeNode node, StringBuilder result){
        if (node != null) {
            postorderHelper(node.left, result);  
            postorderHelper(node.right, result); 
            result.append(node.data);  
        }
    }

    @Override
    public void insert(char item){
        if (root == null) {
            root = new TreeNode(item);
            return;
        }

        // Level order insertion using a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();

            if (current.left == null){
                current.left = new TreeNode(item);
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null){
                current.right = new TreeNode(item);
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    @Override
    public boolean search(char item){
        if (root == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();

            if (current.data == item){
                return true;
            }

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }

        return false;
    }

    @Override
    public int size(){
        return sizeHelper(root);
    }

    private int sizeHelper(TreeNode node){
        if (node == null){
            return 0;
        }

        return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }

    @Override
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public int height(){
        return heightHelper(root);
    }

    private int heightHelper(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHeight = heightHelper(node.left);
        int rightHeight = heightHelper(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
