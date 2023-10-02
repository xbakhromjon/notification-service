package uz.xbakhromjon.notificationservice.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationCommandLineRunner implements CommandLineRunner {

    private final NotificationService notificationService;

    @Override
    public void run(String... strings) throws Exception {
        notificationService.sent(
                new NotificationJpaEntity(
                        1L,
                        NotificationEvent.C));
    }


}

