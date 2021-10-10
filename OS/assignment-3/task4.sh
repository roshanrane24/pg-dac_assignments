#!/bin/bash

if [[ -z $1 ]]
then
    echo "Provide path."
elif [[ -f $1 ]]
then
    echo "$1 is a file"
else
    echo "$1 is a directory"
fi
