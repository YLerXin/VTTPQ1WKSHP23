package Day2Wkshp;

public class MainFD {
    public static void main(String[] args) {
        // Create a Fixed Deposit Account
        FixedDAccount fda = new FixedDAccount("Alice", 1000.0f);
        
        // Print initial account details
        System.out.println("Account Holder: " + fda.getMember().getName());
        System.out.println("Account Number: " + fda.getMember().getAccountno());
        System.out.println("Initial Balance: $" + fda.getBalance());
        
        // Test setting interest
        System.out.println("\nSetting interest to 4%...");
        fda.setInterest(4.0f);
        System.out.println("New Balance (with interest): $" + fda.getBalance());
        
        // Attempting to set interest again
        try {
            fda.setInterest(5.0f);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test deposit and withdrawal
        System.out.println("\nAttempting to deposit $100...");
        fda.deposit(100);
        System.out.println("Transactions: " + fda.getTransactions());

        System.out.println("\nAttempting to withdraw $50...");
        fda.withdraw(50);
        System.out.println("Transactions: " + fda.getTransactions());

        // Print final details
        System.out.println("\nFinal Balance (with interest): $" + fda.getBalance());
    }
}
