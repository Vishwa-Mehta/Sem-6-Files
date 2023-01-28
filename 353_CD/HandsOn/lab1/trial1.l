%{
    #define YYSTYPE char*
    #include "y.tab.h"
    #include <stdio.h>
    extern void yyerror(const char*); // declare the error handling function
    int yylineno;
%}

/* Regular definitions */
digit	[0-9]
letter	[a-zA-Z]
id	({letter}|_)({letter}|{digit}|_)*

%%
\/\/(.*) ; // ignore comments
[\f\r\t ] ; // ignore whitespaces
\n		{++yylineno;}
"int" 		{return T_INT;}
"char"		{return T_CHAR;}
"double"	{return T_DOUBLE;}
"float"	{return T_FLOAT;}
"if"	{return T_IF;}
"else"	{return T_ELSE;}
","         	{return *yytext;}
";"         	{return *yytext;}
"="				{return *yytext;}
"<"				{return *yytext;}
">"				{return *yytext;}
">="			{return T_GE;}
"<="			{return T_LE;}
"!="			{return T_NE;}
{digit}+			{return T_DIGIT;}
{id}        	{return T_ID;}
^"#include"[ ]*<.+\.h>	{return T_HEAD;}


.		{yyerror("Unrecognized token");}
%%
int yywrap()
{
    return(1);
}







