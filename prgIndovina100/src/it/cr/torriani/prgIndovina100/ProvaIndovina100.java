package it.cr.torriani.prgIndovina100;

public class ProvaIndovina100 {
	
	public static void main(String[] args) {
		Model m;
		m=new Model();
		m.Inizia();
		int num=50;
		int x1=1, x2=100;
		int ret;
		do {
			ret=m.Invia(num);
			String msg="Tentativo n. " + m.getNumTentativi();
				if(ret==-1) {
					x1=num+1;
					System.out.println(String.format("%d minore di segreto %s",num,msg));
				}else if(ret==1) {
					x2=num-1;
					System.out.println(String.format("%d maggiore di segreto %s",num,msg));
				}
			num=(x1+x2)/2;
		}while(m.isInGioco());
		if(ret==0)
			System.out.println("Hai vinto "+m.getNumCaso());
		else
			System.out.println("Hai perso "+m.getNumCaso());
	
	}

}
