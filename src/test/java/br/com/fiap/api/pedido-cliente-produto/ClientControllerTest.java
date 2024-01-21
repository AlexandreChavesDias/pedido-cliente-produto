package br.com.fiap.api.client.Client;

import br.com.fiap.api.client.Client.core.entity.Client;
import br.com.fiap.api.client.Client.core.usecase.ClientUseCase;
import br.com.fiap.api.client.Client.entrypoint.controller.ClientController;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.request.CreateClientRequest;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.response.BaseResponse;
import br.com.fiap.api.client.Client.entrypoint.controller.dto.response.ClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private ClientUseCase clientUseCase;

    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        clientController = new ClientController(clientUseCase);
    }

    @Test
    void getByCpf_shouldReturnClientResponse() {
        // Arrange

        Client client = new Client(UUID.randomUUID(),"12345678901", "Alexandre", "alexandre.dias@meta.com.br");
        when(clientUseCase.getClientByCpf(anyString())).thenReturn(client);

        // Act
        ResponseEntity<BaseResponse<ClientResponse>> responseEntity = clientController.getByCpf("12345678901");

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody().isSuccess());
    }

    @Test
    void create_shouldReturnClientResponse() {
        // Arrange
        CreateClientRequest createRequest = new CreateClientRequest("12345678901", "Alexandre", "alexandre.dias@meta.com.br");
        Client client = new Client(UUID.randomUUID(),"12345678901", "Alexandre", "alexandre.dias@meta.com.br");
        when(clientUseCase.saveClient(any())).thenReturn(client);

        // Act
        ResponseEntity<BaseResponse<ClientResponse>> responseEntity = clientController.create(createRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody().isSuccess());
    }
}
