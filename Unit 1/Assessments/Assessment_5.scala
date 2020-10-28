import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

// load dataframe from dataset
// https://github.com/anujdutt9/BigData-and-Machine-Learning/blob/master/Apache%20Spark%20Machine%20Learning%20using%20Scala/Datasets/CitiGroup2006_2008
val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008.csv")
df.printSchema()

// #1 count the rows of the dataframe
df.count()

// #2 summary of the dataframe
df.summary().show()

// #3 first row of the dataframe
df.first()

// #4 first row of the dataframe
df.head()

// #5 first three rows of the dataframe
df.take(3)

// #6 first three rows of the dataframe
df.limit(3)

// #7 sort dataframe
df.sort("Date").show()

// #8 get minimum of column open
df.select(min("Open")).show()

// #9 get maximum of column open
df.select(max("Open")).show()

// #10 get sum of column open
df.select(sum("Open")).show()

// #11 get average of column open
df.select(avg("Open")).show()

// #12 get mean of column open
df.select(mean("Open")).show()

// #13 get variance of column open
df.select(variance("Open")).show()

// #14 get standard deviation of column open
df.select(stddev("Open")).show()

// #15 get correlation between the open and close columns
df.select(corr("Open", "Close")).show()