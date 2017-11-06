package newer_user_switch.mails;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by olexandra on 11/6/17.
 */
@Retention(RUNTIME)
public @interface MailCode {
    int value();
}
