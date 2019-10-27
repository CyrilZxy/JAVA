public class demo2 {
    public static void main(String[] args) {

        mode2 MyArrayList1 = new mode2();

        MyArrayList1.add(0,4);
        MyArrayList1.add(1,7);
        MyArrayList1.add(2,1);
        MyArrayList1.add(2,9);
        MyArrayList1.add(2,10);
        MyArrayList1.display();
        MyArrayList1.add(10,9);
        //MyArrayList1.add(4,4);
        MyArrayList1.contains(7);
        MyArrayList1.contains(8);

        System.out.println(MyArrayList1.search(7));
        System.out.println(MyArrayList1.search(4));
        System.out.println(MyArrayList1.search(8));

        System.out.println(MyArrayList1.getPos(3));
        System.out.println(MyArrayList1.getPos(8));

        MyArrayList1.display();
        MyArrayList1.clear();
        MyArrayList1.display();
    }
}




