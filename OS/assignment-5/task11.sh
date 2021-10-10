#!/bin/bash

# Create a shell program to count number of words, characters, white spaces and special symbols in a given text

if [[ -z $1 ]]
then
    echo "Provide a file as argument"
    exit 1
fi

echo "Number of words in $1 : $(cat $1 | wc -w)"
echo "Number of lines in $1 : $(cat $1 | wc -l)"
echo "Number of characters in $1 : $(cat $1 | wc -c)"
echo "Number of white spaces in $1 : $(cat $1 | grep -Po "\s" | wc -l)"
echo "Number of special character in $1 : $(cat $1 | grep -Po "[^(\w|\d|\s)]" | wc -l)"
