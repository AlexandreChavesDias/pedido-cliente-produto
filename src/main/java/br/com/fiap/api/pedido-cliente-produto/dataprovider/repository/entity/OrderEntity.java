package br.com.fiap.api.client.Client.dataprovider.repository.entity;

import br.com.fiap.api.client.Client.core.entity.Order;
import br.com.fiap.api.client.Client.core.entity.Product;
import br.com.fiap.api.client.Client.dataprovider.enumeration.OrderStatusEnum;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.response.ClientDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "order_food")
public class OrderEntity {

    @Id
    private UUID orderId;
    private Boolean isPaymentReceived;
    private OrderStatusEnum orderStatus;
    @ManyToMany
    @JoinTable(
            name = "orderProducts",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<br.com.fiap.api.client.Client.dataprovider.repository.entity.ProductEntity> orderProducts;
    @ElementCollection
    private List<UUID> orderProductIds;
    private Double orderPrice;
    @OneToOne(optional = true)
    @JoinColumn(name = "client_id")
    private br.com.fiap.api.client.Client.dataprovider.repository.entity.ClientEntity clientEntity;

    public OrderEntity() {
    }

    public OrderEntity(Order order) {
        this.orderId = order.getOrderId();
        this.isPaymentReceived = order.getPaymentReceived();
        this.orderStatus = order.getOrderStatus();
        this.orderProducts = order.getOrderProducts().stream()
                .map(product -> new br.com.fiap.api.client.Client.dataprovider.repository.entity.ProductEntity(product.getProductId(), product.getProductName(), product.getProductDesc(),
                        product.getPrice(), product.getCategory()))
                .toList(); this.orderPrice = order.getOrderPrice();
        this.clientEntity = order.getClient() != null ?  ClientDto.fromClientToClientEntity(order.getClient()) : null;
    }


    public Order toOrder() {
        return new Order(this.orderId,
                this.isPaymentReceived,
                this.orderStatus,
                toProductList(this.orderProducts),
                this.orderProductIds,
                this.orderPrice,
                this.clientEntity != null ?this.clientEntity.toClient() : null);
    }

    public static List<Product> toProductList(List<br.com.fiap.api.client.Client.dataprovider.repository.entity.ProductEntity> productEntities) {
        return productEntities.stream()
                .map(br.com.fiap.api.client.Client.dataprovider.repository.entity.ProductEntity::toProduct)
                .collect(Collectors.toList());
    }

}


