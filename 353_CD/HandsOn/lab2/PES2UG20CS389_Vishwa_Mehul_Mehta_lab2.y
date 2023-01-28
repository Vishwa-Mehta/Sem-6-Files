%{
    #include<stdio.h>
	#include<stdlib.h>
    #include "y.tab.h"
    int yylex();
    void yyerror();
    extern int yylinen;
    int yyerrok();
    extern char *yytext;
    int flag=0;
   
%}
%token NUMBER

%left '+' '-'
%left '*' '/' '%'
%left '(' ')'
%%
ArithmeticExpression : E{
         printf("\nResult=%d\n", $$);
         return 0;
        }
E : E'+'E {$$=$1+$3;}
	|E'-'E {$$=$1-$3;}
	|E'*'E {$$=$1*$3;}
	|E'/'E {$$=$1/$3;}
	|E'%'E {$$=$1%$3;}
	|'('E')' {$$=$2;}
	| NUMBER {$$=$1;}
;
%%

void main()
{
	printf("\nEnter the Expression:\n");
	yyparse();
	if(flag==0)
		printf("\nEntered arithmetic expression is Valid\n\n");
 
}
void yyerror()
{
	printf("\nEntered arithmetic expression is Invalid\n\n");
	flag=1;
}
