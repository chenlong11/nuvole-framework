package com.nuvole.framework.service.oauth;

import com.nuvole.framework.domain.Client;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/27
 * time：17:34
 */
public interface ClientService {

    Client createClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);

    Client findByClientSecret(String clientSecret);

}
