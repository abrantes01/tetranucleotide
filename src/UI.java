
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class UI extends JFrame {
	
	public JLabel labelTitle = new JLabel("Projet Algorithme de recherche", SwingConstants.CENTER);
	public JLabel labelAuthors = new JLabel("Abrantes - Bonnet - Lopez - Metzger - Nominé - Peuckert", JLabel.CENTER);
	public JLabel labelText = new JLabel("Entrez la taille du code (1-60) :");
	public JLabel labelResult = new JLabel("Résultats :");
	
	SpinnerModel model = new SpinnerNumberModel(5, 1, 60, 1);
	JSpinner spinner = new JSpinner(model);
	
	public JButton buttonStart = new JButton("Commencer !");
	public JProgressBar progressBar = new JProgressBar();
	
	public JPanel panelTop = new JPanel();
	public JPanel panelCenter = new JPanel();
	public JPanel panelBottom = new JPanel();
	public JPanel panelForm = new JPanel();
	public JPanel panelProgressBar = new JPanel();
	
	public UI() {
		Font f = labelTitle.getFont();
		labelTitle.setFont(new Font(f.getName(), Font.PLAIN, 2*f.getSize()));
		panelTop.setBorder(new EmptyBorder(10, 5, 5, 5));
		
		panelTop.setLayout(new BorderLayout(15, 15));
		panelTop.add(labelTitle, BorderLayout.NORTH);
		panelTop.add(labelAuthors, BorderLayout.CENTER);
		
		panelForm.add(labelText, BorderLayout.WEST);
		panelForm.add(spinner);
		panelForm.add(buttonStart);
		
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelCenter.add(panelForm, BorderLayout.NORTH);
		panelProgressBar.setBorder(new EmptyBorder(10, 10, 0, 10));

		progressBar.setPreferredSize(new Dimension(0, 20));
		
		panelProgressBar.setLayout(new BorderLayout(5, 0));
		panelProgressBar.add(progressBar);
		panelCenter.add(panelProgressBar);
		panelBottom.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		panelBottom.setLayout(new BorderLayout(5, 0));
		panelBottom.add(labelResult, BorderLayout.NORTH);
		
		panelTop.add(panelCenter, BorderLayout.SOUTH);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelBottom, BorderLayout.CENTER);
		//this.add(panelText);
	}

}
