package au.com.demo.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.demo.clientservice.entity.NotificationEntity;

public interface NotificationRepository  extends JpaRepository<NotificationEntity,Long> {
}
