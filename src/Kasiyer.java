import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Kasiyer extends Thread{
   
	private int idNo ; 
    public int locationX;
    public int locationY;
    public Kasiyer(int idNo,int locationY,int locationX) {
    	  this.idNo = idNo;
    	  this.locationY = locationY;
    	  this.locationX = locationX;
    }
	
	@Override
	public void run() {
		 odemeIslemiAlma();
	}

	 public void odemeIslemiAlma()
	 {
		  while (true)
			{
			synchronized(Problem1Page.lockOdeme)
		       {
		    	  if(Problem1Page.yemegiBitenlerList.size() <=  0 )
		    	  {
		    		 try {
						Problem1Page.lockOdeme.wait(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
		    		  if(Problem1Page.dynamicMusteriSay == 0)
		    		  {	    
		    			     synchronized(Problem1Page.lockSystem)
		    			     {
		    			    	 if(Problem1Page.senaryoStep == Problem1Page.senaryoList.size())
		    			    	 {
		    			    		 Problem1Page.senaryoStep = 0;
		    			    		 Problem1Page.senaryoList.clear();
		    			    		Problem1Page. middlePanel.removeAll();;
		    			    		Problem1Page. ascıPanel.removeAll();;
		    			    		Problem1Page.  kasaPanel.removeAll();
		    			    		Problem1Page.middlePanel.updateUI();
		    			    		Problem1Page.ascıPanel.updateUI();
		    			    		Problem1Page.kasaPanel.updateUI();
		    			    		Problem1Page.isStart = false; 
		    			    		return;
		    			    	 }
		    					 Useful.bufferWrite(Problem1Page.filePath,+ (Problem1Page.senaryoStep)+". Senaryo Bitti ",true);	 
		    			    	 Useful.bufferWrite(Problem1Page.filePath,"**************************************************************",true);
		    			    	 Problem1Page.senaryoStep ++;
		    			    	 JOptionPane.showMessageDialog(Problem1Page.problem1,(Problem1Page.senaryoStep)+". Senaryo Baslıyor => Musteri Sayisi : "+Problem1Page.senaryoList.get(Problem1Page.senaryoStep-1)[1]);   
		    			    	 Problem1Page.problem1Run(Problem1Page.senaryoStep-1);
		    			     }
		    			  return ;
		    		  }
		    	      continue;
		    	  }
		    	  else {
		    		  ArrayList<Object> yemegiBiten   = Problem1Page.yemegiBitenlerList.remove(0);
		    		  Image i = new ImageIcon(Problem1Page.problem1.getClass().getResource("human.png")).getImage();
		    		  Problem1Page.middlePlace.get(((Masa) yemegiBiten.get(0)).locationY-1).get(((Masa) yemegiBiten.get(0)).locationX).setIcon(null);
		    		  Problem1Page.bottomRightPlace.get(this.locationY-1).get(this.locationX).setIcon(new ImageIcon(i));
					  Problem1Page.middlePanel.updateUI();
					  Problem1Page.kasaPanel.updateUI();
		    		  Problem1Page.odemeYapanlarList.add(yemegiBiten);
					  Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNo + " no'lu kasiyer" + ((Masa) yemegiBiten.get(0)).getMasaNo()+" nolu masadan "+((Musteri) yemegiBiten.get(1)).getIdNum() + " nolu müsterinin ödemesini aldı",true);
					  Useful.bufferWrite(Problem1Page.filePath,"->"+((Masa) yemegiBiten.get(0)).getMasaNo() + " nolu masadan "+ ((Musteri) yemegiBiten.get(1)).getIdNum()+" nolu müsteri ayrıldı",true);

		    	  }
			}
			try {
				Thread.sleep(Problem1Page.odemeSure);
	    		  Problem1Page.bottomRightPlace.get(this.locationY-1).get(this.locationX).setIcon(null);
	    		  Problem1Page.kasaPanel.updateUI();
	    		  Problem1Page.musteriSay --;
	    		  Problem1Page.dynamicMusteriSay --;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}  
	 }
	
}
