#/bin/bash

#Create a script that creates the firefox process and then stop the firefox process using SIGKILL sign.

firefox &
ff=$!

sleep 15s

kill -9 $ff
