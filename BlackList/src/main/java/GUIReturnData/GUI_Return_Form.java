package GUIReturnData;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JList;
//import com.google.gson.*;

public class GUI_Return_Form {
	private JTable table;
	private JTextField textField;
	
	
	
	
	public void saveTable()throws Exception
	{
		try{
			//String filepath = textField.getText();
	  BufferedWriter bw = new BufferedWriter(new FileWriter("/home/student/Desktop/Result.txt"));
	  for(int i = 0 ; i < table.getColumnCount() ; i++)
	  {
	    bw.write(table.getColumnName(i));
	    bw.write("\n");
	  }

	  for (int i = 0 ; i < table.getRowCount(); i++)
	  {
	    bw.newLine();
	    for(int j = 0 ; j < table.getColumnCount();j++)
	    {
	      bw.write((String)(table.getValueAt(i,j)));
	      bw.write("\n");;
	    }
	  }
	  bw.close();
	  }catch(IOException e){
		  System.out.println(e);
	  }
	}

	
	private void initialize(){
		JFrame form=new JFrame();
		form.setBounds(100, 100, 450, 325);
		form.setTitle("Information Form");
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.getContentPane().setLayout(null);
		
		JButton savetoButton = new JButton("Save result to .txt file");
		savetoButton.setBounds(10, 253, 426, 23);
		form.getContentPane().add(savetoButton);
	    savetoButton.addActionListener(new saveTotxt());
		//savetoButton.addActionListener(new saveForm());
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Something");
		menuBar.add(menu1);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		JMenuItem aboutItem = new JMenuItem("About");
		JMenuItem backItem=new JMenuItem("Back");
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(aboutItem);
        menu1.add(backItem);
        menu1.add(exitItem);
         
		menuBar.setBounds(0, 0, 434, 21);
		form.getContentPane().add(menuBar);
		
		//table = new JTable();
		//table.setBounds(10, 62, 414, 146);
		//form.getContentPane().add(table);
		//--DefaultTableModel model = new DefaultTableModel();//The DefaultTableModel stores the data for the JTable in a Vector of Vectors.
		//--JScrollPane scroll=new JScrollPane(table);//Create the scroll pane and add the table to it.
//   add this later JScrollPane scrollPane = new JScrollPane(table);//The JScrollPane constructor is invoked with an argument that refers to the table object. This creates a scroll pane as a container for the table; the table is automatically added to the container.
//   add this later	table.setFillsViewportHeight(true);//JTable.setFillsViewportHeight is invoked to set the fillsViewportHeight property. When this property is true the table uses the entire height of the container, even if the table doesn't have enough rows to use the whole vertical space. This makes it easier to use the table as a drag-and-drop target.
		/*Alternative for this
		table.setLayout(new BorderLayout());
		form.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		form.getContentPane().add(table, BorderLayout.CENTER);*/
		//JScrollPane scrollTable = new JScrollPane(table);
		//2JScrollPane pane = new JScrollPane(table);
		
		JLabel label1 = new JLabel("Persons from wanted list :");
		label1.setBounds(10, 37, 212, 14);
		form.getContentPane().add(label1);
		
		JButton resultButton = new JButton("Show results");
		resultButton.setBounds(10, 219, 426, 23);
		form.getContentPane().add(resultButton);
		
		JList list = new JList();
		list.setBounds(10, 63, 426, 144);
		form.getContentPane().add(list);
		
		//JTextArea text = new JTextArea();
		//text.setBounds(234, 64, 88, 143);
		//form.getContentPane().add(text); 
		
		//textField = new JTextField();
	    //textField.setBounds(338, 32, 86, 20);
		//form.getContentPane().add(textField);
		//textField.setColumns(10);
		
		//savetoButton.addActionListener();
		exitItem.addActionListener(new exit());
		backItem.addActionListener(new btmf());
		form.setVisible(true);
	}
	
	
	static class btmf implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	JFrame mainform=new JFrame();
        	mainform.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        	mainform.setBounds(100, 100, 450, 300);
        	mainform.setTitle("Main Form");
          //mainform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	mainform.getContentPane().setLayout(null);
        	mainform.setVisible(true);
        }
    }
	
	static class exit implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	            System.exit(0);
	        }
	    }
	//jTextArea.setText(myArrayList.toString()); 

	/*static class displayresult implements ActionListener
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	ArrayList<String> strings = new ArrayList<String>();
	        	strings.add("one");
	        	strings.add("two");
	        	strings.add("three");
	        	         
	        	JTextArea text = new JTextArea();
	    		text.setBounds(234, 64, 88, 143);
	    		//form.getContentPane().add(text);
	        	// Iterate over entire ArrayList
	        	for(String s : strings)
	        	{
	        	    // Append each string from ArrayList to the end of text in JTextArea
	        	    // separated by newline
	        	    text.append(s + System.getProperty("line.separator"));
	        	}
	        }
	    }*/
	
	/*static class saveForm implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	GUI_Return_Form grf=new GUI_Return_Form();
        	JFrame saveform=new JFrame();
        	saveform.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        	saveform.setBounds(100, 100, 300, 300);
        	saveform.setTitle("Save file");
        	saveform.getContentPane().setLayout(null);
        	saveform.setVisible(true);
        	grf.textField = new JTextField();
        	grf.textField.setBounds(338, 32, 86, 20);
        	saveform.getContentPane().add(saveform);
            grf.textField.setColumns(10);
        }
    }*/
	
	static class saveTotxt implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	GUI_Return_Form g=new GUI_Return_Form();
        	try {
				g.saveTable();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
	
	static class showresultbutton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	/*ArrayList<String> list = new ArrayList<String>();
list.add("str1");
list.add("str2");
list.add("str3");
String json = new Gson().toJson(list);*/

        	//ArrayList<String> strings = new ArrayList<String>();
        	//strings.add("one");
        	//strings.add("two");
        	//strings.add("three");
        	//TextArea.setText(ArrayList<String>.toString()); 
        }
    }
	
	
	public static void main(String[] args) {
		GUI_Return_Form grf=new GUI_Return_Form();
		grf.initialize();
		
		
		
	}
}