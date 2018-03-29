package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import javax.swing.JMenu;
import javax.swing.JList;
public class GuiReturnForm {
	private static JFrame form;
	@SuppressWarnings("rawtypes")
	private static JList list = new JList();
	private static Logger logger = Logger.getLogger(GuiReturnForm.class.getName());
	private static File file = new File("C:\\newfile\\test.json");
	private static class saveTxt implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			String[] array;
			JFileChooser chooser = new JFileChooser();
			createQuery c = new createQuery();
			int retrival = chooser.showSaveDialog(null);
			if (retrival == JFileChooser.APPROVE_OPTION)    
				try{
					int i = 0;
					array = new String [c.searchPerson(Set.parseFromJson(file)).size()];
					for(Person person : c.searchPerson(Set.parseFromJson(file))){
						array[i] = person.toString();
						i++;
					} 
					BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".txt"));
					for(i = 0 ; i < array.length ; i++)
						bw.write(array[i]);
					bw.close();
				}	catch(IOException | ClassNotFoundException | SQLException | ParseException e1) {
					logger.error(e1);
				} 
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void nulllist(){
		String[] arr=new String[1];
		arr [0] = "No match found";
		form=new JFrame();//Form
		form.setBounds(100, 100, 249, 325);
		form.setTitle("Result");
		form.getContentPane().setBackground(SystemColor.inactiveCaption);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setLayout(null);
		list = new JList(arr);
		list.setBounds(10, 62, 218, 180);
		form.getContentPane().add(list);
		JMenuBar menuBar = new JMenuBar();//Menu
		JMenu menu1 = new JMenu("Action");
		menuBar.add(menu1);
		menuBar.setBounds(0, 0, 531, 21);
		form.getContentPane().add(menuBar);
		JMenuItem exitItem = new JMenuItem("Exit");//Menu Items
		JMenuItem aboutItem = new JMenuItem("About");
		JMenuItem backItem=new JMenuItem("Back");
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(aboutItem);
		menu1.add(backItem);
		menu1.add(exitItem);
		aboutItem.addActionListener(new Showabout());
		exitItem.addActionListener(new Exit());
		backItem.addActionListener(new Btmf());
		form.setResizable(false);
		form.setVisible(true);
		list.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initialize() throws IOException, ParseException, ClassNotFoundException, SQLException{	
		createQuery c = new createQuery();
		int i = 0;
		String[] array = new String [c.searchPerson(Set.parseFromJson(file)).size()];
		for(Person person : c.searchPerson(Set.parseFromJson(file))){
			array[i] = person.toString().replace("[", "").replaceAll("]", "");
			i++;
		}
		form=new JFrame();//Form
		form.setBounds(100, 100, 531, 325);
		form.setTitle("Result");
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setBackground(SystemColor.inactiveCaption);
		form.getContentPane().setLayout(null);

		JButton savetoButton = new JButton("Save result to .txt file");//Save to .txt file button
		savetoButton.setBounds(10, 253, 507, 23);
		form.getContentPane().add(savetoButton);

		JMenuBar menuBar = new JMenuBar();//Menu
		JMenu menu1 = new JMenu("Action");
		menuBar.add(menu1);
		menuBar.setBounds(0, 0, 531, 21);
		form.getContentPane().add(menuBar);

		JMenuItem exitItem = new JMenuItem("Exit");//Menu Items
		JMenuItem aboutItem = new JMenuItem("About");
		JMenuItem backItem=new JMenuItem("Back");
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(aboutItem);
		menu1.add(backItem);
		menu1.add(exitItem);

		JLabel lblNewLabel = new JLabel("Individuals from wanted list :");//Label
		lblNewLabel.setBounds(10, 37, 218, 14);
		form.getContentPane().add(lblNewLabel);
		list = new JList(array);
		list.setBounds(10, 62, 218, 180);
		DefaultListSelectionModel m = new DefaultListSelectionModel();
		m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		m.setLeadAnchorNotificationEnabled(false);
		list.setSelectionModel(m);

		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 62, 507, 180);
		form.getContentPane().add(scrollPane);
		form.setResizable(false);

		savetoButton.addActionListener(new saveTxt());
		aboutItem.addActionListener(new Showabout());
		exitItem.addActionListener(new Exit());
		backItem.addActionListener(new Btmf());
		form.setVisible(true);
	}
	static class Btmf implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			form.setVisible(false);
			Set s=new Set();
			s.creation();
		}
	}

	static class Showabout implements ActionListener
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
			aboutForm.setResizable(false);
			aboutForm.setVisible(true);
		}
	}

	static class about implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame about=new JFrame();
			about.getContentPane().setBackground(SystemColor.DARK_GRAY);
			about.setBackground(SystemColor.DARK_GRAY);
			about.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			about.setBounds(200, 200, 390, 160);
			about.setTitle("About");
			about.setResizable(false);
			JTextArea ta = new JTextArea();
			ta.setText("\nBlackList application\n\nVersion : 1.0\n\nContact Us : Command003@gmail.com");
			ta.setBounds(12, 23, 206, 90);
			ta.setFont(new Font("Serif",Font.ITALIC,15));
			ta.setBackground(SystemColor.DARK_GRAY);
			ta.setEnabled(false);
			about.getContentPane().add(ta);
			about.setVisible(true);
		}
	}

	static class openManual implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			File file = new File("C:\\newfile\\BlackList_Manual.pdf");

			try {
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
			} catch (IOException e1) {
				logger.error(e1);
			}
		}
	}
	static class Sch implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame shm=new JFrame();
			shm.getContentPane().setBackground(SystemColor.DARK_GRAY);
			shm.setBackground(SystemColor.DARK_GRAY);
			shm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			shm.setBounds(200, 200, 905, 240);
			shm.setTitle("Schematic");
			JTextArea t = new JTextArea();
			t.setText("\nBlackList application consists of three (3) different databases : SDN , UN Security sanctions list , Al-Qaida.\n"
					+ "Database SDN consists of 1)Person(firstname ,lastname),\n"
					+ "2)Info(category, sdnType, remarks, program, dateOfBirth),\n"
					+ "3)Location(country, address1).\n"
					+ "Database Al-Qaida consisits of 1)Person(FIRST_NAME, SECOND_NAME, THIRD_NAME, FOURTH_NAME),\n"
					+ "2)Info(REFERENCE_NUMBER ,LISTED_ON, COMMENTS1),\n"
					+ "3)Location(COUNTRY, NOTE).\n"
					+ "Database UN Security sanctions list consists of 1)Person(FIRSTNAME ,LASTNAME ,MIDDLENAME ,WHOLENAME),\n"
					+ "2)Info(FUNCTION, GENDER, DATE, LANGUAGE),\n"
					+ "3)Location(COUNTRY,PLACE).");
			t.setBounds(12, 23, 206, 90);
			t.setFont(new Font("Serif",Font.ITALIC,15));
			t.setBackground(SystemColor.DARK_GRAY);
			t.setEnabled(false);
			shm.getContentPane().add(t);
			shm.setResizable(false);
			shm.setVisible(true);
		}
	}
	public static class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException, SQLException {
		GuiReturnForm grf=new GuiReturnForm();
		grf.initialize();	
	}
}