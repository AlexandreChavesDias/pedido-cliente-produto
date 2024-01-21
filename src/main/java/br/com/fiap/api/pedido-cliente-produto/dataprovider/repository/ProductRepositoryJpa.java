package br.com.fiap.api.client.Client.dataprovider.repository;

import br.com.fiap.api.client.Client.dataprovider.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, UUID> {

    List<ProductEntity> findAllByCategory(String category);
}
