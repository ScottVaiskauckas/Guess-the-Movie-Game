package SwingApp;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainFrame extends JFrame {

    private WordPanel wordPanel;
    private FormPanel formPanel;
    private WrongGuessesPanel wrongGuessesPanel;
    private LettersGuessedPanel lettersGuessedPanel;
    boolean hasWon = false;
    int numberWrongGuesses = 0;
    String selectedMovie;
    String movieTitle;
    StringBuilder movieTitlePlaceHolder;
    StringBuilder movieTitlePlaceHolder2;
    StringBuilder lettersGuessed;

    public MainFrame(){
        super("Guess the Movie");

        Movie movie = new Movie();
        selectedMovie = movieSelector();
        movie.setTitle(selectedMovie);
        movieTitle = movie.getTitle();
        /*StringBuilders for player's guesses
        * movieTitlePlaceHolder is for testing whether the puzzle has been solved
        * movieTitlePlaceHolder2 is for displaying the title with spaces between underscores
        */
        movieTitlePlaceHolder = new StringBuilder(movieTitle.length());
        movieTitlePlaceHolder2 = new StringBuilder(movieTitle.length()*2);
        lettersGuessed = new StringBuilder(52);
        //Construct StringBuilder with movieTitle String
        for (int i = 0; i<movieTitle.length(); i++)
            if (movieTitle.substring(i, i + 1).equals(" ")){
                movieTitlePlaceHolder.append(" ");
                movieTitlePlaceHolder2.append("  ");
            }
            else {
                movieTitlePlaceHolder.append("_");
                movieTitlePlaceHolder2.append("_ ");
            }

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        wrongGuessesPanel = new WrongGuessesPanel();
        wordPanel = new WordPanel();
        formPanel = new FormPanel();
        lettersGuessedPanel = new LettersGuessedPanel();

        //First Row //

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 20);
        gc.anchor = GridBagConstraints.LINE_END;
        wrongGuessesPanel.setForeground(Color.decode("#FFFFFF"));
        add(wrongGuessesPanel, gc);

        //Second Row//

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        wordPanel.setForeground(Color.decode("#FFFFFF"));
        add(wordPanel, gc);

        //Third Row//

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        lettersGuessedPanel.setForeground(Color.decode("#FFFFFF"));
        add(lettersGuessedPanel, gc);

        //Fourth Row//

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        formPanel.setForeground(Color.decode("#FFFFFF"));
        formPanel.setSize(400, 400);
        add(formPanel, gc);

        setSize(600, 575);
        getContentPane().setBackground(Color.decode("#474444"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        wordPanel.setMovieTitleLabel(movieTitlePlaceHolder2.toString());
        wrongGuessesPanel.setNumberGuessesLabel(Integer.toString(10-numberWrongGuesses));



        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccurred(FormEvent e) {
                //check if game is over
                if(!hasWon && numberWrongGuesses < 10) {
                    String lettersGuessedString = lettersGuessed.toString();
                    String guess = e.getGuess();
                    //If guessing a single letter
                    if(guess.length() < 2 && guess.length() > 0) {
                        //check if letter has already been guessed
                        if (lettersGuessedString.contains(guess.toLowerCase()) || lettersGuessedString.contains(guess.toUpperCase())) {
                            wordPanel.setResultOfGuess("You already guessed that letter");
                        } else {
                            //check if guess is correct
                            if (movieTitle.contains(guess.toUpperCase()) || movieTitle.contains(guess.toLowerCase())) {
                                for (int i = 0; i < movieTitle.length(); i++) {
                                    if (guess.toUpperCase().equals(movieTitle.substring(i, i + 1))) {
                                        movieTitlePlaceHolder.replace(i, i + 1, guess.toUpperCase());
                                        movieTitlePlaceHolder2.replace(i*2, i*2 + 1, guess.toUpperCase());
                                    }
                                    if (guess.toLowerCase().equals(movieTitle.substring(i, i + 1))) {
                                        movieTitlePlaceHolder.replace(i, i + 1, guess.toLowerCase());
                                        movieTitlePlaceHolder2.replace(i*2, i*2 + 1, guess.toLowerCase());
                                    }
                                }
                                wordPanel.setResultOfGuess("Correct");
                                wordPanel.setMovieTitleLabel(movieTitlePlaceHolder2.toString());
                            //If incorrect increment wrong guesses
                            } else {
                                numberWrongGuesses += 1;
                                wrongGuessesPanel.setNumberGuessesLabel(Integer.toString(10 - numberWrongGuesses));
                                wordPanel.setResultOfGuess("Wrong");
                            }
                            String movieTitle2 = movieTitlePlaceHolder.toString();
                            //Check if player has solved the puzzle
                            if (movieTitle.equals(movieTitle2)) {
                                hasWon = true;
                            }
                            //Display letters already guessed
                            lettersGuessed.append(guess);
                            lettersGuessedString = lettersGuessed.toString();
                            char lettersGuessedCharArray[] = lettersGuessedString.toUpperCase().toCharArray();
                            Arrays.sort(lettersGuessedCharArray);
                            lettersGuessed.delete(0, 51);
                            for (char c : lettersGuessedCharArray) {
                                lettersGuessed.append(c);
                            }
                            lettersGuessedPanel.setLettersGuessedLabel(lettersGuessed.toString());
                        }
                    }
                    //If guessing the entire movie title
                    else if (guess.length() > 2) {
                        if (movieTitle.toLowerCase().equals(guess.toLowerCase())) {
                            hasWon = true;
                            wordPanel.setMovieTitleLabel(movieTitle);
                        }
                        else {
                            numberWrongGuesses += 1;
                            wrongGuessesPanel.setNumberGuessesLabel(Integer.toString(10 - numberWrongGuesses));
                            wordPanel.setResultOfGuess("Wrong");
                        }
                    }
                    else {
                        wordPanel.setResultOfGuess("Please make a guess");
                    }
                    //Game end result
                    if (hasWon) {
                        wordPanel.setEndGameLabel("CONGRATULATIONS!!! YOU WIN!!!");
                        wordPanel.setResultOfGuess("CORRECT! THE MOVIE IS: ");
                        wordPanel.setMovieTitleLabel(movieTitle);
                    } else if (numberWrongGuesses == 10) {
                        wordPanel.setResultOfGuess("YOU'RE OUT OF GUESSES! THE MOVIE TITLE IS: ");
                        wordPanel.setEndGameLabel("YOU LOSE! TRY AGAIN!!");
                        wordPanel.setMovieTitleLabel(movieTitle);
                    }
                }
                //Clear textfield and set focus on textfield
                formPanel.setGuessTextField("");
                formPanel.setFocusAfterGuess();
            }
        });

        formPanel.setResetListener(new ResetListener() {
            @Override
            public void resetButtonPressed(ResetEvent event) {
                hasWon = false;
                numberWrongGuesses = 0;
                selectedMovie = movieSelector();
                movie.setTitle(selectedMovie);
                movieTitle = movie.getTitle();
                movieTitlePlaceHolder = new StringBuilder(movieTitle.length());
                movieTitlePlaceHolder2 = new StringBuilder(movieTitle.length()*2);

                for (int i = 0; i<movieTitle.length(); i++)
                    if (movieTitle.substring(i, i + 1).equals(" ")){
                        movieTitlePlaceHolder.append(" ");
                        movieTitlePlaceHolder2.append("  ");
                    }
                    else {
                        movieTitlePlaceHolder.append("_");
                        movieTitlePlaceHolder2.append("_ ");
                    }

                wordPanel.setMovieTitleLabel(movieTitlePlaceHolder2.toString());
                wrongGuessesPanel.setNumberGuessesLabel(Integer.toString(10-numberWrongGuesses));
                wordPanel.setEndGameLabel("");
                wordPanel.setResultOfGuess("");
                lettersGuessedPanel.setLettersGuessedLabel("");
                lettersGuessed.delete(0, 51);
            }
        });
    }

    public static String movieSelector(){
        InputStream is = Main.class.getResourceAsStream("resources/movieList.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(isr);
        String st;
        ArrayList<String> movieArrayList = new ArrayList<String>();
        try {
            while ((st = bufferedReader.readLine()) != null) {
                movieArrayList.add(st);
            }
            bufferedReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        int randomNumber = (int) (Math.random() * movieArrayList.size());
        String selectedMovie = movieArrayList.get(randomNumber);
        return selectedMovie;
    }
}