#/bin/bash

mkdir -p classes
javac -classpath "/opt/pi4j/lib/*" -d classes src/TrafficLights.java 
