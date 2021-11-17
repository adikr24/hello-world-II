-- create the DataModel
-- create STORE
create TABLE `grocerystore`.`STORE` 
(
StoreName varchar(255) NOT NULL UNIQUE,
Revenue Float 
);


--create ITEMS
create TABLE `grocerystore`.`ITEMS` 
(
StoreName varchar(255) NOT NULL ,
ItemName varchar(255) NOT NULL ,
ItemWeight int,
StoreNameAndItem  varchar(255) NOT NULL  UNIQUE
);

-- create PILOTS
create TABLE `grocerystore`.`PILOTS` 
(
PilotAccount varchar(255) NOT NULL UNIQUE,
FirstName varchar(255) NOT NULL ,
LastName varchar(255) NOT NULL ,
PhoneNumber varchar(255) NOT NULL ,
TaxID varchar(255) NOT NULL ,
LicenseID varchar(255) NOT NULL UNIQUE,
ExperienceLevel INT,
IsAvailable varchar(255) 
);


--create DRONES

create TABLE `grocerystore`.`DRONES` 
(
StoreName varchar(255) NOT NULL ,
DroneID varchar(255) NOT NULL UNIQUE, 
WeightCapacity INT, 
RemainingDeliveries INT, 
IsAvailable varchar(255) 
);


-- create customers
create TABLE `grocerystore`.`CUSTOMERS` 
(
CustomerID varchar(255) NOT NULL UNIQUE, 
FirstName varchar(255) NOT NULL,
LastName varchar(255) NOT NULL, 
PhoneNumber varchar(255) NOT NULL,
CustomerRating INT,
CreditsAvailable INT)
;

--create Order

 create TABLE `grocerystore`.`Order` 
 (
 StoreName varchar(255) NOT NULL,
 OrderID varchar(255) NOT NULL UNIQUE,
 DroneID  varchar(255) NOT NULL,
 CustomerID varchar(255) NOT NULL
 );
 
 ---create deliveries
 
 create TABLE `grocerystore`.`DELIVERITEMS` 
(
StoreName varchar(255) NOT NULL, 
OrderID varchar(255) NOT NULL, 
ItemName varchar(255) NOT NULL, 
ItemQuantity Int Not null,
ItemPrice Int Not Null
);





