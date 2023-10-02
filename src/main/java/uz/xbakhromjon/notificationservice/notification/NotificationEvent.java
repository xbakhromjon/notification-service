package uz.xbakhromjon.notificationservice.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum NotificationEvent {
    A(NotificationTitle.ANNOUNCEMENT, Set.of(NotificationType.SMS)),
    B(NotificationTitle.ANNOUNCEMENT, Set.of(NotificationType.SMS, NotificationType.FIREBASE)),
    C(NotificationTitle.USER, Set.of(NotificationType.SMS, NotificationType.FIREBASE, NotificationType.SOCKET, NotificationType.UNKNOWN));


    private final NotificationTitle title;
    private final Set<NotificationType> types;
}
