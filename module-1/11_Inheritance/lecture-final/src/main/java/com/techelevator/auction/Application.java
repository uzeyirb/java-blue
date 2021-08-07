package com.techelevator.auction;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        System.out.println(generalAuction.placeBid(new Bid("Josh", 1)));
        System.out.println(generalAuction.placeBid(new Bid("Fonz", 23)));
        System.out.println(generalAuction.placeBid(new Bid("Jenny", 13)));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        BuyoutAuction buyoutAuction = new BuyoutAuction("Book", 20);
        buyoutAuction.placeBid( new Bid("name", 22));

        ReserveAuction reserveAuction = new ReserveAuction("Pen", 5);
        reserveAuction.placeBid(new Bid("losing", 2));
        reserveAuction.placeBid(new Bid("winning", 10));


        /*
        Polymorphism below this
         */
        List<Auction> auctions = new ArrayList<Auction>();

        auctions.add(generalAuction);
        auctions.add(buyoutAuction);
        auctions.add(reserveAuction);

        for (Auction auction: auctions) {
            System.out.println( auction.placeBid( new Bid("Polymorphism", 4)));
        }
    }
}
