package alarm;

/**
 * Created by olexandra on 11/6/17.
 */
public class Radio implements RadioInt {
    private double channel;
    private int volume;

    @Override
    public void setChannel(double wave) {
        this.channel = wave;
        System.out.println("Set channel");
    }
    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Set volume");
    }
}
