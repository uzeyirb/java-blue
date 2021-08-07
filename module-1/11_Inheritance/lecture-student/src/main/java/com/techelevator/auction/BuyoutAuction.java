package com.techelevator.auction;

public class BuyoutAuction extends Auction {

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice){
        //the super classes constructor must be called first
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    public int getBuyoutPrice(){
        return buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;

        if(getHighBid().getBidAmount() < buyoutPrice){
            if(offeredBid.getBidAmount() >= buyoutPrice){
                offeredBid = new Bid(offeredBid.getBidder(), buyoutPrice);
            }
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }
}
