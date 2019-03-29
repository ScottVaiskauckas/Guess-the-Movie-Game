package SwingApp;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel {

    private JLabel movieTitleLabel;
    private JLabel endGameLabel;
    private JLabel resultOfGuess;

    public WordPanel() {
        movieTitleLabel = new JLabel("");
        endGameLabel = new JLabel("");
        resultOfGuess = new JLabel("");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //First Row //

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 20, 0);
        gc.anchor = GridBagConstraints.CENTER;
        endGameLabel.setForeground(Color.decode("#FFFFFF"));
        endGameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        add(endGameLabel, gc);

        //Second Row//

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 20, 0);
        resultOfGuess.setForeground(Color.decode("#FFFFFF"));
        resultOfGuess.setFont(new Font("Dialog", Font.BOLD, 14));
        add(resultOfGuess, gc);

        //Third Row//

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        movieTitleLabel.setForeground(Color.decode("#FFFFFF"));
        movieTitleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        add(movieTitleLabel, gc);

        setBackground(Color.decode("#474444"));
    }

    public void setMovieTitleLabel(String text){
        movieTitleLabel.setText(text);
    }

    public void setEndGameLabel(String text){
        endGameLabel.setText(text);
    }

    public void setResultOfGuess(String text){ resultOfGuess.setText(text);}

}
