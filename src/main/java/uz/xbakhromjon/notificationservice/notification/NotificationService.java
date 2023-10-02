package uz.xbakhromjon.notificationservice.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<NotificationSendingType> sendingTypes = notification.getEvent().getSendingViews().stream().map(NotificationSendingView::getSendingType).toList();

        if (sendingTypes.contains(NotificationSendingType.FIREBASE)) {
            firebaseNotificationSender.send(notification);
        }
        if (sendingTypes.contains(NotificationSendingType.SMS)) {
            smsNotificationSender.send(notification);
        }
        if (sendingTypes.contains(NotificationSendingType.SOCKET)) {
            socketNotificationSender.send(notification);
        }
        if (sendingTypes.contains(NotificationSendingType.UNKNOWN)) {
            unknownNotificationSender.send(notification);
        }

    }
}
