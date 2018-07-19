#!/bin/bash

mkdir -p out
javac -d out hashmap/src/com/rovin/Main.java
javac -d out queue/src/com/rovin/Queue.java
javac -d out stack/src/com/rovin/Stack.java
javac -d out reference/src/com/rovin/References.java

cd out
java com.rovin.Main
java com.rovin.Queue
java com.rovin.Stack
java com.rovin.References
