package 二叉树;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/3 12:46
 * @description：
 */
class Node{
    public char value;
    public Node left;      //左节点
    public Node right;     //右节点

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class test1 {
    public static void main(String[] args) {
        Node root=CreatBinaryTree();
        //preOrderTraversal(root);
        //inOrderTraversal(root);
        //postOrderTraversal(root);

        //System.out.println(getSize1(root));
        //System.out.println(getSize2(root));
        //System.out.println(getLeafsize(root));
        //System.out.println(getKLevelSize(root,4));
        System.out.println(getHeight(root));
    }









    //查找 val 所在结点，没有找到返回 null
    public static Node Find(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.value==val){
            return root;
        }
        Node outNode=Find(root.left,val);
        if(outNode!=null){
            return outNode;
        }
        outNode=Find(root.right,val);
        if(outNode!=null){
            return outNode;
        }
        return null;
    }






    //二叉树高度
    public static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return leftHeight>rightHeight ? leftHeight+1:rightHeight+1;
    }

    //第k层节点个数
    public static int getKLevelSize(Node root,int k){
        if (root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }


    //叶子节点个数
    public static int getLeafsize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null || root.right==null){
            return 1;
        }else{
            return getLeafsize(root.left)+getLeafsize(root.right);
        }
    }






    //遍历求节点个数-遍历
    static int size=0;
    public static int getSize2(Node root){
        if(root==null){
            return 0;
        }
        size++;
        getSize2(root.left);
        getSize2(root.right);
        return size;
    }
    //遍历求节点个数-递归
    public static int getSize1(Node root){
        if(root==null){
            return 0;
        }
        return getSize1(root.left)+getSize1(root.right)+1;
    }

    //前序遍历-根左右
    public static void preOrderTraversal(Node root){
        if(root==null) {
            return;
        }
        System.out.print(root.value+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    //中序遍历-左根右
    public static void inOrderTraversal(Node root){
        if(root==null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value+" ");
        inOrderTraversal(root.right);
    }
    //后序遍历-左右根
    public static void postOrderTraversal(Node root){
        if(root==null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value+" ");
    }


    //创建二叉树—手动
    public static Node CreatBinaryTree(){
        Node A=new Node('A');
        Node B=new Node('B');
        Node C=new Node('C');
        Node D=new Node('D');
        Node E=new Node('E');
        Node F=new Node('F');
        Node G=new Node('G');
        Node H=new Node('H');

        A.left=B;
        A.right=C;
        B.left=D;
        B.right=E;
        C.left=F;
        C.right=G;
        E.right=H;

        return A;
    }


}
