package alarm;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.Delegate;

/**
 * Created by olexandra on 11/6/17.
 */

@Setter
@AllArgsConstructor
public class RadioAlarm implements RadioInt, AlarmInt{
   @Delegate
    private RadioInt radioInt;
   @Delegate
   private AlarmInt alarmInt;

//    public RadioAlarm(RadioInt radioInt, AlarmInt alarmInt) {
//        this.radioInt = radioInt;
//        this.alarmInt = alarmInt;
//    }

//    @Override
//    public void setChannel(double wave) {
//        radioInt.setChannel(wave);
//    }
//
//    @Override
//    public void setVolume(int volume) {
//        radioInt.setVolume(volume);
//    }
//
//    @Override
//    public void setDateTime(LocalDateTime dateTime) {
//        alarmInt.setDateTime(dateTime);
//    }
}
