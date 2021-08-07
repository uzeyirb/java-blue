package com.techelevator.parks.controller;

import com.techelevator.parks.model.Park;
import com.techelevator.parks.model.dao.ParksDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkController {

    private ParksDAO parksDAO;

    public ParkController(ParksDAO parksDAO) {
        this.parksDAO = parksDAO;
    }

    @RequestMapping(path="/parks", method= RequestMethod.GET)
    public List<Park> list() {
        return parksDAO.list();
    }

    @RequestMapping(path="/parks/{parkcode}", method= RequestMethod.GET)
    public Park get(@PathVariable(name="parkcode") String parkCode) {
        return parksDAO.get(parkCode);
    }
}
