all: test_uno  jouer_uno
# Ceci est un commentaire pour introdure la variable CC qui comporte le nom du compilateur utilisé :
CC=c99
# Les variables CFLAGS et LDFLAGS comportent les options de compilation et d'édition des liens :
CFLAGS=-Wextra -pedantic -c
LDFLAGS=

depend:
	makedepend *.c -Y

test_uno: carte.o main.o jeu.o uno.o test_uno.o
	$(CC) $(LDFLAGS) $^ -o $@

jouer_uno: carte.o main.o jeu.o uno.o
	$(CC) $(LDFLAGS) $^ -o $@ 

clean:
	rm *.o ephemeride

.PHONY: clean
