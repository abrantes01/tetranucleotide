import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;


public class Functions {
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
  
       /* String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add the vertices
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        // add edges to create a circuit
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v4, v1);
*/
        return g;
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
