%{
	#include <stdio.h>
	#include <stdlib.h>
	#include <string.h>

	void yyerror(const char*); // error handling function
	int yylex(); // declare the function performing lexical analysis
	extern int yylineno; // track the line number
	extern char* yytext;
	int err = 0;
%}

%token T_INT T_CHAR T_DOUBLE T_ID T_FLOAT T_DIGIT T_IF T_ELSE T_HEAD T_GE T_LE T_NE


%start START

%%
START : PROG { if(err==0) {printf("Valid syntax\n"); YYACCEPT;} }	/* If program fits the grammar, syntax is valid */
        ;						/* Anything within {} is C code, it is the action corresponding to the 							production rule */


	  
PROG : DECLR ';' PROG	/* declarations   */

	| ASSIGN ';' PROG
	
	| T_IF '(' COND ')' '{' PROG '}' T_ELSE '{' PROG '}' PROG
				
	| error ';' PROG 			/* snychronizing token */
	| 					/* end of program */
	;

DECLR : TYPE LISTVAR
	;	

ASSIGN : TYPE LISTVAR '=' T_DIGIT
	;

COND : 

LISTVAR : LISTVAR ',' T_ID 
	  | T_ID
	  ;
	
TYPE : T_INT
       | T_FLOAT
       | T_DOUBLE
       | T_CHAR
       ;


%%


/* error handling function */
void yyerror(const char* s)
{
	printf("Error: %s,line number: %d,token: %s\n",s,yylineno,yytext);
	err = 1; // An error has occurred
}


int main(int argc, char* argv[])
{
	yyparse();
	return 0;

}
