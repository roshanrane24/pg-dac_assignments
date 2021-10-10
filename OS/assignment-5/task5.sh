#!/bin/bash

# reate a calculator program in bash that takes two numbers (integers) and display menu to the user for various mathematical operations. Hint: Switch Case Break

while :
do
    read -p "Enter first Number : " first
    read -p "Enter second Number : " second

    echo "Select operation to perform : "
    echo "1) Addition"
    echo "2) Substraction"
    echo "3) Multiplication"
    echo "4) Division"
    read -p "--> " operation

    case $operation in
        1)
            echo "Answer = $(expr $first + $second)"
            ;;
        2)
            echo "Answer = $(expr $first - $second)"
            ;;
        3)
            echo "Answer = $(expr $first \* $second)"
            ;;
        4)
            echo "Answer = $(expr $first / $second)"
            ;;
        *)
            echo "Invalid Operation"
            ;;
    esac

    read -p "Do you want to continue [y/N]:" continue

    case $continue in
        y|Y)
            echo ""
            ;;
        *)
            exit
            ;;
    esac
done
