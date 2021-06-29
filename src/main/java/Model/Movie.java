package Model;

import java.util.Objects;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    //Ignore case when comparing for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle().toLowerCase(), movie.getTitle().toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
