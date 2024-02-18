package com.vc.trapp.record;

import java.math.BigDecimal;

public record SaleItems(Long saleItemsId, Sale sale, Product product, Integer quantity, BigDecimal unitPrice, BigDecimal totalPrice) {}
