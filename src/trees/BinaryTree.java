package trees;

import java.util.*;

//Pair class for top and bottom view
class Pair{
    int hd;
    BinaryTreeNode root;

    public Pair(int hd, BinaryTreeNode root) {
        this.hd = hd;
        this.root = root;
    }
}

class BinaryTreeNode{
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class BinaryTree {
    /////////////////// TOP VIEW //////////////////////////
    public static void topView(BinaryTreeNode root){
        if(root==null) return;
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int hd = p.hd;
            BinaryTreeNode fnode = p.root;

            if(!map.containsKey(hd)){
                map.put(hd,fnode.data);
            }
            if(fnode.left!=null){
                q.add(new Pair(hd-1, fnode.left));
            }
            if(fnode.right!=null){
                q.add(new Pair(hd+1, fnode.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
        System.out.println();
    }
    ///////////////////////////////////////////////////////

    /////////////////// BOTTOM VIEW ///////////////////////
    public static void bottomView(BinaryTreeNode root){
        if (root == null) {
            return;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()){
            Pair p = q.poll();
            int hd = p.hd;
            BinaryTreeNode fnode = p.root;
            map.put(hd, fnode.data);
            if(fnode.left!=null){
                q.add(new Pair(hd-1,fnode.left));
            }
            if(fnode.right!=null){
                q.add(new Pair(hd-1,fnode.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
        System.out.println();
    }
    ///////////////////////////////////////////////////////

    public static BinaryTreeNode inputLevel(){
        System.out.println("Enter root data ");
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        BinaryTreeNode root = new BinaryTreeNode(data);
        Queue<BinaryTreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode fnode=q.poll();
            System.out.println("Enter left node of "+fnode.data);
            int leftdata=sc.nextInt();
            if(leftdata!= -1){
                BinaryTreeNode l = new BinaryTreeNode(leftdata);
                fnode.left= l;
                q.offer(l);
            }
            System.out.println("Enter right node of "+fnode.data);
            int rightdata=sc.nextInt();
            if(rightdata!= -1){
                BinaryTreeNode r = new BinaryTreeNode(rightdata);
                fnode.right= r;
                q.offer(r);
            }
        }
        return root;
    }

    public static void printLevel(BinaryTreeNode root){
        if(root==null) return;
        Queue<BinaryTreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode fnode=q.poll();
            String str = fnode.data+": ";
            if(fnode.left!=null){
                str += fnode.left.data+", ";
                q.offer(fnode.left);
            }
            if(fnode.right!=null){
                str += fnode.right.data;
                q.offer(fnode.right);
            }
            System.out.println(str);
        }
    }

    public static int countNodes(BinaryTreeNode root){
        if(root==null) return 0;
        int count=1;
        if(root.left != null){
            count+=countNodes(root.left);
        }
        if(root.right != null){
            count+=countNodes(root.right);
        }
        return count;
    }

    public static int height(BinaryTreeNode root){
        if (root == null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        if(rh>lh){
            return rh+1;
        } else {
            return lh+1;
        }
    }

    public static boolean isPresent(BinaryTreeNode root, int x){
        if(root==null) return false;
        if(root.data==x) return true;

        return isPresent(root.left,x) || isPresent(root.right,x);
    }

    public static int diameter(BinaryTreeNode root){
        if(root==null) return 0;
        int op1 = height(root.left) + height(root.right);
        int op2 = diameter(root.left);
        int op3 = diameter(root.right);

        return Math.max(op1, Math.max(op2,op3));
    }

    public static void preOrder(BinaryTreeNode root){
        if(root==null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BinaryTreeNode root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode root){
        if(root==null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public static BinaryTreeNode preInTreeConstruct(int[] pre, int[] in){
        return helperPreIn(pre,in,0,pre.length-1,0,in.length-1);
    }

    private static BinaryTreeNode helperPreIn(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
        if(inS>inE) return null;
        int rootdata=pre[preS];
        BinaryTreeNode root=new BinaryTreeNode(rootdata);
        int rootIndex=-1;
        for(int i=inS;i<=inE;i++){
            if(in[i]==rootdata){
                rootIndex=i;
                break;
            }
        }
        int leftIns=inS;
        int leftInE=rootIndex-1;
        int leftPreS=preS+1;
        int leftPreE=leftPreS+leftInE-leftIns;

        int rightIns=rootIndex+1;
        int rightInE=inE;
        int rightPreS=leftPreE+1;
        int rightPreE=preE;

        root.left=helperPreIn(pre, in, leftPreS, leftPreE, leftIns, leftInE);
        root.right=helperPreIn(pre, in, rightPreS, rightPreE, rightIns, rightInE);

        return root;
    }


    public static BinaryTreeNode postInTreeConstruct(int[] post, int[] in){
        return helperPostIn(post,in,0,post.length-1,0,in.length-1);
    }

    private static BinaryTreeNode helperPostIn(int[] post, int[] in, int postS, int postE, int inS, int inE) {
        if(inS>inE) return null;
        int rootdata=post[postE];
        BinaryTreeNode root=new BinaryTreeNode(rootdata);
        int rootIndex=-1;
        for(int i=inS;i<=inE;i++){
            if(in[i]==rootdata){
                rootIndex=i;
                break;
            }
        }

        int rightIns=rootIndex+1;
        int rightInE=inE;
        int rightPostE=postE-1;
        int rightPostS=rightPostE - (rightInE - rightIns);


        int leftIns=inS;
        int leftInE=rootIndex-1;
        int leftPostS=postS;
        int leftPostE=leftPostS+leftInE-leftIns;



        root.left=helperPreIn(post, in, leftPostS, leftPostE, leftIns, leftInE);
        root.right=helperPreIn(post, in, rightPostS, rightPostE, rightIns, rightInE);

        return root;
    }

    public static BinaryTreeNode mirror(BinaryTreeNode root){
        if(root==null) return null;

        BinaryTreeNode temp=root.left;
        root.left=mirror(root.right);
        root.right=mirror(temp);

        return root;
    }


    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        System.out.println("Top view of the binary tree:");
        topView(root);

        System.out.println("Bottom view of the binary tree:");
        bottomView(root);
//        BinaryTreeNode root = inputLevel();
//        printLevel(root);
//        System.out.println("=============================");
//        System.out.println(countNodes(root));
//
//        System.out.println("=============================");
//        preOrder(root);
//        System.out.println("=============================");
//        inOrder(root);
//        System.out.println("=============================");
//        postOrder(root);
//
//        int[] pre={1,2,3,4,15,5,6,7,8,10,9,12};
//        int[] in={4,15,3,2,5,1,6,10,8,7,9,12};
//        BinaryTreeNode r=preInTreeConstruct(pre,in);
//        printLevel(r);
//        System.out.println("==================");
//        BinaryTreeNode ro=mirror(root);
//        printLevel(ro);
    }
}
