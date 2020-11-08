# Spark exercise 

Exercise to preprocess advertising data with Spark

## Prerequisities

1. Install jdk-8 : jdk8-openjdk https://doc.ubuntu-fr.org/oracle-java8-jdk 
2. Install sbt https://www.scala-sbt.org/download.html
3. Install intelij (optional) https://www.jetbrains.com/idea/

## Functionalites to develop

1. Read json dataframe and create a Dataset
2. Lowercase "os" column 
3. Enrich dataframe with 4 new columns : 
   
    3.1 Given size column create two different columns : width and length
   
    3.2 Given timestamp create two columns : datetime, and create date column 
4. Compute ratio of null values by every column
5. Create one column by interest category from interests
6. Drop interests, imp_id, timestamp and size columns
7. Save dataframe to parquet, partition by date