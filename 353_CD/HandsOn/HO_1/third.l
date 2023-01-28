digit	[0-9]
letter	[_A-Za-z]
%{
    #include <stdio.h>
%}

%%
{letter}({letter}|{digit})*	printf("Valid identifier:\n");
%%
int main()
{
    //func that starts analysis
    yylex();
        return 0;
}
