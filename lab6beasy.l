%{
#include<stdio.h>
#include<stdlib.h>
int count=0;
%}
op [\+\-\*\/\=]
nop [\,\;]
digit [0-9]
letter[A-Za-z]
id {letter}+|{letter}{digit}+
nid ({digit}{letter})+
%%
("if")|("for")|("int") {printf("Keyword %s\n",yytext);}
{id} {printf("Identifiers %s\n",yytext);count++;}
{op} {printf("Operator %s\n",yytext);}
{nop} {printf("Not an operator %s\n",yytext);}
{nid} {printf("Not an identifier %s\n",yytext);}
%%
void main()
{
	FILE *fp;
	char file[10];
	printf("ENter file name\n");
	scanf("%s",file);
	fp=fopen(file,"r");
	yyin = fp;
	yylex();
	printf("\nThe no of identifiers are %d",count);
	return 0;
}
int yywrap()
{
	return 1;
}
