package observer;

import observer.enums.NotificationCode;

public class Notification {
    private NotificationCode code;
    private Object data;

    public NotificationCode getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setCode(NotificationCode code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
