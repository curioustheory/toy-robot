# Toy Robot

### Requirements

Make sure Maven installed, you can find the Maven installation [here](https://maven.apache.org/download.cgi).

### Building

1. Download the zip from the repository.

2. Unzip the file and navigate to it.

3. Create the JAR with: ```mvn package```

The jar file is now located in **target/toyRobot.jar**

### Running the app

```java -jar toyRobot.jar```


### Example

1. MOVE MOVE REPORT PLACE 3,2,EAST MOVE LEFT MOVE REPORT
2. PLACE 2,1,NORTH MOVE REPORT PLACE 4,3,SOUTH MOVE REPORT

### Robot Commands



|ROBOT COMMAND|Description|
|-------------|-----------|
|PLACE X,Y,F|Place the robot at (x, y) facing the direction NORTH, EAST, SOUTH or WEST.|
|MOVE|Move one step towards the direction the robot is facing.|
|LEFT|Turn the robot to the left.|
|RIGHT|Turn the robot to the right.|
|REPORT|Report the position of the robot.|
|QUIT|Send the poor robot to the junk yard and quit the application.|



