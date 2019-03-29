package SwingApp;

import java.util.EventListener;

public interface ResetListener extends EventListener {
    public void resetButtonPressed(ResetEvent event);
}