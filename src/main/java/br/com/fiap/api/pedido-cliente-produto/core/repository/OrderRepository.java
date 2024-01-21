package br.com.fiap.api.client.Client.core.repository;

import br.com.fiap.api.client.Client.core.entity.Order;
import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {

    List<Order> getAll();

    Order getById(UUID id);

    Order save(Order order);

    void delete(UUID id);

    void updateByOrderStatusAndOrderId(OrderStatusEnum orderStatus, UUID orderId);

    List<Order> getAllByClientCpf(String cpf);
}

