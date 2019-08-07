package com.company;

public class Node implements Failable {

    int number;
    private boolean isFailed;

    public Node(int number) {
        this.number = number;
        isFailed = false;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFailed() {
        return isFailed;
    }

    public void setFailed() {
        isFailed = true;
    }
}
