#!/bin/bash

# Getting Numbers from user
read -p "Enter the first number: " first
read -p "Enter the second number: " second

# performing operations
echo "Sum of numbers: $(expr $first + $second)"
echo "Difference of numbers: $(expr $first - $second)"
echo "Product of numbers: $(expr $first \* $second)"
if [[ $second -eq 0 ]]
then
    echo "Dividing by zero is not allowed..."
else
    echo "Division of numbers: $(expr $first / $second)"
fi
