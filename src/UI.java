
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;

public class UI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JLabel labelTitle = new JLabel("Projet Algorithme de recherche", SwingConstants.CENTER);
	public JLabel labelAuthors = new JLabel("Abrantes - Bonnet - Lopez - Metzger - Nominé - Peuckert", JLabel.CENTER);
	public JLabel labelText = new JLabel("Entrez la taille du code (1-60) :");
	//public JLabel labelResult = new JLabel("Résultats :");

	SpinnerModel model = new SpinnerNumberModel(3, 1, 60, 1);
	JSpinner spinner = new JSpinner(model);
	
	public JButton buttonStart = new JButton("Commencer !");
	
	public JPanel panelTop = new JPanel();
	public JPanel panelCenter = new JPanel();
	public JPanel panelBottom = new JPanel();
	public JPanel panelForm = new JPanel();
	public JPanel panelResults = new JPanel();
	public JCheckBox chckbxEnregistrerLesRsultats = new JCheckBox("Enregistrer les résultats (results.txt)");
	//public JLabel textResults = new JLabel();
	public JLabel jl_res = new JLabel();
	
	public JLabel jl_temps_ecoule = new JLabel("Temps écoulé");
	
	public UI() {
		
		UIListener listener = new UIListener(this);
		panelBottom.add(jl_temps_ecoule);
		Font f = labelTitle.getFont();
		labelTitle.setFont(new Font(f.getName(), Font.PLAIN, 2*f.getSize()));
		panelTop.setBorder(new EmptyBorder(10, 5, 5, 5));
		
		panelTop.setLayout(new BorderLayout(0, 5));
		panelTop.add(labelTitle, BorderLayout.NORTH);
		
		
		JPanel panelSubTitle = new JPanel();
		panelSubTitle.setLayout(new BorderLayout(0, 15));
		panelSubTitle.add(labelAuthors, BorderLayout.NORTH);
		
		
		panelTop.add(panelSubTitle,  BorderLayout.CENTER);
		chckbxEnregistrerLesRsultats.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelSubTitle.add(chckbxEnregistrerLesRsultats, BorderLayout.SOUTH);
		
		buttonStart.addActionListener(listener);
		
		panelForm.add(labelText, BorderLayout.WEST);
		panelForm.add(spinner);
		panelForm.add(buttonStart);
		
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelCenter.add(panelForm, BorderLayout.NORTH);
		panelBottom.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panelBottom.setLayout(new BorderLayout(5, 0));
		//panelBottom.add(textResults, BorderLayout.NORTH);
		panelBottom.add(jl_temps_ecoule,BorderLayout.EAST);
		panelBottom.add(jl_res, BorderLayout.WEST);
		panelTop.add(panelCenter, BorderLayout.SOUTH);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelBottom, BorderLayout.CENTER);
		//panelBottom.add(textResults, BorderLayout.WEST);

		//this.add(panelText);
	}

}
