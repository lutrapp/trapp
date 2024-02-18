package com.vc.trapp.record;

import java.util.Date;

public record Order(Long orderId, Date orderDate, Product product) {}
