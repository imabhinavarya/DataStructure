package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BstNode{
    int data;
    BstNode left;
    BstNode right;

    public BstNode(int data) {
        this.data = data;
    }

    public BstNode() {

    }
}

public class BinarySearchTree {
    public static BstNode insert(BstNode root, int val){
       if(root==null){
           root=new BstNode(val);
       }
       else if(root.data>val){
           root.left=insert(root.left,val);
       }
       else{
           root.right=insert(root.right,val);
       }
       return root;
    }

    public static void printLevel(BstNode root){
        if (root == null)  return;

        Queue<BstNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            BstNode fnode = q.poll();
            String str=fnode.data+" : ";
            if(fnode.left != null){
                str+="L" +fnode.left.data+", ";
                q.add(fnode.left);
            }
            if(fnode.right != null){
                str+="R"+fnode.right.data;
                q.add(fnode.right);
            }
            System.out.println(str);
        }
    }

    public static int getMax(BstNode root){
        if(root==null) return -1;
        while(root.right != null){
            root=root.right;
        }
        return root.data;
    }

    public static int getMin(BstNode root){
        if(root==null) return -1;
        while(root.left != null){
            root=root.left;
        }
        return root.data;
    }

    public static BstNode deleteNode(BstNode root, int val){
        if(root==null) return null;
        if(root.data < val){
            root.right = deleteNode(root.right, val);
        }else if(root.data > val){
            root.left =deleteNode(root.left, val);
        }else {
            if(root.left != null && root.right != null){
                int lmax = getMax(root.left);
                root.data = lmax;
                root.left = deleteNode(root.left, lmax);
                return root;
            } else if (root.left != null) {
                return root.left;
            } else if (root.right !=  null) {
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }

    public static BstNode getSuccesor(BstNode root){
        if(root==null) return root;
        BstNode temp = root.right;
        while (temp.left != null){
            temp=temp.left;
        }
        return temp;
    }

    public static BstNode getDec(BstNode root){
        if(root==null) return root;
        BstNode temp = root.left;
        while (temp.right != null){
            temp=temp.right;
        }
        return temp;
    }

    public static boolean isBst(BstNode root){
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BstNode root, int min, int max) {
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;

        return helper(root.right, root.data+1, max) && helper(root.left, min, root.data-1);
    }

    private static BstNode getParent(BstNode root, int val){
        if(root == null) return null;
        BstNode parent=null;
        while (root != null){
            if(val<root.data){
                parent=root;
                root=root.left;
            }
            else if(val>root.data){
                parent=root;
                root= root.right;
            }
            else {
                break;
            }
        }
        //uncomment this two line if you want sibling node
//        if (parent.left.data==val) return parent.right;
//        if (parent.right.data==val) return parent.left;

        return parent;
    }

    public static void main(String[] args) {

        BstNode root = insert(null,8);
        root = insert(root,3);
        root = insert(root,10);
        root = insert(root,1);
        root = insert(root,6);
        root = insert(root,14);
        root = insert(root,4);

        root = insert(root,7);
        root = insert(root,13);
        printLevel(root);
        System.out.println("++++++++++++");
//        printLevel(deleteNode(root, 8));
        System.out.println(getDec(root).data);
        System.out.println(isBst(root));
        System.out.println(getParent(root,1).data);
    }
}
