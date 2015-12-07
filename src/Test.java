import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;


public class Test extends Thread {
	//public static BigInteger RESULTAT;
	public DefaultMutableTreeNode arbre;
	public int l;
	public ArrayList<String> conversion;
	public int id;
	
	
	
	public Test (DefaultMutableTreeNode arbre1, int lel, ArrayList<String> conversion1, int id1) {
		this.l=lel;
		this.arbre = arbre1;
		this.conversion = conversion1;
		this.id = id1;
	}
	
	
	public void run() {
		//System.out.println("coucou :" + this.id);
		int debut = 0;
		String virgule = "";
		String tmp = "";
		if (l == 0) {
			if (Functions.isValid(arbre.toString(), conversion)) {
				Functions.COMPTEUR_GLOBAL = Functions.COMPTEUR_GLOBAL.add(BigInteger.ONE);
				System.out.println("Thread : " +this.id);
				UIListener.res.set(this.id-1); 
				/*String[] indexesTab = arbre.toString().split(",");
				ArrayList<String> tetraList = new ArrayList<String>();
				for(String s : indexesTab){
					if ((Integer.parseInt(s))>0) {
						System.out.print(conversion.get(Integer.parseInt(s))+' ');
					}
					else {
						System.out.print(complementary(conversion.get(0-Integer.parseInt(s)))+' ');
					}
				}
				System.out.print(",");*/
			}
		} else {
			if (l != 1) { virgule = ",";}
			String[] indexesTab = arbre.toString().split(",");
			tmp = indexesTab[indexesTab.length - 1];
			if (arbre.toString().equals("")) {debut = 0;} 
			else {
				if (Integer.parseInt(tmp)<0) {
					debut = Integer.parseInt(indexesTab[indexesTab.length-2]);
				}
				else {
					debut = Integer.parseInt(tmp);
				}
			}
			for (int i = debut + 1; i <= 126; i++) {
				try {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + i + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + i + virgule);
						arbre.add(node);
						compteur(node, l - 1, conversion);
					}
				} catch (Exception e) {
				}
			}
			if (arbre.toString().length() != 0) {
				if (!Functions.isAutocomplementary(conversion.get(Integer.parseInt(tmp)))) {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule);
						arbre.add(node);
						compteur(node, l - 1, conversion);
					}
				}	
			}
		}

        
        
        
    }
	
	public static void compteur_aux(DefaultMutableTreeNode arbre, int l, ArrayList<String> conversion) {
		
		if (l!=0) {
			for (int i = 1; i <= 126; i++) {
				try {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + i + ',', conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + i +',');
						arbre.add(node);
						//System.out.println("Coucou : " + Main.tests.size());
						Main.tests.add(new Test(node,l-1,conversion,i));
						Main.tests.get(Main.tests.size()-1).start();
					}
				} catch (Exception e) {
				}
			}
		}
		
	}

    public static void compteur(DefaultMutableTreeNode arbre, int l, ArrayList<String> conversion) {
    	int debut = 0;
		String virgule = "";
		String tmp = "";
		if (l == 0) {
			if (Functions.isValid(arbre.toString(), conversion)) {
				Functions.COMPTEUR_GLOBAL = Functions.COMPTEUR_GLOBAL.add(BigInteger.ONE);
				//UIListener.res.set(this.id-1);
				/*String[] indexesTab = arbre.toString().split(",");
				ArrayList<String> tetraList = new ArrayList<String>();
				for(String s : indexesTab){
					if ((Integer.parseInt(s))>0) {
						System.out.print(conversion.get(Integer.parseInt(s))+' ');
					}
					else {
						System.out.print(complementary(conversion.get(0-Integer.parseInt(s)))+' ');
					}
				}
				System.out.print(",");*/
			}
		} else {
			if (l != 1) { virgule = ",";}
			String[] indexesTab = arbre.toString().split(",");
			tmp = indexesTab[indexesTab.length - 1];
			if (arbre.toString().equals("")) {debut = 0;} 
			else {
				if (Integer.parseInt(tmp)<0) {
					debut = Integer.parseInt(indexesTab[indexesTab.length-2]);
				}
				else {
					debut = Integer.parseInt(tmp);
				}
			}
			for (int i = debut + 1; i <= 126; i++) {
				try {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + i + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + i + virgule);
						arbre.add(node);
						compteur(node, l - 1, conversion);
					}
				} catch (Exception e) {
				}
			}
			if (arbre.toString().length() != 0) {
				if (!Functions.isAutocomplementary(conversion.get(Integer.parseInt(tmp)))) {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule);
						arbre.add(node);
						compteur(node, l - 1, conversion);
					}
				}	
			}
		}
        
    }
    
}

