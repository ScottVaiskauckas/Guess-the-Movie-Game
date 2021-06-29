package Model;

import java.util.ArrayList;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies = new ArrayList<>(22);

    public MovieLibrary() {
        movies.add(new Movie("The Shawshank Redemption"));
        movies.add(new Movie("The Godfather"));
        movies.add(new Movie("The Dark Knight"));
        movies.add(new Movie("Schindler's List"));
        movies.add(new Movie("Pulp Fiction"));
        movies.add(new Movie("The Lord of the Rings"));
        movies.add(new Movie("The Good the Bad and the Ugly"));
        movies.add(new Movie("Fight Club"));
        movies.add(new Movie("Forrest Gump"));
        movies.add(new Movie("Star Wars"));
        movies.add(new Movie("Inception"));
        movies.add(new Movie("The Matrix"));
        movies.add(new Movie("Samurai"));
        movies.add(new Movie("City of God"));
        movies.add(new Movie("The Silence of the Lambs"));
        movies.add(new Movie("Batman Begins"));
        movies.add(new Movie("Die Hard"));
        movies.add(new Movie("Chinatown"));
        movies.add(new Movie("Room"));
        movies.add(new Movie("Dunkirk"));
        movies.add(new Movie("Fargo"));
        movies.add(new Movie("No Country for Old Men"));
    }

    public Movie getMovie(){
        int randomNumber = (int) (Math.random() * movies.size());
        return movies.get(randomNumber);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> copyMovies() {
        return new ArrayList<>(movies);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Movie movie : movies){
            stringBuilder.append(movie);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}






















