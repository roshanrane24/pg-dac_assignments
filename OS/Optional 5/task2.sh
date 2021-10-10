#!/bin/bash

 # Create a script that takes the process name and displays it's pid? - It should throw the error if process name enetered is incorrect or doesnt exist on the system
 
read -p "Enter process name" p

proc=$(pidof $p)

if [[ -n $proc ]]
then
	echo "PID of $p = $proc"
else
	echo "ERROR: process doe not exist"
fi
