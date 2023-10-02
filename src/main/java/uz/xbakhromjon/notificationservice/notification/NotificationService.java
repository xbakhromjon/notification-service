package uz.xbakhromjon.notificationservice.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository repository;
    private final NotificationSender firebaseNotificationSender;
    private final NotificationSender smsNotificationSender;
    private final NotificationSender socketNotificationSender;
    private final NotificationSender unknownNotificationSender;

    public NotificationService(NotificationRepository repository,
                               @Qualifier("FirebaseNotificationSender") NotificationSender firebaseNotificationSender,
                               @Qualifier("SmsNotificationSender") NotificationSender smsNotificationSender,
                               @Qualifier("SocketNotificationSender") NotificationSender socketNotificationSender,
                               @Qualifier("UnknownNotificationSender") NotificationSender unknownNotificationSender) {
        this.repository = repository;
        this.firebaseNotificationSender = firebaseNotificationSender;
        this.smsNotificationSender = smsNotificationSender;
        this.socketNotificationSender = socketNotificationSender;
        this.unknownNotificationSender = unknownNotificationSender;
    }

    public void sent(NotificationJpaEntity notification) {
        notification = repository.save(notification);
        if (notification.getEvent().getTypes().contains(NotificationType.FIREBASE)) {
            firebaseNotificationSender.send(notification);
        }
        if (notification.getEvent().getTypes().contains(NotificationType.SMS)) {
            smsNotificationSender.send(notification);
        }
        if (notification.getEvent().getTypes().contains(NotificationType.SOCKET)) {
            socketNotificationSender.send(notification);
        }
        if (notification.getEvent().getTypes().contains(NotificationType.UNKNOWN)) {
            unknownNotificationSender.send(notification);
        }

    }
}
