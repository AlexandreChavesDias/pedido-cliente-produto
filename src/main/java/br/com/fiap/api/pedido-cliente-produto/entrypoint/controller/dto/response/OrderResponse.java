package br.com.fiap.api.client.Client.entrypoint.controller.dto.response;

import br.com.fiap.api.client.Client.core.entity.Order;
import br.com.fiap.api.client.Client.core.entity.Product;
import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;
import br.com.fiap.api.client.Client.dataprovider.repository.entity.ClientEntity;

import java.util.List;
import java.util.UUID;

public record OrderResponse(UUID orderId, Boolean isPaymentReceived, OrderStatusEnum orderStatus,
                            List<Product> orderProducts, Double orderPrice, ClientEntity client) {

    public static OrderResponse fromEntityToResponse(Order order) {
        return new OrderResponse(order.getOrderId(), order.getPaymentReceived(), order.getOrderStatus(),
                order.getOrderProducts(), order.getOrderPrice(), order.getClient() != null ? br.com.fiap.api.client.Client.entrypoint.controller.dto.response.ClientDto.fromClientToClientEntity(order.getClient()) : null);
    }
}