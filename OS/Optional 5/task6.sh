#!/bin/bash

not_item=()

while read i; do
    found=false
    while read j; do
        if [[ $i == $j ]]
        then
            found=true
        fi
    done < file1
    if [[ $found == false ]]; then
        not_item+=($i)
    fi
done < file2

echo ${not_item[@]}
