package GUI;

import Model.Movie;
import Model.MovieLibrary;

import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {

    private AnswerBankPanel answerBankPanel;
    private GuessPanel guessPanel;
    private MovieLibrary movieLibrary;
    private Movie selectedMovie;

    public CustomJPanel(){
        super();
        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 10, 0);

        //Get your model
        movieLibrary = new MovieLibrary();
        selectedMovie = movieLibrary.getMovie();
        answerBankPanel = new AnswerBankPanel(movieLibrary);
        guessPanel = new GuessPanel(movieLibrary, selectedMovie, answerBankPanel);

        c.gridx = 0;
        c.gridy = 0;
        add(answerBankPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        add(guessPanel, c);
    }
}
