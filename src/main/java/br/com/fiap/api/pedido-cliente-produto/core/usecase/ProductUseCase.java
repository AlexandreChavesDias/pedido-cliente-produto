package br.com.fiap.api.client.Client.core.usecase;

import br.com.fiap.api.client.Client.core.entity.Product;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.response.BaseResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductUseCase {

    List<Product> getAllProducts();
    List<Product> getByCategory(String category);
    Optional<Product> getProductById(UUID id);
    Product saveProduct(Product request);
    Product updateProduct(Product request);
    BaseResponse deleteProduct(UUID id);

}