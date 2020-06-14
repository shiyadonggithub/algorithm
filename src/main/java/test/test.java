package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
//        Scanner reader = new Scanner(System.in);
//        System.out.println("please input the length of the array:");
//
//        int n = reader.nextInt();
//
//        System.out.println("the length of the array is " + n);
//
//        System.out.println("please input the number of the array:");
//
//        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
//        for (int i = 0; i < n; i++) {
//            integerArrayList.add(reader.nextInt());
//        }
//
//        System.out.println("the array of your input is :");
//
//        System.out.println(integerArrayList);
//        System.out.println("please input the number of p:");
//        int p = reader.nextInt();
//
//        //复制一个数组integerArrayList1
//        ArrayList<Integer> integerArrayList1 = new ArrayList<Integer>();
//        for (int i = 0; i < integerArrayList.size(); i++) {
//            integerArrayList1.add(integerArrayList.get(i));
//        }
//
//        for (int i = 0; i < n; i++) {
//            integerArrayList.set(i, integerArrayList1.get((i + p) % (n)));
//        }
//
//        System.out.println("the array after transform is :");
//        System.out.println(integerArrayList);
        String s = "test 123";
        String[] tokens = s.toLowerCase().split("\\W+");
        System.out.println(tokens);
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }
}
