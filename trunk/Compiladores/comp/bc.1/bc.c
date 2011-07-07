#include <stdio.h>
#include "bc.h"

main()
{
    lookahead = gettoken();
    E();
    printf("\n");
    return 0;
}
