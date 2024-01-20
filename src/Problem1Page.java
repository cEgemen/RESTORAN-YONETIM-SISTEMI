import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class Problem1Page extends JFrame {
	static JFrame problem1;
	static String filePath = "C:\\Users\\Abra\\Desktop\\problem1Steps.txt";
	static Object lockAdd =new  Object();
    static Object lockRemove = new Object();
    static Object lockSiparisAlma = new Object();
    static Object lockYemekHazirlama = new Object();
    static Object lockOdeme = new Object();
    static Object lockBitis = new Object();
    static Object lockSystem  = new Object();
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	JPanel topPanel = new JPanel();
	static JPanel middlePanel = new JPanel();
	static JPanel kasaPanel = new JPanel();
	static JPanel ascıPanel = new JPanel();
	JPanel doorPanel = new JPanel();
	JPanel rightSideButtonsPanel;
	JButton backBtn = new JButton("");
	JButton ayarlar = new JButton("");
	JButton garsonGuiBtn = new JButton("");
	JButton asciGuiBtn = new JButton("");
	JButton kasiyerGuiBtn = new JButton("");
	static ArrayList<Integer[]> senaryoList = new ArrayList<Integer[]>() ;
	static  ArrayList<Masa> masaList = new ArrayList<Masa> ();
	static ArrayList<Musteri> musteriList = new ArrayList<Musteri> ();
	static ArrayList<Garson> garsonList = new ArrayList<Garson> ();
	static ArrayList<Ascı> asciList = new ArrayList<Ascı> ();
	static ArrayList<Kasiyer> kasiyerList = new ArrayList<Kasiyer> ();
	static ArrayList<ArrayList<Object>> siparisiAlinmayanlarList = new ArrayList<ArrayList<Object>> ();
	static ArrayList<ArrayList<Object>> siparisiAlinanlarList = new ArrayList<ArrayList<Object>> ();
	static ArrayList<ArrayList<Object>> siparisiHazirlananlarList = new ArrayList<ArrayList<Object>> ();
	static ArrayList<ArrayList<Object>> yemegiBitenlerList = new ArrayList<ArrayList<Object>> ();
	static ArrayList<ArrayList<Object>> odemeYapanlarList = new ArrayList<ArrayList<Object>> ();
	static ArrayList<ArrayList<JButton>> middlePlace = new ArrayList<ArrayList<JButton>> ();
	static ArrayList<ArrayList<JButton>> bottomRightPlace = new ArrayList<ArrayList<JButton>> ();
	static ArrayList<ArrayList<JButton>> bottomLeftPlace = new ArrayList<ArrayList<JButton>> ();
    static boolean isNotifyed = false;
	static boolean isStart = false;
	public static boolean next = false;
	public static int musteriSay = 0;
	public static int dynamicMusteriSay =0;
	public static int masaSay = 6;
	public static int maxMusteriGelmeSay = 10;
	public static int garsonSay = 3;
	public static int ascıSay = 2;
	public static int kasaSay = 1;
	public static int musteriBeklemeSure = 20000;
	public static int siparisAlmaSure = 2000;
	public static int yemekYemeSure = 3000;
	public static int yemekHazirlamaSure = 3000;
	public static int odemeSure = 1000;
	public static int senaryoStep = 0;
	private final JButton senaryoBtn = new JButton("");
	private final JButton startBtn = new JButton("");
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
	private final JLabel doorBack1 = new JLabel("");
	private final JLabel doorBack2 = new JLabel("");
	private final JLabel doorBack3 = new JLabel("");
	private final JPanel middleTopPanel = new JPanel();
	private final JLabel middleTopBackLabelLeft = new JLabel("");
	private final JLabel middleTopBackLabelRight = new JLabel("");
	private final JLabel bottomBackLabel = new JLabel("");
	private void unDisable()
	{
		this.setVisible(false);
	}
	static void problem1Run(int sSay) {
		 middlePanel.removeAll();;
		 ascıPanel.removeAll();;
		 kasaPanel.removeAll();
		 musteriSay = 0;
		 dynamicMusteriSay = 0;
	     masaList = new ArrayList<Masa> ();
		 musteriList = new ArrayList<Musteri> ();
		 garsonList = new ArrayList<Garson> ();
		 asciList = new ArrayList<Ascı> ();
		 kasiyerList = new ArrayList<Kasiyer> ();
		 siparisiAlinmayanlarList = new ArrayList<ArrayList<Object>> ();
		 siparisiAlinanlarList = new ArrayList<ArrayList<Object>> ();
		 siparisiHazirlananlarList = new ArrayList<ArrayList<Object>> ();
		 yemegiBitenlerList = new ArrayList<ArrayList<Object>> ();
		 odemeYapanlarList = new ArrayList<ArrayList<Object>> ();
		 middlePlace = new ArrayList<ArrayList<JButton>> ();
		 bottomRightPlace = new ArrayList<ArrayList<JButton>> ();
		 bottomLeftPlace = new ArrayList<ArrayList<JButton>> ();
	 Useful.bufferWrite(filePath,+ (sSay+1)+". Senaryo Baslıyor",true);	 
	 ArrayList<Masa> dynamicMasaList = new ArrayList<Masa>();
	 int masaRow = Useful.generateRow(masaSay,"masa");
	 System.out.println("masaRow => "+masaRow);
	 int masaCol= Useful.generateCol(masaSay,"masa");
	 System.out.println("masaCol => "+masaCol);
	 int ocakRow = Useful.generateRow(ascıSay,"ocak");
	 System.out.println("ocakRow => "+ocakRow);
	 int ocakCol= Useful.generateCol(ascıSay,"ocak");
	 System.out.println("ocakCol => "+ocakCol);
	 int kasaRow = Useful.generateRow(kasaSay,"kasa");
	 System.out.println("kasaRow => "+kasaRow);
	 int kasaCol= Useful.generateCol(kasaSay,"kasa");
	 System.out.println("kasaCol => "+kasaCol);
	 middlePanel.setLayout(new GridLayout(masaRow,masaCol,6,6)); 
	 kasaPanel.setLayout(new GridLayout(kasaRow,kasaCol,3,3)); 
	 ascıPanel.setLayout(new GridLayout(ocakRow,ocakCol,3,3)); 
     Useful.creatingPlace("masa.png",middlePanel, problem1,masaSay,masaRow,masaCol);
     Useful.creatingPlace("ocak.png",ascıPanel, problem1,ascıSay,ocakRow,ocakCol);
     Useful.creatingPlace("kasa.png",kasaPanel, problem1,kasaSay,kasaRow,kasaCol);
 
     for(int i = 1 ; i<= masaRow ;  i ++ )
	 {
		  for(int j = 1 ; j <= masaCol ; j ++)
		  {
			 if(i % 2 == 0 && j % 2 == 0 && masaList.size() < masaSay)
			 {
				 System.out.println("row : "+i + " col : "+j);
				 masaList.add(new Masa((masaList.size()+1),i-1,j-1));
				 dynamicMasaList.add(new Masa((dynamicMasaList.size()+1),i-1,j-1));
			 }
		  }
	 }
     System.out.println("Problem1Page.senaryoList.get(sSay)[1] = " + Problem1Page.senaryoList.get(sSay)[1]);
     Useful.musteriOperations(musteriList, dynamicMasaList,"add",Problem1Page.senaryoList.get(sSay)[1]);
     Useful.garsonOperations(garsonList,"add",garsonSay);
     Useful.asciOperations(asciList,"add",ascıSay,ocakRow,ocakCol);  
     Useful.kasiyerOperations(kasiyerList,"add",kasaSay,kasaRow,kasaCol);
     
     
     Useful.kasiyerOperations(kasiyerList,"start",kasaSay,kasaRow,kasaCol);
     Useful.asciOperations(asciList,"start",ascıSay,ocakRow,ocakCol);
     Useful.garsonOperations(garsonList,"start",garsonSay);
     Useful.musteriOperations(musteriList, dynamicMasaList,"start",Problem1Page.senaryoList.get(sSay)[1]);		
     
       
	}
	public Problem1Page() {
		File file = new File(filePath);
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 Useful.bufferWrite(filePath,"----> Problem 1 Steps <----",false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	     problem1 = this;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		topPanel.setBackground(new Color(230, 230, 250));
		setBounds(420,0,877,870);
		topPanel.setBounds(0, 0, 799, 40);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		ayarlar.setBackground(Color.WHITE);
		
		
		ayarlar.setBounds(750, 0, 49, 41);
		Image img1 = new ImageIcon(this.getClass().getResource("/setting.png")).getImage();
		ayarlar.setIcon(new ImageIcon(img1));
		Useful.btnDefault(ayarlar);
		ayarlar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 JDialog d = new JDialog(problem1,"Ayarlar", true);  
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
					
					ayarField1 = new JTextField(masaSay+"");
					ayarField1.setBounds(180, 57, 155, 28);
					d.getContentPane().add(ayarField1);
					ayarField1.setColumns(10);
					
					JLabel ayarText2 = new JLabel("Kasa Sayisi :");
					ayarText2.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText2.setBounds(10, 111, 160, 28);
					d.getContentPane().add(ayarText2);
					
					ayarField2 = new JTextField(kasaSay+"");
					ayarField2.setColumns(10);
					ayarField2.setBounds(180, 111, 155, 28);
					d.getContentPane().add(ayarField2);
					
					JLabel ayarText3 = new JLabel("Garson Sayisi :");
					ayarText3.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText3.setBounds(10, 165, 160, 28);
					d.getContentPane().add(ayarText3);
					
					ayarField3 = new JTextField(garsonSay+"");
					ayarField3.setColumns(10);
					ayarField3.setBounds(180, 165, 155, 28);
					d.getContentPane().add(ayarField3);
					
					JLabel ayarText4 = new JLabel("Ascı Sayisi :");
					ayarText4.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText4.setBounds(10, 222, 160, 28);
					d.getContentPane().add(ayarText4);
					
					ayarField4 = new JTextField(ascıSay+"");
					ayarField4.setColumns(10);
					ayarField4.setBounds(180, 222, 155, 28);
					d.getContentPane().add(ayarField4);
					
					JLabel ayarText5 = new JLabel("Musteri Bekleme Suresi :");
					ayarText5.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText5.setBounds(10, 274, 160, 28);
					d.getContentPane().add(ayarText5);
					
					ayarField5 = new JTextField(musteriBeklemeSure+"");
					ayarField5.setColumns(10);
					ayarField5.setBounds(180, 274, 155, 28);
					d.getContentPane().add(ayarField5);
					
					JLabel ayarText6 = new JLabel("Siparis Alma Süresi :");
					ayarText6.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText6.setBounds(10, 330, 160, 28);
					d.getContentPane().add(ayarText6);
					
					ayarField6 = new JTextField(siparisAlmaSure+"");
					ayarField6.setColumns(10);
					ayarField6.setBounds(180, 330, 155, 28);
					d.getContentPane().add(ayarField6);
					
					JLabel ayarText7 = new JLabel("Yemek Hazırlama Suresi :");
					ayarText7.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText7.setBounds(10, 384, 160, 28);
					d.getContentPane().add(ayarText7);
					
					ayarField7 = new JTextField(yemekHazirlamaSure+"");
					ayarField7.setColumns(10);
					ayarField7.setBounds(180, 385, 155, 28);
					d.getContentPane().add(ayarField7);
					
					JLabel ayarText8 = new JLabel("Yemek Yeme Suresi :");
					ayarText8.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText8.setBounds(10, 433, 160, 28);
					d.getContentPane().add(ayarText8);
					
					ayarField8 = new JTextField(yemekYemeSure+"");
					ayarField8.setColumns(10);
					ayarField8.setBounds(180, 434, 155, 28);
					d.getContentPane().add(ayarField8);
					
					JLabel ayarText9 = new JLabel("Odeme Islemi Suresi :");
					ayarText9.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText9.setBounds(10, 483, 160, 28);
					d.getContentPane().add(ayarText9);
					
					ayarField9 = new JTextField(odemeSure+"");
					ayarField9.setColumns(10);
					ayarField9.setBounds(180, 484, 155, 28);
					d.getContentPane().add(ayarField9);
					
					JLabel ayarText10 = new JLabel("Max Musteri Gelme Sayisi :");
					ayarText10.setHorizontalAlignment(SwingConstants.RIGHT);
					ayarText10.setBounds(10, 533, 160, 28);
					d.getContentPane().add(ayarText10);
					
					ayarField10 = new JTextField(maxMusteriGelmeSay+"");
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
							 masaSay = Integer.parseInt(ayarField1.getText());
							 garsonSay = Integer.parseInt(ayarField3.getText());
							 ascıSay = Integer.parseInt(ayarField4.getText());
							 kasaSay = Integer.parseInt(ayarField2.getText());
							 musteriBeklemeSure = Integer.parseInt(ayarField5.getText());
							 yemekHazirlamaSure = Integer.parseInt(ayarField7.getText());
							 yemekYemeSure = Integer.parseInt(ayarField8.getText());
							 odemeSure = Integer.parseInt(ayarField9.getText());
							 siparisAlmaSure = Integer.parseInt(ayarField6.getText());
							} 
							  else {
								  JOptionPane.showMessageDialog(problem1,"Simülasyon Anında Guncelleme Yapamazsınız...");
							  }
							 
							}
						  
					});  
					
					d.getContentPane().add(updateBtn);
					d.setVisible(true);	
			}
			  
		});
		topPanel.add(ayarlar);
		
		
		backBtn.setBounds(0, 6, 49, 37);
		Image img2 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		backBtn.setIcon(new ImageIcon(img2));
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 Main main = new Main();
				 unDisable();
			}           
		});
		Useful.btnDefault(backBtn);
		topPanel.add(backBtn);
		middlePanel.setBackground(new Color(192, 192, 192));
		middlePanel.setBounds(31, 100, 737, 538);
		contentPane.add(middlePanel);
		middlePanel.setLayout(null);
		
		kasaPanel.setBackground(new Color(192, 192, 192));
		kasaPanel.setBounds(445, 693, 323, 140);
		contentPane.add(kasaPanel);
		kasaPanel.setLayout(null);
		
		
		ascıPanel.setBackground(new Color(192, 192, 192));
		ascıPanel.setBounds(31, 693, 387, 140);
		contentPane.add(ascıPanel);
		ascıPanel.setLayout(null);
		
		
		doorPanel.setBackground(new Color(192, 192, 192));
		doorPanel.setBounds(31, 638, 737, 57);
		contentPane.add(doorPanel);
		doorPanel.setLayout(null);
		doorBack2.setBounds(185, 0, 266, 58);
		
		doorPanel.add(doorBack2);
		Image i2 = new ImageIcon(this.getClass().getResource("wall2.jpg")).getImage();
		doorBack2.setIcon(new ImageIcon(i2));
		doorBack3.setBounds(502, 0, 235, 58);
		doorPanel.add(doorBack3);
		doorBack3.setIcon(new ImageIcon(i2));
		doorBack1.setBounds(0, 0, 133, 57);
		doorPanel.add(doorBack1);
		
		doorBack1.setIcon(new ImageIcon(i2));
		
		JLabel leftSide = new JLabel("");
		leftSide.setIcon(new ImageIcon(i2));
		leftSide.setBounds(0, 44, 32, 789);
		contentPane.add(leftSide);
		
		JLabel rightSide = new JLabel("");
		rightSide.setIcon(new ImageIcon(i2));
		rightSide.setBounds(767, 44, 32, 789);
		contentPane.add(rightSide);
		
		senaryoBtn.setBounds(224, 0, 67, 41);	
		Image img3  = new ImageIcon(this.getClass().getResource("senaryo.png")).getImage();
		senaryoBtn.setIcon(new ImageIcon(img3));
		Useful.btnDefault(senaryoBtn);
		senaryoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 if(!isStart)
				{ 
					JDialog d = new JDialog(problem1,"Senoryo Ekleme Panel", true);  
			        d.getContentPane().setLayout(null);  
					d.setBounds(530,300,600,300);
					JLabel title = new JLabel((senaryoList.size()+1) +". Senaryo");
					title.setFont(new Font("Times New Roman", Font.ITALIC, 24));
					title.setHorizontalAlignment(SwingConstants.CENTER);
					title.setBounds(110, 10, 371, 28);
					d.getContentPane().add(title);
					
					JLabel fiedlTitle1 = new JLabel("Müsteri Sayisi("+maxMusteriGelmeSay+" 'den kucuk ya da esit) :");
					fiedlTitle1.setHorizontalAlignment(SwingConstants.RIGHT);
					fiedlTitle1.setBounds(63, 65, 161, 28);
					d.getContentPane().add(fiedlTitle1);
					
					JButton ekleBtn = new JButton("Ekle");
					ekleBtn.setBounds(243, 189, 110, 36);
					ekleBtn.setBackground(Color.yellow);
					d.getContentPane().add(ekleBtn);
					
					JLabel fiedlTitle2 = new JLabel("Oncelik Sayisi : ");
					fiedlTitle2.setHorizontalAlignment(SwingConstants.RIGHT);
					fiedlTitle2.setBounds(63, 131, 161, 28);
					d.getContentPane().add(fiedlTitle2);
					
				  JTextField textField = new JTextField();
					textField.setText("0");
					textField.setBounds(234, 59, 219, 34);
					d.getContentPane().add(textField);
					textField.setColumns(10);
					
					JTextField textField2 = new JTextField();
					textField2.setText("0");
					textField2.setColumns(10);
					textField2.setBounds(234, 131, 219, 30);
					d.getContentPane().add(textField2);
					ekleBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if(Integer.parseInt(textField.getText()) <= maxMusteriGelmeSay)
							{
								Integer [] adim = {Integer.parseInt(textField2.getText()),Integer.parseInt(textField.getText())};
								senaryoList.add(adim);
								title.setText((senaryoList.size()+1) +". Senaryo");
								textField.setText("0");
								textField2.setText("0");
								isStart = true;
							}
						}
						 
					});
					d.setVisible(true);
				}
				 else {
					  JOptionPane.showMessageDialog(problem1,"Simülasyon Anında Senaryo Secemezsiniz...");
				 }
			      	 	
			}
		});
		topPanel.add(senaryoBtn);
		startBtn.setBounds(546, 0, 67, 41);
		Image img4  = new ImageIcon(this.getClass().getResource("start.png")).getImage();
		startBtn.setIcon(new ImageIcon(img4));
		Useful.btnDefault(startBtn);
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
            		     
				 if(isStart)
				   {
			    	 JOptionPane.showMessageDialog(Problem1Page.problem1,(Problem1Page.senaryoStep+1)+". Senaryo Baslıyor => Musteri Sayisi : "+Problem1Page.senaryoList.get(Problem1Page.senaryoStep)[1]);        
			    	 problem1Run(Problem1Page.senaryoStep);
			    	 Problem1Page.senaryoStep ++;      
				   }  
				   else {
					      JOptionPane.showMessageDialog(problem1,"En Az Bir Senaryo Secimi Yapınız...");
				   }   
			}			   
		});
		topPanel.add(startBtn);
		middleTopPanel.setBackground(new Color(192, 192, 192));
		middleTopPanel.setBounds(31, 44, 737, 57);
		
		contentPane.add(middleTopPanel);
		middleTopPanel.setLayout(null);
		middleTopBackLabelLeft.setBounds(0, 0, 379, 57);
		middleTopPanel.add(middleTopBackLabelLeft);
		middleTopBackLabelLeft.setIcon(new ImageIcon(i2));
		middleTopBackLabelRight.setBounds(431, 0, 306, 57);
		middleTopPanel.add(middleTopBackLabelRight);
		middleTopBackLabelRight.setBackground(new Color(192, 192, 192));
		middleTopBackLabelRight.setIcon(new ImageIcon(i2));
		bottomBackLabel.setBounds(414, 693, 32, 140);
		bottomBackLabel.setIcon(new ImageIcon(i2));

		contentPane.add(bottomBackLabel);
		
	    rightSideButtonsPanel = new JPanel();
		rightSideButtonsPanel.setBackground(new Color(230, 230, 250));
		rightSideButtonsPanel.setBounds(798, 0, 65, 833);
		contentPane.add(rightSideButtonsPanel);
		rightSideButtonsPanel.setLayout(null);
		
		garsonGuiBtn.setBounds(10, 362, 45, 40);
		Useful.btnDefault(garsonGuiBtn);
		Image i6 =  new ImageIcon(this.getClass().getResource("garsonInfo.png")).getImage();
		garsonGuiBtn.setIcon(new ImageIcon(i6));
		garsonGuiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 Object[] columns= { "Masa ID","Musteri ID","Sİparis Durumu"};                 
					JDialog d = new JDialog(problem1,"Garson Panel", true); 
			        JTable j = new JTable();
					DefaultTableModel   model  = new DefaultTableModel();
					 model.setColumnIdentifiers(columns);
					 d.getContentPane().setLayout(new BorderLayout(0, 0));
					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(152, 251, 152));
				    d.getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(null);
				    	d.setBounds(200,150,1184,725);
						
						JLabel guiTitle = new JLabel("GARSON BİLGİ");
						guiTitle.setFont(new Font("Times New Roman", Font.ITALIC, 26));
						guiTitle.setHorizontalAlignment(SwingConstants.CENTER);
						guiTitle.setBounds(286, 10, 660, 52);
						panel.add(guiTitle);
						
						JButton refreshBtn = new JButton("");
						 refreshBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								DefaultTableModel	model2 = new DefaultTableModel();
								model2.setColumnIdentifiers(columns);
								for (int i = 0 ; i< masaList.size() ; i++)
				  				{
				  					  boolean isDone = false;
				  					  for(int k = 0 ; k< siparisiAlinanlarList.size() ; k++)
				  					  {
				  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinanlarList.get(k).get(0)).getMasaNo())
				  						   {
				  							    isDone = true;
				  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiAlinanlarList.get(k).get(1)).getIdNum(),"Siparis Alindi"};
				  							  model2.addRow(row);
				  							  break;
				  						   }
				  					  }
				  					  if(!isDone)
				  					  {
				  						 for(int k = 0 ; k< siparisiAlinmayanlarList.size() ; k++)
					  					  {
					  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinmayanlarList.get(k).get(0)).getMasaNo())
					  						   {
					  							    isDone = true;
					  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiAlinanlarList.get(k).get(1)).getIdNum(),"Siparis Alinmadi"};
					  							  model2.addRow(row);
					  							  break;
					  						   }
					  					  }
				  						  
				  					  }
				  					  if(!isDone)
				  					  {
				  						  Object []  row = {masaList.get(i).getMasaNo(),"Musteri Yok","Siparis Alinmadi"};
				  						model2.addRow(row);
				  					  }
				  				}
				  			    j.setModel(model2);
				  			    panel.updateUI(); 
							} 
						 });
						              
							for (int i = 0 ; i< masaList.size() ; i++)
			  				{
			  					  boolean isDone = false;
			  					  for(int k = 0 ; k< siparisiAlinanlarList.size() ; k++)
			  					  {
			  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinanlarList.get(k).get(0)).getMasaNo())
			  						   {
			  							    isDone = true;
			  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiAlinanlarList.get(k).get(1)).getIdNum(),"Siparis Alindi"};
			  							  model.addRow(row);
			  							  break;
			  						   }
			  					  }
			  					  if(!isDone)
			  					  {
			  						 for(int k = 0 ; k< siparisiAlinmayanlarList.size() ; k++)
				  					  {
				  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinmayanlarList.get(k).get(0)).getMasaNo())
				  						   {
				  							    isDone = true;
				  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiAlinanlarList.get(k).get(1)).getIdNum(),"Siparis Alinmadi"};
				  							  model.addRow(row);
				  							  break;
				  						   }
				  					  }
			  						  
			  					  }
			  					  if(!isDone)
			  					  {
			  						  Object []  row = {masaList.get(i).getMasaNo(),"Musteri Yok","Siparis Alinmadi"};
			  						model.addRow(row);
			  					  }
			  				}
						         j.setModel(model);
						        j.setBounds(30, 40, 200, 300);
						 
						refreshBtn.setBounds(1071, 20, 60, 42);
						Image img = new ImageIcon(problem1.getClass().getResource("refresh.png")).getImage();
						refreshBtn.setIcon(new ImageIcon(img));
						Useful.btnDefault(refreshBtn);
						panel.add(refreshBtn);
						  
						JScrollPane scrollPane = new JScrollPane(j);
						scrollPane.setBounds(27, 93, 1119, 574);
						panel.add(scrollPane);
						
						
					d.setVisible(true);
					
			}
			
		});
		rightSideButtonsPanel.add(garsonGuiBtn);
		

		asciGuiBtn.setBounds(10, 456, 45, 40);
		Useful.btnDefault(asciGuiBtn);
		Image i7 =  new ImageIcon(this.getClass().getResource("asciInfo.png")).getImage();
		asciGuiBtn.setIcon(new ImageIcon(i7));
		asciGuiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 Object[] columns= { "Masa ID","Musteri ID","Sİparis Durumu","Siparis Hazırlanmaa Durumu" };                 
				JDialog d = new JDialog(problem1,"AscıPanel", true); 
		        JTable j = new JTable();
				DefaultTableModel   model  = new DefaultTableModel();
				 model.setColumnIdentifiers(columns);
				d.getContentPane().setLayout(new BorderLayout(0, 0));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(152, 251, 152));
			d.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
			    	d.setBounds(200,150,1184,725);
					
					JLabel guiTitle = new JLabel("ASCI BİLGİ");
					guiTitle.setFont(new Font("Times New Roman", Font.ITALIC, 26));
					guiTitle.setHorizontalAlignment(SwingConstants.CENTER);
					guiTitle.setBounds(286, 10, 660, 52);
					panel.add(guiTitle);
					
					JButton refreshBtn = new JButton("");
					 refreshBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							DefaultTableModel	model2 = new DefaultTableModel();
							model2.setColumnIdentifiers(columns);
							for (int i = 0 ; i< masaList.size() ; i++)
			  				{
			  					  boolean isDone = false;
			  					  for(int k = 0 ; k< siparisiHazirlananlarList.size() ; k++)
			  					  {
			  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiHazirlananlarList.get(k).get(0)).getMasaNo())
			  						   {
			  							    isDone = true;
			  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alindi","Siparis Hazirlandi"};
			  							  model2.addRow(row);
			  							  break;
			  						   }
			  					  }
			  					  if(!isDone)
			  					  {
			  						for(int k = 0 ; k< siparisiAlinanlarList.size() ; k++)
				  					  {
				  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinanlarList.get(k).get(0)).getMasaNo())
				  						   {
				  							    isDone = true;
				  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alindi","Siparis Hazirlanmadi"};
				  							  model2.addRow(row);
				  							  break;
				  						   }
				  					  }
			  					  }
			  					  if(!isDone)
			  					  {
			  						for(int k = 0 ; k< siparisiAlinmayanlarList.size() ; k++)
				  					  {
				  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinmayanlarList.get(k).get(0)).getMasaNo())
				  						   {
				  							    isDone = true;
				  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alinmadi","Siparis Hazirlanmadi"};
				  							  model2.addRow(row);
				  							  break;
				  						   }
				  					  }
			  					  }
			  					  if(!isDone)
			  					  {
			  						  Object []  row = {masaList.get(i).getMasaNo(),"Musteri Yok","Siparis Alinmadi","Siparis Hazirlanmadi"};
			  						model2.addRow(row);
			  					  }
			  				}
			  			    j.setModel(model2);
			  			    panel.updateUI(); 
						} 
					 });
					 for (int i = 0 ; i< masaList.size() ; i++)
		  				{
		  					  boolean isDone = false;
		  					  for(int k = 0 ; k< siparisiHazirlananlarList.size() ; k++)
		  					  {
		  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiHazirlananlarList.get(k).get(0)).getMasaNo())
		  						   {
		  							    isDone = true;
		  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alindi","Siparis Hazirlandi"};
		  							  model.addRow(row);
		  							  break;
		  						   }
		  					  }
		  					  if(!isDone)
		  					  {
		  						for(int k = 0 ; k< siparisiAlinanlarList.size() ; k++)
			  					  {
			  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinanlarList.get(k).get(0)).getMasaNo())
			  						   {
			  							    isDone = true;
			  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alindi","Siparis Hazirlanmadi"};
			  							  model.addRow(row);
			  							  break;
			  						   }
			  					  }
		  					  }
		  					  if(!isDone)
		  					  {
		  						for(int k = 0 ; k< siparisiAlinmayanlarList.size() ; k++)
			  					  {
			  						   if(masaList.get(i).getMasaNo() == ((Masa) siparisiAlinmayanlarList.get(k).get(0)).getMasaNo())
			  						   {
			  							    isDone = true;
			  							    Object []  row = {masaList.get(i).getMasaNo(),((Musteri) siparisiHazirlananlarList.get(k).get(1)).getIdNum(),"Siparis Alinmadi","Siparis Hazirlanmadi"};
			  							  model.addRow(row);
			  							  break;
			  						   }
			  					  }
		  					  }
		  					  if(!isDone)
		  					  {
		  						  Object []  row = {masaList.get(i).getMasaNo(),"Musteri Yok","Siparis Alinmadi","Siparis Hazirlanmadi"};
		  						model.addRow(row);
		  					  }
		  				}
					        j.setModel(model);
					        j.setBounds(30, 40, 200, 300);
					 
					refreshBtn.setBounds(1071, 20, 60, 42);
					Image img = new ImageIcon(problem1.getClass().getResource("refresh.png")).getImage();
					refreshBtn.setIcon(new ImageIcon(img));
					Useful.btnDefault(refreshBtn);
					panel.add(refreshBtn);
					  
					JScrollPane scrollPane = new JScrollPane(j);
					scrollPane.setBounds(27, 93, 1119, 574);
					panel.add(scrollPane);
					
					
				d.setVisible(true);
				
			}
			
		});
		rightSideButtonsPanel.add(asciGuiBtn);
		
		kasiyerGuiBtn.setBounds(10, 546, 45, 40);
		Useful.btnDefault(kasiyerGuiBtn);
		Image i8 =  new ImageIcon(this.getClass().getResource("kasiyerInfo.png")).getImage();
		kasiyerGuiBtn.setIcon(new ImageIcon(i8));
		kasiyerGuiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 Object[] columns= { "Masa ID","Musteri ID","Odeme Durumu" };                 
					JDialog d = new JDialog(problem1,"Kasiyer  Panel", true); 
			        JTable j = new JTable();
					DefaultTableModel   model  = new DefaultTableModel();
					 model.setColumnIdentifiers(columns);
					d.getContentPane().setLayout(new BorderLayout(0, 0));
					
					JPanel panel = new JPanel();
					panel.setBackground(new Color(152, 251, 152));
					d.getContentPane().add(panel, BorderLayout.CENTER);
						panel.setLayout(null);
					    	d.setBounds(200,150,1184,725);
						
						JLabel guiTitle = new JLabel("KASİYER BİLGİ");
						guiTitle.setFont(new Font("Times New Roman", Font.ITALIC, 26));
						guiTitle.setHorizontalAlignment(SwingConstants.CENTER);
						guiTitle.setBounds(286, 10, 660, 52);
						panel.add(guiTitle);
                         
						JLabel allMusteriSayLabel = new JLabel("Toplam Musteri Sayısı : "+musteriSay);
						allMusteriSayLabel.setHorizontalAlignment(SwingConstants.CENTER);
						allMusteriSayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
						allMusteriSayLabel.setBounds(70, 631, 287, 34);
						panel.add(allMusteriSayLabel);
						
						JLabel odemeYapanlarSayLabel = new JLabel("Odemen Yapan Sayısı: "+odemeYapanlarList.size());
						odemeYapanlarSayLabel.setHorizontalAlignment(SwingConstants.CENTER);
						odemeYapanlarSayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
						odemeYapanlarSayLabel.setBounds(442, 631, 287, 34);
						panel.add(odemeYapanlarSayLabel);
						int bosMasaSay = 0;
						if(musteriSay >= masaSay)
						{
							bosMasaSay = 0;
						}
						else {
							 bosMasaSay = masaSay - musteriSay;
						}
						JLabel bosMasaSayLabel = new JLabel("Bos Masa Sayısı : "+ bosMasaSay);
						bosMasaSayLabel.setHorizontalAlignment(SwingConstants.CENTER);
						bosMasaSayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
						bosMasaSayLabel.setBounds(821, 632, 287, 34);
						panel.add(bosMasaSayLabel);
						
						
						JButton refreshBtn = new JButton("");
						 refreshBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								DefaultTableModel	model2 = new DefaultTableModel();
								model2.setColumnIdentifiers(columns);
								for (int i = 0 ; i < odemeYapanlarList.size() ; i++)
				  				{		 
				  					Object []  row = {masaList.get(i).getMasaNo(),((Musteri)odemeYapanlarList.get(i).get(1)).getIdNum(),"Odeme Yaptı"};
				  					model2.addRow(row);
				  				}
								int bosMasaSay = 0;
								if(musteriSay >= masaSay)
								{
									bosMasaSay = 0;
								}
								else {
									 bosMasaSay = masaSay - musteriSay;
								}
								bosMasaSayLabel.setText("Bos Masa Sayısı : "+ bosMasaSay);
								odemeYapanlarSayLabel.setText("Odemen Yapan Sayısı: "+odemeYapanlarList.size());
								allMusteriSayLabel.setText("Toplam Musteri Sayısı : "+musteriSay);
				  			    j.setModel(model2);
				  			    panel.updateUI(); 
							} 
						 });
						              
						 for (int i = 0 ; i < odemeYapanlarList.size() ; i++)
			  				{		 
			  					Object []  row = {((Masa)odemeYapanlarList.get(i).get(0)).getMasaNo() ,((Musteri)odemeYapanlarList.get(i).get(1)).getIdNum(),"Odeme Yaptı"};
			  					model.addRow(row);
			  				}
						  j.setModel(model);
						  j.setBounds(30, 40, 200, 300);
						        
						refreshBtn.setBounds(1071, 20, 60, 42);
						Image img = new ImageIcon(problem1.getClass().getResource("refresh.png")).getImage();
						refreshBtn.setIcon(new ImageIcon(img));
					Useful.btnDefault(refreshBtn);
						panel.add(refreshBtn);
						  
						JScrollPane scrollPane = new JScrollPane(j);
						scrollPane.setBounds(27, 93, 1119, 497);
						panel.add(scrollPane);
						
					
					d.setVisible(true);
					
			}
			
		});
		rightSideButtonsPanel.add(kasiyerGuiBtn);
	
		
		this.setVisible(true);
	}
}
