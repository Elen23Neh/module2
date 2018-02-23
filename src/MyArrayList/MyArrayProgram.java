package MyArrayList;

import java.util.ArrayList;

public class MyArrayProgram {
    public static void main(String[] args){
        MyArrayList<Integer> arr = new MyArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(5);

        arr.add(4,2);
        arr.add(3,2);

        arr.print();

        System.out.println("-----");

        System.out.println(arr.get(4));

        System.out.println("-----");

        arr.remove(2);
        arr.print();
    }
}
