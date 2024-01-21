package br.com.fiap.api.client.Client.core.usecase.impl;

import br.com.fiap.api.client.Client.core.entity.Client;
import br.com.fiap.api.client.Client.core.exception.ClientNotFoundException;
import br.com.fiap.api.client.Client.core.repository.ClientRepository;
import br.com.fiap.api.client.Client.core.usecase.ClientUseCase;

public class ClientUseCaseImpl implements ClientUseCase {

    private final ClientRepository clientRepository;


    public ClientUseCaseImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client getClientByCpf(String cpf) {
        return clientRepository.identifyClientByCpf(cpf).orElseThrow(() -> new ClientNotFoundException("client not found"));
    }

    @Override
    public Client saveClient(Client client) {
        clientRepository.registerClient(client);
        return client;
    }
}