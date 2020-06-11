# auction_test
A Java RESTapi for auctions

You have to develop a web application that manages an auction house.
# Step 1 - Auction house
> Create an auction house with a given name.
> List all auction houses created.
> Delete a specific house.
# Step 2 - Auction
For a given Auction house
> create an auction with some parameters: name, description, starting time, end time, start
price, current price
> List all auctions for a given auction house
> Delete a specific auction
> (Optional): List all auctions based on their status (i.e. not_started, running, terminated,
deleted, ...)
# Step 3 - Bidding in an auction
For a given auction:
> Let a specific user bid (if only the bidding price is higher that the auction current price and
the auction is started)
> List all bidding (with the user name) that has happen until now
> For a terminated auction, show the winner (i.e. the bidder that puts the higher price)
# Notes
> This must be a web application that receives and answer to http commands with tools like
cURL or HTTPie
> You can use any library you want
> Database and persistent mechanisms are not asked, you can keep all data in memory
> You can use the domain model (POJO) you want as long as it solves the exercice
# Optional points
> Use of a build system (like maven or gradle)
> Good management or user notifications of errors
> Use of appropriate http requests methods
> Clean code
> Tests
> Documentation
