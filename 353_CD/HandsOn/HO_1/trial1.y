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

%token T_INT T_CHAR T_DOUBLE T_ID T_FLOAT 


%start START

%%
START : PROG { if(err==0) {printf("Valid syntax\n"); YYACCEPT;} }	/* If program fits the grammar, syntax is valid */
        ;						/* Anything within {} is C code, it is the action corresponding to the 							production rule */


	  
PROG : DECLR ';' PROG	/* declarations   */
				
	| error ';' PROG 			/* snychronizing token */
	| 					/* end of program */
	;
	 
DECLR : TYPE LISTVAR
	;	


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
