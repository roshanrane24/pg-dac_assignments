#!/bin/bash

# Create a script to remove all empty lines from a file

if [[ -z $1 ]]
then
    echo "Provide a file as argument."
    exit 1
elif [[ ! -f $1 ]]
then
    echo "Provided path is not afile."
    exit 1
fi

cat $1 | grep -v ^$ > $1
