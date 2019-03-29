package ConsoleApp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Still need to deal with titles with spaces in name
public class GuessTheMovie {

    public static void main(String[] args) throws Exception{
        Movie movie = new Movie();
        String selectedMovie = movieSelector();
        movie.setTitle(selectedMovie);
        String movieTitle = movie.getTitle();
        /*StringBuilders for player's guesses
         * movieTitlePlaceHolder is for testing whether the puzzle has been solved
         * movieTitlePlaceHolder2 is for displaying the title with spaces between underscores
         */
        StringBuilder movieTitlePlaceHolder = new StringBuilder(movieTitle.length());
        StringBuilder movieTitlePlaceHolder2 = new StringBuilder(movieTitle.length()*2);
        StringBuilder lettersGuessed = new StringBuilder(52);

        boolean hasWon = false;
        int numberWrongGuesses = 0;

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

        while(hasWon == false && numberWrongGuesses < 10){
            Scanner scanner = new Scanner(System.in);
            System.out.println("You are guessing: " + movieTitlePlaceHolder2);
            System.out.println(" ");
            System.out.println("You have " + (10 - numberWrongGuesses) + " guesses remaining");
            System.out.println(" ");
            System.out.println("You have already guessed: " + lettersGuessed.toString());
            System.out.println(" ");
            System.out.println("Guess a letter or try to solve:");

            String lettersGuessedString = lettersGuessed.toString();
            String guess = scanner.nextLine();
            if (guess.equals("")){
                guess = " ";
            }

            // Need to add if guess is 1 char
            if(guess.length() < 2) {
                //check if letter has already been guessed
                if (lettersGuessedString.contains(guess.toLowerCase()) || lettersGuessedString.contains(guess.toUpperCase())) {
                    System.out.println(" ");
                    System.out.println("You already guessed that letter");
                    System.out.println(" ");
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
                        System.out.println(" ");
                        System.out.println("Correct");
                        System.out.println(" ");
                        //If incorrect increment wrong guesses
                    } else {
                        numberWrongGuesses += 1;
                        System.out.println(" ");
                        System.out.println("Wrong");
                        System.out.println(" ");
                        System.out.println(10 - numberWrongGuesses);
                        System.out.println(" ");
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
                }
            }
            //If guessing the entire movie title
            else {
                if (movieTitle.toLowerCase().equals(guess.toLowerCase())) {
                    hasWon = true;
                    System.out.println(movieTitle);
                }
                else {
                    numberWrongGuesses += 1;
                    System.out.println(" ");
                }
            }
        }
        //Game end result
        if (hasWon) {
            System.out.println("CONGRATULATIONS!!! YOU WIN!!!");
            System.out.println("CORRECT! THE MOVIE IS: " + movieTitle);
        } else if (numberWrongGuesses == 10) {
            System.out.println("YOU'RE OUT OF GUESSES! THE MOVIE TITLE IS: " + movieTitle);
            System.out.println("YOU LOSE! TRY AGAIN!!");
        }
    }

    public static String movieSelector(){
        InputStream is = ConsoleApp.GuessTheMovie.class.getResourceAsStream("resources/movieList.txt");
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
