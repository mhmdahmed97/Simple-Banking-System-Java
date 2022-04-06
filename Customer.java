import java.util.Scanner;

public class Customer {

    private String fName;
    private String lName;
    private int idNumber;
    private String address;
    private String phoneNum;
    private long checkingAccNum;
    private long savingsAccNum;

    // Constructors

    public Customer() {
        fName = "\0";
        lName = "\0";
        idNumber=0;
        address = "\0";
        phoneNum = "\0";
        checkingAccNum = 0;
        savingsAccNum=0;
    }

    public Customer(String fn, String ln,int idNumber, String addr, String pNum) {
        fName = fn;
        lName = ln;
        address = addr;
        phoneNum = pNum;
    }

    // Getters
    public String getFname() {
        return fName;
    }

    public String getLname() {
        return lName;
    }
    
    public int getIdNumber() {
    	return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public long getCheckingAccNum() {
        return checkingAccNum;
    }
    
    public long getSavingsAccNum() {
        return savingsAccNum;
    }

    // Setters
    public void setFname(String fn) {
        fName = fn;
    }

    public void setLname(String ln) {
        lName = ln;
    }
    
    public void setIdNumber(int idN)
    {
    	idNumber=idN;
    }

    public void setAddress(String addr) {
        address = addr;
    }

    public void setPhoneNum(String pNum) {
        phoneNum = pNum;
    }

    public void setCheckingAccNum(long aNum) {
        checkingAccNum = aNum;
    }
    
    public void setSavingsAccNum(long aNum2) {
        savingsAccNum = aNum2;
    }
    
    //methods
    public void displayCustomerDetails()
    {
    	System.out.println("Name :"+this.fName+" "+this.lName);
    	System.out.println("Id Number : "+this.idNumber);
    	System.out.println("Address : "+this.address);
    	System.out.println("Phone Number : "+this.phoneNum);
    	System.out.println("Checking Account Number : "+this.checkingAccNum);
    	System.out.println("Savings Account Number : "+this.savingsAccNum);
    }
    
    public void enterCustomerDetails()
    {
    	Scanner inObj = new Scanner(System.in); 
        System.out.println("Enter first name of customer : ");
        this.fName=inObj.nextLine(); 
        
        Scanner inObj2 = new Scanner(System.in); 
        System.out.println("Enter last name of customer : ");
        this.lName=inObj2.nextLine();

        Scanner inObj5 = new Scanner(System.in); 
        System.out.println("Enter ID number of customer : ");
        this.idNumber=inObj5.nextInt();
        
        Scanner inObj3 = new Scanner(System.in); 
        System.out.println("Enter address of customer : ");
        this.address=inObj3.nextLine(); 
        
        Scanner inObj4 = new Scanner(System.in); 
        System.out.println("Enter phone number of customer : ");
        this.phoneNum =inObj4.nextLine();
        
        // closing inObj that was used for input
       /* inObj.close();
        inObj2.close();
        inObj3.close();
        inObj4.close();*/
    }
}
