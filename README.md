# Spark exercise 

Exercise to preprocess advertising data with Spark

## Prerequisities

1. Install jdk-8 : jdk8-openjdk https://doc.ubuntu-fr.org/oracle-java8-jdk 
2. Install sbt https://www.scala-sbt.org/download.html
3. Install intelij (optional) https://www.jetbrains.com/idea/

## Functionalities to develop

1. Read json dataframe and create a Dataset of RawDataframe with a unique identifier for each line (create a unique id for each column)
2. Lowercase "os" column 
3. Enrich dataframe with 4 new columns implementing it in createEnrichedataset function : 
   
    3.1 Given size column create two different columns : width and length
   
    3.2 Given timestamp create two columns : datetime, and create date column 
    
 The final dataframe for output is the result of createEnrichedataset function
4. Compute ratio of null values by every column
5. Save dataframe to parquet, partition by date
6. Save dataframe to avro, partition by date
7. Save dataframe to json, partition by date
8. Benchmark the writing time of different formats, specifying the computional ressources you have, 
as well as the config of your spark job and explain the possible reasons of  differences, and in which case you prefer that or this format 
(you can write directly in Readme)
9. Write unit test for creation of date column in createEnrichedataset function of AdsProcesser object