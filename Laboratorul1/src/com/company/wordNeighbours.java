package com.company;

public class wordNeighbours {
    public wordNeighbours(String words[], boolean M[][], int index) {
        int aux = 0;
        this.word = words[index];
        for(int i=0;i<=words.length;i++){
            if(M[index][i]==true) {
                setNeighbour(words[i],aux);
                aux++;
            }
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    String word;

    public String[] getNeighbours() {
        return neighbours;
    }

    public void setNeighbour(String neighbour, int index) {
        this.neighbours[index] = neighbour;
    }

    String[] neighbours;

}