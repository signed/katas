package com.github.signed.kata.chronos.swing;

import com.github.signed.kata.chronos.CommonLauncher;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SwingLauncher {

    public static void main(String[] args) {
        new SwingLauncher().launch(args);
    }

    private void launch(String[] args) {
        final SwingClockCabinet clockCabinet = new SwingClockCabinet();
        CommonLauncher.BuildFrom(args, clockCabinet);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(clockCabinet.component());
            }
        });
    }

    private void createAndShowGUI(JComponent display) {
        //Create and set up the window.
        JFrame frame = new JFrame("Chronos Clock");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }

}
