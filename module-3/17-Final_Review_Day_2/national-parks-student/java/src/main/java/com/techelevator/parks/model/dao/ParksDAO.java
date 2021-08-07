package com.techelevator.parks.model.dao;

import com.techelevator.parks.model.Park;

import java.util.List;

public interface ParksDAO {

    List<Park> list();
    Park get(String parkCode);

}
