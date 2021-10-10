#!/bin/bash

# Create a shell script to find the largest among the 3 given numbers


# Checking arguments
if [ -z $3 ]
then
    echo "Please provide 3 numbers as arguments"
    exit 1
fi

# Calculating max of 3
if [ $1 -gt $2 ]
then
    max=$1
else
    max=$2
fi

if [ $max -gt $3 ]
then
    echo "Largest number is: $max"
else
    echo "Largest number is: $3"
fi
