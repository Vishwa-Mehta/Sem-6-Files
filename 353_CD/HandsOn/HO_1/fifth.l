/* lex program to find output for the string pattern
abb printf("1")
aba printf("2")
a	printf("3")
*/

%{
    #include <stdio.h>
%}

%%
abb	printf("1");
aba	printf("2");
a	printf("3");
%%
int main() {
	yylex();
	return 1;
}
