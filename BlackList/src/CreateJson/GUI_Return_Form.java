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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.json.simple.parser.ParseException;

import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.Toolkit;

public class GUI_Return_Form {
	private static JFrame form;
	private static JList list;
	private static Set s = new Set();
	static class savetxt implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        
        {
        	File file = new File("src/test1.json");
    		String[] array;

//  		  alist.add("Ravi");
//  		  alist.add("Vijay");  
//  		  alist.add("Ravi");  
//  		  alist.add("Ajay");
//  		  alist.add("Ejay");
        	/*String[] array;
  		 array = (String[])  s.getRezult().toArray();*/
  		          
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
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  		
        }
    }
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void initialize() throws FileNotFoundException, IOException, ParseException{
		
		File file = new File("src/test1.json");
		int i = 0;
		String[] array = new String [s.parseFromJson(file).size()];
		for(Person person : s.parseFromJson(file)){
			array[i] = person.toString();
			
			i++;
		}
	
		
    	
 		 //array = (String[]) alist.toArray();
    	
    	//list = new JList(array);
//		ArrayList<String> alist=new ArrayList<String>();
//		  alist.add("Ravi");
//		  alist.add("Vijay");  
//		  alist.add("Ravi");  
//		  alist.add("Ajay");  
//		  alist.add("Ajay1");
//		  alist.add("Ajay2");
//		  alist.add("Ajay3");
//		  alist.add("Ajay4");
//		  alist.add("Ajay5");
//		  alist.add("Ajay7");
//		  alist.add("Ajay8");
//		  alist.add("Ajay9");
//		  alist.add("Ajay99");
//		  alist.add("Ajay11");
//		  alist.add("Ajay22");
//		  String[] array = alist.toArray(new String[0]);
		/*ArrayList<String> alist=new ArrayList<String>();
   	 alist.add("Ravi");
	  alist.add("Vijay");  
	  alist.add("Ravi");  
	  alist.add("Ajay");
	  alist.add("Ejay");
	  String[] array=alist.toArray(new String[0]);*/
		 
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