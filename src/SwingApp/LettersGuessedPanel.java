package SwingApp;

import javax.swing.*;
import java.awt.*;

public class LettersGuessedPanel extends JPanel {

    private JLabel lettersGuessedLabel;
    private JLabel youHaveGuessedLettersLabel;

    public LettersGuessedPanel() {
        youHaveGuessedLettersLabel = new JLabel("You have guessed: ");
        lettersGuessedLabel = new JLabel("");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //First Row //

        gc.weightx = 1;
        gc.weighty = 1.0;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 15, 0);
        youHaveGuessedLettersLabel.setForeground(Color.decode("#FFFFFF"));
        youHaveGuessedLettersLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        add(youHaveGuessedLettersLabel, gc);

        //Second Row//

        gc.weightx = 1;
        gc.weighty = 1.0;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.CENTER;
        lettersGuessedLabel.setForeground(Color.decode("#FFFFFF"));
        lettersGuessedLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(lettersGuessedLabel, gc);

        setBackground(Color.decode("#474444"));
    }

    public void setLettersGuessedLabel(String text){ lettersGuessedLabel.setText(text);}
}
