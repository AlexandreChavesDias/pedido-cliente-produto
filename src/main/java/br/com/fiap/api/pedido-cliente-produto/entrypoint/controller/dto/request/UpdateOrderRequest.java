package br.com.fiap.api.client.Client.entrypoint.controller.dto.request;

import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;

import java.util.UUID;

public record UpdateOrderRequest(UUID orderId, OrderStatusEnum orderStatus) {

}