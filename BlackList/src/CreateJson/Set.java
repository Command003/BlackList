package CreateJson;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;

import CreateJson.GUI_Return_Form.Sch;
import CreateJson.GUI_Return_Form.about;
import CreateJson.GUI_Return_Form.openManual;
import DataBase.*;
import XmlParse.DataOfXml;
import XmlParse.DocumentBuild;
import XmlParse.ResurseXml;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JPanel;
import java.awt.Toolkit;

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
	private JTextField passPort;
	private JTextField gorod;
	private JTextField strana;
	private JTextField ulica;
	private List <Person> rezult;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	public int bln;
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	protected void Creation(){

		JFrame mainForm = new JFrame();
		mainForm.setIconImage(Toolkit.getDefaultToolkit().getImage(Set.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		mainForm.getContentPane().setBackground(SystemColor.inactiveCaption);
		mainForm.setForeground(Color.GRAY);
		mainForm.setFont(new Font("Dialog", Font.BOLD, 16));
		mainForm.setBounds(150, 150, 530, 488);
		mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane jop = new JOptionPane();
		mainForm.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();//Menu
		menuBar.setBounds(0, 0, 530, 21);
		JMenu menu1 = new JMenu("Action");
		menuBar.add(menu1);
		mainForm.getContentPane().add(menuBar);

		JMenuItem exitItem = new JMenuItem("Exit");//Menu Items
		JMenuItem aboutItem = new JMenuItem("About");
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(aboutItem);
		menu1.add(exitItem);
		aboutItem.addActionListener(new showabout());

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
		comboBox = new JComboBox();
		comboBox.setBounds(67, 353, 400, 24);
		comboBox.setModel(new DefaultComboBoxModel(new String[]
				{"SDN Database", "Al-Qaida database", "UN database"}));
		mainForm.getContentPane().add(comboBox);
		JButton selectDB = new JButton("SELECT");
		selectDB.setBounds(210, 389, 117, 45);

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

		JLabel lblNewLabel_1 = new JLabel("*");
		lblNewLabel_1.setBounds(37, 153, 21, 15);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		mainForm.getContentPane().add(lblNewLabel_1);
		mainForm.setTitle("Black List");
		mainForm.setVisible(true);
		mainForm.getContentPane().add(selectDB);
		
		JLabel lblNewLabel = new JLabel("To update database select it once again");
		lblNewLabel.setBounds(123, 328, 299, 15);
		mainForm.getContentPane().add(lblNewLabel);
		mainForm.setTitle("Black List");
		mainForm.setVisible(true);
		String [] link = {"https://www.treasury.gov/ofac/downloads/sdn.xml",
				"https://cdn.rawgit.com/Command003/BlackList/df8242ff/alqaida.xml",
				"http://ec.europa.eu/external_relations/cfsp/sanctions/list/version4/global/global.xml","/home/student/NewFiles/"};
		selectDB.addActionListener(e -> {
			Download d = new Download();
			this.bln = comboBox.getSelectedIndex();
			if(selectDB !=null){
				try {
					ResurseXml.initList(bln);
					DocumentBuild documentBuild = new DocumentBuild();
					DataOfXml dataOfX = new DataOfXml();
					d.downloadFile(link[bln],link[3]);
					DBConnection db = new DBConnection();
					Document doc = documentBuild.createDocument(link[bln]);
					dataOfX.parseXML(doc);
					db.TableModel();
					if (bln == 0){
						db.TableModel();
					} else if(bln == 1) {
						dataOfX.parseXML(doc);
						db.TableModel();
					} else {
						
					}

				} catch (IOException e1) {
					jop.showMessageDialog(null, "Internet not connected!", "ERROR", jop.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnButton.addActionListener(e -> {
			firstname = firstName.getText();
			secondname = surnName.getText();
			passport = passPort.getText();
			city = gorod.getText();
			country = strana.getText();
			street = ulica.getText();
			if((surnName.getText().trim().length() <= 0 )){
				jop.showMessageDialog(null, "Error : Fill name and surname", "ERROR", jop.ERROR_MESSAGE); 
				mainForm.setVisible(true);
			}else{
				try {
					set();
					createQuery c = new createQuery();
					File file = new File("/home/student/workspace/BlackList/src/test.json");
					GUI_Return_Form grf=new GUI_Return_Form();
					if (c.searchPerson(parseFromJson(file)).size() >=1 ) {
						grf.initialize();
					} else {
						grf.nulllist();
					}
					mainForm.setVisible(false);
				} catch (SQLException | IOException | ParseException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}

			}
			firstName.setText("");
			surnName.setText("");
			passPort.setText("");
			gorod.setText("");
			strana.setText("");
			ulica.setText("");	
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public void set() throws IOException{
		List <Person> setArray = new ArrayList<Person>();
		setArray.add(new Person(firstname, secondname, "", passport, "", country, street, city, ""));
		convertToJson(setArray);
	}
	static class showabout implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			JFrame aboutForm=new JFrame();
        	aboutForm.getContentPane().setBackground(SystemColor.DARK_GRAY);
        	aboutForm.setBackground(Color.DARK_GRAY);
        	aboutForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        	aboutForm.setBounds(200, 200, 700, 154);
        	aboutForm.setTitle("Help");
        	JTextArea textArea = new JTextArea("Welcome to the BlackList application.Thank you for choosing our product.\nBlackList(BL) application allow to"
    				+ " work with offline "
        			+ "lists of banned individuals\nfrom different banks and countries.\n"
        			+ "Free version of BL allow to keep and use three (3) different databases at a time.");
    		textArea.setBounds(12, 12, 749, 76);	
    		textArea.setFont(new Font("Serif",Font.ITALIC,15));
    		textArea.setEnabled(false);
        	aboutForm.getContentPane().add(textArea);
        	
        	
        	textArea.setBackground(Color.DARK_GRAY);
        	aboutForm.getContentPane().setLayout(null);
        	JButton manualButton = new JButton("Manual");
        	manualButton.setBounds(22, 91, 117, 25);
    		aboutForm.getContentPane().add(manualButton);
    		manualButton.addActionListener(new openManual());
    		
    		
    		JButton aboutButton = new JButton("About");
    		aboutButton.setBounds(151, 91, 117, 25);
    		aboutForm.getContentPane().add(aboutButton);
    		aboutButton.addActionListener(new about());
    		
    		JButton schematicsButton = new JButton("Schematics");
    		schematicsButton.setBounds(280, 91, 117, 25);
    		aboutForm.getContentPane().add(schematicsButton);
    		schematicsButton.addActionListener(new Sch());
    		aboutForm.setVisible(true);
		}
	}
	public static void main( String[] args )
	{

		Set r = new Set();
		r.Creation();
	}
	public  void convertToJson(List <Person> personList) throws IOException{
		File json = new File("/home/student/workspace/BlackList/src/test.json");
		@SuppressWarnings("resource")
		FileWriter writer = new FileWriter(json, false);
		for (Person person : personList){
			JSONObject obj = new JSONObject();

			obj.put("par1", person.getPar1()); 
			obj.put("par2", person.getPar2());
			obj.put("par3", person.getPar3());
			obj.put("par4", person.getPar4());
			obj.put("par5", person.getPar5());
			obj.put("par6", person.getPar6());
			obj.put("par7", person.getPar7());
			obj.put("par8", person.getPar8());
			obj.put("par9", person.getPar9());
			obj.put("par10", person.getPar10());		

			writer.write(obj.toString()  + System.lineSeparator()); //writing to the json object
		}
		writer.flush();
	}

	public static List<Person> parseFromJson(File file) throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		List <Person> output = new ArrayList<Person>();
		Object obj = parser.parse(new FileReader(file));
		org.json.simple.JSONObject jsonObject =  (org.json.simple.JSONObject) obj;
		output.add(new Person(jsonObject.get("par1").toString(), jsonObject.get("par2").toString(), jsonObject.get("par3").toString(),
				jsonObject.get("par4").toString(), jsonObject.get("par5").toString(), jsonObject.get("par6").toString(), jsonObject.get("par7").toString(),jsonObject.get("par8").toString(), jsonObject.get("par9").toString()
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