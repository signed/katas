package kata.chronos.swing;

import kata.chronos.CommonLauncher;

import javax.swing.*;

public class SwingLauncher {

    public static void main(String[] args) {
        new SwingLauncher().launch(args);
    }

    private void launch(String[] args) {
        final SwingClockCabinet clockCabinet = new SwingClockCabinet();
        CommonLauncher.BuildFrom(args, clockCabinet);

        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI(clockCabinet.component()));
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
