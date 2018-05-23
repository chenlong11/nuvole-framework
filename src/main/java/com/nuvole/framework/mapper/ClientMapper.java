package com.nuvole.framework.mapper;

import com.nuvole.framework.SuperMapper;
import com.nuvole.framework.domain.Client;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/27
 * time：17:38
 */
public interface ClientMapper extends SuperMapper<Client> {

    @Select(" select id,client_name,client_id,client_secret from sys_oauth ")
    List<Client> findAll();

    @Select(" select id,client_name,client_id,client_secret from sys_oauth where client_id = #{clientId} ")
    Client findByClientId(String clientId);

    @Select(" select id,client_name,client_id,client_secret from sys_oauth where client_secret = #{clientSecret} ")
    Client findByClientSecret(String clientSecret);
}
