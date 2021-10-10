#!/bin/bash

if [[ -d $1 ]]
then
    ls -la $1 | grep "^-" | awk '{print $9}'
else
    echo "Provided path is not a directory"
fi
