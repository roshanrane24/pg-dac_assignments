#!/bin/bash

rm -rf test

echo "Creating directory named test"
mkdir test

echo "Creating 5 files inside test directory"
touch test/file{1..5}

echo "adding .txt extension to files"
for file in $(ls test)
do
    mv test/$file test/${file}.txt
done
