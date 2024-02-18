package com.vc.trapp.record;

import java.math.BigDecimal;

public record Product(Long productId, String name, BigDecimal price, String description, Integer stock) {}
