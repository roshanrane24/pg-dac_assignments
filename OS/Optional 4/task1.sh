#!/bin/bash

# Getting Numbers from user
read -p "Enter the first number: " first
read -p "Enter the second number: " second

echo "Greatest number is: "

# Displaying greater number
if [[ first -gt second ]]
then
    echo $first
else
    echo $second
fi
