package com.company;

import java.util.NoSuchElementException;

public class FailSearchEngine {

    private Cluster cluster;

    public FailSearchEngine(Cluster cluster){
        this.cluster = cluster;
    }

    public void search(){
        int firstIndex = 0;
        int lastIndex = cluster.servers.size()-1;

        while(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;

            if(cluster.isFailed(middleIndex, cluster.servers.get(middleIndex).getElement().getAmountNode()-1)){
                try {
                    if (!(cluster.isFailed(middleIndex - 1, cluster.servers.get(middleIndex - 1).getElement().getAmountNode() - 1))) {
                        searchNode(middleIndex);
                        return;
                    } else {
                        lastIndex = middleIndex - 1;

                    }
                }catch (IndexOutOfBoundsException e){
                    searchNode(0);
                    return;
                }
            }else{
                firstIndex = middleIndex + 1;
            }

        }
    }


    public void searchNode(int server) {

            for (int i = 0; i < cluster.servers.get(server).getElement().getAmountNode(); i++) {
                if (cluster.isFailed(server, i) == true) {
                    System.out.println("First broken server is " + server + " on Node " + i);
                    return;
                }
            }

    }
}
