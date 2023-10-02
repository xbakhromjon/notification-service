package uz.xbakhromjon.notificationservice.notification;

public interface NotificationSender {
    void send(NotificationJpaEntity source);
}
