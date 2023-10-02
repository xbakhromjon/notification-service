package uz.xbakhromjon.notificationservice.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("FirebaseNotificationSender")
@Slf4j
public class FirebaseNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationJpaEntity source) {
        NotificationEvent event = source.getEvent();
        Optional<NotificationSendingView> notificationSendingView = event.getSendingViews().stream().filter(item -> item.getSendingType().equals(NotificationSendingType.FIREBASE)).findAny();
        log.info(notificationSendingView.get().getTemplate());
        log.info("ID:{} Notification sent via Firebase", source.getId());
    }
}
