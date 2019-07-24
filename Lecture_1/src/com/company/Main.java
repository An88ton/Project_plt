package com.company;

/*
Для простоти перевірки у методах CreateServers()(Cluster), CreateNodes()(Server), SendMessage()(Cluster), search()(FailSearchEngine)
лежать закоментовані прінти.
 */

public class Main {

    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        FailSearchEngine failSearchEngine = new FailSearchEngine(cluster);
        failSearchEngine.search();
    }
}
