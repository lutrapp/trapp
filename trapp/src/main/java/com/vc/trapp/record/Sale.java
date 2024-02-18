package com.vc.trapp.record;

import java.math.BigDecimal;
import java.util.Date;

public record Sale(Long saleId, Customer customer, Date saleDate, BigDecimal totalAmount) {}
