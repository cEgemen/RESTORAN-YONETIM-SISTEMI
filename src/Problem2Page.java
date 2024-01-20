import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;

public class Problem2Page extends JFrame {
    public static String fileName = "C:\\Users\\Abra\\Desktop\\problem2.txt";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JFrame problem2 ; 
	private JButton backBtn = new JButton("");
	private JButton sbtAkisModeliBtn = new JButton("Sabit Akis Modeli Stratejisi");
    private JButton randomAkisModeliBtn = new JButton("Rantgele Akis Modeli Stratejisi");
    public static int totalSure = 0; 
    public static int musteriGelmeSuresi = 0 ;
    public static int sabitMusteriSayisi = 0;
    public static int musteriSay2 = 0;
	public static int masaSay2 = 6;
	public static int maxMusteriGelmeSay2 = 10;
	public static int garsonSay2 = 3;
	public static int ascıSay2 = 2;
	public static int kasaSay2 = 1;
	public static int musteriBeklemeSure2 = 20;
	public static int siparisAlmaSure2 = 2;
	public static int yemekYemeSure2 = 3;
	public static int yemekHazirlamaSure2 = 3;
	public static int odemeSure2 = 1;
	private final JButton ayarlarBtn = new JButton("");
	private JTextField ayarField1;
	private JTextField ayarField2;
	private JTextField ayarField3;
	private JTextField ayarField4;
	private JTextField ayarField5;
	private JTextField ayarField6;
	private JTextField ayarField7;
	private JTextField ayarField8;
	private JTextField ayarField9;
	private JTextField ayarField10;
	private boolean isStart = false;
    static ArrayList<ArrayList<Integer>> sonOlasılıklar = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> sonMaxKazancSonuclar = new ArrayList<Integer>();

