%{
#include<stdio.h>
%}
%x CMNT
%%
"/*" {BEGIN CMNT;}
<CMNT>. ;
<CMNT>\n ;
<CMNT>"*/" {BEGIN 0; }
"//" {BEGIN CMNT;}
%%
int yywrap()
{
return 1;
}
int main(int argc, char *argv[])
{ 
if(argc !=3)
{ 
printf(" Invalid Argumennts\n",argv[0]);
return;
} 
yyin=fopen(argv[1],"r");
yyout=fopen(argv[2],"w");
yylex();
}

