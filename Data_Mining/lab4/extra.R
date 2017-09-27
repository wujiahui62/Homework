setwd("/Users/jiahuiwu/Desktop/CIS660/lab4")
options(max.print = 100000)
data1 <- read.csv("featureselect.csv", header = TRUE)
str(data1)
names(data1)
dim(data1)
is.null(data1)

set.seed(2)
train = sample(1:nrow(data1), nrow(data1) * 0.7)
test = -train
training_data = data1[train,]
testing_data = data1[test,]

#initialize maximum accuracy to 0, best features to 13
maxAccuracy = 0
bestFeature = 13
#start a for loop to loop the attribute
for(i in 13: 3){
  #each time assign column 1-i to data
  data <- data1[, c(1:i)]
  library(C50)
  model = C5.0(data[1:12000, -1], as.factor(data[1:12000, 1]))
  pred = predict(model, data[12000:18484,])
  #confusion table
  table = table(data[12000:18484, 1], Predicted = pred)
  a = as.vector(table[1])
  b = as.vector(table[2])
  c = as.vector(table[3])
  d = as.vector(table[4])
  #calculate current accuracy
  currAccu = (a + d) / (a + b + c + d)
  #if current accuracy > max accuracy, update maxAccuracy and bestFeature
  if(currAccu > maxAccuracy){
    maxAccuracy = currAccu
    bestFeature = i
  }
}
print(maxAccuracy)
print(bestFeature)


maxAccuracy = 0
bestFeature = 13
for(i in 13: 3){
  data <- data1[, c(1:i)]
  library(rpart)
  model = rpart(BikeBuyer ~., data[1:12000,], method = "class",
                control = rpart.control(cp = 0))
  pred = predict(model, data[12000:18484,], type="class")
  table = table(data[12000:18484, 1], Predicted = pred)
  a = as.vector(table[1])
  b = as.vector(table[2])
  c = as.vector(table[3])
  d = as.vector(table[4])
  currAccu = (a + d) / (a + b + c + d)
  if(currAccu > maxAccuracy){
    maxAccuracy = currAccu
    bestFeature = i
  }
}
print(maxAccuracy)
print(bestFeature)


rpart_model8 = rpart(BikeBuyer ~., training_data, method = "class",
                     control = rpart.control(cp = 0, xval = 30))
rpart_pre8 = predict(rpart_model8, testing_data, type="class")
table(testing_data[, 9], rpart_pre8)


