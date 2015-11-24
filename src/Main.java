import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jgraph.JGraph;
import org.jgrapht.*;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) {
		
		 //String code = "{AATG,AGTT,GTGT,GTTT}";
        DirectedGraph<String, DefaultEdge> hrefGraph = Functions.createHrefGraph("test.txt");
        //System.out.println(Functions.isCyclic(hrefGraph));
        
         //code pour générer les fichiers textes
          
         try {
			Combi.S16();
			Combi.S256();
			Combi.S240();
			Combi.S12();
			Combi.S228();
			Combi.S114();
			Combi.S126();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch bloc   k
			e.printStackTrace();
		}

        //System.out.println(hrefGraph.toString());

        //Functions.getL1("S12.txt");
        //Functions.createTree("S126.txt");
        DefaultMutableTreeNode arbre = Functions.remplir(new DefaultMutableTreeNode(),2);
        //System.out.println(arbre.getDepth());
        Functions.parcourir(arbre);

        //visualization(hrefGraph);
        //System.out.println(complementary("AACT"));
        //System.out.println(Functions.isAutocomplementary("AACT"));
	}
	
	public static void visualization(DirectedGraph<String, DefaultEdge> g){
		JGraphModelAdapter jgraphModelAdapt = new JGraphModelAdapter(g);
		JGraph graph = new JGraph(jgraphModelAdapt);
		JFrame frame = new JFrame();
	    frame.getContentPane().add(graph);
	    frame.setTitle("JGraphT Adapter to JGraph Demo");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
		
		
	}

}
