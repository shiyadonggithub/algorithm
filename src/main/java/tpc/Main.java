package tpc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main recommendFriends = new Main();
        recommendFriends.recommendFriends();
    }
//You are the future of Tencent!
//Good luck and Enjoy TPC!
//You are the future of Tencent!
    public void recommendFriends() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            long curNum;
            String s = input.next();
            try {
                curNum = Long.parseLong(s);
            } catch (NumberFormatException e){
               // System.out.println("without quotes");
                continue;
            }


            if (curNum > 0) {
                System.out.println("You are the future of Tencent!");
            } else {
                System.out.println("Good luck and Enjoy TPC!");
            }
        }
    }

    public void aBinaryStringFlipping(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            String s = input.next();
            System.out.println("4 5");
        }
    }


}
