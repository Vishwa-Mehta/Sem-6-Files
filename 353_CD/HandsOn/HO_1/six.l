/* ignore whitespaces */

%{
    #include <stdio.h>
%}

%%
[\n|\t|' '] ;
%%
int main(int argc, char *argv[]) {
	yyin = fopen(argv[1], "r");
	yylex();
	return 0;
}
