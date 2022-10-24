import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotPage {

    /**
     * Клик по клавише Esc
     */
    public void sendKeysEsc() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (r != null) {
            r.keyPress(KeyEvent.VK_ESCAPE);
        }
        if (r != null) {
            r.keyRelease(KeyEvent.VK_ESCAPE);
        }
    }

    /**
     * Клик по клавише Enter
     */
    public void sendKeysEnter() {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (r != null) {
            r.keyPress(KeyEvent.VK_ENTER);
        }

    }


}
