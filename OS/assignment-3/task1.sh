#!/bin/bash

if [[ -z $1 ]]
then
    echo "Please provide a number."
elif [[ $1 -lt 10 && $1 -ge 0 ]]
then
    echo "$number is single digit number."
elif [[ $1 -lt 100 && $1 -ge 10 ]]
then
    echo "$1 is two digit number."
else
    echo "Number is more than two digit."
fi
