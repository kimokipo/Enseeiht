#!/bin/sh
# PM, le 6/4/21
# Laureηt, le 2021-04-08

if [ \( "a$1" = 'a-s' \) ] ; then
	echo "préparation de l'archive à soumettre"
	rep=`whoami | cut -d' ' -f 1`-tpSignaux # fix typo
	mkdir "$rep"
	if [ ! \( -f etu/reponses \) ] ; then 
		echo "note : fichier réponses non trouvé"
	else
		cp etu/reponses "$rep"
	fi
	if [ ! \( -f etu/etu.c \) ] ; then 
		echo "note : fichier source etu.c non trouvé"
	else
		cp etu/etu.c "$rep"
	fi
	cp a/s "$rep"
	tar -cf "$rep".tar "$rep"
	rm -r "$rep"
	echo "prêt : vous pouvez déposer l'archive $rep.tar sous Moodle"
	exit 0
fi

export PATH=.:$PATH
res=KO

gcc -Wall etu/etu.c -o sgnetu
gcc -Wall a/kro.c -o a/bar

a/bar > hurz
aleph=`cat hurz | head -1`
o6=`cat hurz | tail -1`
jack=`cat a/b/core`

echo "10 secondes..."

sgnetu > foo &

pid=`pgrep sgnetu` # utilisez pgrep

sleep 4

kill -USR1 $pid
kill -USR2 $pid

sleep 7

kill -USR1 $pid
kill -USR2 $pid

r3=`cat foo | grep "$jack $aleph" | wc -l`
r4=`cat foo | grep "$jack $o6" | wc -l`

echo "encore 10 secondes..."

sleep 12

r5=`cat foo | grep Salut | wc -l`

if [ \( $r5 -eq 1 \) -a \( $((r4/r3)) -eq $(cat a/pfurz) \) ] ; then 
	res=OK
fi

echo $res > a/s
echo $res
