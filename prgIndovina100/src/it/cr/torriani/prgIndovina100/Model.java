package it.cr.torriani.prgIndovina100;
/**
 * @author eneac
 * @date 
 */
import java.security.InvalidParameterException;

public class Model {
	private int numCaso;
	private int numTentativi;
	private boolean inGioco; //true se inizio gioco false finito
	private static final int NMAX=100;
	private static final int TMAX=(int) (Math.log10(NMAX)/Math.log10(2))+1;
 /**
  * Avvia il gioco
  */
	public void Inizia() {
	   	numCaso=(int)(Math.random()*NMAX)+1;
    	inGioco = true; 
    	numTentativi=0;
	}
	
	/**
	 * funzione che controlla se il numero è = > < 
	 * @param num numero da controllare
	 * @return 0 se uguale 1 se maggiore -1 se minore
	 */
	public int Invia(int num) {
		int confronto=0; //0 1 -1
		
		if(!inGioco)
			 throw new IllegalStateException("Partita non attiva");
		
		if(num<1 || num>NMAX)
			throw new InvalidParameterException("Numero fuori range");
		
	   	numTentativi++;

		if(num==numCaso) {
			inGioco=false;
			confronto=0;
		}else
			if(num<numCaso)
				confronto=-1;
			else
				confronto=1;
		
		if(numTentativi==TMAX)
			inGioco=false;
			
		return confronto;
	}
	
	/**
	 * 	
	 * getter setter
	 */
	public int getNumCaso() {
		return numCaso;
	}

	public int getNumTentativi() {
		return numTentativi;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public static int getNmax() {
		return NMAX;
	}

	public static int getTmax() {
		return TMAX;
	}

}
