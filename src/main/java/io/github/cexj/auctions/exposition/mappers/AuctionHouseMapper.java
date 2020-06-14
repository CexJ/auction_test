package io.github.cexj.auctions.exposition.mappers;

import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.exposition.dtos.AuctionHouseDTO;

public class AuctionHouseMapper {

    public static AuctionHouseDTO toDto(AuctionHouse auctionHouse) {
        return AuctionHouseDTO.builder()
                .id(auctionHouse.getId())
                .name(auctionHouse.getName())
                .build();
    }

    public static AuctionHouse fromDto(AuctionHouseDTO auctionHouseDTO) {
        return AuctionHouse.builder()
                .id(auctionHouseDTO.getId())
                .name(auctionHouseDTO.getName())
                .build();
    }
}
