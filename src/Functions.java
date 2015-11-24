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
	
    /*private static DirectedGraph<URL, DefaultEdge> createHrefGraph()
    {
        DirectedGraph<URL, DefaultEdge> g =
            new DefaultDirectedGraph<URL, DefaultEdge>(DefaultEdge.class);

        try {
            URL amazon = new URL("http://www.amazon.com");
            URL yahoo = new URL("http://www.yahoo.com");
            URL ebay = new URL("http://www.ebay.com");

            // add the vertices
            g.addVertex(amazon);
            g.addVertex(yahoo);
            g.addVertex(ebay);

            // add edges to create linking structure
            g.addEdge(yahoo, amazon);
            g.addEdge(yahoo, ebay);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return g;
    }*/

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
				DirectedGraph<String, DefaultEdge> g =
						new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
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
		ArrayList<String> array = new ArrayList<>();

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
				array.add(myLine);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	public static boolean isValid(String s) {
		return false;
	}
	/*public static int compteur (DefaultMutableTreeNode arbre, int l) {//au début arbre est vide et res =0
		//si le noeud ne va pas, on arrête dans cette branche
		if (!(isCyclic(arbre.toString()))||!(isAutocomplementary(arbre.toString()))) {
			return 0;
		}
		else {
			if (l==0) { //sinon, si on est à une feuille qui marche, +1
				return 1;
			}
			else { //si on est à un noeud pas feuille qui marche, on crée ses fils
				return compteur_aux(arbre,l);
			}
		}
	}
	public static void compteur_aux(DefaultMutableTreeNode arbre, int l) {
		for (int i=0; i<126; i++) {
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString()+','+i);
			arbre.add(node);
			compteur(node, l-1);
		}
	}*/
	
	public static void compteur(DefaultMutableTreeNode arbre, int l) {
		if (l==0) {
			if(isValid(arbre.toString())) {
				COMPTEUR_GLOBAL.add(BigInteger.ONE);
			}
		}
		else {
			for (int i=0; i<126; i++) {
				if(isValid(arbre.toString()+','+i)) {
					DefaultMutableTreeNode node = new DefaultMutableTreeNode(arbre.toString()+','+i);
					arbre.add(node);
					compteur(node, l-1);
				}
			}
		}
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
    
    public static boolean isCyclic(DirectedGraph<String, DefaultEdge> g) {
    	
    	//renvoie true s'il y a un cycle
    	
    	CycleDetector cd = new CycleDetector(g);
    	return cd.detectCycles();
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
