package newer_user_switch;

import newer_user_switch.mails.BadResponse;
import newer_user_switch.mails.MailResponse;
import newer_user_switch.mails.MailTypeEnum;
import newer_user_switch.mails.WelcomeResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by olexandra on 11/6/17.
 */
public class MailSender {
    private Map<Integer, MailResponse> responses;

    public MailSender() {
        responses = new HashMap<>();
        responses.put(1, new WelcomeResponse());
        responses.put(null, new BadResponse());
    }


    public void sendMail(MailInfo mailInfo) {
        int mailCode = mailInfo.getMailCode();
        MailResponse resp = MailTypeEnum.getResponse(mailCode);
//        MailResponse resp = responses.getOrDefault(mailCode, responses.get(null));
/* ifs
        if (mailCode == 1) {
            System.out.println("Send Welcome");
        } else System.out.println("Send Error");
*/
        System.out.println(resp.getResponse());
    }
}