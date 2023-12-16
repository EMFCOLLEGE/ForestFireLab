import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Starter {

	public static void main(String[] args) {
        JFrame frame = new JFrame("Cooler Forest Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        RealForestPanel mainPanel = new RealForestPanel();
        mainPanel.setPreferredSize(new Dimension(1024,768));
        mainPanel.setBackground(Color.white);
        frame.getContentPane().add(mainPanel);


        frame.pack();

	}
}
