package br.com.fiap.api.client.Client.core.usecase;

import br.com.fiap.api.client.Client.core.entity.Client;

public interface ClientUseCase {

    Client getClientByCpf(String cpf);
    Client saveClient(Client client);
}
