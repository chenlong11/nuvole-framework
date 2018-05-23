package com.nuvole.framework.service.oauth;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nuvole.framework.domain.Client;
import com.nuvole.framework.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by chenlong
 * Date：2018/3/27
 * time：17:36
 */
@Transactional
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService{

    @Override
    public Client createClient(Client client) {
        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        baseMapper.insert(client);
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        baseMapper.updateById(client);
        return client;
    }

    @Override
    public void deleteClient(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public Client findOne(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Client> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public Client findByClientId(String clientId) {
        return baseMapper.findByClientId(clientId);
    }

    @Override
    public Client findByClientSecret(String clientSecret) {
        return baseMapper.findByClientSecret(clientSecret);
    }

}
