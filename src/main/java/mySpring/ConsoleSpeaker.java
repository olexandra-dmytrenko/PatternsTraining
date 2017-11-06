package mySpring;

/**
 * Created by olexandra on 11/6/17.
 */

public class ConsoleSpeaker implements Speaker, MySpring {
    @Override
    public void speak(String message) {
        System.out.println(message);
    }
}
