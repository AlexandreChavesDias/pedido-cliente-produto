package br.com.fiap.api.client.Client.core.entity;

import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;
import br.com.fiap.api.client.Client.dataprovider.repository.entity.OrderEntity;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.response.OrderResponse;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {

    private UUID orderId;
    private Boolean isPaymentReceived;
    private OrderStatusEnum orderStatus;
    private List<br.com.fiap.api.client.Client.core.entity.Product> orderProducts;
    private List<UUID> orderProductIds;
    private Double orderPrice;
    private br.com.fiap.api.client.Client.core.entity.Client client;

    public Order() {

    }

    public Order(UUID orderId, boolean isPaymentReceived, OrderStatusEnum orderStatus, List<br.com.fiap.api.client.Client.core.entity.Product> orderProducts, List<UUID> orderProductIds, Double orderPrice, br.com.fiap.api.client.Client.core.entity.Client client) {
        this.orderId = orderId;
        this.isPaymentReceived = isPaymentReceived;
        this.orderStatus = orderStatus;
        this.orderProducts = orderProducts;
        this.orderProductIds = orderProductIds;
        this.orderPrice = orderPrice;
        this.client = client;
    }

    public List<UUID> getOrderProductIds() {
        return orderProductIds;
    }

    public void setOrderProductIds(List<UUID> orderProductIds) {
        this.orderProductIds = orderProductIds;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<br.com.fiap.api.client.Client.core.entity.Product> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<br.com.fiap.api.client.Client.core.entity.Product> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public br.com.fiap.api.client.Client.core.entity.Client getClient() {
        return client;
    }

    public void setClient(br.com.fiap.api.client.Client.core.entity.Client client) {
        this.client = client;
    }

    public Boolean getPaymentReceived() {
        return isPaymentReceived;
    }

    public void setPaymentReceived(Boolean paymentReceived) {
        isPaymentReceived = paymentReceived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(getOrderId(), order.getOrderId()) && Objects.equals(isPaymentReceived, order.isPaymentReceived) && getOrderStatus() == order.getOrderStatus() && Objects.equals(getOrderProducts(), order.getOrderProducts()) && Objects.equals(getOrderProductIds(), order.getOrderProductIds()) && Objects.equals(getOrderPrice(), order.getOrderPrice()) && Objects.equals(getClient(), order.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), isPaymentReceived, getOrderStatus(), getOrderProducts(), getOrderProductIds(), getOrderPrice(), getClient());
    }

    public OrderEntity toEntity() {
        return new OrderEntity(this);
    }

    public OrderResponse toResponse() {
        return new OrderResponse(this.orderId, this.isPaymentReceived, this.orderStatus, this.orderProducts, this.orderPrice, this.client.toEntity());
    }
}
