import java.time.LocalDate;
import java.util.Scanner;
public class SavingsAccount extends Account {
	private Date lastZakatDate;
	private double zakat;

	public SavingsAccount() {
		lastZakatDate= new Date();
		zakat=0;
	}
	
	public double getZakat()
	{
		if (this.zakat==0)
		{
			double zakatN=this.calculateZakat();
			return zakatN;
		}
		else
		{
			return zakat;
		}
	}
	public double calculateZakat()
	{
		if (balance<20000)
		{
			System.out.println("Not enough funds to calculate Zakat.");
			return 0;
		}
		else if (balance>=20000)
		{
			LocalDate currdate = LocalDate.now();
			if(lastZakatDate.getDay()==currdate.getDayOfMonth() && lastZakatDate.getMonth()==currdate.getMonthValue())
			{
				if((currdate.getYear()-lastZakatDate.getYear())==1)
				{
					//recalculating zakat
					double zakatN=(balance*2.5)/100;
					return zakatN;
				}
				else
				{
					System.out.println("Annual zakat time has not arrived");
					return 0.0;
				}
			}
			else
				return 0.0;
		}
		return 0;
		
	}
	public void makeWithdrawal()
	{
		int amnt;
		System.out.println("Enter amount to withdraw from account.");
		Scanner inObj = new Scanner(System.in);
		amnt=inObj.nextInt();
		if (amnt<=balance)
		{
			balance=balance-amnt;
			System.out.println("Transaction complete!");
			System.out.println("New balance : "+balance);
		}
		else if (amnt>balance)
		{
			System.out.println("Insufficient funds for transaction! Try again.");
		}
	}
	public void makeWithdrawal(int amnt)
	{
		if (amnt<=balance)
		{
			balance=balance-amnt;
			System.out.println("Transaction complete!");
			System.out.println("New balance : "+balance);
		}
		else if (amnt>balance)
		{
			System.out.println("Insufficient funds for transaction! Try again.");
		}
	}
}
