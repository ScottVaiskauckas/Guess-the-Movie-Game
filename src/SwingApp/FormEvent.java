package SwingApp;

import java.util.EventObject;

public class FormEvent extends EventObject{

    private String guess;

    public FormEvent(Object source){
        super(source);
    }

    public FormEvent(Object source, String guess){
        super(source);
        this.guess = guess;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
