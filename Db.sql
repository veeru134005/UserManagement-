

--Country Data

insert into Country (id,countryName) values(1,"India");
insert into Country (id,countryName) values(2,"USA");

--States Data

insert into State (stateId,stateName,CountryId) values(1,"AP",1);
insert into State (stateId,stateName,CountryId) values(2,"TS",1);

insert into State (stateId,stateName,CountryId) values(3,"California",2);
insert into State (stateId,stateName,CountryId) values(4,"Texas",2);

--CitisData

insert into City (citId,cityName,StateId) values(1,"Kurnool",1);
insert into City (citId,cityName,StateId) values(2,"Kakinada",1);

insert into City (citId,cityName,StateId) values(3,"HYD",2);
insert into City (citId,cityName,StateId) values(4,"Miryalaguda",2);

insert into City (citId,cityName,StateId) values(5,"Los Angeles",3);
insert into City (citId,cityName,StateId) values(6,"San Diegos",3);

insert into City (citId,cityName,StateId) values(7,"Houston",4);
insert into City (citId,cityName,StateId) values(8,"San Antonio",4);

