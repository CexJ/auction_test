package io.github.cexj.auctions.infrastructure.repositories;

import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.domain.repositories.AuctionHouseRepository;
import io.github.cexj.auctions.infrastructure.mappers.AuctionHouseMapper;
import io.github.cexj.auctions.infrastructure.entities.AuctionHouseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class AuctionHouseRepositoryImp implements AuctionHouseRepository {

    private static List<AuctionHouseEntity> list = new ArrayList<>();

    static {
        list.add(AuctionHouseEntity.builder().id(0L).name("Fraysse").build());
        list.add(AuctionHouseEntity.builder().id(1L).name("Mercier").build());
        list.add(AuctionHouseEntity.builder().id(2L).name("Daguerre").build());
    }

    @Override
    public List<AuctionHouse> getAllAuctionHouse() {
        return list.stream().map(AuctionHouseMapper::fromEntity).collect(Collectors.toList());
    }

    @Override
    public synchronized Optional<AuctionHouse> createAuctionHouse(AuctionHouse auctionHouse) {
        boolean nameAcceptable = isNameAcceptable(auctionHouse);
        if(nameAcceptable) {
            long nextId = list.stream().mapToLong(AuctionHouseEntity::getId).max().orElse(0)+1;
            AuctionHouseEntity storedAuctionHouse =
                AuctionHouseEntity.builder()
                .name(auctionHouse.getName())
                .id(nextId).build();
            list.add(storedAuctionHouse);
            return Optional.of(AuctionHouseMapper.fromEntity(storedAuctionHouse));
        } else {
            return Optional.empty();
        }
    }

    @Override
    synchronized public void deleteAuctionHouse(long id) {
        list = list.stream().filter(auctionHouse -> auctionHouse.getId() != id).collect(Collectors.toList());
    }

    @Override
    public Optional<AuctionHouse> getAuctionHouse(Long id) {
        return list.stream()
                .filter(auctionHouseEntity -> auctionHouseEntity.getId().equals(id))
                .map(AuctionHouseMapper::fromEntity)
                .findFirst();
    }

    private boolean isNameAcceptable(AuctionHouse auctionHouse) {
        return list.stream()
                    .map(AuctionHouseEntity::getName)
                    .filter(name -> name.equals((auctionHouse.getName())))
                    .collect(Collectors.toList()).isEmpty();
    }
}
