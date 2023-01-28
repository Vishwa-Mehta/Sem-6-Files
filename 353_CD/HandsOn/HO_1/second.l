/* to match keywords */
%{
	#include <stdio.h>
%}

%%
auto|double|if|for|do|else|main|static|while|signed|unsigned	printf("Keyword: \t%s\n", yytext);
%%
/*subroutines*/
int main()
{
    //func that starts analysis
    yylex();
	return 0;
}
