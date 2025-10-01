#!/bin/bash



BASE_NAME="clase"


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

    DIRNAME="${BASE_NAME}${FMT}"

    mkdir -p "$DIRNAME"


    echo "creando directorio: $DIRNAME"
done

echo "Todas las carpetas fueron creadas."

