import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import javax.swing.JOptionPane;

public class Masa {
   private int masaNo;
   public int locationX;
   public int locationY;
	   Masa(int masaNo,int locationY,int locationX)
	   {
		    this.masaNo = masaNo;
		    this.locationY = locationY;
		    this.locationX = locationX;
	   }
	   
   
  public static void masaAdd(ArrayList<Masa> masaList,Masa masa,Musteri musteri)
  {     
	  synchronized (Problem1Page.lockAdd) {
		  int emptyMasaSize = masaList.size();
	     masaList.add(masa);
	     if(emptyMasaSize == 0)
	     {
	    	 synchronized(Problem1Page.lockRemove)
	    	 {
	    		    Problem1Page.isNotifyed = true;
	    		    Problem1Page.lockRemove.notifyAll();
	    		    
	    	 }
	     }
	  }	  
  }
  public static  Masa  masaRemove(ArrayList<Masa> masaList,int index,Musteri musteri)
  {
	  
	  synchronized ( Problem1Page.lockRemove) {
	  if(masaList.size() <= 0 )
	  {
                   Useful.bufferWrite(Problem1Page.filePath,"-> "+musteri.getIdNum()+" . musteri bos masa bekliyor", true);  
		  try {    
            	 Problem1Page.lockRemove.wait(Problem1Page.musteriBeklemeSure);
            	 int masaSize= masaList.size();
            	 if(!Problem1Page.isNotifyed)
            	 {
            		  System.out.println("musteri Ayrildi ve masaSize => "+masaSize);
            		  Useful.bufferWrite(Problem1Page.filePath,"->"+musteri.getIdNum() + " .musteri yeterince bekledigi için restorandan ayrıldı ...",true);
            		  Problem1Page.musteriSay --;
    	    		  Problem1Page.dynamicMusteriSay --;
            		  return null;
            	 }
            	
            	 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
          return  Masa.masaRemove(masaList, index, musteri);
           
	  }
	  Masa tmp = masaList.remove(index);
	  int siparisiAlinmayanMasaSize = Problem1Page.siparisiAlinmayanlarList.size();
	  ArrayList<Object> tmpList = new ArrayList<Object>();
	  tmpList.add(tmp);
	  tmpList.add(musteri);
	  Problem1Page.siparisiAlinmayanlarList.add(tmpList);
	  synchronized(Problem1Page.lockSiparisAlma)
	  {
		   Problem1Page.lockSiparisAlma.notifyAll();
	  }	    
	    Useful.bufferWrite(Problem1Page.filePath,"->"+musteri.getIdNum() + " .musteri "+ tmp.masaNo+" .masaya oturdu ",true);
        Problem1Page.isNotifyed = false;
		return tmp;
	  }
	  }
  
	   
  public int getMasaNo()
   {
	   return masaNo;
   }
   
	
} 
