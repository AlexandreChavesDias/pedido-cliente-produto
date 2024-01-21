package br.com.fiap.api.client.Client.entrypoint.controller.dto.request;

import br.com.fiap.api.client.Client.core.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateProductRequest(String productName, String productDesc, BigDecimal price, String category) {
    public Product fromRequestProduct() {
        return new Product(UUID.randomUUID(), productName, productDesc, price, category);
    }
}
