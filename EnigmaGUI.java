import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaGUI extends JFrame {
    
    private JComboBox<String> innerVal;
    private JComboBox<String> middleVal;
    private JComboBox<String> outVal;
    private JTextField toValue;

    private JButton button;
    private JButton button1;

    private JTextArea text;
    private JTextArea text1;


    private final String[] rotorInit = {
        "1", "2", "3", "4", "5",
    };
    
    private final double[] cfact = {
        1.0000, 1.0 / 12, 3.28084, 0.0328084
    };

    public EnigmaGUI() {
        super();

        toValue = new JTextField("EST", 10);
        innerVal = new JComboBox<String>(rotorInit); //dropdown options of from/to
        middleVal   = new JComboBox<String>(rotorInit);
        outVal = new JComboBox<String>(rotorInit);
        button = new JButton("Encrypt");
        button1 = new JButton("Decrypt");
        text = new JTextArea(5,35);
        text1 = new JTextArea(5,35);

        //toValue.setEditable(true); //do not let the result be edited

        // Create panel with flow layout and add GUI elements
        JPanel dpanel = new JPanel(new FlowLayout()); 
        dpanel.add(new JLabel("Inner"));
        dpanel.add(innerVal);
        dpanel.add(new JLabel("Middle"));
        dpanel.add(middleVal);
        dpanel.add(new JLabel("Out"));
        dpanel.add(outVal);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(toValue);
        dpanel.add(button, BorderLayout.SOUTH);
        dpanel.add(button1, BorderLayout.SOUTH);
        dpanel.add(new JLabel("Input"));
        dpanel.add(text);
        dpanel.add(new JLabel("Output"));
        dpanel.add(text1);

        //add the same action listener for all
        CoverterActionListener a = new CoverterActionListener();
        
        innerVal.addActionListener(a); //change the number in from (when enter is hit)
        middleVal.addActionListener(a);//change the to units
        outVal.addActionListener(a); //change the from units
            
        
        this.add(dpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    //use a private, inner class to handle events
    private class CoverterActionListener implements ActionListener {

         public void actionPerformed(ActionEvent e) {

             //get the index selected in the comboboxes
             int fIdx = innerVal.getSelectedIndex();
             int tIdx = outVal.getSelectedIndex();

             //retrieve the from value as a double
             double fVal = Double.parseDouble(toValue.getText());

             //first convert from value to feet and then divde by the
             //convert to units
             double tVal = (fVal * cfact[fIdx]) / cfact[tIdx];
              
             //round to 3 decimal places
             tVal = Math.round(tVal * 1000.0) / 1000.0;
             
             toValue.setText("" + tVal); //set the toValue text field
         }
    }
}