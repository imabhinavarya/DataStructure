package trees;

import java.sql.SQLOutput;
import java.util.*;

class TreeNode{
    int data;
    List<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        children=new ArrayList<>();
    }
}

public class Tree {
    public static TreeNode inputLevel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data");
        int data=sc.nextInt();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(data);
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode fnode=q.poll();
            System.out.println("Enter number of children of "+fnode.data);
            int child=sc.nextInt();
            for(int i=0;i<child;i++){
                System.out.println("Enter " +(i+1) +" child of "+fnode.data);
                data=sc.nextInt();
                TreeNode childnode=new TreeNode(data);
                fnode.children.add(childnode);
                q.add(childnode);
            }
        }
        return root;
    }

    public static void printLevel(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()){
            TreeNode fnode=q.poll();
            if(fnode==null){
                System.out.println();
                if(!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(fnode.data+" ");
                for(TreeNode child : fnode.children){
                    q.offer(child);
                }
            }
        }
    }

    public static int noOfNodes(TreeNode root){
        if(root==null) return 0;
        if(root.children==null) return 1;
        int count=1;
        for(TreeNode child : root.children){
            count += noOfNodes(child);
        }
        return count;
    }

    public static int largest(TreeNode root){
        if(root==null) return 0;
        int max=root.data;
        for(TreeNode child : root.children){
            int childmax=largest(child);
            if(max<childmax){
                max= childmax;
            }
        }
        return max;
    }

    public static int height(TreeNode root){
        if(root==null) return 0;
        if(root.children==null) return 1;
        int h=0;
        for(TreeNode child : root.children){
            h=Math.max(h,height(child));
        }
        return h+1;
    }

    public static void depthPrint(TreeNode root, int k){
        if(k<=0) return;
        if(k==1) {
            System.out.print(root.data+" ");
        }
        for(TreeNode child : root.children){
            depthPrint(child,k-1);
        }

    }

    public static int noOfLeaf(TreeNode root){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.children.isEmpty()) return 1;
        for(TreeNode child : root.children){
            count+= noOfLeaf(child);
        }
        return count;
    }

    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root.data+" ");
        for(TreeNode child : root.children){
            preOrder(child);
        }
    }

    public static void postOrder(TreeNode root){
        if(root==null) return;
        for(TreeNode child : root.children){
            postOrder(child);
        }
        System.out.println(root.data+" ");
    }

    private static int sumOfNodes(TreeNode root) {
        if(root==null) return 0;
        int sum=root.data;
        for(TreeNode child : root.children){
            sum+=sumOfNodes(child);
        }
        return sum;
    }

    //No of nodes greater than X
    private static int greaterThanX(TreeNode root, int x) {
        int count=0;
        if(root==null) return 0;
        if(root.data> x) count++;

        for(TreeNode child : root.children){
            count+=greaterThanX(child,x);
        }
        return count;
    }

    public static void main(String[] args) {
//        TreeNode root = inputLevel();
//        printLevel(root);

        Scanner sc = new Scanner(System.in);
        TreeNode root = inputRec(sc);
        printRec(root);
        System.out.println("=============================");
        System.out.println(noOfNodes(root));
        System.out.println(largest(root));
        System.out.println(height(root));
        System.out.println("==============================");
        depthPrint(root, 2);
        System.out.println();
        System.out.println(noOfLeaf(root));
        System.out.println("==============================");
        preOrder(root);
        System.out.println("==============================");
        postOrder(root);
        System.out.println("==============================");
        System.out.println(sumOfNodes(root));
        System.out.println(greaterThanX(root,3));
    }

    private static void printRec(TreeNode root) {
        if(root==null){
            return;
        }
        String str=root.data+" : ";
        for(TreeNode c : root.children){
            str+= c.data+",";
        }
        System.out.println(str);
        for(TreeNode c : root.children){
            printRec(c);
        }
    }

    private static TreeNode inputRec(Scanner sc) {
        System.out.println("Enter root data");
        int data=sc.nextInt();
        TreeNode root=new TreeNode(data);
        System.out.println("Enter no of child");
        int child= sc.nextInt();
        for(int i=0;i<child;i++){
            TreeNode  cnode = inputRec(sc);
            root.children.add(cnode);
        }
        return root;
    }


}
