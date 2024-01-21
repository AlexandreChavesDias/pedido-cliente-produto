package br.com.fiap.api.client.Client.entrypoint.controller.dto.response;

import br.com.fiap.api.client.Client.core.entity.Product;

public record ProductResponse(Product product) {

    public static ProductResponse fromEntityToResponse(Product product) {
        return new ProductResponse(product);
    }
}