package Day2Wkshp;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class FixedDAccount {
    
    private float balance;
    private List<String> transaction;
    private boolean status;
    private String creationdate;
    private String closingdate;
    private Members member;
    private float interest;
    private int duration;
    private boolean interestChanged;
    private boolean durationChanged;


    public FixedDAccount(String name, Float balance){
        this.member = new Members(name);
        this.transaction = new ArrayList<>();
        this.balance = balance;
        this.status = true;
        this.creationdate = new Date().toString();
        this.interest =3.0f;
        this.duration = 6;
        this.interestChanged = false;
        this.durationChanged = false;
    }
    public Members getMember() {
        return member;
    }

    public List<String> getTransactions() {
        return transaction;
    }

    public float getBalance() {
        return balance + (balance * interest / 100);
    }
    public void setInterest(float interest) {
        if (interestChanged) {
            throw new IllegalArgumentException("Interest can only be changed once.");
        }
        this.interest = interest;
        this.interestChanged = true;
    }
    public void setDuration(int duration) {
        if (durationChanged) {
            throw new IllegalArgumentException("Duration can only be changed once.");
        }
        this.duration = duration;
        this.durationChanged = true;
    }
    public void deposit(int amount) {
        transaction.add("Attempted deposit of $" + amount + " (NOP)");
    }

    public void withdraw(int amount) {
        transaction.add("Attempted withdrawal of $" + amount + " (NOP)");
    }

    public boolean isActive() {
        return status;
    }
}