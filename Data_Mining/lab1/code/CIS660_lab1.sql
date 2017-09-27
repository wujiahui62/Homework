use AdventureWorksDW2014
select * from vTargetMail

go
create view VTargetBuyerMailList as
select v.CustomerKey, v.FirstName, v.MiddleName, v.LastName, v.EmailAddress, v.Age, v.YearlyIncome, v.CommuteDistance, 
		v.HouseOwnerFlag, v.NumberCarsOwned, v.NumberChildrenAtHome, v.Region, v.EnglishOccupation
from vTargetMail v
go

select * from VTargetBuyerMailList

go
create view VTargetBuyers as
select  v.Age, v.YearlyIncome, v.CommuteDistance, v.HouseOwnerFlag, v.NumberCarsOwned, 
		v.NumberChildrenAtHome, v.Region, v.EnglishOccupation
from VTargetBuyerMailList v
go

select * from VTargetBuyers

select CommuteDistance, count(*)
from VTargetBuyers
group by CommuteDistance

select Gender, count(*)
from VTargetBuyers
group by Gender

select HouseOwnerFlag, count(*)
from VTargetBuyers
group by HouseOwnerFlag

select MaritalStatus, count(*)
from VTargetBuyers
group by MaritalStatus

select NumberCarsOwned, count(*)
from VTargetBuyers
group by NumberCarsOwned

select NumberChildrenAtHome, count(*)
from VTargetBuyers
group by NumberChildrenAtHome

select EnglishOccupation, count(*)
from VTargetBuyers
group by EnglishOccupation

select Region, count(*)
from VTargetBuyers
group by Region

select YearlyIncome, count(*)
from VTargetBuyers
group by YearlyIncome

select Age, count(*)
from VTargetBuyers
group by Age