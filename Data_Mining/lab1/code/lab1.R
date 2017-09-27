setwd("/Users/jiahuiwu/Desktop/CIS660/lab1")
options(max.print = 100000)
data1 <- read.csv("VTargetBuyers.csv", header = TRUE)
dim(data1)
is.null(data1)

#cut age
cuts <- cut(data1$Age, breaks = c(30, 40, 50, 60, 70, 102), 
            label = c(30, 40, 50, 60, 70),
            right = FALSE)
data1$Age <- cuts

#plotting age using barplot
table(data1$Age)
A = table(data1$Age)
barplot(A, main = "Barplot for Age", xlab = "Age",
        ylab = "Frequency", col = "#0000ff")

#YearlyIncome
x <- data1$YearlyIncome
a = min(x)
b = max(x)
newIncome <- function(x){(x - a) / (b - a)}
data1$YearlyIncome <- apply(data1[2], 2, newIncome)

#histogram of yearly income
hist(as.numeric(data1$YearlyIncome))
income = hist(as.numeric(data1$YearlyIncome), 
     breaks = seq(from = 0.0, to = 1.0, by = 0.2), xlab = "YearlyIncome",
     main = "Histogram for YearlyIncome")

#commute distance
data1$CommuteDistance <- as.character(data1$CommuteDistance)
data1$CommuteDistance[which(data1$CommuteDistance == "0-1 Miles")] <- "1"
data1$CommuteDistance[which(data1$CommuteDistance == "1-2 Miles")] <- "2"
data1$CommuteDistance[which(data1$CommuteDistance == "2-5 Miles")] <- "3"
data1$CommuteDistance[which(data1$CommuteDistance == "5-10 Miles")] <- "4"
data1$CommuteDistance[which(data1$CommuteDistance == "10+ Miles")] <- "5"
data1$CommuteDistance <- as.numeric(data1$CommuteDistance)

#barplot of commute distance
dist = table(data1$CommuteDistance)
dist
barplot(dist, main="Barplot for different commmute distance", 
        xlab = "Distance Ranking", ylab = "Frequency")
summary(data1$CommuteDistance)
var(data1$CommuteDistance)
sd(data1$CommuteDistance)

#HouseOwnerFlag
table(data1$HouseOwnerFlag)
HF = table(data1$HouseOwnerFlag)/18484
barplot(HF, main="Barplot for house owner", ylab = "%")
summary(data1$HouseOwnerFlag)
var(data1$HouseOwnerFlag)
sd(data1$HouseOwnerFlag)

#NumberCarsOwned
table(data1$NumberCarsOwned)
carNumber = table(data1$NumberCarsOwned)/18484
barplot(carNumber, main="Barplot for NumberCarsOwned", xlab = "number of cars",
        ylab = "%")
summary(data1$NumberCarsOwned)
var(data1$NumberCarsOwned)
sd(data1$NumberCarsOwned)

#NumberChildrenAtHome
table(data1$NumberChildrenAtHome)
ChildrenNumber = table(data1$NumberChildrenAtHome)/18484
barplot(ChildrenNumber, main="Barplot for NumberChildrenAtHome", 
        xlab = "number of children",
        ylab = "%")
summary(data1$NumberChildrenAtHome)
var(data1$NumberChildrenAtHome)
sd(data1$NumberChildrenAtHome)

#Region
table(data1$Region)
region = table(data1$Region)/18484
region
pie(region, main="piechart for Region")

#EnglishOccupation
table(data1$EnglishOccupation)
occupation = table(data1$EnglishOccupation)/18484
occupation
pie(occupation, main="piechart for EnglishOccupation")

#write data1 from R to txt file
write.table(data1, file = "/Users/jiahuiwu/Desktop/CIS660/lab1/TransformData1.txt",
            col.names = TRUE)

write.table(data1, file = "/Users/jiahuiwu/Desktop/CIS660/lab1/TransformData1.csv",
            col.names = TRUE)

