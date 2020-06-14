package io.github.cexj.auctions.exposition.controllers;

import io.github.cexj.auctions.application.commands.AuctionHouseCommands;
import io.github.cexj.auctions.application.queries.house.AuctionHouseQueries;
import io.github.cexj.auctions.domain.model.AuctionHouse;
import io.github.cexj.auctions.exposition.dtos.AuctionHouseDTO;
import io.github.cexj.auctions.exposition.mappers.AuctionHouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/houses")
public class AuctionsHouseController {
    @Autowired
    private AuctionHouseQueries auctionHouseQueries;

    @Autowired
    private AuctionHouseCommands auctionHouseCommands;


    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<List<AuctionHouseDTO>> getAllAuctionHouses() {
        final List<AuctionHouseDTO> response = auctionHouseQueries.getAllAuctionHouses().stream()
                .map(AuctionHouseMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<?> getAuctionHouse(final @RequestParam Long id) {
        final Optional<AuctionHouseDTO> auctionHouseDTO = auctionHouseQueries.getAuctionHouse(id)
                .map(AuctionHouseMapper::toDto);
        return auctionHouseDTO
                .map(response -> new ResponseEntity<Object>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>("The auction house does not exist", HttpStatus.NOT_FOUND));
    }

    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addAuctionHouse(final @RequestBody AuctionHouseDTO auctionHouseDto) {
        final ResponseEntity<?> response;
        if(auctionHouseDto.getName() == null) {
            response = new ResponseEntity<>("The auction house must have a name!", HttpStatus.BAD_REQUEST);
        } else {
            final Optional<AuctionHouse> createdAuctionHouse = auctionHouseCommands.createAuctionHouse(AuctionHouseMapper.fromDto(auctionHouseDto));
            if(createdAuctionHouse.isPresent()) {
                final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(createdAuctionHouse.get().getId())
                        .toUri();
                response = ResponseEntity.created(location).build();
            } else {
                response =  createdAuctionHouse
                    .map(result -> new ResponseEntity<Object>(AuctionHouseMapper.toDto(result), HttpStatus.OK))
                    .orElse(new ResponseEntity<>("The auction house " + auctionHouseDto.getName() + " already exists!", HttpStatus.BAD_REQUEST));
            }
        }
        return response;
    }

    @DeleteMapping(path="/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteAuctionHouse(final @RequestParam long id) {
        auctionHouseCommands.deleteAuctionHouse(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
