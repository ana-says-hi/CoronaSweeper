
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Meniu {
		static int NrCol=0;	//nr care parcurge coloanele
		static int NrR=0;	//nr care parcurge randurile
		static int NrVir=0;
		static int NrB=0;
		static JFrame JF2;
		static String numeBloc;
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame JF1=new JFrame("RonaROna");
		JPanel JP=new JPanel();
		JF1.setSize(400, 400);
		JF1.setVisible(true);
		JF1.setContentPane(JP);

		JLabel Lpov1 = new JLabel("Bun venit in Orasel!");
		
		JLabel Lpov2 = new JLabel("<html> Momentan ne aflam intr-o pandemie. In <br>"
				+" blocul acesta se afla multe familii.<br>"
				+ "Directia de Sanatate va cere ajutorul <br>"
				+ "pentru a afla in ce apartamente se afla <br>"
				+ "persoane infectate cu noua boala. <br>");
		
		
		Lpov1.setFont(new Font("Verdana", Font.PLAIN, 24));
		Lpov2.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		Lpov1.setHorizontalAlignment(SwingConstants.LEFT);
		Lpov2.setHorizontalAlignment(SwingConstants.RIGHT);
		JF1.add(Lpov1);
		JF1.add(Lpov2);
		
		JLabel Ldiff=new JLabel("Alegeti nivelul de dificultate:");
		Ldiff.setBounds(50, 180, 300, 50);
		Ldiff.setFont(new Font("Verdana", Font.BOLD, 16));
		
		
		JF1.add(Ldiff);
		Ldiff.setVisible(true);
		
		//butoanele radio
		JRadioButton r1=new JRadioButton("A) Incepator (7x7)");    
		JRadioButton r2=new JRadioButton("B) Intermediar (9x9)"); 
		JRadioButton r3=new JRadioButton("C) Expert (12x12)");
		JRadioButton r4=new JRadioButton("D) Bloc (7x9)");
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);   

		JF1.add(r1);JF1.add(r2);JF1.add(r3);JF1.add(r4);  

		r1.setBounds(75,170,160,50);
		r2.setBounds(75,205,160,50);
		r3.setBounds(75,240,160,50);
		r4.setBounds(75,275,160,50);
		
		r1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			// nr de coloane si nr de randuri devin 9  
				NrCol=7;
				NrR=7;
				NrVir=7;
				numeBloc="Scara 1";
			        }  
			    });
		r2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			// nr de coloane si nr de randuri devin 16 
				NrCol=9;
				NrR=9;
				NrVir=30;
				numeBloc="Scara 2";
			        }  
			    }); 
		r3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			// nr de coloane si nr de randuri devin 24  
				NrCol=12;
				NrR=12;
				NrVir=8*12;
				numeBloc="Scara 3";
			        }  
			    }); 
		r4.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			// nr de coloane devine 9 nr de randuri devine 24  
				NrCol=9;	//nr de randuri
				NrR=7; 		//nr de coloane
				NrVir=9*4;
				numeBloc="Scara 4";
			        }  
			    }); 
		
		
		//Butonul de start
		JButton B1= new JButton("Start");
		JP.add(B1);
		B1.setBounds(250, 225, 100, 50);
		B1.setVisible(true);
		
		B1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if(NrCol!=0)
				{
					JF1.dispose();
					JF2=new JFrame(numeBloc);
					JF2.setSize(NrR*50-10,NrCol*50-10);
					JF2.setVisible(true);
					Joc JP2 = new Joc(NrCol,NrR,NrVir);			
					JF2.setContentPane(JP2);
				}
				
			        }  
			    });  
		
		
	}

}
