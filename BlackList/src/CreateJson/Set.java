package CreateJson;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		  
		}
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    if ("Nimbus".equals(info.getName())) {
		        try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        break;
		    }
		}

		JFrame mainForm = new JFrame();
		mainForm.getContentPane().setBackground(SystemColor.inactiveCaption);
		mainForm.setForeground(Color.GRAY);
		mainForm.setFont(new Font("Dialog", Font.BOLD, 16));
		mainForm.setBounds(150, 150, 511, 451);
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
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(aboutItem);
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
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[]
				{"Blacklist1", "Blacklist2", "Blacklist3"}));
		comboBox.setBounds(55, 328, 400, 24);
		mainForm.getContentPane().add(comboBox);
		JButton selectDB = new JButton("SELECT");
		selectDB.setBounds(210, 364, 117, 45);

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
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(37, 153, 21, 15);
		mainForm.getContentPane().add(lblNewLabel_1);
		mainForm.setTitle("Black List");
		mainForm.setVisible(true);
    	selectDB.setBounds(210, 364, 117, 45);
    	mainForm.getContentPane().add(selectDB);
    	mainForm.setTitle("Black List");
    	mainForm.setVisible(true);
		String [] link = {"http://ec.europa.eu/external_relations/cfsp/sanctions/list/version4/global/global.xml",
				"https://scsanctions.un.org/al-qaida/",
				"https://www.treasury.gov/ofac/downloads/sdn.xml","/home/student/NewFiles/"};
		selectDB.addActionListener(e -> {
			Download d = new Download();
			this.bln = comboBox.getSelectedIndex();
			if(selectDB !=null){
				try {
					d.downloadFile(link[bln],link[3]);
					
				} catch (IOException e1) {
					jop.showMessageDialog(null, "Internet not conneced!", "ERROR", jop.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}


			System.out.println(bln);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
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
	}
	public static void convertToJson(List <Person> personList) throws IOException{
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