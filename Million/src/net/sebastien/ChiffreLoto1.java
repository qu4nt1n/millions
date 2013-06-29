package net.sebastien;

public class ChiffreLoto1 {
	
	int[] chiffresMain = new int[5];
	int[] chiffresEtoiles = new int[2];
	
	public String tirageGagnant(){
		
		for (int slot = 0; slot < chiffresMain.length; slot++){
			
			int num;
			try_again:
				do {
					num = rnd(50)+1;
					for (int i = 0; i<slot; i++)
						if (chiffresMain[i]== num)
							continue try_again;
						break;
					}while (true);
					chiffresMain[slot] = num;
		}
		
		
		for (int slotEtoiles = 0; slotEtoiles<chiffresEtoiles.length;slotEtoiles++){
			int num;
			try_again_etoiles:
				do {
					num = rnd(10)+1;
					for (int i = 0; i<slotEtoiles; i++)
						if (chiffresEtoiles[i] == num)
							continue try_again_etoiles;
						break;
					}
					while (true);
					chiffresEtoiles[slotEtoiles] = num;
				}
			
	
		
		String resultatGagnant = "";
		for (int i = 0; i<chiffresMain.length;i++){
			resultatGagnant = resultatGagnant + chiffresMain[i] + "\n";
		}
		resultatGagnant += "etoiles\t";
		for (int i = 0; i<chiffresEtoiles.length;i++){
			resultatGagnant = resultatGagnant+ chiffresEtoiles[i] + "\t";
		}
		
		return resultatGagnant;
		
	}

	private int rnd(int i) {
		// TODO Auto-generated method stub
		return (int)(Math.random()*i);
	}

}
