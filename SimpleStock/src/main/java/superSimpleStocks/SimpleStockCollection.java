package superSimpleStocks;

import java.util.Iterator;
import java.util.List;

class SimpleStockCollection 
	{
		List<SimpleStock> StockCollection;
		
		public SimpleStockCollection(List<SimpleStock> stocks)
		{
		this.StockCollection = stocks;	
		}
		
		public double allShareIndex()
		{
			double geometricMean = 0.0;
			double totalPrice = 1.0;
			Iterator<SimpleStock> iterator= StockCollection.iterator();
			 while (iterator.hasNext())
			  {
				totalPrice *= iterator.next().marketPrice;
			  }
			  geometricMean = Math.pow(totalPrice,(double)1/(double)StockCollection.size());
			  return geometricMean;
		}

}
