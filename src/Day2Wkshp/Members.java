package Day2Wkshp;

import java.util.Random;

public class Members {

    private final String name;
    private String accountno;

    public Members(String name){
        this.name = name;
        genaccount();
    }

    public void genaccount(){
        Random rand = new Random();
        accountno = String.format("%08d",rand.nextInt(99999999));
    }

    public String getName() {
        return name;
    }

    public String getAccountno() {
        return accountno;
    }


}
