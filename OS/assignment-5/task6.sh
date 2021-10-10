#!/bin/bash

#Create 2 VMs - both CentOS 7 (with fresh snapshots) with names - machineA and machineB
	#1. From machineA copy any file to machineB
	#2. From machineA - create a dir named 'testdir' on machineB

read -p "machineB username : " username
read -p "machineB location : " location
echo ""
echo "1. Copying files from machineA to machineB ---"
read -p "source path on machineA : " src
read -p "destination path on machineB : " dest

scp -r $src $username@$location:$dest

ssh $username@$location 'cd ~ ; mkdir testdir'
