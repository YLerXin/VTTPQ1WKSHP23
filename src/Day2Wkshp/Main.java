package Day2Wkshp;

public class Main {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("Jim");

        System.out.println("Account Holder: " + a.getMember().getName());
        System.out.println("Account Number: " + a.getMember().getAccountno());
        System.out.println("Initial Balance: $" + a.getBalance());
        
        System.out.println("\nDepositing $100...");
        a.deposit(100);
        System.out.println("New Balance: $" + a.getBalance());
        System.out.println("Transactions: " + a.getTransaction());

        System.out.println("\nWithdrawing $50...");
        a.withdraw(50);
        System.out.println("New Balance: $" + a.getBalance());
        System.out.println("Transactions: " + a.getTransaction());

        try {
            System.out.println("\nWithdrawing $100 (should fail)...");
            a.withdraw(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinal Balance: $" + a.getBalance());
        System.out.println("Transactions: " + a.getTransaction());
    }
    
}
