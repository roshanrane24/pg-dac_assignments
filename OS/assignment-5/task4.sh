#!/bin/bash

# Create a script that asks for a user name and add that user with password same as that of user name. The user added should be assigned nologin shell


if [[ $EUID -ne 0 ]]
then
    echo "You need to be root to run this script."
    exit 1
fi

read -p "Enter username: " usrname

user=$(cat /etc/passwd | grep "^$usrname")

if [[ -n $user ]]
then
    echo "User '$usrname' already exist."
    exit 1
fi

useradd -m -s /bin/nologin -p $(perl -e "print crypt($usrname, 'sha')") $usrname

# Alternative for passwd command
# ($usrname; $usrname) | passwd $usrname
