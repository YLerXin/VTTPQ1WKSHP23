package Day3Wkshp;

public class User {
    private String name;
    private ShoppingCart cart;
    
    public User(String name){
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public String getName() {
        return name;
    }
    public ShoppingCart getCart() {
        return cart;
    }

}
