# Définition des Variables (à compléter)
CC =c99
CFLAGS =-Wextra -pedantic -c 
LDFLAGS = 
EXE = 

# Règles (à compléter avec des variables automatiques)
all: test_file exemple_file

test_file: file.o test_file.o
	$(CC) $(LDFLAGS) $^ -o $@
exemple_file: file.o exemple_file.o
	$(CC) $(LDFLAGS) $^ -o $@
makedepend:
	makedepend *.c -Y
clean:
	rm *.o test_file exemple_file

.PHONY: clean all makedepend

