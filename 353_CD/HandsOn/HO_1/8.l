letter	[A-Za-z]
%{
    #include <stdio.h>
%}

%%
IF/\(.*\)	printf("FORTRAN IF detected");
%%
int main() {
	yylex();
}
