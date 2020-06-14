package io.github.cexj.auctions.application.queries.house;

import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.domain.repositories.AuctionHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionHouseQueriesImpl implements AuctionHouseQueries {

    @Autowired
    private AuctionHouseRepository auctionHouseRepository;

    @Override
    public List<AuctionHouse> getAllAuctionHouses(){
        return auctionHouseRepository.getAllAuctionHouse();
    }

    @Override
    public Optional<AuctionHouse> getAuctionHouse(Long id) {
        return auctionHouseRepository.getAuctionHouse(id);
    }
}
