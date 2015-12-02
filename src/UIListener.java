import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class UIListener implements ActionListener {
	public static Result res = new Result();
	UI ui;
	
	public UIListener(UI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//
		// TODO Auto-generated method stub
		
        //DirectedGraph<String, DefaultEdge> hrefGraph = Functions.createHrefGraph("test.txt");
        ArrayList<String> array = Functions.arrayTetra126();
       
        
        int n = (Integer) ui.model.getValue();
		ui.textResults.setText("Starting with l = "+ n);
		//System.out.println(ui.textResults.getText());

		// Lecture du son modem.mp3
		try {
			InputStream in = new FileInputStream("modem.wav");
			AudioStream as = new AudioStream(in);         
			AudioPlayer.player.start(as);            
		}	
		catch(Exception ex){
			System.out.println(ex);
		}
		
        /*Test.compteur_aux(new DefaultMutableTreeNode(), n, array);
        ui.jl_res.setText("Résultat : "+ res.total().toString());*/
		Functions.compteur(new DefaultMutableTreeNode(), n, array);
        ui.jl_res.setText("Résultat : "+ Functions.COMPTEUR_GLOBAL);
        //Functions.COMPTEUR_GLOBAL = new BigInteger("0");
        //System.out.println(Functions.COMPTEUR_GLOBAL);
		
	}

}
