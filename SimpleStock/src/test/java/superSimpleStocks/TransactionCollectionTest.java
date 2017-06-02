package superSimpleStocks;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TransactionCollectionTest {
	TransactionCollection transactiontestlist;
	List<StockTransactions> transactionList = new ArrayList<StockTransactions>();
	@Before
	public void createlist(){
	
	transactionList.add(new StockTransactions("POP",'B',5,10));
	transactionList.add(new StockTransactions("POP",'B',55,90));
	transactionList.add(new StockTransactions("POP",'B',5,20));
    transactiontestlist = new TransactionCollection(transactionList);
	}
	@Test
	public void testcomputeVolumeWeightedStockPrice() {		
	 assertEquals(78.4615, transactiontestlist.computeVolumeWeightedStockPrice("POP"),0.01);
	}
	
	@Test
	public void testcomputeVolumeWeightedStockPriceafter15mins() {
			
		Iterator <StockTransactions> iterator= transactiontestlist.transactionlistCollection.iterator();
		if (iterator.hasNext()){
			StockTransactions transactions = iterator.next();
			transactions.transactionDate = transactions.transactionDate.minusMinutes(16);
			}
	 assertEquals(84.1666, transactiontestlist.computeVolumeWeightedStockPrice("POP"),0.01);
	}
}
