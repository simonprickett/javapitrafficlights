#/bin/bash

java -Dpi4j.linking=dynamic -classpath classes:"/opt/pi4j/lib/*" TrafficLights
