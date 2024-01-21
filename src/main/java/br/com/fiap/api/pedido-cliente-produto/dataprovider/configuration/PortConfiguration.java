package br.com.fiap.api.client.Client.dataprovider.configuration;



import br.com.fiap.api.client.Client.core.repository.ClientRepository;
import br.com.fiap.api.client.Client.core.repository.OrderRepository;
import br.com.fiap.api.client.Client.core.repository.ProductRepository;
import br.com.fiap.api.client.Client.core.usecase.ClientUseCase;
import br.com.fiap.api.client.Client.core.usecase.OrderUseCase;
import br.com.fiap.api.client.Client.core.usecase.ProductUseCase;
import br.com.fiap.api.client.Client.core.usecase.impl.ClientUseCaseImpl;
import br.com.fiap.api.client.Client.core.usecase.impl.OrderUseCaseImpl;
import br.com.fiap.api.client.Client.core.usecase.impl.ProductUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfiguration {


    @Bean
    ProductUseCase productUseCase(ProductRepository productRepositoryPort) {
        return new ProductUseCaseImpl(productRepositoryPort);
    }

    @Bean
    OrderUseCase orderUseCase(
            OrderRepository orderRepositoryPort,
            ProductRepository productRepositoryPort,
            ClientRepository clientRepositoryPort) {
        return new OrderUseCaseImpl(orderRepositoryPort, productRepositoryPort, clientRepositoryPort);
    }

    @Bean
    ClientUseCase clientUseCase(ClientRepository clientRepository) {
        return new ClientUseCaseImpl(clientRepository);
    }
}