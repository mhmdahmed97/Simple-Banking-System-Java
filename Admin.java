import java.util.Scanner;

public class Admin extends Bank {
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void openAccount()
	{
		Customer tempObj= new Customer();
		String accType;
		tempObj.enterCustomerDetails();
		
		/*Scanner inObjType = new Scanner(System.in); 
        System.out.println("Enter type of account you want to open (savings/checking) : ");
        String accType2=inObjType.nextLine();
		if (accType2=="s")
			accType="savings";
		else if (accType2=="c")
			accType="checking";*/
        accType="checking";

        if(customerArray.size()==0) //if condition for when no customer or accounts exist
		{
			if(accType=="checking")
			{
				tempObj.setCheckingAccNum(100001);
				CheckingAccount tempoObj=new CheckingAccount();
				tempoObj.setAccNumber(100001);
				CheckingAccountArray.add(tempoObj);
				customerArray.add(tempObj);
			}
			else if (accType=="savings")
			{
				tempObj.setSavingsAccNum(600001);
				SavingsAccount tempoSobj = new SavingsAccount();
				tempoSobj.setAccNumber(600001);
				SavingsAccountArray.add(tempoSobj);
				customerArray.add(tempObj);
			}
		}
		else if (customerArray.size()!=0)
		{
			int trackIndex=0;
			boolean duplicateChecker=false;
			for (int i=0;i<customerArray.size();i++)
			{
				if (tempObj.getIdNumber()==customerArray.get(i).getIdNumber())
				{
					trackIndex=i;
					duplicateChecker=true;
					break;
				}
			}
			if (duplicateChecker==true)
			{
				if(accType=="checking" && customerArray.get(trackIndex).getCheckingAccNum()!=0)
				{
					System.out.println("Checking account for this customer already exists");
				}
				else if (accType=="savings" && customerArray.get(trackIndex).getSavingsAccNum()!=0)
				{
					System.out.println("Savings account for this customer already exists!");
				}
				else if (accType=="checking" && customerArray.get(trackIndex).getCheckingAccNum()==0)
				{
					if (CheckingAccountArray.size()==0)
					{
						customerArray.get(trackIndex).setCheckingAccNum(10001);
						CheckingAccount tempoObj= new CheckingAccount();
						tempoObj.setAccNumber(100001);
						CheckingAccountArray.add(tempoObj);
						
					}
					else if (CheckingAccountArray.size()!=0)
					{
						int lastIndex=CheckingAccountArray.size()-1;
						
						long tempAccNum = CheckingAccountArray.get(lastIndex).getAccNumber();
						//adding new checking account number below
						
						tempObj.setCheckingAccNum(++tempAccNum);
						CheckingAccount tempoObj = new CheckingAccount();
						tempoObj.setAccNumber(++tempAccNum);
						CheckingAccountArray.add(tempoObj);
						customerArray.get(trackIndex).setCheckingAccNum(++tempAccNum);
					}
				}
				else if (accType=="savings" && customerArray.get(trackIndex).getSavingsAccNum()==0)
				{
					if(SavingsAccountArray.size()==0)
					{
						customerArray.get(trackIndex).setSavingsAccNum(6001);
						SavingsAccount tempoObjS= new SavingsAccount();
						tempoObjS.setAccNumber(6001);
						SavingsAccountArray.add(tempoObjS);
					}
					else if (SavingsAccountArray.size()!=0)
					{
						int lastIndex=SavingsAccountArray.size()-1;
						
						long tempAccNum = SavingsAccountArray.get(lastIndex).getAccNumber();
						//adding new checking account number below
						
						tempObj.setSavingsAccNum(++tempAccNum);
						SavingsAccount tempoObjS = new SavingsAccount();
						tempoObjS.setAccNumber(++tempAccNum);
						SavingsAccountArray.add(tempoObjS);
						customerArray.get(trackIndex).setSavingsAccNum(++tempAccNum);
					}
				}
			}
			else if (duplicateChecker==false)
			{
				System.out.println("Entered false pretenses idiots");
			}
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void displayCustomerDetails() {
		for (int i=0;i<customerArray.size();i++)
		{
			customerArray.get(i).displayCustomerDetails();
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void closeAccount() {
		long tempAccNum;
		System.out.println("Enter Account number you want to delete : ");
		Scanner accObj= new Scanner (System.in);
		tempAccNum= accObj.nextLong();
		
		boolean checkingVar=false, savingsVar=false;
		int accLocation = 0;
		for(int i=0;i<CheckingAccountArray.size();i++)
		{
			if(CheckingAccountArray.get(i).getAccNumber()== tempAccNum)
			{
				checkingVar=true;
				accLocation=i;
				break;
			}
		}
		if (checkingVar==false)
		{
			for(int i=0;i<SavingsAccountArray.size();i++)
			{
				if(SavingsAccountArray.get(i).getAccNumber()== tempAccNum)
				{
					savingsVar=true;
					accLocation=i;
					break;
				}
			}
		}
		
		if(checkingVar==false && savingsVar==false)
		{
			System.out.println("Account to be deleted does not exist! Invalid Account number.");
			return;
		}
		else if (checkingVar==true)
		{
			int customerIndex=0;
			for (int i=0;i<customerArray.size();i++)
			{
				if(customerArray.get(i).getCheckingAccNum()== tempAccNum)
				{
					customerIndex=i;
					break;
				}
			}
			CheckingAccountArray.remove(accLocation);
			customerArray.remove(customerIndex);
			System.out.println("Account removed successfully!");
		}
		else if (savingsVar==true)
		{
			int customerIndex=0;
			for(int i=0;i<customerArray.size();i++)
			{
				if(customerArray.get(i).getSavingsAccNum()==tempAccNum)
				{
					customerIndex=i;
					break;
				}
			}
			SavingsAccountArray.remove(accLocation);
			customerArray.remove(customerIndex);
			System.out.println("Account removed successfully!");
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void transferAmount()
	{
		int amount;
		System.out.println("Enter Amount to transfer");
		Scanner amntObj=new Scanner (System.in);
		amount=amntObj.nextInt();
		
		boolean checkingSender=false;
		boolean savingsSender=false;
		long senderAccNum;
		int senderIndex = 0;
		System.out.println("Enter account number you want to transfer money from : ");
		Scanner inObj2 = new Scanner (System.in);
		senderAccNum=inObj2.nextLong();
		
		//checking type of account
		for (int i=0;i< CheckingAccountArray.size();i++)
		{
			if (senderAccNum==CheckingAccountArray.get(i).getAccNumber())
			{
				checkingSender=true;
				senderIndex=i;
				break;
			}
		}
		for(int i=0;i< SavingsAccountArray.size();i++)
		{
			if (senderAccNum== SavingsAccountArray.get(i).getAccNumber())
			{
				savingsSender=true;
				senderIndex=i;
				break;
			}
		}
		
		if(checkingSender==false && savingsSender==false)
		{
			System.out.println("Sending Account number does not exist");
			return;
		}
		
		
		
		boolean checkingAccounter=false;
		boolean savingsAccounter=false;
		long recAccNum;
		int recIndex = 0;
		System.out.println("Enter account number you want to transfer money to : ");
		Scanner inObj = new Scanner (System.in);
		recAccNum=inObj.nextLong();
		
		for (int i=0;i< CheckingAccountArray.size();i++)
		{
			if (recAccNum==CheckingAccountArray.get(i).getAccNumber())
			{
				checkingAccounter=true;
				recIndex=i;
				break;
			}
		}
		for(int i=0;i< SavingsAccountArray.size();i++)
		{
			if (recAccNum== SavingsAccountArray.get(i).getAccNumber())
			{
				savingsAccounter=true;
				recIndex=i;
				break;
			}
		}
		if(checkingAccounter==false && savingsAccounter==false)
		{
			System.out.println("Receiving account number does not exist");
			return;
		}
	
		if(checkingSender==true && checkingAccounter==true)
		{
			CheckingAccountArray.get(senderIndex).makeWithdrawal(amount);
			CheckingAccountArray.get(recIndex).makeDeposit(amount);
			System.out.println("Transaction Complete!");
		}
		else if (checkingSender==true && savingsAccounter==true)
		{
			CheckingAccountArray.get(senderIndex).makeWithdrawal(amount);
			SavingsAccountArray.get(recIndex).makeDeposit(amount);
			System.out.println("Transaction Completed!");
		}
		else if (savingsSender==true && savingsAccounter==true)
		{
			SavingsAccountArray.get(senderIndex).makeWithdrawal(amount);
			SavingsAccountArray.get(recIndex).makeDeposit(amount);
			System.out.println("Transaction Completed!");
		}
		else if (savingsSender==true && checkingAccounter==true)
		{
			SavingsAccountArray.get(senderIndex).makeWithdrawal(amount);
			CheckingAccountArray.get(recIndex).makeDeposit(amount);
			System.out.println("Transaction Completed!");
		}

		
	}
}
