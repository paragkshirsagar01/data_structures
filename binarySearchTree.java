package data_structure;

import java.util.ArrayList;
import java.util.List;

class binarySearchTree<T extends Comparable<T>>{
    int size=0;
    class node{
        T data;
        node right;
        node left;
        node(T data){
            this.data=data;
            right=null;
            left=null;
        }
    }
    node root;
    binarySearchTree(){
        root=null;
    }
    binarySearchTree(T data){
        if(root==null){
            root=new node(data);
        }
        size++;
    }
    public boolean add(T data){
        root=insertdata(root,data);
        return true;
    }
    private node insertdata(node root, T data) {
        if(root==null){
            root=new node(data);
            return root;
        }
        if(data.compareTo(root.data)==1){
            root.right=insertdata(root.right, data);
        }else if(data.compareTo(root.data)==-1){
            root.left=insertdata(root.left, data);
        }
        return root;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }else{
            return false;
        }
    }
    public List<T> inOrderTraversal(){
        ArrayList<T> datastored=new ArrayList<>();
        inOrdTrave(datastored,root);
        return datastored;
    }

    public void inOrdTrave(ArrayList<T> datastored,node root){
        if(root.left!=null){
            inOrdTrave(datastored, root.left);
        }
        datastored.add(root.data);
        if(root.right!=null){
            inOrdTrave(datastored, root.right);
        }
    }
}