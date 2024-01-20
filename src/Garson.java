import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Garson extends Thread{
    private int idNo;
    public int locationX;
    public int locationY;
	public Garson(int idNo) {
		   this.idNo = idNo;
		   
	}
	
	@Override
	public void run() {
		siparisAlma();
	}
   
	
	public void siparisAlma()
	{
	  while (true)
		{
		  int siparisiAlinanlarSay = 0;
		synchronized(Problem1Page.lockSiparisAlma)
	       {
	    	  if(Problem1Page.siparisiAlinmayanlarList.size() <=  0 )
	    	  {
	    		 try {
					Problem1Page.lockSiparisAlma.wait(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
	    		  if(Problem1Page.dynamicMusteriSay == 0)
	    		  {
	    			  return ;
	    		  }

	    		  continue;
	    	  }
	    	  else {
	    		  siparisiAlinanlarSay =Problem1Page.siparisiAlinanlarList.size();
	    		  ArrayList<Object> siparisiAlinmayanMasa =Problem1Page.siparisiAlinmayanlarList.remove(0);	
	              Image i = new ImageIcon(Problem1Page.problem1.getClass().getResource("garson.png")).getImage();
	              this.locationY = ((Masa)siparisiAlinmayanMasa.get(0)).locationY;
	              this.locationX =	((Masa)siparisiAlinmayanMasa.get(0)).locationX-1;	  
	              Problem1Page.middlePlace.get(((Masa)siparisiAlinmayanMasa.get(0)).locationY).get(((Masa)siparisiAlinmayanMasa.get(0)).locationX-1).setIcon(new ImageIcon(i));
	    		  Problem1Page.middlePanel.updateUI();
	              Problem1Page.siparisiAlinanlarList.add(siparisiAlinmayanMasa);
	            	 Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNo + " no'lu garson " + ((Masa) siparisiAlinmayanMasa.get(0)).getMasaNo()+" nolu masadan "+((Musteri) siparisiAlinmayanMasa.get(1)).getIdNum()+ " no'lu müsterinin siparisini aldı",true);

	            	 if(siparisiAlinanlarSay <= 0 )
	      			{
	      				synchronized(Problem1Page.lockYemekHazirlama)
	      				{
	      					Problem1Page.lockYemekHazirlama.notifyAll();
	      				}
	      			}
	    	  }
	    	
		}
		try {
			Thread.sleep(Problem1Page.siparisAlmaSure);
            Problem1Page.middlePlace.get(this.locationY).get(this.locationX).setIcon(null);
            Problem1Page.middlePanel.updateUI();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
    	 
	}
	           
	}
	  
	 public int getIdNo()
	 {
		  return idNo;
	 }
	 
	 public void setIdNo(int idNo)
	 {
		  this.idNo = idNo;
	 }
	
}
