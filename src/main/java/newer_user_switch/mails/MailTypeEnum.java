package newer_user_switch.mails;

import lombok.Getter;

/**
 * Created by olexandra on 11/6/17.
 */
@Getter
public enum MailTypeEnum {
    WELCOME(1, new WelcomeResponse()),
    EMAIL_CALLBACK(2, new BadResponse());

    int dbCode;
    MailResponse response;

    MailTypeEnum(int dbCode, MailResponse response) {
        this.dbCode = dbCode;
        this.response = response;
    }

    public static MailResponse getResponse(int code){
        for (MailTypeEnum responseEnum : MailTypeEnum.values()) {
            if (responseEnum.dbCode==code){
                return responseEnum.response;
            }
        }
        throw new UnsupportedOperationException();
    }
}
