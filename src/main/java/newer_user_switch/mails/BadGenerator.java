package newer_user_switch.mails;

/**
 * Created by olexandra on 11/6/17.
 */
@MailCode(2)
public class BadGenerator implements MailGenerator {
   public String getResponse(){
        return "BadResponse";
    }
}
