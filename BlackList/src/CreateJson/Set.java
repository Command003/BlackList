package CreateJson;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Font;
import java.awt.TextField;


public class Set 

{
	public Set(){}
	String firstname = "";
	String secondname = "";
	String passport = "";
	String city = "";
	String country = "";
	String street = "";
	
	private JTextField firstName;
	private JTextField surnName;
	private JTextField result;
	private JTextField passPort;
	private JTextField gorod;
	private JTextField strana;
	private JTextField ulica;
	private List <Person> rezult;
	
	@SuppressWarnings("static-access")
	protected void Creation(){
	
		
		JFrame mainForm = new JFrame();
		mainForm.setForeground(Color.GRAY);
		mainForm.setFont(new Font("Dialog", Font.BOLD, 16));
    	mainForm.setBounds(150, 150, 511, 400);
    	mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainForm.getContentPane().setLayout(null);
    	JOptionPane jop = new JOptionPane();
    	
    	JMenuBar menuBar = new JMenuBar();//Menu
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
    	
    	result = new JTextField();
    	result.setBounds(37, 339, 275, 19);
    	mainForm.getContentPane().add(result);
    	result.setColumns(10);
    	
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
			
			if((firstName.getText().trim().length() <= 0 ) || (surnName.getText().trim().length() <= 0 )){
		        jop.showMessageDialog(null, "Error : Fill name and surname", "ERROR", jop.ERROR_MESSAGE); 
		        mainForm.setVisible(true);
		        }else{
		        	try {
		        		createQuery c = new createQuery();
						File file = new File("src/test.json");
						convertToJson1(c.searchPerson(parseFromJson(file)));
							
					} catch (SQLException | IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		          mainForm.setVisible(false);
		        
		          GUI_Return_Form grf=new GUI_Return_Form();
		          try {
					grf.initialize();
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		          
		          
		        }
				firstName.setText("");
				surnName.setText("");
				passPort.setText("");
				gorod.setText("");
				strana.setText("");
				ulica.setText("");
				
				result.setText(firstname + " " + secondname + " " + passport + " " + city + " " + country + " " +street);
				//mainForm.setVisible(false);
				
				//GUI_Return_Form grf=new GUI_Return_Form();
				//grf.initialize();
				
				
				/*	mainForm.setVisible(false);
				JFrame AA = new JFrame();
				AA.setTitle("Temp");
		    	AA.setBounds(150, 150, 400, 400);
		    	AA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	AA.getContentPane().setLayout(null);
		    	AA.setVisible(true);
				*/
			
		
    		
		});
    
	exitItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
    
	}
	
	public void set() throws IOException{
		List <Person> setArray = new ArrayList<Person>();
		setArray.add(new Person(firstname, secondname, "", passport , city, country, street));
		convertToJson(setArray);
	}
	static class showabout implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	JFrame aboutForm=new JFrame();
        	aboutForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        	aboutForm.setBounds(100, 100, 300, 300);
        	aboutForm.setTitle("About");
        	JLabel aboutlabel = new JLabel("Greeting!\nHere you will learn everithing about this app!");//Label
        	aboutlabel.setBounds(10, 10, 10, 300);
        	aboutForm.getContentPane().add(aboutlabel);
        	aboutForm.getContentPane().setLayout(null);
        	aboutForm.setVisible(true);
        }
        
      
    }
	
	 
    public static void main( String[] args )
    {
    	
    	Set r =new Set();
    	r.Creation();
    	
    	
    	
    	//System.out.println();
    }
    public static void convertToJson(List <Person> personList) throws IOException{
		File json = new File("src/test.json");
		@SuppressWarnings("resource")
		FileWriter writer = new FileWriter(json);
		for (Person person : personList){
		JSONObject obj = new JSONObject(); //creating of  JSON object
		obj.put("firstname", person.getFirstname()); 
		obj.put("lastname", person.getLastname());
		obj.put("wholename", person.getWholename());
		obj.put("number", person.getNumber());
		obj.put("country", person.getCountry());
		obj.put("city", person.getCity());
		obj.put("street", person.getStreet());
		obj.put("index", person.getIndex());
		obj.put("gender", person.getGender());
		writer.write(obj.toString()  + System.lineSeparator()); //writing to the json object
		}
		writer.flush();
	}
    public static void convertToJson1(List <Person> personList) throws IOException{
		File json = new File("src/test1.json");
		@SuppressWarnings("resource")
		FileWriter writer = new FileWriter(json);
		JSONObject out = new JSONObject();
		JSONArray fname = new JSONArray();
		JSONArray lname = new JSONArray();
		JSONArray wname = new JSONArray();
		JSONArray number = new JSONArray();
		JSONArray country = new JSONArray();
		JSONArray city = new JSONArray();
		JSONArray street = new JSONArray();
		JSONArray gender = new JSONArray();
		JSONArray index = new JSONArray();
		int i = 1;
		for (Person person : personList){
		 //creating of  JSON object
			
			fname.add(i+") " + person.getFirstname());
			lname.add(i+") " +  person.getLastname());
			wname.add(i+") " + person.getWholename());
			number.add(i+") " + person.getNumber());
			gender.add(i+") " + person.getGender());
			country.add(i+") " + person.getCountry());
			city.add(i+") " + person.getCity());
			index.add(i+") " + person.getIndex());
			street.add(i+") " + person.getStreet());
			i++;
//		obj.add("firstname", person.getFirstname()); 
//		obj.put("lastname", person.getLastname());
//		obj.put("wholename", person.getWholename());
//		obj.put("number", person.getNumber());
//		obj.put("country", person.getCountry());
//		obj.put("city", person.getCity());
//		obj.put("street", person.getStreet());
//		obj.put("index", person.getIndex());
//		obj.put("gender", person.getGender());
		 //writing to the json object
		}
		out.put("firstname",fname);
		out.put("lastname",lname);
		out.put("wholename",wname);
		out.put("number",number);
		out.put("country",country);
		out.put("city",city);
		out.put("street",street);
		out.put("index",index);
		out.put("gender",gender);
		writer.write(out.toString()  + System.lineSeparator());
		writer.flush();
	}
    public static List<Person> parseFromJson(File file) throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		List <Person> output = new ArrayList<Person>();
		Object obj = parser.parse(new FileReader(file));
		org.json.simple.JSONObject jsonObject =  (org.json.simple.JSONObject) obj;
        output.add(new Person(jsonObject.get("firstname").toString(), jsonObject.get("lastname").toString(), jsonObject.get("wholename").toString(),
        		jsonObject.get("number").toString(), jsonObject.get("gender").toString(), jsonObject.get("country").toString(), jsonObject.get("city").toString(),jsonObject.get("street").toString(), jsonObject.get("index").toString()
        		));
        return output;
	}
    
    public List<Person> getRezult() {
		return rezult;
	}
	public void setRezult(List<Person> rezult) {
		this.rezult = rezult;
	}

	
}