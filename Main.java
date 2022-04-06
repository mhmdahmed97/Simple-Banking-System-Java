
//import javax.lang.model.util.ElementScanner14;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	Admin bankAdmin = new Admin();
    	int i=0;
    	while (i<1)
    	{
    		int selectNum;
    		System.out.println("Select operations to perform as an admin : \n 1. Open Account for customer \n 2. Close an account \n 3. Login to a customer account \n 4. Transfer Money \n Exit menu ");
    		Scanner inObj = new Scanner(System.in);
    		selectNum=inObj.nextInt();
    		if(selectNum==1)
    		{
    			bankAdmin.openAccount();
    		}
    		else if (selectNum==2)
    		{
    			bankAdmin.closeAccount();
    		}
    		else if (selectNum==3)
    		{
    			
    		}
    		else if (selectNum==4)
    		{
    			bankAdmin.transferAmount();
    		}
    		else if (selectNum==5)
    		{
    			i++;
    		}
    	}
    }

}
