package com.company;
/*
* @author: Sarghe Andrei Vlad
* */
import java.util.Arrays;

public class Main {

    public static String randWord(int ln, int size, char[] alphabet){
        String word = new String();
        for(int i=0; i<ln; i++){
            int randomIndex = (int)(Math.random()*(size-1));
            word += alphabet[randomIndex];
        }
        return word;
    }

    public static boolean isNeighbour(String w1, String w2){
        for(int i=0; i<w1.length(); i++){
            for(int j=0; j<w2.length(); j++){
                if(w1.charAt(i)==w2.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);
        char[] myAlphabet = new char[args.length-2];
        String[] words = new String[n];

        //Generating myAlphabet
        for(int i=2;i<args.length;i++){
            if(args[i].matches("[a-zA-Z]")){
                myAlphabet[i-2] = args[i].toCharArray()[0];
            }else{
                System.out.println("Invalid arguments, try again");
                System.exit(-1);
            }
        }
        System.out.println(Arrays.toString(myAlphabet));

        //Word generator
        for(int i=0; i<n; i++){
            words[i] = new String();
            words[i] = randWord(p, args.length-2, myAlphabet);
            System.out.println(words[i]);
        }

        //n x n adjacency matrix
        boolean[][] M = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isNeighbour(words[i], words[j])==true){
                    M[i][j]=true;
                }else{
                    M[i][j]=false;
                }
                if(i==j){
                    M[i][j] = false;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

        /*for(int i=0;i<= words.length;i++){
            wordNeighbours orderedWord = new wordNeighbours(words,M,i);
            System.out.println(orderedWord.getWord() + " has the following neighbours: " + orderedWord.getNeighbours());
        }*/

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Time in nanoseconds: " + totalTime);
    }
}