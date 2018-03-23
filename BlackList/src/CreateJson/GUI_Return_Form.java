package CreateJson;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import org.json.simple.parser.ParseException;
import javax.swing.JMenu;
import javax.swing.JList;
public class GUI_Return_Form {
	private static JFrame form;
	@SuppressWarnings("rawtypes")
	private static JList list;
	private static Set s = new Set();
	static class savetxt implements ActionListener
    {
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e)
        
        {
        	File file = new File("/home/student/workspace/BlackList/src/test1.json");
    		String[] array;
      JFileChooser chooser = new JFileChooser();
  			int retrival = chooser.showSaveDialog(null);
  			if (retrival == JFileChooser.APPROVE_OPTION)    
  		try{
  			int i = 0;
  			array = new String [s.parseFromJson(file).size()];
  			for(Person person : s.parseFromJson(file)){
  				array[i] = person.toString();
  				i++;
  			}
  			BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".txt"));
	  for(i = 0 ; i < array.length ; i++)
	  {
	    bw.write(array[i]);
	  }
	  bw.close();
	  }catch(IOException ex) {
          System.err.println("An IOException was caught!");
          ex.printStackTrace();
	  } catch (ParseException e1) {
		e1.printStackTrace();
	}
  		
        }
    }
	public void nulllist(){
		String[] arr=new String[1];
		arr [0] = "FALSE";
		form=new JFrame();//Form
		form.setBounds(100, 100, 249, 325);
		form.setTitle("Result Form");
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setLayout(null);
		list = new JList(arr);
		list.setBounds(10, 62, 218, 180);
		form.getContentPane().add(list);
		form.setVisible(true);
		list.setVisible(true);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void initialize() throws FileNotFoundException, IOException, ParseException{	
		File file = new File("/home/student/workspace/BlackList/src/test1.json");
		int i = 0;
		String[] array = new String [s.parseFromJson(file).size()];
		for(Person person : s.parseFromJson(file)){
			array[i] = person.toString();
			i++;
		}
		form=new JFrame();//Form
		form.setBounds(100, 100, 249, 325);
		form.setTitle("Result Form");
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setLayout(null);
		
		JButton savetoButton = new JButton("Save result to .txt file");//Save to .txt file button
		savetoButton.setBounds(10, 253, 218, 23);
		form.getContentPane().add(savetoButton);
		
		JMenuBar menuBar = new JMenuBar();//Menu
		JMenu menu1 = new JMenu("Action");
		menuBar.add(menu1);
		menuBar.setBounds(0, 0, 240, 21);
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
		//form.getContentPane().add(list);
		DefaultListSelectionModel m = new DefaultListSelectionModel();
	    m.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    m.setLeadAnchorNotificationEnabled(false);
	    list.setSelectionModel(m);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 62, 218, 180);
		form.getContentPane().add(scrollPane);
		
		savetoButton.addActionListener(new savetxt());
		aboutItem.addActionListener(new showabout());
		exitItem.addActionListener(new exit());
		backItem.addActionListener(new btmf());
		form.setVisible(true);
	}
	static class btmf implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	form.setVisible(false);
        	Set s=new Set();
        	s.Creation();
        }
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
	static class exit implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            System.exit(0);
	        }
	    }
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		GUI_Return_Form grf=new GUI_Return_Form();
		grf.initialize();	
	}
}