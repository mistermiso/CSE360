/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.io.*;
import java.util.*;

public class Driver extends JFrame implements ActionListener 
{

    static JFrame frame;
    
    public static void main(String[] args) 
    {
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.add(panel);
        frame.setTitle("CSE360 Final Project");
        frame.setLocationRelativeTo(panel);
        frame.setVisible(true);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem about = new JMenuItem("About");
        JMenuItem loadRoster = new JMenuItem("Load a Roster");
        JMenuItem addAttendance = new JMenuItem("Add Attendance");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem plotData = new JMenuItem("Plot Data");
        
        Driver s = new Driver();
        file.add(loadRoster);
        file.add(addAttendance);
        file.add(save);
        file.add(plotData);
        menuBar.add(file);
        menuBar.add(about);
        frame.setJMenuBar(menuBar);
        frame.validate();
        frame.repaint();
        String popup = "hi";
        about.addActionListener(s);
        loadRoster.addActionListener(s);
        addAttendance.addActionListener(s);
        
}
    @Override
        public void actionPerformed(ActionEvent e) 
        { 
            String csvFile;
            String s = e.getActionCommand();
            if(s.equals("About"))
            {
                JDialog dialog = new JDialog(frame, "About");
                String aboutText = "This team is awesome";
                JLabel label = new JLabel(aboutText);
                dialog.add(label);
                dialog.setSize(200, 200);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
            
            if(s.equals("Load a Roster"))
            {
                JFileChooser chosenFile = new JFileChooser();
                chosenFile.showOpenDialog(null);
                JTable table = new JTable();
                
            }
            
            if(s.equals("Add Attendance"))
            {
            	JFrame frame = new JFrame();
            	JDialog dialog = new JDialog(frame, "Date Picker");
                dialog.setSize(200, 200);
                dialog.setLocationRelativeTo(frame);
            	/*
            	 * This line of code is VERY IMPORTANT. It allows for adding 
            	 * multiple JPanels inside one JDialog pane. Currently it's 
            	 * set to include two JPanels stacked on top of each other.
            	 */
            	dialog.setLayout(new GridLayout(2, 1));
            	
            	JFileChooser chosenFile = new JFileChooser();
                chosenFile.showOpenDialog(null);
                JTable table = new JTable();
            	
                String pickerText = "Please pick a date.";
                JPanel instructionsPanel = new JPanel();
                JPanel datePickerPanel = new JPanel();
                JLabel label = new JLabel(pickerText);
                
                dialog.add(instructionsPanel);
                dialog.add(datePickerPanel);

                Properties properties = new Properties();
                properties.put("text.today", "Today");
                properties.put("text.month", "Month");
                properties.put("text.year", "Year");
            	UtilDateModel model = new UtilDateModel();

            	model.setDate(2020, 10, 29);
                JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
                JDatePickerImpl datePicker = new JDatePickerImpl
                		(datePanel, new DateLabelFormatter());
                
                instructionsPanel.add(label);
                datePickerPanel.add(datePicker);

                /*
                 * Use the Date object, "selectedDate" as the date input we 
                 * need for the programming.
                 */
                Calendar selectedValue = (Calendar) datePicker.getModel().getValue();
                //Date selectedDate = selectedValue.getTime();
                
                dialog.pack();
                dialog.setVisible(true);
            }
            
        }
        public class CSVReaderTest 
        {
            public static final String delimiter = ",";
 
        
            public void read(String csvFile) 
            {
                try {
                    File file = new File(csvFile);
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line = "";
                    String[] tempArr;
                    while((line = br.readLine()) != null) 
                    {
                        tempArr = line.split(delimiter);
                        for(String tempStr : tempArr) 
                        {
                            System.out.print(tempStr + " ");
                        }
                        System.out.println();
                    }
                    br.close();
                }catch(IOException ioe) 
                {
                    ioe.printStackTrace();
                }
            }
        
        
        
        
        
    }
}
    

