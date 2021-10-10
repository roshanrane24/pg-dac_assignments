#!/bin/bash

# Create a script that fetches only the IP address of the machine from output of ifconfig command

if [[ -z $1 ]]
then
    interface="enp2s0"
else
    interface="$1"
fi

echo "$(ip a | grep $interface | grep -Po "\d+\.\d+\.\d+\.\d+" | head -n 1)"
