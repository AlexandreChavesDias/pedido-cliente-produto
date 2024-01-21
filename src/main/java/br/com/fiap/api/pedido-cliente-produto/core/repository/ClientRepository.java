package br.com.fiap.api.client.Client.core.repository;

import br.com.fiap.api.client.Client.core.entity.Client;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> identifyClientByCpf(String cpf);
    Client registerClient(Client client);

}