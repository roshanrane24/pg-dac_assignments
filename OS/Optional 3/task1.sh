#!/bin/bash

#Create a script that takes a user name and lists down all the files he owns?

read -p "Enter a username" user

find / -user greenalien -type f 2> /dev/null
