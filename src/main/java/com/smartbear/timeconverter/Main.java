package com.smartbear.timeconverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in HH:mm format: ");
        String inputTime = scanner.nextLine();

        try {
            BritishTimeConverter btc=new BritishTimeConverter();
            String spoken = btc.toSpokenForm(inputTime);
            System.out.println("Spoken form: " + spoken);
        } catch (Exception e) {
            System.out.println("Invalid time format.");
        }
    }
}
