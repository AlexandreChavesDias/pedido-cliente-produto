package br.com.fiap.api.client.Client.dataprovider.repository;

import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;
import br.com.fiap.api.client.Client.dataprovider.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderStatus = ?1 WHERE o.orderId = ?2")
    void updateByOrderStatusAndOrderId(OrderStatusEnum orderStatus, UUID orderId);

    List<OrderEntity> getAllByClientEntityClientCpf(String cpf);
}
