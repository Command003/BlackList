package GUIReturnData;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import javax.swing.JList;
import java.awt.Toolkit;

public class GUI_Return_Form {
	protected static JFrame form;
	private static JList list;
	
	

	protected void initialize(){

		ArrayList<String> alist=new ArrayList<String>();
		  alist.add("Ravi");
		  alist.add("Vijay");  
		  alist.add("Ravi");  
		  alist.add("Ajay");  
		  alist.add("Ajay1");
		  alist.add("Ajay2");
		  alist.add("Ajay3");
		  alist.add("Ajay4");
		  alist.add("Ajay5");
		  alist.add("Ajay7");
		  alist.add("Ajay8");
		  alist.add("Ajay9");
		  alist.add("Ajay99");
		  alist.add("Ajay11");
		  alist.add("Ajay22");
		  String[] array = alist.toArray(new String[0]);
		  
		 
		form=new JFrame();//Form
		form.setBounds(100, 100, 242, 325);
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
	
	
	static class savetxt implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        
        {
          ArrayList<String> alist=new ArrayList<String>();
  		  alist.add("Ravi");
  		  alist.add("Vijay");  
  		  alist.add("Ravi");  
  		  alist.add("Ajay");
  		  alist.add("Ejay");
  		 String[] array = alist.toArray(new String[0]);
  		          
      JFileChooser chooser = new JFileChooser();
  			int retrival = chooser.showSaveDialog(null);
  			if (retrival == JFileChooser.APPROVE_OPTION)    
  		try{
  			BufferedWriter bw = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".txt"));
	  for(int i = 0 ; i < array.length ; i++)
	  {
	    bw.write((i+1)+") "+array[i]+"\n\n");
	  }
	  bw.close();
	  }catch(IOException ex) {
          System.err.println("An IOException was caught!");
          ex.printStackTrace();
	  }
  		
        }
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
	
	public static void main(String[] args) {
		GUI_Return_Form grf=new GUI_Return_Form();
		grf.initialize();
		
		
		
	}
}
