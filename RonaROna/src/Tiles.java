import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Tiles {

	public JButton geam;
	public JLabel familie=new JLabel();	
	
	//TODO contructor
	public Tiles(int x,int y) {
		familie.setText(" ");
		geam=new JButton(" ");
		geam.setBounds(x, y, 30, 30);
		familie.setBounds(x, y, 30, 30);
		geam.setVisible(true);
		familie.setVisible(false); 
		
		Border border = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(10,16,10,17);
		familie.setBorder(new CompoundBorder(border, margin));
		
	}
	
	/*
	//situatia de imbolnavire= bolnav
	public Tiles(String bolnav) {
		familie.setText(bolnav);
		geam=new JButton(" ");
	}
	
	public void setBounds(int x,int y,int width, int height) {
		geam.setBounds(x, y, width, height);
		familie.setBounds(x, y, width, height);
	}
	

	public void setVisible(boolean DaOriBa) {
		geam.setVisible(DaOriBa);
		familie.setVisible(DaOriBa);
	}
	*/
	
	public boolean isVir() {
		if(familie.getText()=="*")
			return true;
		return false;
	}
	
	public void rename(String stareNoua) {
		familie.setText(stareNoua);
		if(stareNoua=="*")
		{
			familie.setForeground(Color.RED);
		}
			
	}
	 
	public void doSomething(){
		geam.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				//geam.setText(familie.getText());
				Meniu.NrB++;
				geam.setEnabled(false);
				geam.setVisible(false);
				familie.setVisible(true);
				if(isVir()==true) {
					JOptionPane.showMessageDialog(null, "Oh nu, ati luat contact direct cu virusul! Ati pierdut!"+'\n'+" Doriti sa jucati inca o data?", "AtiPierdut!", JOptionPane.WARNING_MESSAGE);
					Meniu.JF2.dispose();
					Meniu.main(null);
				}
					if(Meniu.NrB==Meniu.NrCol*Meniu.NrR-Meniu.NrVir) {
					JOptionPane.showMessageDialog(null, "Ati descoperit totii bolnavii de Covid-19 din bloc! DSP va multumeste! FELICITARI!"+'\n'+"Doriti sa mai jucati inca o data?", "Ati castigat!", JOptionPane.YES_OPTION);
					Meniu.JF2.dispose();
					Meniu.main(null);
				}
				
					}
				
	          
		});
		
	}
	
}
