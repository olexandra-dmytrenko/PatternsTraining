package mySpring;


/**
 * Created by olexandra on 11/6/17.
 */

public class IRobot implements MySpring{
    Speaker speaker = new ConsoleSpeaker();
    private ICleaner cleaner = new CleanerImpl();

    public void cleanRoom() {
        speaker.speak("I started");
        cleaner.clean();
        speaker.speak("I finished");

    }
}
