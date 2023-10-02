package uz.xbakhromjon.notificationservice.notification;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification")
@Entity(name = "Notification")
public class NotificationJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "receiver_id")
    private Long receiver;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "title")
//    private NotificationTitle title;

//    @Column(name = "content")
//    private String content;

    @Column(name = "event")
    private NotificationEvent event;

    @Column(name = "seen")
    private boolean seen;

//    @Column(name = "attachment")
//    private String attachment;

    public NotificationJpaEntity(Long receiver, NotificationEvent event) {
        this.receiver = receiver;
        this.event = event;
    }
}
