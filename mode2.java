import java.util.Arrays;

class mode2 {
        //属性
        private int[] elem;
        private int usedSize;
        private final int CAPACITY = 10;

        public mode2() {
            this.elem = new int[CAPACITY];
            this.usedSize = 0;
        }


        //方法
        // 打印顺序表
        public void display() {
            for (int i = 0; i < this.usedSize ; i++) {
                System.out.print(this.elem[i]+" ");
            }
            System.out.println(" ");
        }


        private boolean isFull(){
            if(this.usedSize==this.elem.length){
                return true;
            }return false;
        }

        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            /*if (isFull()){  //二倍扩容
                this.elem= Arrays.copyOf(this.elem,this.elem.length*2);
            }*/
            if(pos<0||pos>this.usedSize){
                System.out.println("位置不合法");
                return;
            }
            for (int i = this.usedSize; i>=pos; i--) {
                this.elem[i+1]=this.elem[i];
            }
            this.elem[pos]=data;
            this.usedSize++;
        }


        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if(this.elem[i]==toFind){
                    System.out.println("true");
                    return true;
                }
            }
            System.out.println("false");
            return false;
        }


        // 查找某个元素对应的位置
        public int search(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind) {
                    System.out.print(toFind + "元素对应位置为：" );
                    return i;
                }
            }
            return -1;
        }


        // 获取 pos 位置的元素
        public int getPos(int pos) {
            for (int i = 0; i <this.usedSize; i++) {
                if(i==pos){
                    System.out.print(pos+"位置对应元素为：");
                    return elem[i];
                }
            }
            return -1;
        }


        // 给 pos 位置的元素设为 value
        public void setPos(int pos, int value) { }


        //删除第一次出现的关键字key
        public void remove(int toRemove) { }


        // 获取顺序表长度
        public int size() { return 0; }


        // 清空顺序表
        public void clear() {
            this.usedSize=0;
        }

    }

