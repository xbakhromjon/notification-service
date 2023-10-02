package uz.xbakhromjon.notificationservice.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("FirebaseNotificationSender")
@Slf4j
public class FirebaseNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationJpaEntity source) {
        log.info("ID:{} Notification sent via Firebase", source.getId());
    }
}
