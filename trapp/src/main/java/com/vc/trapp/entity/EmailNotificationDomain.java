package com.vc.trapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emailNotifications")
public class EmailNotificationDomain {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "notificationId")
@Setter(AccessLevel.NONE)
private Long notificationId;

@ManyToOne
@JoinColumn(name = "customerId")
private CustomerDomain customer;

@Column(name = "sentDate")
private Date sentDate;

@Column(name = "message")
private String message;
}
