#!/bin/bash

# Create a script that asks for a command name - then displays it's absolute path and the runs it and displays the output?

read -p "Enter a command " com

which $com

$com > /tmp/testtask

cat /tmp/testtask


