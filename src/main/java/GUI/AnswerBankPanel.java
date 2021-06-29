package GUI;

import Model.Movie;
import Model.MovieLibrary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerBankPanel extends JPanel {

    private List<JLabel> labels;
    private List<Movie> movies;

    public AnswerBankPanel(MovieLibrary movieLibrary){
        //Get the movies from the library
        movies = movieLibrary.copyMovies();
        labels = new ArrayList<>();
        GridBagLayout bagLayout = new GridBagLayout();
        setLayout(bagLayout);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 5, 10);
        c.gridx = 0;
        c.gridy = 0;

        for(int i = 0; i < movies.size(); i++){
            c.gridy+=1;
            JLabel jLabel = new JLabel(movies.get(i).getTitle());
            labels.add(jLabel);
            add(jLabel, c);
            //Every five items, move to a new col
            if(c.gridy % 5 == 0){
                c.gridx+=1;
                c.gridy=0;
            }
        }
    }

    public void removeAnswer(String title){
        Movie movie = new Movie(title);

        if(movies.contains(movie)){
            movies.remove(movie);
        }
        erase();
        redraw();
    }

    public void reset(MovieLibrary movieLibrary){
        movies = movieLibrary.copyMovies();

        for(int i = 0; i < movies.size(); i++){
            String title = movies.get(i).getTitle();
            labels.get(i).setText(title);
        }
    }

    private void redraw(){
        for(int i = 0; i < movies.size(); i++){
            String title = movies.get(i).getTitle();
            labels.get(i).setText(title);
        }
    }

    private void erase(){
        for(int i = 0; i < labels.size(); i++){
            labels.get(i).setText(" ");
        }
    }
}
