package CreateJson;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class fileEx extends JFrame {
	List <Person> person1 = new ArrayList<Person>();

	
	private JPanel contentPane;
	private JTextField fName;
	private JTextField lName;
	private JTextField wName;
	private JTextField pNumber;
	private JTextField country1;
	private JTextField city1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fileEx frame = new fileEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fileEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("ACCEPT");
		button.setBounds(86, 194, 270, 44);
		contentPane.add(button);
		
		fName = new JTextField();
		fName.setBounds(50, 29, 126, 19);
		contentPane.add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(50, 74, 126, 19);
		contentPane.add(lName);
		lName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(73, 12, 103, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("Lastname");
		lblLastname.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLastname.setBounds(73, 57, 103, 15);
		contentPane.add(lblLastname);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(53, 163, 62, 23);
		contentPane.add(male);
		male.setActionCommand("male");
		
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(118, 163, 149, 23);
		contentPane.add(female);
		female.setActionCommand("female");
		wName = new JTextField();
		wName.setColumns(10);
		wName.setBounds(50, 121, 126, 19);
		contentPane.add(wName);
		
		JLabel lblWholename = new JLabel("Wholename");
		lblWholename.setFont(new Font("Dialog", Font.BOLD, 14));
		lblWholename.setBounds(72, 105, 116, 15);
		contentPane.add(lblWholename);
		
		pNumber = new JTextField();
		pNumber.setColumns(10);
		pNumber.setBounds(255, 29, 126, 19);
		contentPane.add(pNumber);
		
		country1 = new JTextField();
		country1.setColumns(10);
		country1.setBounds(255, 74, 126, 19);
		contentPane.add(country1);
		
		city1 = new JTextField();
		city1.setColumns(10);
		city1.setBounds(255, 121, 126, 19);
		contentPane.add(city1);
		
		JLabel lblPassport = new JLabel("Passport");
		lblPassport.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassport.setBounds(272, 12, 103, 15);
		contentPane.add(lblPassport);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCountry.setBounds(284, 57, 103, 15);
		contentPane.add(lblCountry);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCity.setBounds(296, 105, 103, 15);
		contentPane.add(lblCity);
		ButtonGroup group = new ButtonGroup();
		group.add(male);
		group.add(female);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 232, 389, 26);
		contentPane.add(textArea);
		button.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      String firstname = fName.getText();
			      String lastname = lName.getText();
			      String wholename = wName.getText();
			      String country = country1.getText();
			      String city = city1.getText();
			      String pass = pNumber.getText();
			      String gender = group.getSelection().getActionCommand();
			      person1.add(new Person(firstname, lastname, wholename, pass, gender, country, city));
			      try {
					convertToJson(person1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}});
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
	public static List<Person> parseFromJson(File file) throws FileNotFoundException, IOException, ParseException{
		JSONParser parser = new JSONParser();
		List <Person> output = new ArrayList<Person>();
		Object obj = parser.parse(new FileReader(file));
        JSONObject jsonObject =  (JSONObject) obj;
        output.add(new Person(jsonObject.get("firstname").toString(), jsonObject.get("lastname").toString(), jsonObject.get("wholename").toString(),
        		jsonObject.get("number").toString(), jsonObject.get("gender").toString(), jsonObject.get("country").toString(), jsonObject.get("city").toString(),
        		jsonObject.get("street").toString(), jsonObject.get("index").toString()));       
        return output;
	}
	
	
}
