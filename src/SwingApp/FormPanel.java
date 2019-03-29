package SwingApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    private JButton guessButton;
    private JButton resetButton;
    private JTextField guessTextField;

    private FormListener formListener;

    private ResetListener resetListener;

    public FormPanel(){
        guessTextField = new JTextField(10);
        guessButton = new JButton("Guess");
        resetButton = new JButton("Reset");

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //First Row //

        gc.weightx = 1;
        gc.weighty = 1.0;
        gc.gridwidth = 2;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 15, 0);
        guessTextField.setBackground(Color.decode("#676565"));
        guessTextField.setForeground(Color.decode("#FFFFFF"));
        guessTextField.setFont(new Font("Dialog", Font.BOLD, 14));
        add(guessTextField, gc);

        //Second Row//

        gc.weightx = 1;
        gc.weighty = 1.0;
        gc.gridwidth = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 5);
        guessButton.setBackground(Color.decode("#676565"));
        guessButton.setForeground(Color.decode("#FFFFFF"));
        guessButton.setOpaque(true);
        guessButton.setBorderPainted(false);
        guessButton.setFont(new Font("Dialog", Font.BOLD, 14));
        add(guessButton, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 5, 0, 0);
        gc.anchor = GridBagConstraints.CENTER;
        resetButton.setBackground(Color.decode("#676565"));
        resetButton.setForeground(Color.decode("#FFFFFF"));
        resetButton.setOpaque(true);
        resetButton.setBorderPainted(false);
        resetButton.setFont(new Font("Dialog", Font.BOLD, 14));
        add(resetButton, gc);

        setBackground(Color.decode("#474444"));

        guessTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guess = guessTextField.getText();

                FormEvent formEvent = new FormEvent(this, guess);

                if (formListener != null){
                    formListener.formEventOccurred(formEvent);
                }
            }
        });

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String guess = guessTextField.getText();

               FormEvent formEvent = new FormEvent(this, guess);

                if (formListener != null){
                    formListener.formEventOccurred(formEvent);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResetEvent resetEvent = new ResetEvent(this);

                if (resetListener != null) {
                    resetListener.resetButtonPressed(resetEvent);
                }
            }
        });
    }
    public void setFormListener(FormListener listener){
        this.formListener = listener;
    }
    public void setResetListener(ResetListener listener){
        this.resetListener = listener;
    }
    public void setGuessTextField(String string){guessTextField.setText(string);}
    public void setFocusAfterGuess(){guessTextField.requestFocus();}
}
