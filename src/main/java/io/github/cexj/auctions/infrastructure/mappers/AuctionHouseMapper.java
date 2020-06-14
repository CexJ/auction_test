package io.github.cexj.auctions.infrastructure.mappers;

import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.infrastructure.entities.AuctionHouseEntity;

public class AuctionHouseMapper {
    public static AuctionHouse fromEntity(AuctionHouseEntity auctionHouseDTO) {

        return AuctionHouse.builder()
                .id(auctionHouseDTO.getId())
                .name(auctionHouseDTO.getName())
                .build();
    }

    public static AuctionHouseEntity toEntity(AuctionHouse auctionHouse) {
        return AuctionHouseEntity.builder()
                .id(auctionHouse.getId())
                .name(auctionHouse.getName())
                .build();
    }

}
