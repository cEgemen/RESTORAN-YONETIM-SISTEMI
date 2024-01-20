import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Musteri extends Thread{
     
	private int idNum ;
	public int locationX;
	public int locationY;
	private Masa emptyMasa;
	public ArrayList<Masa> masaList ;
	public Musteri(int idNum,ArrayList<Masa> masaList)
	{
		this.idNum = idNum;
		this.masaList = masaList;
	}
	
	@Override
	public void run() {
		synchronized(this) {
			Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNum + " Musteri Restorana Geldi",true);
		  boolean result =	masaSecim();
			if(result == false)
			{
				return;
			}
		  try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNum + " Musteri Yemegi Geldi",true);
			yemekYeme();
		}
		
	}
   
	public boolean masaSecim()
	{
	    emptyMasa = Masa.masaRemove(masaList,0,this);
        if(emptyMasa == null)
        {
        	return false;
        }
	    Image i = new ImageIcon(Problem1Page.problem1.getClass().getResource("human.png")).getImage();
        Problem1Page.middlePlace.get(emptyMasa.locationY-1).get(emptyMasa.locationX).setIcon(new ImageIcon(i));
        Problem1Page.middlePanel.updateUI();
	    return true;
	}
	
	public void yemekYeme()
	{
		  try {
				Thread.sleep(Problem1Page.yemekYemeSure);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  ArrayList<Object> yemegiBiten = new ArrayList<Object>();
		  yemegiBiten.add(emptyMasa);
		  yemegiBiten.add(this);
		  int bitirenSay =  Problem1Page.yemegiBitenlerList.size();
		  synchronized(Problem1Page.lockBitis)
		  {
			  Problem1Page.yemegiBitenlerList.add(yemegiBiten);
		  }
		  Useful.bufferWrite(Problem1Page.filePath,"->"+this.idNum +" nüsteri yemegini bitirdi", true);
		  Masa.masaAdd(masaList, emptyMasa,this);
		  if(bitirenSay <= 0)
		  {
			  synchronized(Problem1Page.lockOdeme)
			  {
				  Problem1Page.lockOdeme.notifyAll();
			  }
		  }
		  
	}
	
	public int getIdNum() {
		return idNum;
	}

	public void setId(int idNum) {
		this.idNum = idNum;
	}
      
  
   
	
}
