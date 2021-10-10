#!/bin/bash

# Perform Q1 - change: script will ask for multiple process names this time. User enters multiple processes(comma separeted) and then system initiates and then kills those processes. eg: firefox,vi,top

read -p "process names (, seprated) = " procs

IFS=","

pids=()

for i in $procs
do
	echo "Starting $i"
	bash -c "$i & 2> /dev/null"
	pids+=($!)
done

echo "Wait 5s"
sleep 5

for i in ${pids[@]}
do
	echo "Killing PID $i"
	kill -9 $i
done
