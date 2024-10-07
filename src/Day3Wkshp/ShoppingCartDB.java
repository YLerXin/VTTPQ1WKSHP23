package Day3Wkshp;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDB {

    private File dbDirectory;

    public ShoppingCartDB(String directory){
        dbDirectory = new File(directory);
        if (!dbDirectory.exists()){
            dbDirectory.mkdir();
        }
    }
    public void saveCart(User user) throws IOException {
        File cartFile = new File(dbDirectory, user.getName() + "_cart.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cartFile))) {
            List<String> items = user.getCart().getCartItems();
            for (String item : items) {
                writer.write(item);
                writer.newLine(); // Write each item on a new line
            }
        }
    }
    public void loadCart(User user) throws IOException {
        File cartFile = new File(dbDirectory, user.getName() + "_cart.txt");
        if (!cartFile.exists()) {
            System.out.printf("No saved cart found for %s.%n", user.getName());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(cartFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Use addItem to add each item from the file
                user.getCart().addItem(line);
            }
        }
    }
}
