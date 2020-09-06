
package 堆;


/**
 * @author ：ZXY
 * @date ：Created in 2020/9/6 17:59
 * @description：
 */


public class TestHeap {
    public int[] elem;
    public int usedSize;
    public TestHeap() {
        this.elem=new int[10];
        this.usedSize=0;
    }

    //创建堆
    public void creatHeap(int[] array){
        for(int i=0;i<array.length;i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        // i 表示每棵子树的根节点
       for(int i=(this.usedSize-1-1)/2;i>=0;i--){
           adjustDown(i,this.usedSize);
        }
    }

    public void show(){
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
    //向下调整  root每棵子树根节点  len每棵子树结束位置
    public void adjustDown(int root,int len){
        int parent=root;
        int child=2*parent+1;
        while (child<len){
            //1、找到左右孩子的最大值
            if((child+1<len) && this.elem[child]<this.elem[child+1]){
                child=child+1;
            }
            //child保存左右孩子最大值下标

            if(this.elem[child]>this.elem[parent]){
                int tmp=this.elem[child];
                this.elem[child]=this.elem[parent];
                this.elem[parent]=tmp;
                parent=child;
                child=2*parent+1;
            }else{
                //不需进行调整
                break;
            }
        }
    }
}

