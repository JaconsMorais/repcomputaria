#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#include <lexer.h>
#include <parser.h>

main(int argc, char const *argv[])
{
    if(argc>1){
	    int fd = open(argv[1], O_RDONLY);
	    if (fd == -1) {
		    fprintf(stderr, "cannot open %s\n", argv[1]);
		    exit (-2);
	    }
	    dup2(fd, 0);
    }
    /*
     * boot the lexer 
     */
    lookahead = gettoken(stdin);

    /*
     * boot the parser by calling the initial grammar symbol 
     */
    program();

    /*
     * success! 
     */
    printf("\n");
    exit(0);
}
