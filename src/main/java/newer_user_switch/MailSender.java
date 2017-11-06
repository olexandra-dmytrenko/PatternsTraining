package newer_user_switch;

import newer_user_switch.mails.MailCode;
import newer_user_switch.mails.MailGenerator;
import newer_user_switch.mails.MailTypeEnum;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by olexandra on 11/6/17.
 */
public class MailSender {
    private Map<Integer, MailGenerator> responses;
    private Reflections reflections = new Reflections("newer_user_switch");

    private Map<Integer, MailGenerator> map = new HashMap<>();


    public MailSender() throws IllegalAccessException, InstantiationException {

        Set<Class<? extends MailGenerator>> classes = reflections.getSubTypesOf(MailGenerator.class);

        for (Class<? extends MailGenerator> aClass : classes) {

            if (!Modifier.isAbstract(aClass.getModifiers())) {
                MailCode annotation = aClass.getAnnotation(MailCode.class);
                if (annotation == null) {
                    throw new RuntimeException("if you use MailGenerator you MUST annotated your class with @MailType");
                }
                int mailCode = annotation.value();
                if (map.containsKey(mailCode)) {
                    throw new RuntimeException(mailCode + " already in use");
                }
                map.put(mailCode, aClass.newInstance());
            }
        }

//        responses = new HashMap<>();
//        responses.put(1, new WelcomeResponse());
//        responses.put(null, new BadResponse());
    }


    public void sendMail(MailInfo mailInfo) {
        int mailCode = mailInfo.getMailCode();
        MailGenerator resp = MailTypeEnum.getResponse(mailCode);
//        MailResponse resp = responses.getOrDefault(mailCode, responses.get(null));
/* ifs
        if (mailCode == 1) {
            System.out.println("Send Welcome");
        } else System.out.println("Send Error");
*/
        System.out.println(resp.getResponse());
    }
}