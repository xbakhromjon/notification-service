package uz.xbakhromjon.notificationservice.notification;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NotificationSendingView {
    private NotificationSendingType sendingType;
    private String template;
}
