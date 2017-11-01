#!/usr/bin/env bash

folder="$1"

if [ -z "$folder" ]; then
    echo "Param0 cant be empty!"
    exit
fi

rm -rf src/$folder/classes
mkdir src/$folder/classes
javac -sourcepath src/$folder src/Framework/*.java src/$folder/*.java -d src/$folder/classes
cd src/$folder/classes
java Main
