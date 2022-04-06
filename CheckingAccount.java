import java.util.Scanner;

public class CheckingAccount extends Account {
	
	public void makeWithdrawal()
	{
		int amnt;
		System.out.println("Enter amount to withdraw from account.");
		Scanner inObj = new Scanner(System.in);
		amnt=inObj.nextInt();
		
		if(amnt > balance+5000 || amnt <0)
		{
			System.out.println("Error! Insufficient funds to perform transaction.");
		}
		else if (amnt >0 && amnt <= balance+5000)
		{
			balance=amnt-balance;
			System.out.println("Transaction complete!");
			System.out.println("New balance is : "+balance);
		}
	}
	public void makeWithdrawal(int amnt)
	{
		if(amnt > balance+5000 || amnt <0)
		{
			System.out.println("Error! Insufficient funds to perform transaction.");
		}
		else if (amnt >0 && amnt <= balance+5000)
		{
			balance=amnt-balance;
			System.out.println("Transaction complete!");
			System.out.println("New balance is : "+balance);
		}
	}

}
