package com.company;

public class FailSearchEngine {

    private Cluster cluster;

    public FailSearchEngine(Cluster cluster){
        this.cluster = cluster;
    }

    public void search(){
        int firstIndex = 0;
        int lastIndex = cluster.servers.size()-1;
        //int middleIndex;

        while(firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;

            if(cluster.isFailed(middleIndex, cluster.servers.get(middleIndex).getAmountNode()-1) == true){
                if(middleIndex == 0){
                        for(int i = 0; i < cluster.servers.get(middleIndex).getAmountNode(); i++){
                            if(cluster.isFailed(middleIndex, i) == true){
                                System.out.println("First broken server is " + middleIndex + " on Node " + i);
                                return;
                            }
                        }
                }
                if(cluster.isFailed(middleIndex-1, cluster.servers.get(middleIndex-1).getAmountNode()-1) == false){
                    for(int i = 0; i < cluster.servers.get(middleIndex).getAmountNode(); i++){
                        if(cluster.isFailed(middleIndex, i) == true){
                            System.out.println("First broken server is " + middleIndex + " on Node " + i);
                            return;
                        }
                    }
                }else{
                    lastIndex = middleIndex -1;

                }
            }else{
                firstIndex = middleIndex + 1;
            }

        }
    }
}
