package com.company;

import java.util.ArrayList;


public class Server implements Failable {

    private ArrayList <Optional<Node>> nodes;

    private int number;
    private boolean isFailed = false;

    public Server(int number) {
        this.number = number;
    }

    public ArrayList<Optional<Node>> getNodes() {
        return nodes;
    }

    public void createNodes() {
        nodes = new ArrayList<>();
        int amountNode = (int) ((Math.random() * (6 - 1)) + 1);
        //System.out.println("    amount nodes: " + amount);
        do{
        for (int i = 0; i < amountNode; i++) {
            Optional<Node> node = new Optional<>(new Node(i));
            if (node.isPresent())
                nodes.add(node);
            //  System.out.println("    Node "+ i);
        }
    }while(nodes.size() == 0);
    }

    public int getAmountNode() {
        return nodes.size();
    }

    public boolean isFailed() {
        return isFailed;
    }

    public void setFailed() {
        isFailed = true;
    }

}
