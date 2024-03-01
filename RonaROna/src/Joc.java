import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Joc extends JPanel{
	
	//TODO button methods
	/**
	 * 
	 */
	
   Joc(int NrCol,int NrR,int NrVir) {
	   
		Tiles[][] apartamente=new Tiles[NrCol][NrR];
		int stare;
		Random random;
		int x,y,i,j;

		//este initializat blocul
		for(i=0;i<NrCol;i++)	
			for(j=0;j<NrR;j++)
			{
				apartamente[i][j]=new Tiles(i*40, j*40);
				apartamente[i][j].geam.setPreferredSize(new Dimension(40,35));
				add(apartamente[i][j].familie);
				add(apartamente[i][j].geam);
			}
		
	 //*oamenii din bloc constata ca au Covid
		for(i=0;i<NrVir;i++)		
				{
					random =new Random();
					x=random.nextInt(Meniu.NrCol);
					random =new Random();
					y=random.nextInt(Meniu.NrR);
					apartamente[x][y].rename("*");
				}
	
		for(i=0;i<NrCol;i++)	
			for(j=0;j<NrR;j++)
			{
				if(apartamente[i][j].isVir()==false)
				{
					stare=VeciniVir(i,j,apartamente);
					apartamente[i][j].rename(String.valueOf(stare));	//https://attacomsian.com/blog/java-convert-integer-to-string
				}
			}
	  
		for(i=0;i<NrCol;i++)	
			for(j=0;j<NrR;j++) 
			{
				apartamente[i][j].doSomething();
					
			}
		
   }
   
   

   
   
   //TODO functia VeciniVir
	/*	exista 3 cazuri de persoane care stiu despre vecinii lor (si nu au fost infestate)
	 * 		cei care stau la margine *care  au 5 vecini				//alte 4 cazuri
	 * 		cei din colturi *care stiu situatia a doar 3 vecini		//alte 4 cazuri
	 * 		restul *care stiu situatia celo 8 vecini din jurul lor	//1 caz
	 * */
   
private int VeciniVir(int x,int y,Tiles[][] a) {
	int ct=0;
	//x,y coord unui casute
	
	//colturile
	
	if(x==0&&y==0)
	{
		for(int i=0;i<=1;i++)
			for(int j=0;j<=1;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;	
	}
	if(x==0&&y==Meniu.NrR-1)
	{
		for(int i=0;i<=1;i++)
			for(int j=-1;j<=0;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;	
	}
	
	if(x==Meniu.NrCol-1&&y==0)
	{
		for(int i=-1;i<=0;i++)
			for(int j=0;j<=1;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	if(x==Meniu.NrCol-1&&y==Meniu.NrR-1)
	{
		for(int i=-1;i<=0;i++)
			for(int j=-1;j<=0;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	
	//marginile
	
	if(x==0 && (y!=0&&y!=Meniu.NrR-1))
	{
		for(int i=0;i<=1;i++)
			for(int j=-1;j<=1;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	if(x==Meniu.NrCol-1 && (y!=0&&y!=Meniu.NrR-1))
	{
		for(int i=-1;i<=0;i++)
			for(int j=-1;j<=1;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	if((x!=0&&x!=Meniu.NrCol-1) && y==0)
	{
		for(int i=-1;i<=1;i++)
			for(int j=0;j<=1;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	if((x!=0&&x!=Meniu.NrCol-1) && y==Meniu.NrR-1)
	{
		for(int i=-1;i<=1;i++)
			for(int j=-1;j<=0;j++)
				if(a[x+i][y+j].isVir()==true)	ct++;
		return ct;
	}
	
	
for(int i=-1;i<=1;i++)
	for(int j=-1;j<=1;j++)
		if(a[x+i][y+j].isVir()==true)	ct++;
	
return ct;
}
   
   
/*	
 // versiunea 1
   private int VeciniVir(int x, int y, Tiles[][] a) {

	
		int minI,maxI,minJ,maxJ;	//delimirea matricei de vecini ale caror dituatii sunt stiute
		
		if(x==0) {	//primul rand
			minJ=0;
			maxJ=1;
			 
			if(y==0) 	{
				minI=0;	//coltul din stanga sus este chiar persoana
				maxI=1;	//coltul din dreapta jos este primul vecin de pe diagonala
			}
			else
				{
				if(y==Meniu.NrR-1) 	{
					minI=-1;
					maxI=0;
					}	//pana aici e bine
				else	{	
					minI=-1;	
					maxI=1;
				}
			}
		}
		else {
			if(x==Meniu.NrCol-1){	//ultimul rand
				minJ=-1;
				maxJ=0;
				
				if(y==0) {
					minI=0;
					maxI=1;
				}
				else {
					if(y==Meniu.NrR-1) {
						minI=-1;	
						maxI=0;
					}
					else	{
						minI=-1;	
						maxI=1;
					}
				}
			}
			else	
			{
				minI=-1;maxI=1;
				if(y==0) {
					minJ=0;maxJ=1;
				}
				else if(y==Meniu.NrR-1) 	{minJ=-1;maxJ=0;}
					else	{
						minJ=-1;	
						maxJ=1;
					}
			}
		}
					
		int ct=0;
		for(int I=minI;I<=maxI;I++)
			for(int J=minJ;J<=maxJ;J++)
				if(a[x+I][y+J].isVir()==true)	ct=ct+1;
		return ct;
	}
*/

}



 
   

