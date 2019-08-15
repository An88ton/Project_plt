package com.company;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Scanner;

public class Gamer {
    private String name;
    private int skill;
    private int age;
    Scanner scanner;

    public Gamer(){
        scanner  = new Scanner(System.in);
        System.out.println("Print name: ");
        name = scanner.nextLine();
        System.out.println("Print skill: ");
        skill = scanner.nextInt();
        System.out.println("Print age: ");
        age = scanner.nextInt();
        scanner.close();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toJSON(){
        try {
            return new ObjectMapper().writeValueAsString(this);
        }catch(IOException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return "";
    }
}
