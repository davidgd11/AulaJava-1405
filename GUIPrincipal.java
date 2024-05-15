package br.com.fiap.main;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class GUIPrincipal extends JFrame{
	
	private Container contentPane;
	private JMenuBar mnBarra;
	private JMenu mnArquivo, mnGeometria;
	private JMenuItem miSair, miAreas;
	
	public GUIPrincipal() {
		inicializarComponentes();
		definirEventos();
	}
	
	public void inicializarComponentes() {
		setTitle("Janela Principal");
		setBounds(0,0,600,400);
		contentPane = getContentPane();
		
		mnBarra = new JMenuBar();
		mnArquivo = new JMenu("Arquivo");
		mnArquivo.setMnemonic('A');
		mnGeometria = new JMenu("Geometria");
		mnGeometria.setMnemonic('G');
		miAreas = new JMenuItem("Áreas");
		miSair = new JMenuItem("Sair", new ImageIcon(getClass().getResource("../images/exit_icon.png")));
		
		setJMenuBar(mnBarra);
		mnBarra.add(mnArquivo);
		mnBarra.add(mnGeometria);
		mnArquivo.add(miSair);
		mnGeometria.add(miAreas);
		
	}
	
	public void definirEventos() {
		miSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		miAreas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIAreas areas = new GUIAreas();
				contentPane.removeAll();
				contentPane.add(areas);
				contentPane.validate();
			}
		});
	}
	
	public static void main(String[] args) {
		GUIPrincipal frame = new GUIPrincipal();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(tela.width - frame.getWidth()/2, (tela.height - frame.getHeight()/2));
		frame.setVisible(true);
	}
	

}
