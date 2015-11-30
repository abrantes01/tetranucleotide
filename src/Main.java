import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
//import java.util.function.Function;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jgraph.JGraph;
import org.jgrapht.*;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		
		
		// Lauching user interface
		UIManager.setLookAndFeel(new MetalLookAndFeel()); // For MAC users
		UI ui = new UI();
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ui.pack();
		ui.setSize(500, 600);
		ui.setVisible(true);
		
		
		 //String code = "{AATG,AGTT,GTGT,GTTT}";
        DirectedGraph<String, DefaultEdge> hrefGraph = Functions.createHrefGraph("test.txt");
        //System.out.println(Functions.isCyclic(hrefGraph));
        
         //code pour générer les fichiers textes
          
         /*try {
			Combi.S16();
			Combi.S256();
			Combi.S240();
			Combi.S12();
			Combi.S228();
			Combi.S114();
			Combi.S126();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        //System.out.println(hrefGraph.toString());

        //Functions.getL1("S12.txt");
        //Functions.createTree("S126.txt");
        //DefaultMutableTreeNode arbre = Functions.remplir(new DefaultMutableTreeNode(),3);
        ArrayList<String> array = Functions.arrayTetra126();
        for(int i = 0 ; i < array.size() ; i++)
        {
            //System.out.println(i+" : "+array.get(i));
        }
        System.out.println("debut");
        Functions.compteur(new DefaultMutableTreeNode(),4,array);
        System.out.println();
        System.out.println(Functions.COMPTEUR_GLOBAL);
        //DirectedGraph<String, DefaultEdge> g = Functions.createGraph("1,125,37,2,9,45,120", array);
        //System.out.println(g.toString());
        //System.out.println(arbre.getDepth());
        //Functions.parcourir(arbre);

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
