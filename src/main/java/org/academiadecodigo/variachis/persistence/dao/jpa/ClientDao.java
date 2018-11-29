package org.academiadecodigo.variachis.persistence.dao.jpa;

import org.academiadecodigo.variachis.persistence.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDao extends GenericDao<Client> {


    public ClientDao(){
        super(Client.class);
    }
}
