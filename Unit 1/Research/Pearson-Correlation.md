The correlation between two data points X and Y is the measure of the linear relationship between the attributes of X and Y. Pearson's correlation takes values from -1 (perfect negative correlation) to +1 (perfect positive correlation) with the A value of zero means that there is no correlation between X and Y. Since the correlation measures linear relationships, a value of zero does not indicate that there is no relationship. It just means that there is no linear relationship, but there may be a quadratic relationship or a higher-order relationship between the data points. The Pearson correlation between two data points X and Y is given by:

![](Pearson-Correlation-Figure-1) (1)

where * s * ~ * xy * ~ is the covariance of X and Y. The covariance indicates the degree of synchronization of the variance (or volatility) between two variables, calculated as:

![](Pearson-Correlation-Figure-2) (2)

Where * s * ~ * x * ~ and * s * ~ * and * ~ y are the standard deviation of X and Y, respectively.

Figure 1 illustrates pairs of numerical values plotted against each other, with the value of the correlation between the two variables shown on the x-axis. The graph on the right has a perfect positive correlation of 1, while the graph in the middle has no correlation between the two variables. The graph on the left has a perfect negative correlation of -1.

![](Pearson-Correlation-Figure-3)

Figure 1. Correlation between two numerical variables.

A correlation can be calculated between two numerical values (e.g. salary and age) or between two categorical values (e.g., type of product and profession). However, a company may want to calculate correlations between different types of variables. One method of calculating the correlation between numeric values and categorical values is by converting the numeric values into categories. For example, categorize age ranges.

There are different correlation measures, all of which are based on assumptions about the behavior of correlated data sets. A data analyst can impose different types of requirements for correlated data depending on your needs. So there are many correlation values available to data scientists such as: Cosine, Spearman, Jaccard, Gini, and Maximum Information Coefficient.

# References
- David N. (2014). Commercial Data Mining.
- Vijay K. & Bala D. (2019). Data Science (Second Edition).
- Jules J. (2018). Principles and Practice of Big Data (Second Edition).