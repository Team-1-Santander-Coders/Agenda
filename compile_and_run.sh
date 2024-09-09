#!/bin/bash
SRC_DIR="src"

OUT_DIR="out"

mkdir -p $OUT_DIR

find $SRC_DIR -name "*.java" > sources.txt

if [ -s sources.txt ]; then
    javac -d $OUT_DIR @sources.txt
    echo "Projeto compilado com sucesso!"

    java -cp $OUT_DIR com.team1.AgendaApp
else
    echo "Nenhum arquivo .java encontrado."
fi

rm sources.txt
