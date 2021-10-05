package au.com.demo.clientservice.entity;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "TBL_NOTIFICATION")
@Data
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "MESSAGE")
    private String message;
}
