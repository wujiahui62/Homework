setwd("/Users/jiahuiwu/Desktop/CIS660/lab1/output")
options(max.print = 100000)
data1 <- read.csv("VTargetBuyers.csv", header = TRUE)

#cut age
cuts <- cut(data1$Age, breaks = c(30, 40, 50, 60, 70, 102), 
            label = c(30, 40, 50, 60, 70),
            right = FALSE)
data1$Age <- cuts

#normalize yearlyincome to 0-1
x <- data1$YearlyIncome
a = min(x)
b = max(x)
newIncome <- function(x){(x - a) / (b - a)}
data1$YearlyIncome <- apply(data1[2], 2, newIncome)

#replace commute distance with numbers
data1$CommuteDistance <- as.character(data1$CommuteDistance)
data1$CommuteDistance[which(data1$CommuteDistance == "0-1 Miles")] <- "1"
data1$CommuteDistance[which(data1$CommuteDistance == "1-2 Miles")] <- "2"
data1$CommuteDistance[which(data1$CommuteDistance == "2-5 Miles")] <- "3"
data1$CommuteDistance[which(data1$CommuteDistance == "5-10 Miles")] <- "4"
data1$CommuteDistance[which(data1$CommuteDistance == "10+ Miles")] <- "5"
data1$CommuteDistance <- as.numeric(data1$CommuteDistance)

#interval-scale of commute distance
cd <- data1$CommuteDistance
newdis <- function(cd){(cd - 1) / (5 - 1)}
data1$CommuteDistance <- apply(data1[3], 2, newdis)

#select sample data (100 rows)
test1 <- data1[sample(nrow(data1), 100), ]

#data for euclidean distance
ecdist <- test1[, c(1, 2, 3)]

#calculate euclidean distance
install.packages("spam")
install.packages("grid")

library(fields)
ecdistMatrix = rdist(ecdist, ecdist)
write.table(ecdistMatrix, file = "ecdistMatrix.txt",
            row.names = FALSE, col.names = FALSE)

#data for hamming distance and jaccard distance
hamdist <- test1[, c(4, 7, 8)]

hamdist_bi <- within(hamdist, {
    R1=ifelse(hamdist$Region=="Pacific", 1, 0)
    R2=ifelse(hamdist$Region=="North America", 1, 0)
    R3=ifelse(hamdist$Region=="Europe", 1, 0)
    E1=ifelse(hamdist$EnglishOccupation=="Professional", 1, 0)
    E2=ifelse(hamdist$EnglishOccupation=="Manual", 1, 0)
    E3=ifelse(hamdist$EnglishOccupation=="Skilled Manual", 1, 0)
    E4=ifelse(hamdist$EnglishOccupation=="Clerical", 1, 0)
    E5=ifelse(hamdist$EnglishOccupation=="Management", 1, 0)
  })

hamdist_bical <- hamdist_bi[, c(1, 4:11)]

#hamming distance
n <- nrow(hamdist_bical)
m <- matrix(nrow=n, ncol=n)
for(i in seq_len(n))
  for(j in seq(i, n))
    m[j, i] <- m[i, j] <- sum(hamdist_bical[i,] != hamdist_bical[j,])
m

write.table(m, file = "hamdist.txt", row.names = FALSE, col.names = FALSE)

#jaccard distance
n <- nrow(hamdist_bical)
k <- matrix(nrow = n, ncol = n)
for(i in seq_len(n))
  for(j in seq(i, n)){
    rs <- sum(hamdist_bical[i,] != hamdist_bical[j,])
    q <- sum(hamdist_bical[i,] == 1 & hamdist_bical[j,] == 1)
    k[j, i] <- k[i, j] <- rs / (rs + q)
  }

write.table(k, file = "jacdist.txt", row.names = FALSE, col.names = FALSE)

#jaccard similarity
n <- nrow(hamdist_bical)
s <- matrix(nrow = n, ncol = n)
for(i in seq_len(n))
  for(j in seq(i, n)){
    s[j, i] <- s[i, j] <- 1 - k[i, j]
  }

write.table(k, file = "jacsim.txt", row.names = FALSE, col.names = FALSE)

#data for cosine distance
cosdis <- test1[, c(5, 6)]

install.packages('proxy')
library('proxy')
r = dist(cosdis, method="cosine")
save(r, file = "cosdis.rda")


test2 <- data1[sample(nrow(data1), 3), ]


