package br.com.fiap.api.client.Client.entrypoint.controller.dto.response;

import br.com.fiap.api.client.Client.core.entity.Client;
import br.com.fiap.api.client.Client.dataprovider.repository.entity.ClientEntity;

import java.util.UUID;

public record ClientDto(UUID clientId, String clientCpf, String clientName, String clientEmail) {
    public static ClientEntity fromClientToClientEntity(Client client) {
        return new ClientEntity(client.getClientId(), client.getClientCpf(),client.getClientName(), client.getClientEmail());
    }
}