function arbre {
    if [-z $2 ]
    then    
        if [ -z $1 ]
        then ls ./*.*
        else
                if [$1 = "-d" ]
                then ls ./*
                else ls $1/*.*
                fi
        fi
    else ls $2/*
    fi
    return 0
}
