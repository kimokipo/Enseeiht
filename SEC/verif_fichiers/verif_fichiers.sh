#!/bin/sh
# PM, le 13/4/21

if [ \( "a$1" = 'a-s' \) ] ; then
	echo "préparation de l'archive à soumettre"
	rep=`whoami|cut -d' ' -f 1`-tpFichiers
	mkdir "$rep"
	if [ ! \( -f etu/copier.c \) ] ; then 
		echo "note : fichier source copier.c (q10,11,12) non trouvé"
	else
		cp etu/copier.c "$rep"
	fi
	if [ ! \( -f etu/scruter.c \) ] ; then 
		echo "note : fichier source scruter.c non trouvé"
	else
		cp etu/scruter.c "$rep"
	fi
	cp a/s "$rep"
	tar -cf "$rep".tar "$rep"
	rm -r "$rep"
	echo "prêt : vous pouvez déposer l'archive $rep.tar sous Moodle"
	exit 0
fi

export PATH=.:$PATH
res=KO
nbOK=0

gcc -Wall etu/scruter.c -o scruter
gcc -Wall etu/copier.c -o copier
gcc -Wall a/kro.c -o cpt

#copier
copier a/pfurz ww
if [ $? -eq 0 ] ; then 
	nbOK=$((nbOK+1))
fi

diff a/pfurz ww
if [ $? -eq 0 ] ; then 
	nbOK=$((nbOK+1))
fi

copier a/pfurz a/b/core
if [ $? -ne 0 ] ; then 
	nbOK=$((nbOK+1))
fi

copier plop a/pfurz
if [ $? -ne 0 ] ; then 
	nbOK=$((nbOK+1))
fi

if [ $(cat etu/copier.c | grep close | wc -l) -gt 0 ] ; then 
	nbOK=$((nbOK+1))
fi

if [ $(cat etu/copier.c | grep perror | wc -l) -gt 0 ] ; then 
	nbOK=$((nbOK+1))
fi

if [ $nbOK -eq 6 ] ; then
	res=OK
fi

echo "copier : $res ($nbOK/6)"

# scruter
scruter > /dev/null
if [ -f "temp" ] ; then
	cpt > foo
	diff foo a/bar
	if [ $? -eq 0 ] ; then 
		res2=OK
	else
		res2=KO
	fi
else
	res2="??"
fi
rm cpt
rm ww
echo "scruter : $res2"
echo $res$res2 > a/s
