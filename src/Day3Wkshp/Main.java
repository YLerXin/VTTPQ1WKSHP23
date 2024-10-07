package Day3Wkshp;

import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;


public class Main {

    private static List<User> Users = new ArrayList<>();
    private static User currentUser = null;
    private static String directory = "db";

    public static void login(String userName) throws IOException{
        for (User user : Users) {
            if (user.getName().equalsIgnoreCase(userName)) {
                currentUser = user;
                displayCartContents();
                return; // Exit the method after finding the user
            }
        }
        currentUser = new User(userName);
        Users.add(currentUser);
        ShoppingCartDB dbcart = new ShoppingCartDB(directory);
        dbcart.loadCart(currentUser); 

        System.out.printf("%s has been added. Your cart is empty.%n", userName);
    }
    private static void displayCartContents() {
        if (currentUser.getCart().isEmpty()) {
            System.out.printf("%s, your cart is empty.%n", currentUser.getName());
        } else {
            System.out.printf("%s, your cart contains the following items:%n", currentUser.getName());
            currentUser.getCart().listItems();
        }
    }

    public static void listUsers(){
        System.out.println("The following users are registered:");
        for (int i = 0; i < Users.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, Users.get(i).getName());
        } 
    }

    public static void main(String[] args)throws IOException {

        if (args.length >0){
            directory = args[0];
        }
        Path dirPath = Paths.get(directory);
        if (!Files.exists(dirPath)){
            try{
                Files.createDirectories(dirPath);

            }catch (IOException e){
                System.err.println("Error creating directory: " + directory);
                return;  
            }
        }



        Console cons = System.console();

        String command;//input of the console

        System.out.println("Welcome to your shopping cart");

        while (true) {
            command = cons.readLine("> ").trim();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            String[] parts = command.split(" ", 2);
            String action = parts[0];

            switch (action.toLowerCase()){
                case "login":
                if (parts.length > 1) {
                    login(parts[1]);
                } else {
                    cons.printf("Please specify a username to login.%n");
                }
                break;
                case "users":
                    listUsers();
                break;
                
                case "save":
                    if (currentUser != null) {
                        ShoppingCartDB dbcart = new ShoppingCartDB(directory);
                         dbcart.saveCart(currentUser);
                        cons.printf("Your cart has been saved.%n");
                    } else {
                        cons.printf("You need to log in first.%n");
                    }
                    break;


                case "list":
                    if (currentUser != null) {
                        currentUser.getCart().listItems();
                    } else {
                        cons.printf("You need to log in first.%n");
                    }
                    break;

                case "add":
                    if (currentUser != null) {
                        if (parts.length > 1) {
                            currentUser.getCart().addItem(parts[1]);
                        } else {
                            cons.printf("Please specify items to add.%n");
                        }
                    } else {
                        cons.printf("You need to log in first.%n");
                    }
                    break;

                case "delete":
                    if (currentUser != null) {
                        if (parts.length > 1) {
                            try {
                                int index = Integer.parseInt(parts[1]);
                                currentUser.getCart().deleteItem(index);
                            } catch (NumberFormatException e) {
                                cons.printf("Please provide a valid item index.%n");
                            }
                        } else {
                            cons.printf("Please specify an item index to delete.%n");
                        }
                    } else {
                        cons.printf("You need to log in first.%n");
                    }
                    break;

                default:
                    cons.printf("Unknown command. Please use 'list', 'add', or 'delete'.%n");
                    break;
            }
        }
    }
}
