package superSimpleStocks;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleStockTest {
	CommonSimpleStock commonStock = new CommonSimpleStock("POP",8,0,100,12);
	PreferredSimpleStock preferredStock = new PreferredSimpleStock("ALE",8,2,100,24);

	@Test
	public void testcalcPERatio() {
		double expectedCommonPERatio = commonStock.computePERatio();
		assertEquals(1.5, expectedCommonPERatio,0.01);
		double expectedPreferredPERation=preferredStock.computePERatio();
		assertEquals(3.0, expectedPreferredPERation,0.01);
		}
	@Test
	public void testcalcDivyield() {
		double expectedCommonPERatio = commonStock.computeDivyield();
		assertEquals(0.66666666, expectedCommonPERatio,0.01);
		double expectedPreferredPERation=preferredStock.computeDivyield();
		assertEquals(8.3333333, expectedPreferredPERation,0.01);
		}
	

}
