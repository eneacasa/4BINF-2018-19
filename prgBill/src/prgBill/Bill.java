package prgBill;

import java.security.InvalidParameterException;

/*
 * 
 * @author 4B INFO v.1
 *
*/

public class Bill 
{
	private double importo;
	private double manciaPerc;
	private final double ivaPerc = 24.20;
	
	public Bill(double importo, double manciaPerc)
	{
		this.importo = importo;
		this.manciaPerc = manciaPerc;
		if(importo<=0)
		{
			throw new 
			InvalidParameterException("Err: Importo <= 0");
		}
		if(manciaPerc<0)
		{
			throw new 
			InvalidParameterException("Err: Mancia % < 0");
		}
	}
	
	public double calcMancia() {
		return importo/100*manciaPerc;
				
	}
	
	public String toString() {
		String str;
		double mancia=calcMancia();
		str=String.format("%-12s €%6.2f%n", "Importo:", importo);
		str+=String.format("%-12s €%6.2f%n", "Mancia:",mancia );
		str+="--------------------\n";
		str+=String.format("%-12s €%6.2f%n", "Totale:",importo+mancia );
		return str;
	}
//getter and setter	
	public double getImporto() 
	{
		return importo;
	}

	public void setImporto(double importo)
	{
		this.importo = importo;
	}

	public double getManciaPerc() 
	{
		return manciaPerc;
	}

	public void setManciaPerc(double manciaPerc) 
	{
		this.manciaPerc = manciaPerc;
	}
	
	public double getIvaPerc()
	{
		return ivaPerc;
	}
	
	
}
