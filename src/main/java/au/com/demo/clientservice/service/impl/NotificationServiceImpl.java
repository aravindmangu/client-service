package au.com.demo.clientservice.service.impl;

import org.springframework.stereotype.Service;

import au.com.demo.clientservice.entity.NotificationEntity;
import au.com.demo.clientservice.repository.NotificationRepository;
import au.com.demo.clientservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repo;

    public void sendNotification(String notification) {
        NotificationEntity ne = new NotificationEntity();
        ne.setMessage(notification);
        repo.save(ne);
    }
}
