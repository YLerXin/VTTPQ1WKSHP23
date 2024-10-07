package Day3Wkshp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void listItems() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i));
            }
        }
    }

    public void addItem(String items) {
        String[] newItems = items.split(",\\s*");
        for (String item : newItems) {
            if (!cart.contains(item)) {
                cart.add(item);
                System.out.println(item + " added to cart.");
            } else {
                System.out.println("You have " + item + " in your cart.");
            }
        }
    }

    public void deleteItem(int index) {
        if (index < 1 || index > cart.size()) {
            System.out.println("Incorrect item index.");
        } else {
            String removedItem = cart.remove(index - 1);
            System.out.println(removedItem + " removed from cart.");
        }
    }
    public boolean isEmpty(){
        return cart.isEmpty();
    }
    public List<String> getCartItems(){
        return cart;
    }


}