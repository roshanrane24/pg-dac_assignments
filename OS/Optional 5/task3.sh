#!/bin/bash

# Create a script that takes a pid and displays the process name

read -p "Enter PID : " p

ps -p $p -o comm=
