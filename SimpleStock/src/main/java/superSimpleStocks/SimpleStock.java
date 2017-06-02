package superSimpleStocks;


public abstract class SimpleStock
{
	 String stockSymbol;
 	 int lastDividend;
     int fixedDividend;
     int parValue;
     int marketPrice;
 	abstract double computeDivyield();
    SimpleStock(String stockSimpleSymbol,int lDiv,int fixDiv,int parV,int mPri)
 	{
 		  this.stockSymbol = stockSimpleSymbol;
  		  this.lastDividend=lDiv;
 		  this.fixedDividend=fixDiv;
 		  this.parValue=parV;
 		  this.marketPrice=mPri;
 	  }  

   double computePERatio()
    {
         return ((double)this.marketPrice / (double)this.lastDividend);
    }
 
 }
class CommonSimpleStock extends SimpleStock
{
	 String stockType;
	CommonSimpleStock(String stockSimpleSymbol, int lDiv, int fixDiv, int parV, int mPri)
	{
		super(stockSimpleSymbol, lDiv, fixDiv, parV, mPri);
		this.stockType = "COMMON";
	}

 
	double computeDivyield()
	  {
		return ((double)this.lastDividend / (double) this.marketPrice);
	  }
}
class PreferredSimpleStock extends SimpleStock
{
	 String stockType;
	 PreferredSimpleStock(String stockSimpleSymbol, int lDiv, int fixDiv, int parV, int mPri) 
	  {
		super(stockSimpleSymbol, lDiv, fixDiv, parV, mPri);
		this.stockType = "PREFERRED";
	  }

	double computeDivyield()
	  {
            return ((double) (this.fixedDividend * this.parValue) / (double) this.marketPrice);
     }
}
