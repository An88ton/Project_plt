package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Cluster {

    ArrayList<Optional<Server>> servers;
    int amountServers;

    public Cluster() {
        servers = new ArrayList<>();
        amountServers = (int) ((Math.random()* (21-2))+2);
        createServers(amountServers);
        sendMessage();

    }

    public void createServers(int amount){

       System.out.println("servers: " + amount);

        for(int i = 0; i < amount; i++){
            Optional <Server> server = new Optional<>(new Server(i));
         //   System.out.println("Server " + i);
            if(server.isPresent()) {
                server.getElement().createNodes();
                while (server.getElement().getNodes().size() == 0){
                    server.getElement().createNodes();
                }
                servers.add(server);
            }

        }
    }


    public void sendMessage(){
        int choosen = (int) (Math.random() * servers.size());

        int amountNode;

        amountNode = servers.get(choosen).getElement().getAmountNode();
        System.out.println("Broken server: " + choosen);
        for(int i =(int)(Math.random() * amountNode); i < amountNode; i++){
            if(servers.get(choosen).getElement().getNodes().get(i).isPresent()){
            servers.get(choosen).getElement().getNodes().get(i).getElement().setFailed();}

            System.out.println(" Node: " + i + " broken ");
        }

        for(int i = ++choosen; i < servers.size(); i++){
            //amountNode = servers.get(i).getElement().getAmountNode();
            try{
                failNodes(i, servers.get(i).getElement().getAmountNode());
                servers.get(i).getElement().setFailed();
            }catch (NoSuchElementException e){
                System.out.println("  Server № " + i + "doesn't exist");
            }
        }
    }
    public void failNodes(int numServer, int amountNode){

        for(int i = 0; i < amountNode; i++){
            try {
                servers.get(numServer).getElement().getNodes().get(i).getElement().setFailed();
            }catch (NoSuchElementException e){
                System.out.println("    Node № " + i + " on server № " + numServer + " doesn't exist");
            }

            System.out.println("Server " + numServer + " broken: " );
        }
    }

    public boolean isFailed(int numServer, int numNode){
        return servers.get(numServer).getElement().getNodes().get(numNode).getElement().isFailed();

    }


}
