package newer_user_switch.mails;

/**
 * Created by olexandra on 11/6/17.
 */
@MailCode(3)
public class GoToDinnerMailGenerator implements MailGenerator {
    @Override
    public String getResponse() {
        return "Go to dinner";
    }
}
