package com.company;

/*
Для простоти перевірки у методах CreateServers()(Cluster), CreateNodes()(Server), SendMessage()(Cluster), search()(FailSearchEngine)
лежать закоментовані прінти.
Exceptions використані в методах search() та searchNode() класу FailSearchEngine
 */

public class Main {

    public static void main(String[] args) {
        Cluster cluster = new Cluster();
        FailSearchEngine failSearchEngine = new FailSearchEngine(cluster);
        failSearchEngine.search();
    }
}
