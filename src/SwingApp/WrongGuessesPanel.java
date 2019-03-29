package SwingApp;

import javax.swing.*;
import java.awt.*;

public class WrongGuessesPanel extends JPanel {

    private JLabel guessesRemainingLabel;
    private JLabel numberGuessesLabel;

    public WrongGuessesPanel() {
        guessesRemainingLabel = new JLabel("Wrong Guesses Remaining: ");
        numberGuessesLabel = new JLabel("");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        guessesRemainingLabel.setForeground(Color.decode("#FFFFFF"));
        System.out.println(guessesRemainingLabel.getFont());
        guessesRemainingLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        add(guessesRemainingLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 5);
        numberGuessesLabel.setForeground(Color.decode("#FFFFFF"));
        numberGuessesLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        add(numberGuessesLabel, gc);

        setBackground(Color.decode("#474444"));
    }

    public void setNumberGuessesLabel(String text){
        numberGuessesLabel.setText(text);
    }

}
