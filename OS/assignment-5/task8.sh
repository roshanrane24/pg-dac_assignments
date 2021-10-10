#!/bin/bash

# Create a script that displays the system information like: OS name, kernel version, RAM, etc.

echo "Username : $(whoami)"
echo "Hostname : $(hostname)"
echo "Operating System : $(uname -o)"
echo "Kernel : $(uname -s)"
echo "Kernel Version : $(uname -a | awk '{print $3}')"
#ram=$(lshw -c memory | grep size | awk '{print $2}') &> /dev/null
#echo "Ram : $ram"
