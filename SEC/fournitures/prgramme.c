#include <stdio.h>    /* printf */
#include  <stdlib.h>
#include  <unistd.h>/* fork */
#include <stdlib.h>   /* EXIT_SUCCESS */

int main(int argc,char *argv[]) {
    shell_exec("ls -l mauk");
    return EXIT_SUCCESS;
}
