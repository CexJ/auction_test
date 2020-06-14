package io.github.cexj.auctions.domain.model;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public final class Auction {

    private final String name;
    private final String description;
    private final ZonedDateTime startingHour;
    private final ZonedDateTime endingHour;
    private final BigInteger startPrice;
    private final BigInteger currentPrice;

    public Auction(
            final String name,
            final String description,
            final ZonedDateTime startingHour,
            final ZonedDateTime endingHour,
            final BigInteger startPrice,
            final BigInteger currentPrice) {
        this.name = name;
        this.description = description;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.startPrice = startPrice;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getStartingHour() {
        return startingHour;
    }

    public ZonedDateTime getEndingHour() {
        return endingHour;
    }

    public BigInteger getStartPrice() {
        return startPrice;
    }

    public BigInteger getCurrentPrice() {
        return currentPrice;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String name;
        private String description;
        private ZonedDateTime startingHour;
        private ZonedDateTime endingHour;
        private BigInteger startPrice;
        private BigInteger currentPrice;

        private Builder(){}

        public Auction build(){
            return new Auction(
                    name,
                    description,
                    startingHour,
                    endingHour,
                    startPrice,
                    currentPrice);
        }

        public Builder name() {
            this.name = name;
            return this;
        }

        public Builder description() {
            this.description =  description;
            return this;
        }

        public Builder startingHour() {
            this.startingHour = startingHour;
            return this;
        }

        public Builder endingHour() {
            this.endingHour = endingHour;
            return this;
        }

        public Builder startPrice() {
            this.startPrice = startPrice;
            return this;
        }

        public Builder currentPrice() {
            this.currentPrice = currentPrice;
            return this;
        }

    }
}
