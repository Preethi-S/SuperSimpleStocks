package superSimpleStocks;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class SimpleStockCollectionTest {
	SimpleStockCollection stockTestCollection;
	List<SimpleStock> stocklist = new ArrayList <SimpleStock>();
	@Before
	public void createlist(){
	SimpleStock inputStock = new CommonSimpleStock("GIN",23,0,100,10);
    stocklist.add(inputStock);
    stocklist.add(new PreferredSimpleStock("POP",8,0,60,20));
    stocklist.add(new CommonSimpleStock("TEA",13,2,100,30));
    stockTestCollection = new SimpleStockCollection(stocklist);
	}
	@Test
	public void testallShareIndex() {
		assertEquals(18.1712,stockTestCollection.allShareIndex(),0.01 );
	}
	

}
