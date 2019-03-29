package SwingApp;

import javax.swing.*;

public class Main {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new MainFrame();
            }
        });
    }
}