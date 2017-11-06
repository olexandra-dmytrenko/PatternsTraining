package newer_user_switch.mails;

/**
 * Created by olexandra on 11/6/17.
 */
@MailCode(1)
public class WelcomeGenerator implements MailGenerator {
    @Override
    public String getResponse(){
        return "WelcomeResponse";
    }
}
