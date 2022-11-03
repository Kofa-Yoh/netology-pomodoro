package com.kotkina;

import java.util.Scanner;

public class PomodorTimer {
    public static void main(String[] args) {
        System.out.println("Введите время работы и отдыха");
        var cmd = new Scanner(System.in).nextLine().split(" ");

        int workTime = 1;
        int breakTime = 1;
        boolean isHelp = false;

        for (int i = 0; i < cmd.length; i++){
            switch(cmd[i]){
                case "-w" -> workTime = Integer.parseInt(cmd[++i]);
                case "-b" -> breakTime = Integer.parseInt(cmd[++i]);
                case "--help" -> {
                    System.out.println("-w время работы\n" +
                        "-b время отдыха");
                    isHelp = true;}
            }
        }

        if (isHelp) return;

        System.out.println("workTime = " + workTime + " breakTime = " + breakTime);
    }
}
