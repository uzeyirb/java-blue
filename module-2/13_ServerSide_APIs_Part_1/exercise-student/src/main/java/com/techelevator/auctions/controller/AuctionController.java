package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController

public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> searchByTitle(@RequestParam(required = false, defaultValue = "") String title_like,
                                       @RequestParam(required = false, defaultValue = "0") double currentBid_lte) {
        List<Auction> matchingAuctions;
        if (title_like.length() != 0 && currentBid_lte != 0) {
            matchingAuctions = dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (title_like.length() != 0) {
            matchingAuctions = dao.searchByTitle(title_like);
        } else if (currentBid_lte != 0) {
            matchingAuctions = dao.searchByPrice(currentBid_lte);
        } else {
            matchingAuctions = dao.list();
        }
        return matchingAuctions;
    }


    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction) {
        return dao.create(auction);

    }
}
