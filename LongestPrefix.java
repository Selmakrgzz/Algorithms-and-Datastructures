package org.example;

import java.util.Arrays;

public class LongestPrefix {

    public static String[] longestPrefix(String[] strs){
        String[] output = new String[2];
        for (int i = 0; i < strs.length; i++){
            String word = strs[i];
            String[] wordArray = new String[word.length()];
            for (int j = 0; j < word.length(); j++){
                String letter = String.valueOf(word.charAt(j));
                wordArray[j] = wordArray[Integer.parseInt(letter)];
            }


        }
        return null;
    }

    public static String[] test(String word){
        String[] wordArray = new String[word.length()];
        for (int i = 0; i < word.length(); i++){
            String wooord = String.valueOf(word.charAt(i));
            wordArray[i] = wooord;
        }
        return wordArray;
    }

    public static String[] test2(String[] words){
        String[] allArrays = new String[words.length];
        int lowestNum = 0;
        for (int i = 0; i < words.length; i++){
            String word = words[i];
            String[] wordArray = new String[word.length()];
            for (int j = 0; j < word.length(); j++){
                String letters = String.valueOf(word.charAt(j));
                wordArray[j] = letters;
            }
            allArrays[i] = Arrays.toString(wordArray);
           /* if (allArrays[i].length() < allArrays[i+1].length()){
                lowestNum = allArrays[i].length();
            }*/
        }
        System.out.println(Arrays.toString(allArrays[0][0]));
       return  allArrays;
    }
    public static void main(String[] args){
        String[] strs = {"flower", "floor", "flights"};
        String word = "flower";
        //System.out.println(Arrays.toString(test(word)));
        System.out.println(Arrays.toString(test2(strs)));
    }

}
