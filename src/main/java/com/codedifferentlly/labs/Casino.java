package com.codedifferentlly.labs;

import com.codedifferentlly.labs.games.GoFish;
import com.codedifferentlly.labs.players.CardPlayer;


import java.util.Scanner;

public class Casino {

    private void displayMenu() {
        System.out.println("====================================");
        System.out.println("  WELCOME TO THE CASINO APP");
        System.out.println("====================================");
        System.out.println("1. Go Fish");
        System.out.println("0. Exit");
        System.out.println();
    }

    private void goFish() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nYou selected Go Fish!");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        CardPlayer player = new CardPlayer(name);
        new GoFish(player).play(player);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    goFish();
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Casino app = new Casino();
        app.start();
    }
}
