
package superSimpleStocks;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	class TransactionCollection 
		{
			List <StockTransactions> transactionlistCollection;
			Logger Logger = LoggerFactory.getLogger(TransactionCollection.class);
			public TransactionCollection(List<StockTransactions> transactions)
			{
			this.transactionlistCollection = transactions;	
			}
			
			public double computeVolumeWeightedStockPrice(String transactionSymbol)
			{
				int sumQuantitynPrice = 0;
				int totalQuantity = 0;
				Iterator<StockTransactions> iterator= transactionlistCollection.iterator();
				try{
				while (iterator.hasNext()){
					StockTransactions transactions = iterator.next();
					long duration;
					LocalDateTime timeNow;
					timeNow = LocalDateTime.from(LocalDateTime.now());
					duration= Math.abs(timeNow.until(transactions.transactionDate, ChronoUnit.MINUTES));
					if ((duration < 15) && (transactions.transactionStockSymbol.equalsIgnoreCase(transactionSymbol)))
					{						
						sumQuantitynPrice += transactions.quantity *transactions.tradePrice;
						totalQuantity += transactions.quantity;
					}
				   }
					return((double)sumQuantitynPrice /(double) totalQuantity);
				}
				catch(NoSuchElementException e){
					Logger.info("Transactions are not available");
					return 0.0;
				}
 				
			}

	}

