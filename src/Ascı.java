import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ascı extends Thread{
     
	private int idNo;
	public int locationX;
	public int locationY;
	public Ascı(int idNo,int locationY,int locationX)
	{
		 this.idNo = idNo; 
		 this.locationX = locationX;
		 this.locationY = locationY;
    }
	@Override
	public void run() {
		  siparisHazirlama();
	}

	public void siparisHazirlama()
	{
		while (true)
		{
		synchronized(Problem1Page.lockYemekHazirlama)
	       {
	    	  if(Problem1Page.siparisiAlinanlarList.size() <=  0 )
	    	  {
	    		 try {
					Problem1Page.lockYemekHazirlama.wait(10000);
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
	    		   System.out.println("ascı location x : "+this.locationX + " y : "+this.locationY);
	    		  ArrayList<Object>   siparisiAlinanMasa =Problem1Page.siparisiAlinanlarList.remove(0);
	    		  Image i = new ImageIcon(Problem1Page.problem1.getClass().getResource("chef.png")).getImage();
	    		  Problem1Page.bottomLeftPlace.get(this.locationY).get(this.locationX).setIcon(new ImageIcon(i));
	    		  Problem1Page.ascıPanel.updateUI();
	    		   Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNo + " no'lu ascı " +((Masa) siparisiAlinanMasa.get(0)).getMasaNo() + " no'lu masadan " + ((Musteri) siparisiAlinanMasa.get(1)).getIdNum() +" no'lu müsterinin siparisini hazirladi",true);
	    		   Problem1Page.siparisiHazirlananlarList.add(siparisiAlinanMasa);
		    	     synchronized((Musteri) siparisiAlinanMasa.get(1))
	  { 
		    	    	 ((Musteri) siparisiAlinanMasa.get(1)).notify();
	  }
	 		       if(Problem1Page.siparisiAlinanlarList.size() >= 1 )
		    	       {   	    	   
	 		    	  siparisiAlinanMasa = Problem1Page.siparisiAlinanlarList.remove(0);  
		    		       Problem1Page.siparisiHazirlananlarList.add(siparisiAlinanMasa);
		    		       Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNo + " no'lu ascı " +((Masa) siparisiAlinanMasa.get(0)).getMasaNo() + " no'lu masadan " + ((Musteri) siparisiAlinanMasa.get(1)).getIdNum() +" no'lu müsterinin siparisini hazirladi",true);
		    		       synchronized((Musteri) siparisiAlinanMasa.get(1))
		    	    	     { 
		    	    	 ((Musteri) siparisiAlinanMasa.get(1)).notify();
		    	    	     }
		    	       }
	    	  }
		}
		  try {
					Thread.sleep(Problem1Page.yemekHazirlamaSure);	 
		    		  Image i = new ImageIcon(Problem1Page.problem1.getClass().getResource("ocak.png")).getImage();
		    		  Problem1Page.bottomLeftPlace.get(this.locationY).get(this.locationX).setIcon(new ImageIcon(i));
		    		  Problem1Page.ascıPanel.updateUI();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	 
	}
	           
	}
	
}
