import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    	//System.out.println( res );
    	writer.println(res);
    }
    writer.close();
  }
  
  public static void S16() throws FileNotFoundException {  
	  PrintWriter writer = new PrintWriter("S16.txt");
	  FileReader input;
		try {
			input = new FileReader("S256.txt");
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
				
				if ((myLine.charAt(0) == myLine.charAt(2))&&(myLine.charAt(1) == myLine.charAt(3))) {
					writer.println(myLine);
				}	
			}
      }
      catch (IOException e) {
			e.printStackTrace();
		}
      writer.close();
  }
  
  public static void S240() throws FileNotFoundException {
	  
	  PrintWriter writer = new PrintWriter("S240.txt");
	  FileReader input;
		try {
			input = new FileReader("S256.txt");
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
				
				if ((myLine.charAt(0) != myLine.charAt(2))||(myLine.charAt(1) != myLine.charAt(3))) {
					writer.println(myLine);
				}	
			}
      }
      catch (IOException e) {
			e.printStackTrace();
		}
      writer.close();
  }
  
  public static void S12() throws FileNotFoundException {
	  
	  PrintWriter writer = new PrintWriter("S12.txt");
	  FileReader input;
		try {
			input = new FileReader("S240.txt");
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
				
				if(Functions.isAutocomplementary(myLine)) {
					writer.println(myLine);
				}
			}
      }
      catch (IOException e) {
			e.printStackTrace();
		}
      writer.close();
	  
  }
  
public static void S228() throws FileNotFoundException {
	  
	  PrintWriter writer = new PrintWriter("S228.txt");
	  FileReader input;
		try {
			input = new FileReader("S240.txt");
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
				
				if(!Functions.isAutocomplementary(myLine)) {
					writer.println(myLine);
				}
			}
      }
      catch (IOException e) {
			e.printStackTrace();
		}
      writer.close();
	  
  }
	public static void S114() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter("S114.txt");
		List<String> l228 = new ArrayList<String>();
		List<String> l114 = new ArrayList<String>();
		  FileReader input;
			try {
				input = new FileReader("S228.txt");
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
					
					if(!Functions.isAutocomplementary(myLine)) {
						l228.add(myLine);
					}
				}
	      }
	      catch (IOException e) {
				e.printStackTrace();
			}
	      
	      for (String tetra:l228) {
	    	  if(!l114.contains(Functions.complementary(tetra))) {
	    		  l114.add(tetra);
	    	  }
	      }
	      for (String tetra : l114) {
	    	  writer.println(tetra);
	      }
	      writer.close();
	}
	
	public static void S126() throws FileNotFoundException {
		  List<String> l126 = new ArrayList<String>();
		  PrintWriter writer = new PrintWriter("S126.txt");
		  FileReader input;
		  FileReader input2;
			try {
				input = new FileReader("S114.txt");
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
					l126.add(myLine);
				}
	      }
	      catch (IOException e) {
				e.printStackTrace();
			}
	      
	      try {
				input2 = new FileReader("S12.txt");
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				input2 = null;
				e.printStackTrace();
			}
	      bufRead = new BufferedReader(input2);
	      try {
				while ((myLine = bufRead.readLine()) != null) {
					l126.add(myLine);
				}
	      }
	      catch (IOException e) {
				e.printStackTrace();
			}
	      //on trie la liste par ordre lexicographique
	      Collections.sort(l126);
	      for (String tetra : l126) {
	    	  writer.println(tetra);
	      }
	      writer.close();
	}
  
}
