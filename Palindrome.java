package org.example;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        int num1 = 0;
        int num2 = 0;
        int num3 = x;
        boolean check = false;

        while(x != 0){
            num1 = x % 10;
            num2 = (num2 + num1)*10;
            x = (x-num1)/10;
            if(x==1){
                num2+=x;
                break;
            }

        }
        System.out.println(num2);
        if(num2 == num3){
            check = true;
        }
        return check;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(126621));
    }
}
