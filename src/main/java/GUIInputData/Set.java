package GUIInputData;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import org.omg.PortableServer.ServantRetentionPolicyValue;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JToggleButton;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * Hello world!
 *
 */
public class Set 

{
	public int bln;
	String firstname = "";
	String secondname = "";
	String passport = "";
	String city = "";
	String country = "";
	String street = "";
	
	private JTextField firstName;
	private JTextField surnName;
	private JTextField passPort;
	private JTextField gorod;
	private JTextField strana;
	private JTextField ulica;
	/**
	 * @wbp.parser.entryPoint
	 */
	protected void Creation(){
	
		
		JFrame mainForm = new JFrame();
		mainForm.setForeground(Color.GRAY);
		mainForm.setFont(new Font("Dialog", Font.BOLD, 16));
    	mainForm.setBounds(150, 150, 511, 451);
    	mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JOptionPane jop = new JOptionPane();
    	
    	JMenuBar menuBar = new JMenuBar();//Menu
	    JMenu menu1 = new JMenu("Action");
	    menuBar.add(menu1);
	    
	    JMenuItem exitItem = new JMenuItem("Exit");//Menu Items
	    JMenuItem aboutItem = new JMenuItem("About");
	 //   JMenuItem backItem=new JMenuItem("Back");
	    JMenu menuHelp = new JMenu("Help");
	    menuBar.add(menuHelp);
	    menuHelp.add(aboutItem);
	    //    menu1.add(backItem);
	        menu1.add(exitItem);
    	
    	firstName = new JTextField("",20);
    	
    	firstName.setColumns(10);
    	
    	surnName = new JTextField("",20);
    	surnName.setColumns(10);
    	
    	JButton btnButton = new JButton("Search");
    	
    	JLabel lblInputName = new JLabel("Name ");
    	
    	
    	
    	JLabel lblInputSurname = new JLabel("Surname ");
    	
    	passPort = new JTextField();
    	passPort.setColumns(10);
    	
    	gorod = new JTextField();
    	gorod.setColumns(10);
    	
    	JLabel lblCity = new JLabel("City ");
    	
    	JLabel lblPassport = new JLabel("Passport ");
    	
    	strana = new JTextField();
    	strana.setColumns(10);
    	
    	JLabel lblCountry = new JLabel("Country ");
    	
    	ulica = new JTextField();
    	ulica.setColumns(10);
    	
    	JLabel lblStreet = new JLabel("Street ");
    	
    	JLabel lblNewLabel = new JLabel("*");
    	lblNewLabel.setForeground(Color.RED);
    	lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    	
    	JLabel lblNewLabel_1 = new JLabel("*");
    	lblNewLabel_1.setForeground(Color.RED);
    	lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
    	
    	JComboBox comboBox = new JComboBox();
    	comboBox.setModel(new DefaultComboBoxModel(new String[]
    			{"Blacklist1", "Blacklist2", "Blacklist3"}));
    	
    	JButton selectDB = new JButton("SELECT");
    	GroupLayout groupLayout = new GroupLayout(mainForm.getContentPane());
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(92)
    				.addComponent(lblInputName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
    				.addGap(208)
    				.addComponent(lblPassport, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(37)
    				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
    				.addGap(3)
    				.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
    				.addGap(120)
    				.addComponent(passPort, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(90)
    				.addComponent(lblInputSurname, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
    				.addGap(198)
    				.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(37)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(18)
    						.addComponent(surnName, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
    				.addGap(120)
    				.addComponent(gorod, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(102)
    				.addComponent(lblCountry, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
    				.addGap(196)
    				.addComponent(lblStreet, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(55)
    				.addComponent(strana, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
    				.addGap(120)
    				.addComponent(ulica, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(210)
    				.addComponent(btnButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(55)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(210)
    				.addComponent(selectDB, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addGap(4)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(lblInputName)
    					.addComponent(lblPassport))
    				.addGap(9)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(11)
    						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(3)
    						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
    					.addComponent(passPort, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
    				.addGap(34)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(lblInputSurname)
    					.addComponent(lblCity))
    				.addGap(12)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(8)
    						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
    					.addComponent(surnName, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
    					.addComponent(gorod, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
    				.addGap(24)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(3)
    						.addComponent(lblCountry))
    					.addComponent(lblStreet, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
    				.addGap(9)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(strana, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
    					.addComponent(ulica, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
    				.addGap(12)
    				.addComponent(btnButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
    				.addGap(12)
    				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addGap(12)
    				.addComponent(selectDB, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
    	);
    	mainForm.getContentPane().setLayout(groupLayout);
    	mainForm.setTitle("Black List");
    	mainForm.setVisible(true);
    	btnButton.addActionListener(e -> {
				// TODO Auto-generated method stub
			firstname = firstName.getText();
			secondname = surnName.getText();
			passport = passPort.getText();
			city = gorod.getText();
			country = strana.getText();
			street = ulica.getText();
			
			if(firstName.getText().trim().length() <= 0 ){
				
				jop.showMessageDialog(null, "Firstname : Mandatory field to enter", "ERROR", jop.ERROR_MESSAGE);
				mainForm.setVisible(true);
				 
    		}else{
    			mainForm.setVisible(false);
    		}
			if(surnName.getText().trim().length() <= 0 ){
				jop.showMessageDialog(null, "Secondname : Mandatory field to enter", "ERROR", jop.ERROR_MESSAGE); 
				 
    		}
				firstName.setText("");
				surnName.setText("");
				passPort.setText("");
				gorod.setText("");
				strana.setText("");
				ulica.setText("");	
					
		});
    
    	String [] link = {"http://www.polyglotinc.com/resume/resumeXML.zip",
    			"https://www.youtube.com/watch?v=5uR8_xoKaCo","/home/student/NewFiles/"};
    	selectDB.addActionListener(e -> {
    		
    		Download d = new Download();
        		this.bln = comboBox.getSelectedIndex();
        		if(selectDB !=null){
        			
        			try {
						d.downloadFile(link[bln],link[2]);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}
        		System.out.println(bln);
    	});
    
	exitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
    
	}
	
	public void set(){
		String [] setArray = {firstname,secondname,passport,city,country,street};
	}
	static class showabout implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        /*  JFrame aboutForm=new JFrame();
          aboutForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          aboutForm.setBounds(100, 100, 300, 300);
          aboutForm.setTitle("About");
          //JLabel aboutlabel = new JLabel("Greeting!\nHere you will learn everithing about this app!");//Label
          aboutlabel.setBounds(10, 10, 10, 300);
          aboutForm.getContentPane().add(aboutlabel);
          aboutForm.getContentPane().setLayout(null);
          aboutForm.setVisible(true); */
        }
        
      
    }
	
	 
    public static void main( String[] args )
    {
    	Set r =new Set();
    	r.Creation();
    	//System.out.println();
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
