package com.vc.trapp.record;

import java.util.Date;

public record EmailNotification(Long notificationId, Customer customer, Date sentDate, String message) {}
