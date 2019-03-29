package SwingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Movie {
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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
