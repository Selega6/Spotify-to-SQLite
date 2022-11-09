package es.ulpgc.spotify.downloader;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static es.ulpgc.spotify.downloader.Controller.singers;

public class Main {
    public static void main(String[] args) throws Exception {
        String userInput;
        Scanner sn = new Scanner(System.in);
        Controller controller = new Controller();
        while (true) {
            System.out.println("Press 1 to Introduce an artist id from spotify");
            System.out.println("Press 2 to run the code without adding more artists");
            System.out.println("Press 3 to drop tables");
            userInput = sn.next();
            switch (userInput) {
                case "1":
                    System.out.println("adding");
                    String input = sn.next();
                    List<String> inputs = Arrays.asList(input.split("\\s*,\\s*"));
                    singers.addAll(inputs);
                    System.out.println("executing");
                    controller.controller();
                    System.out.println("finished");
                    System.exit(0);
                    break;
                case "2":
                    System.out.println("executing");
                    controller.controller();
                    System.out.println("finished");
                    System.exit(0);
                    break;
                case "3":
                    System.out.println("eliminating tables");
                    controller.dropTables();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please execute again.");
                    System.exit(0);
            }
        }
    }
}

