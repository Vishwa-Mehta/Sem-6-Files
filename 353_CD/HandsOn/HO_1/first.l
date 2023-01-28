/* lex program to match identifier */

%{
	#include <stdio.h>
%}

%%
[_a-zA-Z]([a-zA-Z0-9])*	{printf("Identifier\n");}
.						{printf("%s\n", yytext);}
%%
/*subroutines*/
int main()
{
	//func that starts analysis
	yylex();
}
/*
int yywrap()
{
	return 1;
}
*/
