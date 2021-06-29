import GUI.CustomJPanel;

import javax.swing.*;

public class Main {

//    TODO: Get this to launch correctly
    public static void main(String[] args){
        JFrame jFrame = new JFrame();
        CustomJPanel jPanel = new CustomJPanel();

        jFrame.setSize(1000, 300);
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
