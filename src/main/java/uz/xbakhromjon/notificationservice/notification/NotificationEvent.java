package uz.xbakhromjon.notificationservice.notification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum NotificationEvent {
    A(NotificationTitle.ANNOUNCEMENT, Set.of(new NotificationSendingView(NotificationSendingType.SMS, "T"))),
    B(NotificationTitle.ANNOUNCEMENT, Set.of(new NotificationSendingView(NotificationSendingType.SMS, "T"), new NotificationSendingView(NotificationSendingType.FIREBASE, "T"))),
    C(NotificationTitle.USER, Set.of(new NotificationSendingView(NotificationSendingType.SMS, "T"), new NotificationSendingView(NotificationSendingType.FIREBASE, "T"), new NotificationSendingView(NotificationSendingType.SOCKET, "T"), new NotificationSendingView(NotificationSendingType.UNKNOWN, "T")));


    private final NotificationTitle title;
    private final Set<NotificationSendingView> sendingViews;
}
