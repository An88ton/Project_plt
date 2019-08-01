package com.company;

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

            if(cluster.isFailed(middleIndex, cluster.servers.get(middleIndex).getAmountNode()-1)){
                try {
                    if (!(cluster.isFailed(middleIndex - 1, cluster.servers.get(middleIndex - 1).getAmountNode() - 1))) {
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
        try {
            if(cluster.servers.get(server).getAmountNode() == 0){throw new NullNodeException();}
        for (int i = 0; i < cluster.servers.get(server).getAmountNode(); i++) {
            if (cluster.isFailed(server, i) == true) {
                System.out.println("First broken server is " + server + " on Node " + i);
                return;
            }
        }
    }catch (NullNodeException e){
            System.out.println(e.getMessage());
        }
    }
}
