# Unit 1

## [Evaluation](Evaluation.scala)

Instructions of the evaluation


    1. Create a simple session in spark.
    2. Load the netflix stock csv, using sparks type inference.
    3. What are the names of the columns?
    4. What's the schema?
    5. Print the first 5 columns.
    6. Use describe to know about the dataframe.
    7. Create a new dataframe with a new column named "HV Ratio", which is the relation between "High" and "Volume". (Hint: it is a column operation).
    8. Which day was the highest on the "Close" column?
    9.  Write a comment with your own words, about the meaning of the "Close" column.
    10. What are the maximum and minimum values of the column "Volume"?
    11. With scala/spark $ syntax, answer the folling:
        a.  How many days was the column "Close" less than 600?
        b.  What's the time percentage of the column "High" where it was more than 500? 
        c.  What's the pearson correlation between the column "High" and "Volume"?
        d.  What's the maximum of the column "High" for each year?
        e.  What's the average of the column "Close" for each month?