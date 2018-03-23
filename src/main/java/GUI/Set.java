package GUI;



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
	public void Creation(){
	
		
		JFrame mainForm = new JFrame();
		mainForm.setForeground(Color.GRAY);
		mainForm.setFont(new Font("Dialog", Font.BOLD, 16));
    	mainForm.setBounds(150, 150, 511, 451);
    	mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainForm.getContentPane().setLayout(null);
    	JOptionPane jop = new JOptionPane();//extra table with error alert
    	
    	JMenuBar menuBar = new JMenuBar();//File Menu
	    JMenu menu1 = new JMenu("Action");
	    menuBar.add(menu1);
	    menuBar.setBounds(0, 0, 509, 21);
	    mainForm.getContentPane().add(menuBar);
	    
	    JMenuItem exitItem = new JMenuItem("Exit");//Menu Items
	    JMenuItem aboutItem = new JMenuItem("About");
	 //   JMenuItem backItem=new JMenuItem("Back");
	    JMenu menuHelp = new JMenu("Help");
	    menuBar.add(menuHelp);
	    menuHelp.add(aboutItem);
	    //    menu1.add(backItem);
	        menu1.add(exitItem);
    	
    	firstName = new JTextField("",20);
    	firstName.setBounds(55, 52, 146, 32);
    	mainForm.getContentPane().add(firstName);
    	
    	firstName.setColumns(10);
    	
    	surnName = new JTextField("",20);
    	surnName.setBounds(55, 145, 146, 32);
    	mainForm.getContentPane().add(surnName);
    	surnName.setColumns(10);
    	
    	JButton btnButton = new JButton("Search");
    	btnButton.setBounds(210, 275, 117, 41);
    	mainForm.getContentPane().add(btnButton);
    	
    	JLabel lblInputName = new JLabel("Name ");
    	lblInputName.setBounds(92, 25, 58, 15);
    	mainForm.getContentPane().add(lblInputName);
    	
    	
    	
    	JLabel lblInputSurname = new JLabel("Surname ");
    	lblInputSurname.setBounds(90, 118, 80, 15);
    	mainForm.getContentPane().add(lblInputSurname);
    	
    	passPort = new JTextField();
    	passPort.setBounds(321, 49, 146, 32);
    	mainForm.getContentPane().add(passPort);
    	passPort.setColumns(10);
    	
    	gorod = new JTextField();
    	gorod.setBounds(321, 145, 146, 32);
    	mainForm.getContentPane().add(gorod);
    	gorod.setColumns(10);
    	
    	JLabel lblCity = new JLabel("City ");
    	lblCity.setBounds(368, 118, 43, 15);
    	mainForm.getContentPane().add(lblCity);
    	
    	JLabel lblPassport = new JLabel("Passport ");
    	lblPassport.setBounds(358, 25, 80, 15);
    	mainForm.getContentPane().add(lblPassport);
    	
    	strana = new JTextField();
    	strana.setBounds(55, 231, 146, 32);
    	mainForm.getContentPane().add(strana);
    	strana.setColumns(10);
    	
    	JLabel lblCountry = new JLabel("Country ");
    	lblCountry.setBounds(102, 204, 70, 15);
    	mainForm.getContentPane().add(lblCountry);
    	
    	ulica = new JTextField();
    	ulica.setBounds(321, 231, 146, 32);
    	mainForm.getContentPane().add(ulica);
    	ulica.setColumns(10);
    	
    	JLabel lblStreet = new JLabel("Street ");
    	lblStreet.setBounds(368, 201, 70, 21);
    	mainForm.getContentPane().add(lblStreet);
    	
    	JLabel lblNewLabel = new JLabel("*");
    	lblNewLabel.setForeground(Color.RED);
    	lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    	lblNewLabel.setBounds(37, 60, 15, 15);
    	mainForm.getContentPane().add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("*");
    	lblNewLabel_1.setForeground(Color.RED);
    	lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
    	lblNewLabel_1.setBounds(37, 153, 21, 15);
    	mainForm.getContentPane().add(lblNewLabel_1);
    	
    	JComboBox comboBox = new JComboBox();
    	comboBox.setModel(new DefaultComboBoxModel(new String[]
    				{"Blacklist1", "Blacklist2", "Blacklist3"}));
    	comboBox.setBounds(55, 328, 400, 24);
    	mainForm.getContentPane().add(comboBox);
    	
    	JButton selectDB = new JButton("SELECT");
    	selectDB.setBounds(210, 364, 117, 45);
    	mainForm.getContentPane().add(selectDB);
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
    
    	
    	selectDB.addActionListener(e -> {
        		this.bln = comboBox.getSelectedIndex();
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
	
	 
   /* public static void main( String[] args )
    {
    	Set r =new Set();
    	r.Creation();
    	//System.out.println();
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
	}*/
}