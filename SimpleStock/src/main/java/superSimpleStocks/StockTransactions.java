package superSimpleStocks;

import java.time.LocalDateTime;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StockTransactions {
		 String transactionStockSymbol;	
		 LocalDateTime transactionDate;
		 int quantity;
		 char buysellIndicator;
		 int tradePrice;
		 static Logger Logger = LoggerFactory.getLogger(StockTransactions.class);
		 
		 StockTransactions(String inputTransactionSymbol, char inputBuySellIndicator,int inputQuantity,int inputTradePrice)
			 {
				 transactionStockSymbol = inputTransactionSymbol;
				 transactionDate = LocalDateTime.now();
				 quantity = inputQuantity;
				 buysellIndicator = inputBuySellIndicator;
				 tradePrice = inputTradePrice;
			 }
			 
			 public static StockTransactions getUserTransactionInputs(StockTransactions transaction)
		 {
			 String userTransactionSymbol;
	       	 char userBuySellIndicator;
			 int userQuantity;
			 int userTradePrice;
			 Scanner inputScanner = new Scanner(System.in);
			 try{
			 System.out.println("Enter the Stock Symbol:");
			 userTransactionSymbol=inputScanner.next();
			 System.out.println("Enter the B/S Indicator:");
			 userBuySellIndicator = inputScanner.next().charAt(0);
			 System.out.println("Enter the Quantity:");
			 userQuantity=inputScanner.nextInt();
			 System.out.println("Enter the Trade Price:");
			 userTradePrice=inputScanner.nextInt();
			 transaction = new StockTransactions(userTransactionSymbol.toUpperCase(),Character.toUpperCase(userBuySellIndicator),userQuantity,userTradePrice);
			 }
			 catch(InputMismatchException e)
			 {
				 Logger.info("Input Transaction details are Invalid");
			 }
			 return transaction;
		 }
	

}
