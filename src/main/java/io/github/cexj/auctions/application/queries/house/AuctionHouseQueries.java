package io.github.cexj.auctions.application.queries.house;

import io.github.cexj.auctions.domain.model.AuctionHouse;

import java.util.List;
import java.util.Optional;

public interface AuctionHouseQueries {

    List<AuctionHouse> getAllAuctionHouses();

    Optional<AuctionHouse> getAuctionHouse(Long id);
}
