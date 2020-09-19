package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

import static 二叉树.test1.CreatBinaryTree;

/**
 * @author ：ZXY
 * @date ：Created in 2020/9/5 13:52
 * @description：
 */

public class test2 {

    public static void main(String[] args) {
        Node root=CreatBinaryTree();
        levelOrderTraversal(root);
    }


    //层序遍历 返回List<List>
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }

        Queue<Node> que=new LinkedList<>();
        que.offer(root);

        //区分每层是否遍历结束
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> list=new ArrayList<>();
            //每层的数据
            while (size>0){
                Node cur=que.poll();
                size--;
                if(cur!=null){
                    //System.out.print(cur.value+" ");
                    list.add(Integer.valueOf(cur.value));
                    if(cur.left!=null){
                        que.offer(cur.left);
                    }
                    if(cur.right!=null){
                        que.offer(cur.right);
                    }
                }//队列大小为2
            }
            ret.add(list);
        }
        return ret;
    }

    //判断完全二叉树 队列
    boolean isCompleteTree(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }

        while (!queue.isEmpty()){
            Node cur=queue.peek();
            if(cur!=null){
                return false;
            }
        }
        return true;
    }



    //层序遍历
    public static void levelOrderTraversal(Node root){
        if(root==null){
            return;
        }

        Queue<Node> que=new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            Node out=que.poll();
            if(out!=null){
                System.out.print(out.value+" ");
                if(out.left!=null){
                    que.offer(out.left);
                }
                if(out.right!=null){
                    que.offer(out.right);
                }
            }
        }

    }
}
