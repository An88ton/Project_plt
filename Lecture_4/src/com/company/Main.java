package com.company;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choise item: "+ '\n' + "1.Serialize object; " + '\n' + "2.Deseriaize object");
        int choise = scanner.nextInt();
        switch (choise){
            case 1:
                serializeByJackson(new Gamer());
                break;
            case 2:
                deserializeByJackson();
                break;
        }
    }


    public static void serializeByJackson(Gamer gamer){
        ObjectMapper obMap = new ObjectMapper();
        try {
            obMap.writeValue(new FileOutputStream("ExampleJson.json"), gamer);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Gamer deserializeByJackson(){
        ObjectMapper obMap = new ObjectMapper();
        try {
            return obMap.readValue("ExampleJson.json", Gamer.class);
        }catch (IOException e){
            e.getMessage();
        }
        return new Gamer();
    }
}
