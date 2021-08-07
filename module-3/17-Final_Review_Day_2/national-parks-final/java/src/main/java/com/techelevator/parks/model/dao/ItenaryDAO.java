package com.techelevator.parks.model.dao;

import com.techelevator.parks.model.Itenary;

import java.util.List;

public interface ItenaryDAO {

    Itenary create(Itenary itenary, String username);
    List<Itenary> getListforUser(String username);
    Itenary get(long itenaryId, String username);
    void update(Itenary itenary);
    void delete(long itenaryId);

    boolean isItenaryUsers(Long itenaryId, String username);

}
