import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.*;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

public class Combi {
	
  public static void S256() throws FileNotFoundException {
	PrintWriter writer = new PrintWriter("S256.txt");

    ICombinatoricsVector<String> originalVector = Factory.createVector(new String[] { "A", "C", "G", "T" });

    // Create the generator by calling the appropriate method in the Factory class.
    // Set the second parameter as 4, since we will generate 4-elemets permutations
    Generator<String> gen = Factory.createPermutationWithRepetitionGenerator(originalVector, 4);

    // Print the result
    for (ICombinatoricsVector<String> perm : gen) {
    	String res = "";
    	for (String str : perm) {
    		res = res + str;
    	}
    	System.out.println( res );
    	writer.println(res);
    }
    writer.close();
  }
  
  
}
