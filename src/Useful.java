import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Useful {
       
	
	  public static void creatingPlace(String url , JPanel panel ,JFrame frame ,int count,int row,int col) {
		  int syc=0;
		  for ( int i = 1  ;  i <= row ; i++)
	       {
			  ArrayList<JButton> rowItems = new ArrayList<JButton>();
			  for(int j =1 ;j<=col ; j++)
			  {
				 JButton btn = new JButton();
				 Useful.btnDefault(btn);
	    	     if(j % 2 == 0  && i % 2 == 0 && syc < count && url == "masa.png")
	    	     {	    		    	 
	    	    	 Image img = new ImageIcon(frame.getClass().getResource(url)).getImage();
		    	     btn.setIcon(new ImageIcon(img));
		    	     syc ++ ;
	    	     }
	    	     if( i % 2 == 0 && syc < count && url !="masa.png")
	    	     {
	    	    	 Image img = new ImageIcon(frame.getClass().getResource(url)).getImage();
		    	     btn.setIcon(new ImageIcon(img));
		    	     syc ++ ; 
	    	     }
	    	     rowItems.add(btn);
	    	     panel.add(btn);
			  }  
			  if(url == "kasa.png")
			  {
				  Problem1Page.bottomRightPlace.add(rowItems);
			  }
			  else if(url == "masa.png")
			  {
				  Problem1Page.middlePlace.add(rowItems);
			  }
			  else if(url == "ocak.png")
			  {
				  Problem1Page.bottomLeftPlace.add(rowItems);
			  }
			  }
		  panel.updateUI();
	  }

	  public static int generateRow(int count,String type)
	  {
		 
		  if(type == "masa")
		  {
			  int bol = count / 40;
			  
			  return 10+(10*bol);  
		  }
		  else {
			  int bol = count / 16;
			 return 4+(4*bol);  
		  }
		  
	  }
	  
	  public static int generateCol(int count,String type)
	  {
		  if(type == "masa")
		  {
			  return 16;
		  }
		  else {

			  return 8;
		  }
	  }
	  
	  public static void garsonOperations(ArrayList<Garson> garsonList,String operationType,int count)
	  {
		    for(int i = 0 ; i< count ; i++)
		    {  
		    	  if(operationType == "start")
		    	  {
		    		  garsonList.get(i).start();
		    	  }
		    	  else if (operationType == "join")
		    	  {
		    		  try {
						garsonList.get(i).join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		    	  else if (operationType == "add")
		    	  {
		    		  garsonList.add(new Garson(i+1));
		    	  }
		    }
	  }
	  public static void asciOperations(ArrayList<Ascı> asciList,String operationType,int count,int row , int col)
	  {
		 if(operationType != "add") {
		  for(int i = 0 ; i< count ; i++)
		    {  
		    	  if(operationType == "start")
		    	  {
		    		  asciList.get(i).start();
		    	  }
		    	  else if (operationType == "join")
		    	  {
		    		  try {
		    			  asciList.get(i).join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		    }
	  }
		    else 
	    	  {
	              for(int i= 1 ; i<= row ; i ++ )
	              {
	            	   for ( int j = 1;  j <= col ; j ++)
	            	   {
	            		   if(i % 2 == 0 && asciList.size()<count)
	            		   {
	       		    	asciList.add(new Ascı((i+1),i-1,j-1));
	            		   }
	            	   }
	              }
	    	  }
	  }
	  
	  public static void musteriOperations(ArrayList<Musteri> musteriList,ArrayList<Masa> masaList,String operationType,int count)
	  {
		    for(int i = 0 ; i< count ; i++)
		    {  
		    	  if(operationType == "start")
		    	  {
		    		  musteriList.get(i).start();
		    	  }
		    	  else if (operationType == "join")
		    	  {
		    		  try {
		    			  musteriList.get(i).join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		    	  else if (operationType == "add")
		    	  {
		    		  Problem1Page.musteriSay ++;
		    		  Problem1Page.dynamicMusteriSay ++;
		    		  musteriList.add(new Musteri((i+1),masaList));
		    	  }
		    }
	  }
	  
	  public static void kasiyerOperations(ArrayList<Kasiyer> kasiyerList,String operationType,int count,int row, int col)
	  {
		if(operationType != "add") {
		  for(int i = 0 ; i< count ; i++)
		    {  
		    	  if(operationType == "start")
		    	  {
		    		  kasiyerList.get(i).start();
		    	  }
		    	  else if (operationType == "join")
		    	  {
		    		  try {
		    			  kasiyerList.get(i).join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		    }
	  }
	  else{
	       for ( int i = 1 ; i<= row ; i++)
	       {
	    	     for (int j =1 ; j<=col ; j++)
	    	     {
	    	    	 if( i % 2 == 0 && kasiyerList.size()<count)
          		   {
     		    	kasiyerList.add(new Kasiyer((i+1),i-1,j-1));
          		   }
	    	     }
	       }
	  }
	  
	  }
	  
	  static void bufferWrite(String filePath,String veri,boolean append)
	  {
		  try {
				BufferedWriter buffer = new BufferedWriter( new FileWriter (filePath,append));
				buffer.write(veri);
				buffer.newLine();
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
	  public static void btnDefault(JButton btn)
	  {
		   btn.setBorderPainted(false);
		   btn.setFocusPainted(false);
		   btn.setContentAreaFilled(false);
	  }
	  
}
