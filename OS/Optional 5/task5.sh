#!/bin/bash

# Perform Q1 - change: script will ask for multiple process names this time. User enters multiple processes(comma separeted) and then system initiates and then kills those processes. eg: firefox,vi,top

read -p "process names (, seprated) = " procs

IFS=","

for i in $procs
do
	echo "Starting $i"
	"$i" &>/dev/null & 

done

echo "Wait 2s"
sleep 2

for i in $1
do
	echo "Killing Process $i"
	pkill -9 $i
done
