package com.kotkina;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PomodorTimer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Введите время работы и отдыха");
        var cmd = new Scanner(System.in).nextLine().split(" ");

        int workTime = 1;
        int breakTime = 1;
        int count = 1;
        int increase = 5;
        boolean isHelp = false;

        for (int i = 0; i < cmd.length; i++){
            switch(cmd[i]){
                case "-w" -> workTime = Integer.parseInt(cmd[++i]);
                case "-b" -> breakTime = Integer.parseInt(cmd[++i]);
                case "-c" -> count = Integer.parseInt(cmd[++i]);
                case "-i" -> increase = Integer.parseInt(cmd[++i]);
                case "--help" -> {
                    System.out.println("-w время работы\n" +
                        "-b время отдыха\n" +
                        "-c кол-во итераций\n" +
                        "-i увеличение отдыха каждую итерацию");
                    isHelp = true;}
            }
        }

        if (isHelp) return;

        long startTime = System.currentTimeMillis();
        timer(workTime, breakTime, count, increase);
        long endTime = System.currentTimeMillis();
        System.out.println("Таймер работал: " + (endTime - startTime)/(1000*60) + " мин.");
    }
    public static void timer(int workTime, int breakTime, int count, int increase) throws InterruptedException {
        for (int i = 0; i < count; i++){
            printProgress("Work time: ", workTime + (increase * i), 30);
            printProgress("Break time: ", breakTime, 30);
        }
    }
    private static void printProgress(String process, int time, int size) throws InterruptedException {
        int length;
        int rep;
        length = 60 * time / size;
        rep = 60 * time /length;
        int stretchb = size /(3 * time);
        for(int i=1; i <= rep; i++){
            double x = i;
            x = 1.0/3.0 * x;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            double w = time * stretchb;
            double percent = (x/w) *1000;
            x /=stretchb;
            x *= 10;
            x = Math.round(x);
            x /= 10;
            percent = Math.round(percent);
            percent /= 10;
            System.out.print(process + percent+"% " + (" ").repeat(5 - (String.valueOf(percent).length())) +"[" + ("#").repeat(i) + ("-").repeat(rep - i)+"]    ( " + x +"min / " + time +"min )"+  "\r");
            if(true){
                TimeUnit.SECONDS.sleep(length);
            }
        }
        System.out.println();
    }
}
