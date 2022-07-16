%{
#include<stdio.h>
#include<stdlib.h>
int yyerror();
%}
%token A B
%%
str: s'\n' {printf("Valid String\n");}
;s
: x B
;x
: x A | A
; %%
int main()
{ 
printf(" Type the String ?\n");
if(!yyparse())
printf(" Valid String\n ");
}
int yyerror()
{ 
printf(" Invalid String.\n");
exit(0);
}
