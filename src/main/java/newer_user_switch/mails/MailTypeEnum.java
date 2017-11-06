package newer_user_switch.mails;

import lombok.Getter;

/**
 * Created by olexandra on 11/6/17.
 */
@Getter
public enum MailTypeEnum {
    WELCOME(1, new WelcomeGenerator()),
    EMAIL_CALLBACK(2, new BadGenerator());

    int dbCode;
    MailGenerator response;

    MailTypeEnum(int dbCode, MailGenerator response) {
        this.dbCode = dbCode;
        this.response = response;
    }

    public static MailGenerator getResponse(int code){
        for (MailTypeEnum responseEnum : MailTypeEnum.values()) {
            if (responseEnum.dbCode==code){
                return responseEnum.response;
            }
        }
        throw new UnsupportedOperationException();
    }
}
