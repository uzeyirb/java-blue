package com.techelevator.parks.controller;

import com.techelevator.parks.model.Itenary;
import com.techelevator.parks.model.dao.ItenaryDAO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class ItenaryController {

    private ItenaryDAO itenaryDAO;

    public ItenaryController(ItenaryDAO itenaryDAO) {
        this.itenaryDAO = itenaryDAO;
    }

    @RequestMapping(path="/itenaries", method= RequestMethod.POST)
    public Itenary add(@RequestBody Itenary itenary, Principal principal) {
        return itenaryDAO.create(itenary, principal.getName());
    }

    @RequestMapping(path="/itenaries", method= RequestMethod.GET)
    public List<Itenary> list(Principal principal) {
        return itenaryDAO.getListforUser(principal.getName());
    }

    @RequestMapping(path="/itenaries/{id}", method= RequestMethod.GET)
    public Itenary get(@PathVariable Long id, Principal principal) {
        return itenaryDAO.get(id, principal.getName());
    }

    @RequestMapping(path="/itenaries/{id}", method= RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Itenary itenary, Principal principal) {
        if (itenaryDAO.isItenaryUsers(itenary.getItenaryId(), principal.getName())) {
            itenaryDAO.update(itenary);
        }
    }

    @RequestMapping(path="/itenaries/{id}", method= RequestMethod.DELETE)
    public void update(@PathVariable Long id, Principal principal) {
        if (itenaryDAO.isItenaryUsers(id, principal.getName())) {
            itenaryDAO.delete(id);
        }
    }

}
