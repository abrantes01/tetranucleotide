import java.io.FileNotFoundException;
import java.net.*;
import java.util.Arrays;
import org.jgrapht.*;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
        //UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();

        // note undirected edges are printed as: {<v1>,<v2>}
        //System.out.println(stringGraph.toString());

        // create a graph based on URL objects
		 String code = "{AATG,AGTT,GTGT,GTTT}";
        DirectedGraph<String, DefaultEdge> hrefGraph = createHrefGraph(code);
        System.out.println(isCyclic(hrefGraph));

        // note directed edges are printed as: (<v1>,<v2>)
        System.out.println(hrefGraph.toString());
        Combi.S256();
	}
	
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
    private static DirectedGraph<String, DefaultEdge> createHrefGraph(String code)
    {
        DirectedGraph<String, DefaultEdge> g =
            new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        
        //on dit que le string est de la forme {AAAA,BBBB,...}
       
        code = code.substring(1,code.length()-1);
        String[] a = code.split(",");
        
        
        //System.out.println(Arrays.toString(a));
        
        String s1 = new String();
        String s2 = new String();
        
        for (String s : a) {
        	for (int i=1;i<4;i++) {
        		s1 = s.substring(0,i);
        		s2 = s.substring(i,4);
        		g.addVertex(s1);
        		g.addVertex(s2);
        		g.addEdge(s1,s2);
        		
        	}
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
    	CycleDetector cd = new CycleDetector(g);
    	return cd.detectCycles();
    }

}
