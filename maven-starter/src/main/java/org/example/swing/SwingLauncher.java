package org.example.swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SwingLauncher {

    public static void main(String[] args) {
        new SwingLauncher().launch(args);
    }

    private void launch(String[] args) {
        JLabel label = new JLabel("hello world");
        final JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(160, 25));
        JButton button = new JButton("press me");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Ouch, not so hard...");
            }
        });


        final JPanel panel = new JPanel();
        panel.add(label);
        panel.add(button);
        panel.add(textField);


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(panel);
            }
        });
    }

    private void createAndShowGUI(JComponent display) {
        JFrame frame = new JFrame("application name");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }

}
