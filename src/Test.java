import java.math.BigInteger;
import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;


public class Test extends Thread {
	public static BigInteger RESULTAT;
	public DefaultMutableTreeNode arbre;
	public int l;
	public ArrayList<String> conversion;
	
	public Test(BigInteger res, DefaultMutableTreeNode a, int len,ArrayList<String> conv ){
		RESULTAT = res;
		l = len;
		arbre = a;
		conversion = conv;
	}
	
	public void run() {
		//RESULTAT = new BigInteger[this.l+1];
		BigInteger res_tmp = new BigInteger("0");
		//Marche pas comme ça, voir comment couper pour threader
		for(int i=l;i!=0;i--){
			Thread th = new Test(res_tmp, arbre, i, conversion);
		}

		/*if (l == 0) {
			if (Functions.isValid(arbre.toString(), conversion)) {
				RESULTAT = RESULTAT.add(BigInteger.ONE);
			}
		} */
	}
	
	public void calcul(){
		int debut = 0;
		String virgule = "";
		String tmp = "";

		if (l != 1) {
			virgule = ",";
		}
		String[] indexesTab = arbre.toString().split(",");
		tmp = indexesTab[indexesTab.length - 1];

		if (arbre.toString().equals("")) {
			debut = 0;
		} else {
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
				}
			} catch (Exception e) {
			}
		}

		if (arbre.toString().length() != 0) {
				if (!Functions.isAutocomplementary(conversion.get(Integer.parseInt(tmp)))) {
					if (!Functions.isCyclic(Functions.createGraph(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule);
						arbre.add(node);
					}
				}
		}
	}
}
