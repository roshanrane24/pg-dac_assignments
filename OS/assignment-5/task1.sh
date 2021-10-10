#!/bin/bash

# Write a script that performs following operations on the given set of files?	(15)															29/09/2021

e) displays only those files which have underscore '_' in their names


if [ -z $1 ]
then
    echo "Please provide path to the file as argument"
    exit
fi

rm -rf test
mkdir test

while read file
do
    touch "test/$file"
done <  $1

# displays the total count of files

echo "Total number of file : $(ls test | wc -l)"

# displays the count of *.pdf files and *.docx

echo "Number of files with .pdf : $(ls test/*.(pdf) | wc -l)"
echo "Number of files with .docx : $(ls test/*.(docx) | wc -l)"

# rename all *.pdf to *.docx

echo "Renaming .pdf to .docx"
while read file
do
    mv "test/$file" "test/$(echo $file | sed "s/\.pdf/\.docx/g")"
done <  $(ls test/*.pdf)

# displays the count of *.pdf files and *.docx

echo "Number of files with .docx : $(ls test/*.(docx) | wc -l)"
echo "Number of files with .pdf : $(ls test/*.(pdf) | wc -l)"

# displays only those files which have underscore '_' in their names

echo "Number of files with _ in their name : $(ls test) | wc -l)"
