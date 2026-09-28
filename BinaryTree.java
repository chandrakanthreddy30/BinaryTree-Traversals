package Dsajava.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BinaryTree {
     static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        Node node=new Node(arr[0]);
        node.left=new Node(arr[1]);
        node.right=new Node(arr[2]);
        node.left.left=new Node(arr[3]);
        node.left.right=new Node(arr[4]);
        System.out.println("Recursive inorder Traversal : ");
        inorder(node);
        System.out.println();
        System.out.println("Recursive Preorder Traversal : ");
        preorder(node);
        System.out.println();
        System.out.println("Recursive Postorder Traversal : ");
        postorder(node);
       System.out.println("\nLevel order traversal : ");
       List<Integer> ans= levelorder(node);        //levelorder raversal (Queue data structure)
       System.out.println(ans);
       
       System.out.println("Iterative Preorder");
       List<Integer> pre=IterativePreorder(node);  //preorder Iterative traversal
       System.out.println(pre);
       
       System.out.println("Iterative Inorder");
       List<Integer> in=IterativeInorder(node);    //inorder Iterative traversal
       System.out.println(in);

       System.out.println("Iterative Postorder  traversal Using two Stacks");  //Iterative postorder using two stacks
       List<Integer> post=IterativePostorder1(node);
       System.out.println(post);

       System.out.println("Iterative Postorder  traversal Using one Stacks");  //Iterative postorder using one stacks
        List<Integer> post2=IterativePostorder2(node);
       System.out.println(post);
    }


    public static void inorder(Node root){          //inorder traversal recursion 
       if (root==null) return;
        inorder(root.left);
        System.out.print(root.data+"  ");
        inorder(root.right);
    }
    public static void preorder(Node root){            //preorder recursive function
      if(root==null) return;
      System.out.print(root.data + "  ");
      preorder(root.left);
      preorder(root.right);
    }
    public static void postorder(Node root){           //postorder recursive function 
      if(root==null) return ;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data + "  ");
    }
    public static List<Integer> levelorder(Node root){   //levelorder traversal 
      List<Integer> res=new ArrayList<>();
      Queue<Node> que=new LinkedList<>();
      if(root ==null) return res;
      que.add(root);
while(!que.isEmpty()){
    Node current=que.poll();
    res.add(current.data);
    if(current.left!=null){
        que.add(current.left);
    }
    if(current.right!=null){
        que.add(current.right);
    }
}
      return res;
    }
    public static List<Integer> IterativePreorder(Node root){     //iterative preorder 
        List <Integer> res =new ArrayList<>();
        Stack<Node> st=new Stack<Node>();
        if (root==null) return res;
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            res.add(root.data);
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.right!=null){
                st.push(root.left);
            }
        }
        return res;
    }
    public static List<Integer> IterativeInorder(Node root){
        List<Integer> res =new ArrayList<>();
        Stack<Node> st=new Stack<Node>();
        Node node =root;
        while(true){
            if(node!=null){
              st.push(node);
              node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                res.add(node.data);
                node=node.right;
            }
        }
        return res;
    }
    public static List<Integer> IterativePostorder1(Node root){
        List<Integer> res =new ArrayList<>();
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        if(root==null) return res;
        st1.push(root);
        while(!st1.isEmpty()){
            root=st1.pop();
            st2.push(root);
            if(root.left!=null){
              st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            res.add(st2.pop().data);
        }
        return res;
    }
    public static List<Integer> IterativePostorder2(Node root){
      List<Integer> res=new ArrayList<>();
      return res;
    }
}
