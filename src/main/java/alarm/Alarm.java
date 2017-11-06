package alarm;

import java.time.LocalDateTime;

/**
 * Created by olexandra on 11/6/17.
 */
public class Alarm implements AlarmInt{
    private LocalDateTime dateTime;
    private boolean isAlarm;

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        System.out.println("Set date");
    }
}
