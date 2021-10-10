#!/bin/bash

var_date=$(date +%D)
var_time=$(date +%T)
var_username=$(whoami)
var_cwd=$(pwd)

echo "Date: $var_date"
echo "Time: $var_time"
echo "Username: $var_username"
echo "Current Working Directory: $var_cwd"
