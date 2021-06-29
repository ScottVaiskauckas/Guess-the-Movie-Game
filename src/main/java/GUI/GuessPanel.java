package GUI;

import Model.Movie;
import Model.MovieLibrary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessPanel extends JPanel {
    private JButton resetButton, guessButton;
    //TODO: Remove trailing spaces
    private JTextField guessField;
    private JLabel displayLabel;
    private MovieLibrary movieLibrary;
    private Movie selectedMovie;
    private AnswerBankPanel answerBankPanel;

    public GuessPanel(MovieLibrary movieLibrary, Movie selectedMovie, AnswerBankPanel answerBankPanel){
        super();
        this.movieLibrary = movieLibrary;
        this.selectedMovie = selectedMovie;
        this.answerBankPanel = answerBankPanel;
        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetListener());
        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessListener());

        displayLabel = new JLabel();
        guessField = new JTextField(20);

        add(displayLabel);
        add(guessField);
        add(guessButton);
        add(resetButton);
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getGuessButton() {
        return guessButton;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectedMovie = movieLibrary.getMovie();
            displayLabel.setText("");
            answerBankPanel.reset(movieLibrary);
            guessField.setEnabled(true);
            guessButton.setEnabled(true);
        }
    }

    public class GuessListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = guessField.getText();
            Movie movie = new Movie(title);
            if(movie.equals(selectedMovie)){
                //TODO: Calculate miss-to-list ratio to display score
                displayLabel.setText("You win!");
                guessField.setEnabled(false);
                guessButton.setEnabled(false);
            } else {
                guessField.setText("");
                displayLabel.setText("guess again");
                answerBankPanel.removeAnswer(title);
            }
        }
    }
}
