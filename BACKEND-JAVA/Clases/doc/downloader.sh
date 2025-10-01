#!/bin/bash


DEST_DIR="./src"
CURSO="JAVA"
BASE_URL="https://ttech2025.github.io/flipbook/${CURSO}"

mkdir -p "$DEST_DIR"

# for in range 0 a 16
for N in $(seq 0 16); do


    # if N < 10
    if [ $N -lt 10 ]; then
        # 0N (ie: 01,02, ...0N)
        FMT=$(printf "0%d" $N)
    else
        # N (ie: 10,11, ...N)
        FMT="$N"
    fi

    # Construir URL completa
    FILE_URL="${BASE_URL}/Clase${FMT}/files/downloads/Clase${FMT}.pdf"
    
    # Descargar el archivo en la carpeta DEST_DIR
    wget -c "$FILE_URL" -P "$DEST_DIR"
    
    echo "Descargado: $FILE_URL"
done

echo "Todas las descargas completadas."

