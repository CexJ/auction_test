package io.github.cexj.auctions.application.commands;

import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.domain.repositories.AuctionHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionHouseCommandsImpl implements AuctionHouseCommands {

    @Autowired
    private AuctionHouseRepository auctionHouseRepository;

    @Override
    public Optional<AuctionHouse> createAuctionHouse(AuctionHouse auctionHouse){
        return auctionHouseRepository.createAuctionHouse(auctionHouse);
    }

    @Override
    public void deleteAuctionHouse(long id) {
        auctionHouseRepository.deleteAuctionHouse(id);
    }


}
