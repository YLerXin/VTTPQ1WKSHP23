package Day2Wkshp;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public class BankAccount {
    
    private float balance;
    private List<String> transaction;
    private boolean status;
    private String creationdate;
    private String closingdate;
    private Members member;

    public BankAccount(String name){
        this.member = new Members(name);
        this.transaction = new ArrayList<>();
        this.balance = 0;
        this.status = true;
        Date date = new Date();
        this.creationdate = date.toString();
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getClosingdate() {
        return closingdate;
    }

    public void setClosingdate(String closingdate) {
        this.closingdate = closingdate;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    public BankAccount(String name,float balance){
        this.member = new Members(name);
        this.transaction = new ArrayList<>();
        this.balance = balance;
        this.status = true;
        Date date = new Date();
        this.creationdate = date.toString();
    }

    public void deposit(int amount){
        if (amount <=0){
            throw new IllegalArgumentException();
        }
        else if(status == false){
            throw new IllegalArgumentException();
        }
        else{
            balance += amount;
            Date transactiondate = new Date();
            String Stdate = transactiondate.toString();
            transaction.add("deposit $"+amount + " at "+Stdate);
        }
    }
    public void withdraw(int amount){
        if (amount <=0){
            throw new IllegalArgumentException();
        }
        else if(status == false){
            throw new IllegalArgumentException();
        }
        else{
            balance -= amount;
            Date transactiondate = new Date();
            String Stdate = transactiondate.toString();
            transaction.add("deposit $"+amount + " at "+Stdate);
        }
    }
}
