package com.techelevator.auction;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        // the super classes constructor must be called first
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
       boolean isCurrentWinningBid = false;

       if (getHighBid().getBidAmount() < buyoutPrice) {
            if (offeredBid.getBidAmount() >= buyoutPrice) {
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            /*
            If an override wants to use the functionality of the original
            function it is overridding it can do so using the super keyword.
             */
           isCurrentWinningBid = super.placeBid(offeredBid);
       }

       return isCurrentWinningBid;
    }
}
