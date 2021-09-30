#!/bin/bash

count=0

while read file
do
    ((count++))
	if [[ -f /etc/$file ]]
	then
	    echo -en "\033[0;32m$count\033[0m -> "
		stat -c "%n ---> %a" /etc/$file
	else
	    echo -en "\033[0;31m$count\033[0m -> "
		echo "File [$file] does not exist in this system."
	fi
done < filelist.txt
