import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp 
{

    public static void main(String[] args) 
    {
    	NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(1);
        
        
        System.out.println("The Future Value Calculator\n");
        
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        
        
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = sc.nextDouble();
            System.out.print("Enter number of years:      ");
            int years = sc.nextInt();
           
            String table = "";
            
            String headerRow= "Years\t";
            for(double interestRate = 5.0 ; interestRate < 7.0 ; interestRate += 0.5) 
            {
            	headerRow+= percent.format(interestRate/100)+"\t\t";
            }
            table+=headerRow + "\n";
            for(int i = 1; i <= years; i++) 
            {
            	String row = i + "\t";
            	for (double rate = 5.0; rate < 7.0; rate+= 0.5)
            	{
            		int months = i * 12;
            		double monthlyInterestRate = rate/12/100;
            		double futureValue = 0.0;
            		for(int m = 1; m <= months; m++)
            		{
            			futureValue = (futureValue + monthlyInvestment) *
            								(1 + monthlyInterestRate);
            		}
            		row += currency.format(futureValue)+ "\t";
            	}
            	table+= row + "\n";
            }
            	//months = years*12;
    		//monthlyInterestRate = interestRate/12/100;
    		//futureValue = (futureValue + monthlyInvestment)
    		//			  *(1+ monthlyInterestRate);

            // see if the user wants to continue
            System.out.println(table);
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
            System.out.println("Bye!");
    }
}
