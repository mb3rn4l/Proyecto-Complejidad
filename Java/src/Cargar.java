/*
 * Dise�adores: Miguel Angel Bernal Colonia Codigo: 201153852 - 3743
 * 				Yeison Betancourt Solis Codigo: 201153328 - 3743 				
 * 				Andrea Mora Ospina Codigo: 201153685 - 3743
 * 
 * Instituto: Universidad del Valle - 06 Tulu�
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.*;

@SuppressWarnings("serial")
public class Cargar extends JFrame{

	private JLabel title = new JLabel("CARGAR");
	private JLabel labelDirectory = new JLabel("Archivo:");
	private JLabel routeDirectory = new JLabel("");
	private JLabel superviser = new JLabel();
	private JLabel problem = new JLabel("Problema: ");
	private JButton examine = new JButton("Examinar");
	private JTextArea textArea = new JTextArea(); 
	private JButton bExit = new JButton();
	private JButton bBack = new JButton();
	private JButton case1 = new JButton("VC <p HC");
	private JButton case2 = new JButton("HC <p TS");
	private JFileChooser archivo = new JFileChooser();
	
	String dato;
	
	CicloHamiltoniano CicloHamiltoniano = new CicloHamiltoniano();
			
	public Cargar(){
		
		setTitle("Configuracion");
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		Font font1 = new Font("Tahoma", 1, 30);
		Font font2 = new Font("Tahoma", 1, 12);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		
		getContentPane().add(title);
		getContentPane().add(labelDirectory);
		getContentPane().add(routeDirectory);
		getContentPane().add(superviser);
		getContentPane().add(examine);
		getContentPane().add(problem);
		getContentPane().add(scrollPane);
		getContentPane().add(bExit);
		getContentPane().add(bBack);		
		getContentPane().add(case1);
		getContentPane().add(case2);
		
		
		title.setBounds(225, 10, 500, 100);
		title.setFont(font1);
		examine.setBounds(240, 150, 100, 40);
		problem.setBounds(380, 80, 200, 40);
		scrollPane.setBounds(380, 120, 170, 170);
		labelDirectory.setBounds(210, 230, 80, 40);
		labelDirectory.setFont(font2);
		routeDirectory.setBounds(265, 230, 150, 40);
		routeDirectory.setFont(font2);
		case1.setBounds(120, 340, 100, 40);
		case2.setBounds(350, 340, 100, 40);
			
		ImageIcon img1 = new ImageIcon("img/supervisor.png");
		superviser.setIcon(img1);
		superviser.setBounds(20, 80, 200, 250);
		
		ImageIcon img2 = new ImageIcon("img/salir.png");		
		ImageIcon img3 = new ImageIcon("img/atras.png");	
		
		bExit.setIcon(img2);
		bExit.setBounds(430, 370, 150, 100);
		bExit.setOpaque(false);
		bExit.setContentAreaFilled(false);
		bExit.setBorderPainted(false);
		
		bBack.setIcon(img3);
		bBack.setBounds(30, 370, 70, 100);
		bBack.setOpaque(false);
		bBack.setContentAreaFilled(false);
		bBack.setBorderPainted(false);
		
		ManejoDeEventos eventos = new ManejoDeEventos();
		examine.addActionListener(eventos);
		bExit.addActionListener(eventos);
		bBack.addActionListener(eventos);
		case1.addActionListener(eventos);
		case2.addActionListener(eventos);
			
	}
	
	public int returnInt (String s) {
        int i = 0;

        try {
            i = Integer.parseInt(s.trim());
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return i;
    }
	
	private void Init(String fileName) {
        File f = new File(fileName);
        String line;
        int i,j;
        int tamMatrix;
        int [ ] [ ] matrix;
        int VC;
        
        problem.setText("Problema: Vertex Cover");
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            line = in.readLine();
            
            StringTokenizer st = new StringTokenizer(line);
        	tamMatrix = returnInt(st.nextToken());
        	
        	i = 0;
        	textArea.append(tamMatrix+"\n");
        	CicloHamiltoniano.setTamMatriz(tamMatrix);
        	
        	matrix = new int [tamMatrix] [tamMatrix];
                                   
            while ((line = in.readLine()) != null) {
            	j = 0;
            	if(i < tamMatrix){
            		textArea.append(line);  
            		StringTokenizer st3 = new StringTokenizer(line);
            		
            		while(j < tamMatrix){
            			matrix [i][j] =  returnInt(st3.nextToken());
            			j++;
            		}
            		
                	if(!line.startsWith(" ")){
                		textArea.append("\n");            	
                	}      
                	
                	i++;
            	}else{
            		StringTokenizer st2 = new StringTokenizer(line);
                	VC = returnInt(st2.nextToken());
            		textArea.append(line);
            		CicloHamiltoniano.setCH(VC);
            	}
            }   

            CicloHamiltoniano.setMatrix(matrix);        
            /*System.out.println(CicloHamiltoniano.getTamMatriz());
            System.out.println(CicloHamiltoniano.getMatrix().length);
            System.out.println(CicloHamiltoniano.getMatrix()[2][2]);
            System.out.println(CicloHamiltoniano.getVC());*/
            in.close();
        }
        catch (IOException e) { /* Handle exceptions */ }
    }
	
	public class ManejoDeEventos implements ActionListener{

		public void actionPerformed(ActionEvent eve) {
			
			if(eve.getSource().equals(bExit)){
				
				System.exit(0);				
			}
			
			if(eve.getSource().equals(bBack)){
				
		        VentanaPrincipal ventana = new VentanaPrincipal();
		        
		        ventana.setLocationRelativeTo(null);
		        ventana.setVisible(true);
				dispose();
				
			}
		
			if(eve.getSource().equals(examine)){
				
				File directory = new File("C:/Users/Yeison/Documents/Workspace/ProyectoComplejidad/datos");
				archivo.setCurrentDirectory(directory);
				int valor = archivo.showOpenDialog(Cargar.this);
				
				if(valor == JFileChooser.APPROVE_OPTION){
					dato = archivo.getName(archivo.getSelectedFile());				
				}

				textArea.setText("");
				routeDirectory.setText(dato);	
				Init("datos/"+dato);
				
			}
			
			if(eve.getSource().equals(case1)){

				problem.setText("Problema: Circuito Hamiltoniano");
				textArea.setText("Programando...");
				
			}
			
			if(eve.getSource().equals(case2)){

				problem.setText("Problema: Agente Viajero");
				textArea.setText("Programando...");
				
			}
			
		}
	
	} 
		
}
