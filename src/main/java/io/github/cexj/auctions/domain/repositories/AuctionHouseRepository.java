package io.github.cexj.auctions.domain.repositories;

import io.github.cexj.auctions.domain.model.AuctionHouse;

import java.util.List;
import java.util.Optional;

public interface AuctionHouseRepository {

    List<AuctionHouse> getAllAuctionHouse();

    Optional<AuctionHouse> createAuctionHouse(AuctionHouse auctionHouse);

    Optional<AuctionHouse> getAuctionHouse(Long id);

    void deleteAuctionHouse(long id);
}
