package com.nuvole.framework.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by chenlong
 * Date：2018/3/27
 * time：17:35
 */
@Data
public class Client extends SuperEntity<Client>  implements Serializable {

    private String clientName;
    private String clientId;
    private String clientSecret;

}
