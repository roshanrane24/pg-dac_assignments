#!/bin/bash

# Write a command that fetches the list of all files under /root directory that are more than 2KB in size

if [[ $EUID -ne 0 ]]
then
    echo "You need to be root to run this script."
    exit 1
fi

echo "All files under /root"
echo ""
sudo find /root -type f -size +2k


