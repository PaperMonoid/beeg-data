import org.apache.spark.sql.SparkSession

// 1. Create a simple session in spark.
val spark = SparkSession.builder().getOrCreate()

// 2. Load the netflix stock csv, using sparks type inference.
//
// load dataframe from dataset
// https://github.com/anujdutt9/BigData-and-Machine-Learning/blob/master/Apache%20Spark%20Machine%20Learning%20using%20Scala/Datasets/Netflix_2011_2016.csv
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

// 3. What are the names of the columns?
df.columns
/* 
scala> df.columns
res16: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
*/

// 4. What's the schema?
df.printSchema()
/*
scala> df.printSchema()
root
 |-- Date: string (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)
*/

// 5. Print the first 5 columns.
df.columns.slice(0, 5)
/*
scala> df.columns.slice(0, 5)
res18: Array[String] = Array(Date, Open, High, Low, Close)
*/

// 6. Use describe to know about the dataframe.
df.describe().show()
/*
scala> df.describe().show()
+-------+----------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|      Date|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+----------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|      1259|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|      null|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|      null|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|2011-10-24|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|2016-10-24|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
+-------+----------+------------------+------------------+------------------+------------------+--------------------+------------------+
*/

// 7. Create a new dataframe with a new column named "HV Ratio", which is the relation between "High" and "Volume". (Hint: it is a column operation).
val df2 = df.withColumn("HV Ratio", df("High") / df("Volume"))
df2.show()
/*
scala> df2.show()
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
|      Date|             Open|              High|       Low|            Close|   Volume|         Adj Close|            HV Ratio|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
|2011-10-24|       119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|9.985040951285156E-7|
|2011-10-25|        74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|2.515989989281927E-7|
|2011-10-26|            78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|5.474206014903126E-7|
|2011-10-27|        82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|1.161960907430818...|
|2011-10-28|        80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|1.465476686700271...|
|2011-10-31|83.63999799999999|         84.090002| 81.450002|        82.080003| 39653600|         11.725715|2.120614572195210...|
|2011-11-01|        80.109998|         80.999998|     78.74|        80.089997| 33016200|         11.441428|2.453341026526372E-6|
|2011-11-02|        80.709998|         84.400002| 80.109998|        83.389999| 41384000|         11.912857|2.039435578967717E-6|
|2011-11-03|        84.130003|         92.600003| 81.800003|        92.290003| 94685500|13.184285999999998| 9.77974483949496E-7|
|2011-11-04|91.46999699999999| 92.89000300000001| 87.749999|        90.019998| 84483700|             12.86|1.099502069629999...|
|2011-11-07|             91.0|         93.839998| 89.979997|        90.830003| 47485200|         12.975715|1.976194645910725...|
|2011-11-08|91.22999899999999|         92.600003| 89.650002|        90.470001| 31906000|         12.924286|2.902275528113834...|
|2011-11-09|        89.000001|         90.440001| 87.999998|        88.049999| 28756000|         12.578571|3.145082800111281E-6|
|2011-11-10|        89.290001| 90.29999699999999| 84.839999|85.11999899999999| 39614400|             12.16|2.279474054889131E-6|
|2011-11-11|        85.899997|         87.949997|      83.7|        87.749999| 38140200|         12.535714|2.305965805108520...|
|2011-11-14|        87.989998|              88.1|     85.45|        85.719999| 21811300|         12.245714|4.039190694731629...|
|2011-11-15|            85.15|         87.050003| 84.499998|        86.279999| 21372400|         12.325714|4.073010190713256...|
|2011-11-16|        86.460003|         86.460003| 80.890002|        81.180002| 34560400|11.597142999999999|2.501707242971725E-6|
|2011-11-17|            80.77|         80.999998| 75.789999|        76.460001| 52823400|         10.922857|1.533411291208063...|
|2011-11-18|             76.7|         78.999999| 76.039998|        78.059998| 34729100|         11.151428|2.274749388841058...|
+----------+-----------------+------------------+----------+-----------------+---------+------------------+--------------------+
only showing top 20 rows
*/

// 8. Which day was the highest on the "Close" column?
df.sort(desc("Close")).limit(1).select("Date", "Close").show()
/*
scala> df.sort(desc("Close")).limit(1).select("Date", "Close").show()
+----------+----------+
|      Date|     Close|
+----------+----------+
|2015-07-13|707.610001|
+----------+----------+
*/

// 9. Write a comment with your own words, about the meaning of the "Close" column.
/*
When talking about the stock market, the close price is the price of the 
last trade made when the market closed that day. 
*/

// 10. What are the maximum and minimum values of the column "Volume"?
df.select(min("Volume"), max("Volume")).show()
/*
scala> df.select(min("Volume"), max("Volume")).show()
+-----------+-----------+
|min(Volume)|max(Volume)|
+-----------+-----------+
|    3531300|  315541800|
+-----------+-----------+
*/

// 11. With scala/spark $ syntax, answer the folling:
// a.  How many days was the column "Close" less than 600?
df.filter($"Close" < 600).count()
/*
scala> df.filter($"Close" < 600).count()
res23: Long = 1218
*/

// b.  What's the time percentage of the column "High" where it was more than 500? 
df.filter($"High" > 500).count().toFloat / df.count().toFloat * 100.0
/*
scala> df.filter($"High" > 500).count().toFloat / df.count().toFloat * 100.0
res24: Double = 4.92454320192337
*/

// c.  What's the pearson correlation between the column "High" and "Volume"?
df.select(corr($"High", $"Volume")).show()
/*
scala> df.select(corr($"High", $"Volume")).show()
+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+
*/

// d.  What's the maximum of the column "High" for each year?
df.groupBy(date_format($"Date", "yyyy").as("Year")).max("High").orderBy("Year").show()
/*
scala> df.groupBy(date_format($"Date", "yyyy").as("Year")).max("High").orderBy("Year").show()
+----+------------------+
|Year|         max(High)|
+----+------------------+
|2011|120.28000300000001|
|2012|        133.429996|
|2013|        389.159988|
|2014|        489.290024|
|2015|        716.159996|
|2016|129.28999299999998|
+----+------------------+
*/

// e.  What's the average of the column "Close" for each month?
df.groupBy(date_format($"Date", "MMMM").as("Month")).avg("Close").orderBy("Month").show()
/*
scala> df.groupBy(date_format($"Date", "MMMM").as("Month")).avg("Close").orderBy("Month").show()
+---------+------------------+
|    Month|        avg(Close)|
+---------+------------------+
|    April|246.97514271428562|
|   August|195.25599892727263|
| December| 199.3700942358491|
| February| 254.1954634020619|
|  January|212.22613874257422|
|     July|243.64747528037387|
|     June| 295.1597153490566|
|    March| 249.5825228971963|
|      May|264.37037614150944|
| November| 194.3172275445545|
|  October|205.93297300900903|
|September|206.09598121568627|
+---------+------------------+
*/