    private void unDisable()
	{
		this.setVisible(false);
	}
	public static void sabitAkisModeliStratejisi()
	{         
		    sonOlasılıklar.clear();
		    sonMaxKazancSonuclar.clear();
		    int toplamSure = (totalSure);
		    Useful.bufferWrite(fileName,"-> Girilen Toplam Sure : " + toplamSure,true);
		    System.out.println("toplamSure : "+toplamSure);
		    int sabitMusteriGelmeSuresi = (musteriGelmeSuresi);
		    Useful.bufferWrite(fileName,"-> Girilen Sabit Musteri Gelme Suresi : " + sabitMusteriGelmeSuresi,true);
		    Useful.bufferWrite(fileName,"-> Girilen Sabit Musteri Sayisi : " + sabitMusteriSayisi,true);
		    System.out.println("sabitMusteriGelmeSuresi : "+sabitMusteriGelmeSuresi);
		    int masadanKalkmaSuresi =( (yemekHazirlamaSure2 + yemekYemeSure2 + siparisAlmaSure2));
		    Useful.bufferWrite(fileName,"-> Bir Kisinin Bir Masadan Kalkma Suresi (bir ascı yemek hazirlama suresi ,bir musteri yemek yeme suresi , bir garsonun siparis alma suresi) : " +masadanKalkmaSuresi+"  ("+(yemekHazirlamaSure2)+","+(yemekYemeSure2)+","+(siparisAlmaSure2)+")",true);
		    System.out.println("masadan kalkma suresi  = " + masadanKalkmaSuresi);
		    System.out.println("toplam Sure = "+ toplamSure + " sabitMusteriGelmeSuresi = "+sabitMusteriGelmeSuresi);
		    ArrayList<ArrayList<Integer>> olasılıklar = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> maxKazancSonuclari = new ArrayList<Integer>();
		    int parcaSayisi = (toplamSure / sabitMusteriGelmeSuresi);
		    Useful.bufferWrite(fileName,"-> Girilen Toplam Sureye ve Musteri Gelme Suresine Gore Musteri Gelme Aralıgı : " + parcaSayisi,true);
		    int toplamGelecekMusteriSayisi = parcaSayisi * sabitMusteriSayisi + sabitMusteriSayisi;
		    Useful.bufferWrite(fileName,"-> Gelecek Toplam Musteri Sayisi : " +toplamGelecekMusteriSayisi,true);
		    int sonMusteriSure = parcaSayisi* sabitMusteriGelmeSuresi + (musteriBeklemeSure2);
		    Useful.bufferWrite(fileName,"-> Son Gelen Musterinin Bekleme Suresi(formul = (musteriGelmeAraligi * sabitGelenMusteri) + sabitGelenMusteri) : " + sonMusteriSure,true);
		    System.out.println("Son Gelen Musterinin Bekleme Suresi(formul = (musteriGelmeAraligi * sabitGelenMusteri) + sabitGelenMusteri) : " + sonMusteriSure);
		    int sonMusteriSira = 0 ;
		    int blm  = sonMusteriSure / masadanKalkmaSuresi; 
               if(sonMusteriSure % masadanKalkmaSuresi != 0)
               {
            	   blm ++;
               }
             sonMusteriSira = blm;
 		    Useful.bufferWrite(fileName,"-> Son Gelen Musterinin Kalkmadan Oturması Icin Bekleme Sirası : (formul = (sonMusteriSuresi / sonMusterininBeklemeSuresi)) : "+sonMusteriSira,true);
		    Useful.bufferWrite(fileName,"-> Olasılıkları ve Hesaplama Formulu : toplamMusteri = (sonMusteriKalkmaSirasi)*idealGarson + idealMasa || bu formul ile olasılıklar hesaplanır ve veriler elde edilir.",true);
 		    System.out.println("son musteri sirasi = "+sonMusteriSira);
             for(int i = 0  ;  i < 2 ; i ++ )
             {
            	 int target = sonMusteriSira - i ;
            	 int syc = 1 ;
            	 int kazanc = 0;
            	 int idealMasa = 0;
            	 int idealGarson = 0 ;
            	 int idealAsci = 0;
            	 int ayrilanMusteri =0 ;
            	 while(true)
            	 {
            		idealGarson = syc;
            		idealAsci = syc;
            		if(i == 0 )
            		{
            			ayrilanMusteri  =  idealGarson;
            		}
            	    idealMasa = toplamGelecekMusteriSayisi - target*syc; 	 
            		 if(idealMasa >= syc) 
            		 {
            			 ArrayList<Integer> result = new ArrayList<Integer>();
            			 result.add(toplamGelecekMusteriSayisi);result.add(idealMasa);result.add(idealGarson);result.add(idealAsci);result.add(ayrilanMusteri);
            			 kazanc = toplamGelecekMusteriSayisi - idealMasa - idealGarson - idealAsci - ayrilanMusteri;
            			 olasılıklar.add(result);
            			 maxKazancSonuclari.add(kazanc);
            		 }
            		 else {
            			  break;
            		 }
            		 syc++;
            	 }
             }
               for(int i = 0 ; i<maxKazancSonuclari.size() ; i++)
               {
       		    Useful.bufferWrite(fileName,"-> Max Kazanc : " +  maxKazancSonuclari.get(i) + "  [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+olasılıklar.get(i),true);
               }
              sonMaxKazancSonuclar.add(maxKazancSonuclari.get(0));
              sonOlasılıklar.add(olasılıklar.get(0));
              for(int i = 1 ; i< maxKazancSonuclari.size() ; i ++ )
              {
            	       if(sonMaxKazancSonuclar.get(0) < maxKazancSonuclari.get(i))
            	       {
            	    	   sonMaxKazancSonuclar.clear();
            	    	   sonOlasılıklar.clear();
            	    	   sonMaxKazancSonuclar.add(maxKazancSonuclari.get(i));
           	            sonOlasılıklar.add(olasılıklar.get(i));
            	       }
            	       else if (sonMaxKazancSonuclar.get(0) == maxKazancSonuclari.get(i))
            	       {
            	    	    sonMaxKazancSonuclar.add(maxKazancSonuclari.get(i));
            	            sonOlasılıklar.add(olasılıklar.get(i));
            	       }
              }
             for(int i = 0 ; i< sonMaxKazancSonuclar.size() ; i ++ )
             {
     Useful.bufferWrite(fileName,"-> En Ideal Olasılık ve Max Kazanc : " +  sonMaxKazancSonuclar.get(i) + "  [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+sonOlasılıklar.get(i),true);
             }
	JOptionPane.showMessageDialog(problem2,"Sabit Akis Modeli Stratejisi Sonucu Max Kazanc : " +sonMaxKazancSonuclar.get(0)+ " ve [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+ sonOlasılıklar.get(0));     
	}
	public static void rastgeleAkisModeliStatejisi() {
		sonOlasılıklar.clear();
	    sonMaxKazancSonuclar.clear();
        Random random = new Random();
		    int toplamSure = (totalSure);
		    Useful.bufferWrite(fileName,"-> Girilen Toplam Sure : " + toplamSure,true);
		    int parcaSayisi  = 0;
		    int toplamGelecekMusteriSayisi = random.nextInt(maxMusteriGelmeSay2) + 1;
		    int toplamGecenSure = 0 ;
		    int sureSiniri = 15;
		    ArrayList<Integer> gecenSureler = new ArrayList<Integer>();
		    System.out.println("toplam sure => "+toplamSure);
		    while(true)
		    {
		        int sure = random.nextInt(sureSiniri) + 1;
		        int gelecekMusteri = random.nextInt(maxMusteriGelmeSay2) +1 ;
		        System.out.println("toplamSure = "+toplamGecenSure);
		        System.out.println("rastgele sure = "+sure);
                if((toplamGecenSure + sure ) >= toplamSure)
                {
                	 if((toplamGecenSure + sure ) > toplamSure)
                	 {
                		 sure -= ((toplamGecenSure + sure )- toplamSure);
                	 }
                	 gecenSureler.add(sure);
                	 toplamGecenSure += sure;
                     parcaSayisi ++; 
                     toplamGelecekMusteriSayisi += gelecekMusteri;
         		    Useful.bufferWrite(fileName,"-> Rastgale Gelecek Kisi Sayisi : " + gelecekMusteri+ " Sure : " + sure,true);
                     break;
                }
                else if((toplamGecenSure + sure ) < toplamSure)
                {
                	gecenSureler.add(sure);
                	toplamGecenSure += sure;
                    parcaSayisi ++;
                    toplamGelecekMusteriSayisi += gelecekMusteri;
         		    Useful.bufferWrite(fileName,"-> Rastgale Gelecek Kisi Sayisi : " + gelecekMusteri + " Sure : " + sure,true);
                }
		    }
 		    Useful.bufferWrite(fileName,"-> Toplam Sureye ve Rastgele Gelme Suresine Gore Gelme Araligi  : " + parcaSayisi,true);
		    int masadanKalkmaSuresi =( (yemekHazirlamaSure2 + yemekYemeSure2 + siparisAlmaSure2));
		    Useful.bufferWrite(fileName,"-> Bir Kisinin Bir Masadan Kalkma Suresi  (bir ascı yemek hazirlama suresi ,bir musteri yemek yeme suresi , bir garsonun siparis alma suresi) : " +masadanKalkmaSuresi+" ("+(yemekHazirlamaSure2 / 1000)+","+(yemekYemeSure2 / 1000)+","+(siparisAlmaSure2 / 1000)+")",true);
		    System.out.println("masadan kalkma suresi  = " + masadanKalkmaSuresi);
		    System.out.println("toplam Sure = "+ toplamSure);
		    ArrayList<ArrayList<Integer>> olasılıklar = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> maxKazancSonuclari = new ArrayList<Integer>();
		    int sonMusteriSure =( musteriBeklemeSure2);
		    for(int i = 0 ; i< gecenSureler.size() ; i ++ )
		    {
		    	sonMusteriSure += gecenSureler.get(i);
		    }
		    Useful.bufferWrite(fileName,"-> Son Gelen Musterinin Bekleme Suresi(formul = (musteriGelmeAraligi * sabitGelenMusteri) + sabitGelenMusteri) : " + sonMusteriSure,true);
		    System.out.println("son musteri bekleme suresi = " + sonMusteriSure);
		    int sonMusteriSira = 0 ;
		    int blm  = sonMusteriSure / masadanKalkmaSuresi; 
              if(sonMusteriSure % masadanKalkmaSuresi != 0)
              {
           	   blm ++;
              }
            sonMusteriSira = blm;
            Useful.bufferWrite(fileName,"-> Son Gelen Musterinin Kalkmadan Oturması Icin Bekleme Sirası : (formul = (sonMusteriSuresi / sonMusterininBeklemeSuresi)) : "+sonMusteriSira,true);
		    Useful.bufferWrite(fileName,"-> Olasılıkları ve Hesaplama Formulu : toplamMusteri = (sonMusteriKalkmaSirasi)*idealGarson + idealMasa || bu formul ile olasılıklar hesaplanır ve veriler elde edilir.",true);
            System.out.println("son musteri sirasi = "+sonMusteriSira);
            for(int i = 0  ;  i < 2 ; i ++ )
            {
           	 int target = sonMusteriSira - i ;
           	 int syc = 1 ;
           	 int kazanc = 0;
           	 int idealMasa = 0;
           	 int idealGarson = 0 ;
           	 int idealAsci = 0;
           	 int ayrilanMusteri =0 ;
           	 while(true)
           	 {
           		idealGarson = syc;
           		idealAsci = syc;
           		if(i == 0 )
           		{
           			ayrilanMusteri  =  idealGarson;
           		}
           	    idealMasa = toplamGelecekMusteriSayisi - target*syc; 	 
           		 if(idealMasa >= syc) 
           		 {
           			 ArrayList<Integer> result = new ArrayList<Integer>();
           			 result.add(toplamGelecekMusteriSayisi);result.add(idealMasa);result.add(idealGarson);result.add(idealAsci);result.add(ayrilanMusteri);
           			 kazanc = toplamGelecekMusteriSayisi - idealMasa - idealGarson - idealAsci - ayrilanMusteri;
           			 olasılıklar.add(result);
           			 maxKazancSonuclari.add(kazanc);
           		 }
           		 else {
           			  break;
           		 }
           		 syc++;
           	 }
            }
            for(int i = 0 ; i<maxKazancSonuclari.size() ; i++)
            {
    		    Useful.bufferWrite(fileName,"-> Max Kazanc : " +  maxKazancSonuclari.get(i) + "  [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+olasılıklar.get(i),true);
            }
             sonMaxKazancSonuclar.add(maxKazancSonuclari.get(0));
             sonOlasılıklar.add(olasılıklar.get(0));
             for(int i = 1 ; i< maxKazancSonuclari.size() ; i ++ )
             {
           	       if(sonMaxKazancSonuclar.get(0) < maxKazancSonuclari.get(i))
           	       {
           	    	   sonMaxKazancSonuclar.clear();
           	    	   sonOlasılıklar.clear();
           	    	   sonMaxKazancSonuclar.add(maxKazancSonuclari.get(i));
          	            sonOlasılıklar.add(olasılıklar.get(i));
           	       }
           	       else if (sonMaxKazancSonuclar.get(0) == maxKazancSonuclari.get(i))
           	       {
           	    	    sonMaxKazancSonuclar.add(maxKazancSonuclari.get(i));
           	            sonOlasılıklar.add(olasılıklar.get(i));
           	       }
             }
            for(int i = 0 ; i< sonMaxKazancSonuclar.size() ; i ++ )
            {
                Useful.bufferWrite(fileName,"-> En Ideal Olasılık ve Max Kazanc : " +  sonMaxKazancSonuclar.get(i) + "  [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+sonOlasılıklar.get(i),true);
            }
			JOptionPane.showMessageDialog(problem2,"Rastgele Akis Modeli Stratejisi Sonucu Max Kazanc : " +sonMaxKazancSonuclar.get(0)+ " ve [toplamGelecekMusteriSayisi,idealMasa,idealGarson,idealAsci,ayrilanMusteri] : "+ sonOlasılıklar.get(0));
	}
	public Problem2Page() {
		problem2 = this;
		setBounds(200,100,1177,643);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel problem2TitleLable = new JLabel("Max Musteri Hizmet Stratejisi");
		problem2TitleLable.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		problem2TitleLable.setHorizontalAlignment(SwingConstants.CENTER);
		problem2TitleLable.setBounds(250, 10, 669, 49);
		contentPane.add(problem2TitleLable);
		
		
		backBtn.setBounds(33, 10, 56, 37);
		Useful.btnDefault(backBtn);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				   new Main();
				   unDisable();
			}
			  
		});
		Image i1 = new ImageIcon(this.getClass().getResource("back.png")).getImage();
		backBtn.setIcon(new ImageIcon(i1));
		contentPane.add(backBtn);
		
		sbtAkisModeliBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		sbtAkisModeliBtn.setFocusPainted(false);
		sbtAkisModeliBtn.setBorderPainted(false);
		sbtAkisModeliBtn.setBounds(197, 305, 246, 57);
		sbtAkisModeliBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
               totalSure =Integer.parseInt(JOptionPane.showInputDialog(problem2, "Lütfen Toplam Süreyi Giriniz : "));
               musteriGelmeSuresi = Integer.parseInt(JOptionPane.showInputDialog(problem2,"Lütfen Müsteri Gelme Aralık Süresini Giriniz : "));
		       sabitMusteriSayisi = Integer.parseInt(JOptionPane.showInputDialog(problem2,"Lütfen Sabit Gelecek Müsteri Sayisini Giriniz : "));
			   while(true)
			   {
				    if(sabitMusteriSayisi <= maxMusteriGelmeSay2)
				    {
				    	break;
				    }
				    sabitMusteriSayisi = Integer.parseInt(JOptionPane.showInputDialog(problem2,"Lütfen Sabit Gelecek Müsteri Sayisini Giriniz("+maxMusteriGelmeSay2+" 'den kucuk ya da esit): "));
			   }
		       Useful.bufferWrite(fileName," Sabit Akis Modeli Stratejisi ",false);
		       sabitAkisModeliStratejisi();    
		       isStart = false;
			}
		});
		contentPane.add(sbtAkisModeliBtn);
		
		randomAkisModeliBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		randomAkisModeliBtn.setFocusPainted(false);
		randomAkisModeliBtn.setBorderPainted(false);
		randomAkisModeliBtn.setBounds(741, 305, 246, 57);
		randomAkisModeliBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    totalSure = Integer.parseInt(JOptionPane.showInputDialog(problem2,"Lütfen Toplam Süreyi Giriniz : "));	
			    Useful.bufferWrite(fileName," Rastgele Akis Modeli Stratejisi ",false);
			    rastgeleAkisModeliStatejisi();
				isStart = false;
			}
		});
		contentPane.add(randomAkisModeliBtn);
		ayarlarBtn.setBounds(1066, 10, 64, 37);
		Image i2 = new ImageIcon(this.getClass().getResource("setting.png")).getImage();
		ayarlarBtn.setIcon(new ImageIcon(i2));
		Useful.btnDefault(ayarlarBtn);
		ayarlarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 JDialog d = new JDialog(problem2,"Ayarlar", true);  
			        d.getContentPane().setLayout(null);  
					d.setBounds(580,150,395,700);
					d.getContentPane().setLayout(null);
					JLabel title = new JLabel("Ayarlar\r\n");
					title.setHorizontalAlignment(SwingConstants.CENTER);
					title.setFont(new Font("Times New Roman", Font.ITALIC, 26));
					title.setBounds(10, 10, 355, 28);
					d.getContentPane().add(title);
					
					JLabel ayarText1 = new JLabel("Masa Sayisi :");
					ayarText1.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText1.setBounds(10, 57, 160, 28);
					d.getContentPane().add(ayarText1);
					
					ayarField1 = new JTextField(masaSay2+"");
					ayarField1.setBounds(180, 57, 155, 28);
					d.getContentPane().add(ayarField1);
					ayarField1.setColumns(10);
					
					JLabel ayarText2 = new JLabel("Kasa Sayisi :");
					ayarText2.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText2.setBounds(10, 111, 160, 28);
					d.getContentPane().add(ayarText2);
					
					ayarField2 = new JTextField(kasaSay2+"");
					ayarField2.setColumns(10);
					ayarField2.setBounds(180, 111, 155, 28);
					d.getContentPane().add(ayarField2);
					
					JLabel ayarText3 = new JLabel("Garson Sayisi :");
					ayarText3.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText3.setBounds(10, 165, 160, 28);
					d.getContentPane().add(ayarText3);
					
					ayarField3 = new JTextField(garsonSay2+"");
					ayarField3.setColumns(10);
					ayarField3.setBounds(180, 165, 155, 28);
					d.getContentPane().add(ayarField3);
					
					JLabel ayarText4 = new JLabel("Ascı Sayisi :");
					ayarText4.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText4.setBounds(10, 222, 160, 28);
					d.getContentPane().add(ayarText4);
					
					ayarField4 = new JTextField(ascıSay2+"");
					ayarField4.setColumns(10);
					ayarField4.setBounds(180, 222, 155, 28);
					d.getContentPane().add(ayarField4);
					
					JLabel ayarText5 = new JLabel("Musteri Bekleme Suresi :");
					ayarText5.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText5.setBounds(10, 274, 160, 28);
					d.getContentPane().add(ayarText5);
					
					ayarField5 = new JTextField(musteriBeklemeSure2+"");
					ayarField5.setColumns(10);
					ayarField5.setBounds(180, 274, 155, 28);
					d.getContentPane().add(ayarField5);
					
					JLabel ayarText6 = new JLabel("Siparis Alma Süresi :");
					ayarText6.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText6.setBounds(10, 330, 160, 28);
					d.getContentPane().add(ayarText6);
					
					ayarField6 = new JTextField(siparisAlmaSure2+"");
					ayarField6.setColumns(10);
					ayarField6.setBounds(180, 330, 155, 28);
					d.getContentPane().add(ayarField6);
					
					JLabel ayarText7 = new JLabel("Yemek Hazırlama Suresi :");
					ayarText7.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText7.setBounds(10, 384, 160, 28);
					d.getContentPane().add(ayarText7);
					
					ayarField7 = new JTextField(yemekHazirlamaSure2+"");
					ayarField7.setColumns(10);
					ayarField7.setBounds(180, 385, 155, 28);
					d.getContentPane().add(ayarField7);
					
					JLabel ayarText8 = new JLabel("Yemek Yeme Suresi :");
					ayarText8.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText8.setBounds(10, 433, 160, 28);
					d.getContentPane().add(ayarText8);
					
					ayarField8 = new JTextField(yemekYemeSure2+"");
					ayarField8.setColumns(10);
					ayarField8.setBounds(180, 434, 155, 28);
					d.getContentPane().add(ayarField8);
					
					JLabel ayarText9 = new JLabel("Odeme Islemi Suresi :");
					ayarText9.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText9.setBounds(10, 483, 160, 28);
					d.getContentPane().add(ayarText9);
					
					ayarField9 = new JTextField(odemeSure2+"");
					ayarField9.setColumns(10);
					ayarField9.setBounds(180, 484, 155, 28);
					d.getContentPane().add(ayarField9);
					
					JLabel ayarText10 = new JLabel("Max Musteri Gelme Sayisi :");
					ayarText10.setHorizontalAlignment(SwingConstants.RIGHT); 
					ayarText10.setBounds(10, 533, 160, 28);
					d.getContentPane().add(ayarText10);
					
					ayarField10 = new JTextField(maxMusteriGelmeSay2+"");
					ayarField10.setColumns(10);
					ayarField10.setBounds(180, 533, 155, 28);
					d.getContentPane().add(ayarField10);
					
					JButton updateBtn = new JButton("Guncelle");
					updateBtn.setBounds(156, 581, 85, 31);
					updateBtn.setBackground(Color.green);
					updateBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							  if(!isStart)
							{
							 masaSay2 = Integer.parseInt(ayarField1.getText());
							 garsonSay2 = Integer.parseInt(ayarField3.getText());
							 ascıSay2 = Integer.parseInt(ayarField4.getText());
							 kasaSay2 = Integer.parseInt(ayarField2.getText());
							 musteriBeklemeSure2 = Integer.parseInt(ayarField5.getText());
							 yemekHazirlamaSure2 = Integer.parseInt(ayarField7.getText());
							 yemekYemeSure2 = Integer.parseInt(ayarField8.getText());
							 odemeSure2 = Integer.parseInt(ayarField9.getText());
							 siparisAlmaSure2 = Integer.parseInt(ayarField6.getText());
							} 
							  else {
								  JOptionPane.showMessageDialog(problem2,"Cozum Anında Guncelleme Yapamazsınız...");
							  }
							 
							}
						  
					});  
					
					d.getContentPane().add(updateBtn);
					d.setVisible(true);	
                 			
				
			}	
		});
		contentPane.add(ayarlarBtn);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
}
