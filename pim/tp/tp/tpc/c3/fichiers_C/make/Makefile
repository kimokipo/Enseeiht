all: ephemeride EDT
CC=c99
# Les variables CFLAGS et LDFLAGS comportent les options de compilation et d'édition des liens :
CFLAGS=-Wextra -pedantic -c
LDFLAGS=

depend:
	makedepend *.c -Y

ephemeride: date.o ephemeride.o
    $(CC) $(LDFLAGS) $^ -o $@

clean:
	rm *.o ephemeride

# DO NOT DELETE

EDT: date.o salle.o enseignant.o cours.o EDT.o
	  $(CC) $(LDFLAGS) $^ -o $@
.PHONY: clean all
