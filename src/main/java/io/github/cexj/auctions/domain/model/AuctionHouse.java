package io.github.cexj.auctions.domain.model;

import io.github.cexj.auctions.exposition.dtos.AuctionHouseDTO;

public final class AuctionHouse {

    private final Long id;
    private final String name;

    private AuctionHouse(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private Long id;
        private String name;

        private Builder(){}
        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder fromAuctionHouse(AuctionHouse auctionHouse) {
            this.id = auctionHouse.getId();
            this.name = auctionHouse.getName();
            return this;
        }

        public AuctionHouse build(){
            return new AuctionHouse(id, name);
        }


    }
}
