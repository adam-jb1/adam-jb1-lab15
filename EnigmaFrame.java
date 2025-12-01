import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame {

    public static void main(String[] args) {
        EnigmaGUI gui = new EnigmaGUI();
        gui.setTitle("Enigma GUI"); // sets title that appears on the top bar
        gui.setSize(800, 250);          // sets the size (in pixels) of the frame
        gui.setLocation(100, 100);
        gui.setVisible(true);
    }
}
