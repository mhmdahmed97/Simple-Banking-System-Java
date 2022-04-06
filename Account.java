import java.util.Scanner;
public class Account {

    private long accNumber;
    protected double balance;
    protected Date createDate;
    //private String accType;

    //// constructor start
    public Account() {
        accNumber = 0;
        balance = 0;
        createDate = new Date();
       // accType = "\0";
    }
    //// constructor end

    
    
    public void setAccNumber(long accN)
    {
    	accNumber=accN;
    }
    
    public long getAccNumber()
    {
    	return this.accNumber;
    }
    

    public double CheckBalance() {
        System.out.println("Account number: " + accNumber + "\n");
        System.out.println("Balance: " + balance + "\n");

        return balance;
    }

    public void makeDeposit(int amnt) {
        balance += amnt;
        System.out.println("Amount deposited: " + amnt);
        System.out.println("New balance: " + balance);
    }
    public int getDateDay()
    {
    	return createDate.getDay();
    }
    public int getDateMonth()
    {
    	return createDate.getMonth();
    }
    public int getDateYear()
    {
    	return createDate.getYear();
    }


    public void displayCreateDate() {
        createDate.DisplayDate();
    }

}
