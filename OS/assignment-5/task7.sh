#!/bin/bash

# Create a script that depicts sending the process to background so that the next command in sequence can run without wait


echo "running find command in background & loging output to /tmp/find.log"

find / > /tmp/find.log 2> /tmp/find-err.log &

echo "Running ls in foreground while find runs in background"

ls -la ~
