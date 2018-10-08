create table Product
(
  ID          bigint,
  Name        varbinary(50),
  Price       float,
  Description text,
  Image       text
)
go

create table Order
(
  ID            bigint,
  TotalQuantity int,
  OrderDate     date,
  DeliveryDate  date,
  DeliveryForm  varchar(50),
  Payment       nvarchar(50),
  Status        nvarchar(50),
  TotalPrice    float
)
go

create table CartPosition
(
  ID       bigint,
  Product  bigint,
  Quantity int
)
go

