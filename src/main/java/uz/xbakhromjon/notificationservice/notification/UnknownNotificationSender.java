package uz.xbakhromjon.notificationservice.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("UnknownNotificationSender")
@Slf4j
public class UnknownNotificationSender implements NotificationSender {
    @Override
    public void send(NotificationJpaEntity source) {
        log.info("ID:{} Notification sent via Unknown", source.getId());
    }
}
