package io.github.cexj.auctions.application.commands;

import io.github.cexj.auctions.domain.model.AuctionHouse;

import java.util.List;
import java.util.Optional;

public interface AuctionHouseCommands {

    Optional<AuctionHouse> createAuctionHouse(AuctionHouse auctionHouse);

    void deleteAuctionHouse(long id);
}
