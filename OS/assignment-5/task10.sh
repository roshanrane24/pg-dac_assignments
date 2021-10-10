#!/bin/bash

# Create a shell program to check whether a given string is palindrome

read -p "Enter a string to check for palindrome : " org

reverse=$(echo $org | rev)

if [[ $org = $reverse ]]
then
    echo "Provided string is palindrome"
else
    echo "String is not a palindrome"
fi

