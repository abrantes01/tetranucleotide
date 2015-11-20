import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import org.jgrapht.*;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.graph.*;

public class Main {

	public static void main(String[] args) {
		
		 //String code = "{AATG,AGTT,GTGT,GTTT}";
        DirectedGraph<String, DefaultEdge> hrefGraph = Functions.createHrefGraph("test.txt");
        System.out.println(Functions.isCyclic(hrefGraph));
        
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println(hrefGraph.toString());  
        //System.out.println(complementary("AACT"));
        //System.out.println(Functions.isAutocomplementary("AACT"));
	}

}
