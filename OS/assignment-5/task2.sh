#!/bin/bash

#Write a script that displays the user information on the linux box in the following format:	(10)
#Username	Shell assigned to that user

echo -e "$(whoami)\t$SHELL"
