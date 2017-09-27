setwd("/Users/jiahuiwu/Desktop/CIS660/lab4")
options(max.print = 100000)
data1 <- read.csv("bikebuyer.csv", header = TRUE)
str(data1)
names(data1)
dim(data1)

#YearlyIncome
x <- data1$YearlyIncome
a = min(x)
b = max(x)
newIncome <- function(x){(x - a) / (b - a)}
data1$YearlyIncome <- apply(data1[2], 2, newIncome)

#cut age
cuts <- cut(data1$Age, breaks = c(30, 40, 50, 60, 70, 102), 
            label = c(30, 40, 50, 60, 70),
            right = FALSE)
data1$Age <- cuts

#commute distance
data1$CommuteDistance <- as.character(data1$CommuteDistance)
data1$CommuteDistance[which(data1$CommuteDistance == "0-1 Miles")] <- "1"
data1$CommuteDistance[which(data1$CommuteDistance == "1-2 Miles")] <- "2"
data1$CommuteDistance[which(data1$CommuteDistance == "2-5 Miles")] <- "3"
data1$CommuteDistance[which(data1$CommuteDistance == "5-10 Miles")] <- "4"
data1$CommuteDistance[which(data1$CommuteDistance == "10+ Miles")] <- "5"
data1$CommuteDistance <- as.numeric(data1$CommuteDistance)

head(data1)
str(data1)

#split data into testing and training sets
set.seed(2)
train = sample(1:nrow(data1), nrow(data1) * 0.7)
test = -train
training_data = data1[train,]
testing_data = data1[test,]

######################## use C5.0
library(C50)
C50_model1 = C5.0(training_data[, -9], as.factor(training_data[, 9]))
C50_model1
summary(C50_model1)
plot(C50_model1)
C50_pre1 = predict(C50_model1, testing_data)
t = table(testing_data[, 9], Predicted = C50_pre1)
b = as.vector(t)
b
b[2]

count(C50_pre1 != buy_data)
dim(testing_data)
C5.0Control()
#change parameters
#1
C50_model2 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(earlyStopping = FALSE))
C50_pre2 = predict(C50_model2, testing_data)
table(testing_data[, 9], Predicted = C50_pre2)
#2
C50_model3 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(sample = .9))
C50_pre3 = predict(C50_model3, testing_data)
table(testing_data[, 9], Predicted = C50_pre3)
#3
C50_model4 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(subset = FALSE))
C50_pre4 = predict(C50_model4, testing_data)
table(testing_data[, 9], Predicted = C50_pre4)
#4
C50_model5 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(winnow = TRUE))
C50_pre5 = predict(C50_model5, testing_data)
table(testing_data[, 9], Predicted = C50_pre5)
#5
C50_model6 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(noGlobalPruning = TRUE))
C50_pre6 = predict(C50_model6, testing_data)
table(testing_data[, 9], Predicted = C50_pre6)
#6
C50_model7 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(CF = 1))
C50_pre7 = predict(C50_model7, testing_data)
table(testing_data[, 9], Predicted = C50_pre7)
#7
C50_model8 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(minCases = 0))
C50_pre8 = predict(C50_model8, testing_data)
table(testing_data[, 9], Predicted = C50_pre8)
#8
C50_model9 = C5.0(training_data[, -9], y=as.factor(training_data[, 9]),
                  control = C5.0Control(fuzzyThreshold = TRUE))
C50_pre9 = predict(C50_model9, testing_data)
table(testing_data[, 9], Predicted = C50_pre9)
######################
#using rpart
######################
install.packages("rpart")
install.packages("rpart.plot")
require(rpart)
require(rpart.plot)
rpart_model1 = rpart(BikeBuyer ~., training_data, method = "class")
rpart_model1
rpart.plot(rpart_model1)
summary(rpart_model1)
rpart_pre1 = predict(rpart_model1, testing_data, type="class")
table(testing_data[, 9], rpart_pre1)
dim(testing_data)
rpart.control()
#2
rpart_model2 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(minsplit = 1))
rpart_pre2 = predict(rpart_model2, testing_data, type="class")
table(testing_data[, 9], rpart_pre2)
#3
rpart_model3 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = -.01))
rpart_pre3 = predict(rpart_model3, testing_data, type="class")
table(testing_data[, 9], rpart_pre3)
#4
rpart_model4 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, maxcompete = 20))
rpart_pre4 = predict(rpart_model4, testing_data, type="class")
table(testing_data[, 9], rpart_pre4)
#5
rpart_model5 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, usesurrogate = 0))
rpart_pre5 = predict(rpart_model5, testing_data, type="class")
table(testing_data[, 9], rpart_pre5)
#6
rpart_model6 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, surrogatestyle = 1))
rpart_pre6 = predict(rpart_model6, testing_data, type="class")
table(testing_data[, 9], rpart_pre6)
#7
rpart_model7 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, maxdepth = 15))
rpart_pre7 = predict(rpart_model7, testing_data, type="class")
table(testing_data[, 9], rpart_pre7)
#8
rpart_model8 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, xval = 30))
rpart_pre8 = predict(rpart_model8, testing_data, type="class")
table(testing_data[, 9], rpart_pre8)

help(rpart) 

C50_model1 = C5.0(training_data[, -9], as.factor(training_data[, 9]))
C50_pre1 = predict(C50_model1, testing_data)
table(testing_data[, 9], Predicted = C50_pre1)

rpart_model3 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0))
rpart_pre3 = predict(rpart_model3, testing_data, type="class")
table(testing_data[, 9], rpart_pre3)








