import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;



public class Functions {
	
	public static BigInteger COMPTEUR_GLOBAL = new BigInteger("0");
	/**
     * Creates a toy directed graph based on URL objects that represents link
     * structure.
     *
     * @return a graph based on URL objects.
     */
	
   

    /**
     * Create a toy graph based on String objects.
     *
     * @return a graph based on String objects.
     */
    public static DirectedGraph<String, DefaultEdge> createHrefGraph(String fichier)
    {
        DirectedGraph<String, DefaultEdge> g =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        
        FileReader input;
		try {
			input = new FileReader(fichier);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			input = null;
			e.printStackTrace();
		}
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;
        
        try {
			while ((myLine = bufRead.readLine()) != null) {
	        
		        String s1 = new String();
		        String s2 = new String();
		        
		        for (int i=1;i<4;i++) {
		        	s1 = myLine.substring(0,i);
		        	s2 = myLine.substring(i,4);
		        	g.addVertex(s1);
		        	g.addVertex(s2);
		        	g.addEdge(s1,s2);
		        }	
			}
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			bufRead.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return g;
    }

	public static void getL1(String fichier){
		FileReader input;
		try{
			input = new FileReader(fichier);
		}
		catch (FileNotFoundException e){
			System.out.println("Error while opening file");
			input = null;
		}

		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;

		int res = 0;

		try {
			while ((myLine = bufRead.readLine()) != null) {
				SimpleDirectedGraph<String, DefaultEdge> g =
						new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
				String s1 = new String();
				String s2 = new String();

				for (int i=1;i<4;i++) {
					s1 = myLine.substring(0,i);
					s2 = myLine.substring(i,4);
					g.addVertex(s1);
					g.addVertex(s2);
					g.addEdge(s1,s2);
				}

				if(isAutocomplementary(myLine) && !isCyclic(g)){
					res++;
				}

				System.out.println(myLine+ " ---> " +g);
				//System.out.println(g);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Resultat : " + res);

	}

	public static ArrayList<String> arrayTetra126(){
		ArrayList<String> array = new ArrayList<String>();

		FileReader input;
		try{
			input = new FileReader("S126.txt");
		}
		catch (FileNotFoundException e){
			System.out.println("Error while opening file");
			input = null;
		}
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;
		int i = 1;
		array.add(null);
		try {
			while ((myLine = bufRead.readLine()) != null) {
				array.add(i,myLine);
				i++;
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bufRead.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	
	public static void compteur(DefaultMutableTreeNode arbre, int l, ArrayList<String> conversion) {
		int debut = 0;
		String virgule = "";
		String tmp = "";
		/*String tmp2 = new String("");
		int index = 0;*/

		if (l == 0) {
			if (isValid(arbre.toString(), conversion)) {
				COMPTEUR_GLOBAL = COMPTEUR_GLOBAL.add(BigInteger.ONE);
				/*String[] indexesTab = arbre.toString().split(",");
				//System.out.print(arbre.toString()+" , ");
				ArrayList<String> tetraList = new ArrayList<String>();
				for(String s : indexesTab){
					if ((Integer.parseInt(s))>0) {
						System.out.print(conversion.get(Integer.parseInt(s))+' ');
					}
					else {
						System.out.print(complementary(conversion.get(0-Integer.parseInt(s)))+' ');
					}
					
					//System.out.print(s+' ');
				}
				System.out.print(",");*/
			}
		} else {
			//System.out.println(arbre.toString());
			if (l != 1) {
				virgule = ",";
			}
			/*else {
				virgule=",";
			}*/
			String[] indexesTab = arbre.toString().split(",");

			tmp = indexesTab[indexesTab.length - 1];


			//System.out.println(tmp);
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
				/*String[] indexesTab = (arbre.toString()+i).split(",");
				ArrayList<String> tetraList = new ArrayList<String>();
				for(String s : indexesTab){
					System.out.print(conversion.get(Integer.parseInt(s))+' ');
				}
				System.out.println();*/


				try {
					//if (i!=Integer.parseInt(tmp)) {
					if (!isCyclic(createGraph(arbre.toString() + i + virgule, conversion))) {
						DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + i + virgule);
						arbre.add(node);
						compteur(node, l - 1, conversion);
						//System.out.println("UN DANS LE ELSE");
					}

					//}
				} catch (Exception e) {
					//System.out.println("Loops dedans putain");
				}
			}
			//System.out.println(tmp.getClass().getName());
			//System.out.println("a : "+arbre.toString());
			//System.out.println("a: "+tmp);
			if (arbre.toString().length() != 0) {
				//for (int j = Integer.parseInt(tmp)-1; j<indexesTab.length;j++) {
					//tmp2 = indexesTab[indexesTab.length - j];
					if (!isAutocomplementary(conversion.get(Integer.parseInt(tmp)))) {
						if (!isCyclic(createGraph(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule, conversion))) {
							DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp)) + virgule);
							arbre.add(node);
							compteur(node, l - 1, conversion);
						}
						else{
							//arbre=null;
						}
					}
					/*tmp2 = indexesTab[indexesTab.length - 2];
					if (!isAutocomplementary(conversion.get(Integer.parseInt(tmp2)))) {
						if (!isCyclic(createGraph(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp2)) + virgule, conversion))) {
							DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString() + String.valueOf(0 - Integer.parseInt(tmp2)) + virgule);
							arbre.add(node);
							compteur(node, l - 1, conversion);
						}
					}*/
					
				//}
				
			}
		}
		arbre = null;
	}


	public static DefaultMutableTreeNode remplir(DefaultMutableTreeNode root, int l){
		if (l == 0) return root;
		else {
			root = remplir_aux(root,l);
		}
		return root;
	}

	public static DefaultMutableTreeNode remplir_aux(DefaultMutableTreeNode root, int l){
		FileReader input;
		try{
			input = new FileReader("S126.txt");
		}
		catch (FileNotFoundException e){
			System.out.println("Error while opening file");
			input = null;
		}

		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;

		try {
			while ((myLine = bufRead.readLine()) != null) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(myLine);
				root.add(node);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Enumeration e = root.children(); e.hasMoreElements();){
			remplir((DefaultMutableTreeNode) e.nextElement(),l-1);
		}
		try {
			bufRead.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;

	}

	public static void parcourir(MutableTreeNode parent) {
		int childNumber = parent.getChildCount();
		for (int i = 0 ; i < childNumber ; i++) {
			MutableTreeNode child = (MutableTreeNode) parent.getChildAt(i);
			System.out.println(child.getChildCount());
			parcourir(child);
		}
	}


	public static int compte(MutableTreeNode a){
		if (a == null) return 0;
		else {
			//if (a.)
		}
		return 0;
	}


	public static void createTree(String fichier){
		JTree tree;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");


		FileReader input;
		try{
			input = new FileReader(fichier);
		}
		catch (FileNotFoundException e){
			System.out.println("Error while opening file");
			input = null;
		}

		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;

		int res = 0;

		try {
			while ((myLine = bufRead.readLine()) != null) {
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(myLine);
				root.add(node);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tree = new JTree(root);

		//Enumeration e = root.children();

		for (Enumeration e = root.children(); e.hasMoreElements();)
			System.out.println(e.nextElement());

		//System.out.println(tree.toString());


	}
    
    public static boolean isCyclic(SimpleDirectedGraph<String, DefaultEdge> g) {
    	
    	//renvoie true s'il y a un cycle
    	
    	CycleDetector cd = new CycleDetector(g);
    	return cd.detectCycles();
    }

	public static SimpleDirectedGraph<String,DefaultEdge> createGraph (String indexes, ArrayList<String> conversion){
		SimpleDirectedGraph<String, DefaultEdge> g =
				new SimpleDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
		String[] indexesTab = indexes.split(",");
		String tetraString = new String();
		for (String s: indexesTab) {
			if(Integer.parseInt(s)<0) {
				tetraString = complementary(conversion.get(Integer.parseInt(String.valueOf(0-Integer.parseInt(s)))));
			}
			else {
				tetraString = conversion.get(Integer.parseInt(s));
			}
			String s1 = new String();
			String s2 = new String();

			for (int i=1;i<4;i++) {
				s1 = tetraString.substring(0,i);
				s2 = tetraString.substring(i,4);
				g.addVertex(s1);
				g.addVertex(s2);
				g.addEdge(s1,s2);
			}
			//System.out.println(conversion.get(Integer.parseInt(s)));
			//System.out.println(s);
		}
		return g;
	}


	public static boolean isValid(String indexes, ArrayList<String> conversion){
		//System.out.print("Appel isValid :" + indexes );
		boolean res = true;
		if (indexes.equals("")){
			System.out.println("Salut");
		}
		//System.out.print(indexes+" ");
		/*if(isCyclic(createGraph(indexes,conversion))) {
			//System.out.println("C'est cyclique");
			res = false;
		}*/
		else{
		String[] indexesTab = indexes.split(",");
		ArrayList<String> tetraList = new ArrayList<String>();
		for(String s : indexesTab){
			//System.out.print(s+' ');
			if ((Integer.parseInt(s))>0) {
				tetraList.add(conversion.get(Integer.parseInt(s)));
			}
			else {
				tetraList.add(complementary(conversion.get(0-Integer.parseInt(s))));

			}
			
		}
		//System.out.println();
		/*
			ArrayList<String> tetraListComp = new ArrayList<String>();

			for(String ts : tetraList){
				tetraListComp.add(complementary(ts));
			}
			if(!tetraList.containsAll(tetraListComp)) res = false;*/
		for(int i = 0; i < tetraList.size() && res;i++){
			String tetranucleotide = tetraList.get(i);
	        res = tetraList.contains(complementary(tetranucleotide));
	       // System.out.print(tetranucleotide+' ');
	    }
		
		}
		//System.out.print(" "+res+" ");
		//System.out.print(" ; ");

		return res;
	}

    public static String complementary(String tetra) {
    	StringBuilder res = new StringBuilder( "AAAA");
    	if (tetra.length()!=4){
    		System.out.println("Erreur, le nucleotide doit contenir 4 caracteres");
    		System.exit(0);
    	}
    	else{
        	for (int i = 0; i<4; i++){
        		switch (tetra.charAt(i)) {
        			case 'A':	res.setCharAt(3-i,'T');
        						break;
        			case 'C':	res.setCharAt(3-i,'G');
    							break;
        			case 'G':	res.setCharAt(3-i,'C');
    							break;
        			case 'T':	res.setCharAt(3-i,'A');
    							break;
        		}
        	}
    	}
    	
    	return res.toString();
    }

    public static boolean isAutocomplementary(String tetra) {
    	return complementary(tetra).equals(tetra);
    }
	
}
