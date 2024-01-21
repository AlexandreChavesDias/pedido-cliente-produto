package br.com.fiap.api.client.Client.core.usecase;

import br.com.fiap.api.client.Client.core.entity.Order;
import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderUseCase {

    List<Order> getAllOrders();

    Optional<Order> getOrderById(UUID id);

    Order saveOrder(Order order);

    void updateOrder(OrderStatusEnum status, UUID id);

    void deleteOrder(UUID id);

    List<Order> orderCheckout(String cpf);

}
