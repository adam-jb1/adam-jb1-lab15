import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaGUI extends JFrame {
    
    private JComboBox<String> innerVal;
    private JComboBox<String> middleVal;
    private JComboBox<String> outVal;
    private JTextField startValue;

    private JButton button;
    private JButton button1;

    private JTextArea text;
    private JTextArea text1;


    private final String[] rotorInit = {
        "1", "2", "3", "4", "5",
    };

    public EnigmaGUI() {
        super();

        startValue = new JTextField("EST", 10);
        innerVal = new JComboBox<String>(rotorInit); //dropdown options of from/to
        middleVal   = new JComboBox<String>(rotorInit);
        outVal = new JComboBox<String>(rotorInit);
        button = new JButton("Encrypt");
        button1 = new JButton("Decrypt");
        text = new JTextArea(5,35);
        text1 = new JTextArea(5,35);

        // Create panel with flow layout and add GUI elements
        JPanel dpanel = new JPanel(new FlowLayout());

        dpanel.add(new JLabel("Inner"));
        dpanel.add(innerVal);
        dpanel.add(new JLabel("Middle"));
        dpanel.add(middleVal);
        dpanel.add(new JLabel("Out"));
        dpanel.add(outVal);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(startValue);
        dpanel.add(button, BorderLayout.SOUTH);
        dpanel.add(button1, BorderLayout.SOUTH);

        //Layout the text areas
        JPanel layPanel = new JPanel();
        layPanel.setLayout(new GridLayout(2, 2, 2, 2));

        layPanel.add(new JLabel("Input"));
        layPanel.add(text);

        layPanel.add(new JLabel("Output"));
        layPanel.add(text1);
        text1.setEditable(false);

        add(layPanel, BorderLayout.SOUTH);

        //add the same action listener for all
        CoverterActionListener a = new CoverterActionListener();

        button.addActionListener(a);
        button1.addActionListener(a);
            
        
        this.add(dpanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }



    //use a private, inner class to handle events
    private class CoverterActionListener implements ActionListener {

         public void actionPerformed(ActionEvent e) {

            // Get rotor numbers
            int r1 = innerVal.getSelectedIndex();
            int r2 = middleVal.getSelectedIndex();
            int r3 = outVal.getSelectedIndex();

            String start = startValue.getText();
            String input = text.getText();
            Enigma eng = new Enigma(r1, r2, r3, start);
            String result; 

            //e.getSource() I found from google to check for multiple buttons.
            if ((e.getSource() == button) == true) {
                result = eng.encrypt(input);
            } else {
                result = eng.decrypt(input);
            }

            // Send to output box
            text1.setText(result);
        }
    }
}
