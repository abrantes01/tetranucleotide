
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.JCheckBox;

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
	public JPanel panelResults = new JPanel();
	private final JCheckBox chckbxEnregistrerLesRsultats = new JCheckBox("Enregistrer les résultats (results.txt)");
	
	
	public UI() {
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
		panelBottom.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		panelBottom.setLayout(new BorderLayout(5, 0));
		panelBottom.add(labelResult, BorderLayout.NORTH);
		
		panelTop.add(panelCenter, BorderLayout.SOUTH);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelBottom, BorderLayout.CENTER);
		

		
		JPanel panelScroll = new JPanel();
		panelScroll.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelScroll.setLayout(new BorderLayout(0, 0));

		JTextArea textResults = new JTextArea(16, 58);
		textResults.setText("totototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\ntotototototototototototo\n");
		textResults.setEditable(false);
		JScrollPane scroll = new JScrollPane(textResults);
		scroll.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		panelScroll.add(scroll);
		
		
		panelBottom.add(panelScroll);
		//this.add(panelText);
		
		// Lecture du son modem.mp3
		try {
			InputStream in = new FileInputStream("modem.wav");
			AudioStream as = new AudioStream(in);         
			AudioPlayer.player.start(as);            
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

}
