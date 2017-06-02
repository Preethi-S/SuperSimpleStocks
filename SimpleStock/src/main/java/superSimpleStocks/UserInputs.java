package superSimpleStocks;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserInputs
{
	 public static Scanner input = new Scanner(System.in);
     static Logger Logger = LoggerFactory.getLogger(UserInputs.class);
	 SimpleStock getUserStockInputs(SimpleStock inputStock)
	 {
		try
		{
		 System.out.println("Enter the Stock Symbol:");
		 String inputstockSymbol = input.next();
		 System.out.println("Enter the last Div:");
		 int inputlastDividend=input.nextInt();
	     System.out.println("Enter the fixed Div:");
	     int inputfixedDividend =input.nextInt();
		 System.out.println("Enter the parValue:");
		 int inputparValue=input.nextInt();
		 System.out.println("Enter the Market Price:");
		 int inputmarketPrice= input.nextInt();
		 System.out.println("Enter the Type (COMMON or PREFERRED):");
		 String inputStockType = input.next();
		 if (inputStockType.equalsIgnoreCase("COMMON"))
				inputStock = new CommonSimpleStock(inputstockSymbol.toUpperCase(),inputlastDividend,inputfixedDividend,inputparValue,inputmarketPrice) ;
			 else
				inputStock = new PreferredSimpleStock(inputstockSymbol.toUpperCase(),inputlastDividend,inputfixedDividend,inputparValue,inputmarketPrice) ;
			
		}
		catch(InputMismatchException e)
		{
			Logger.info("Invalid Stock Data is entered");
		}
	 return inputStock;
	 }   
	 void recordTransactions()
	 {
		    String transStockSymbol;
			List<StockTransactions> inputTransactions = new ArrayList<StockTransactions>();
			StockTransactions inputTransaction = null;
			try{
			   System.out.println("Enter the number of Transactions to be recorded:");
			   int proceedInput = input.nextInt();
			   for(int i=0;i < proceedInput; i++)
			   {
				inputTransaction = StockTransactions.getUserTransactionInputs(inputTransaction);
				inputTransactions.add(inputTransaction);
			   }
			   if (inputTransactions.size() > 0 )
			   {
			     System.out.println("Do you want to calculate Volume Weighted Stock Price");
			     char calculateVolumeWeighted=input.next().charAt(0);
			     if (Character.toUpperCase(calculateVolumeWeighted) == 'Y')
			      {
		           System.out.println("Enter the Stock Symbol: ");
			       transStockSymbol = input.next();
			       System.out.println("Volume Weighted Stock Price on trades in past 15 minutes: ");
			       TransactionCollection inputTransactionCollection = new TransactionCollection(inputTransactions);
			       System.out.println(inputTransactionCollection.computeVolumeWeightedStockPrice(transStockSymbol.toUpperCase()));
			      }
			     else
				   Logger.info("Volume weighted Stock is not calculated"); 
			    }
			   else
	     	    Logger.info("No transactions to calculate Volume Weighted Stock Price");
			} catch(InputMismatchException e)
			  {
				Logger.info("Not Valid Input Type");
			  }
			}
	 void calculateDividendYieldPERatio(List <SimpleStock> inputStocks)
	 {
		    System.out.println("Enter the Stock Symbol for Dividend Yield and P/E Ration calculation: ");
			String stockSymbol = input.next();
			Iterator<SimpleStock> iterator= inputStocks.listIterator();
			try{
			while (iterator.hasNext()){
				SimpleStock stockCalculation = iterator.next();
				if (stockCalculation.stockSymbol.equalsIgnoreCase(stockSymbol))
					{
					System.out.println("Dividend Yield for Stock Symbol  " + stockSymbol + " "+ stockCalculation.computeDivyield());
					System.out.println("P/E Ratio for Stock Symbol  " + stockSymbol + " " + stockCalculation.computePERatio());
					}
				}	  
			}catch(IndexOutOfBoundsException e)
			{
				Logger.info("Simple Stocks List Index out of Bound exception" );
			}
	 }
	public static void calculateAllShareIndex(List <SimpleStock> inputStocks)
	{
		SimpleStockCollection allStocks = new SimpleStockCollection(inputStocks);
		try{
		double geometricMean = allStocks.allShareIndex();
		System.out.println("GBCE All Share Index of all stocks: " + geometricMean);
		} catch(IndexOutOfBoundsException e)
		{
			Logger.info("Simple Stocks List Index out of Bound exception" );
		}
		
	}
	public static void main (String[] args)
	   {
		UserInputs userValue = new UserInputs();
		List<SimpleStock> inputStocks = new ArrayList<SimpleStock>();
		SimpleStock inputStock = null;
        int numberOfInputStocks = 0;
        System.out.println("Enter the number of Stock Inputs: ");
        numberOfInputStocks = input.nextInt();
        for (int i = 0; i < numberOfInputStocks; i++)
         {
          inputStock = userValue.getUserStockInputs(inputStock);	
           inputStocks.add(inputStock);
         }
        int computationChoice = 0;
        System.out.println("Enter Choice of Computation (1/2/3)");
    	System.out.println("1. Calculate Dividend Yield & P/E Ratio");
		System.out.println("2. Record Transactions");
		System.out.println("3. Calculate GBCE All Share Index");
		computationChoice = input.nextInt();
		switch(computationChoice)
		{
		case 1:
			userValue.calculateDividendYieldPERatio(inputStocks);			
		    break;
		case 2:
			userValue.recordTransactions();
			break;
		case 3:
			calculateAllShareIndex(inputStocks);			
			break;
		default:	
			Logger.info("Not entered any valid options");
		}
    input.close();		
	}
 	}
