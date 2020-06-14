package io.github.cexj.auctions.exposition.dtos;

public class AuctionHouseDTO {

    private final Long id;
    private final String name;

    private AuctionHouseDTO(Long id, String name) {
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

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public AuctionHouseDTO build(){
            return new AuctionHouseDTO(id, name);
        }
    }
}