grammar lang;

program : statement+ |;



statement
    :def_var
    |assign_var
    |read
    |print
    |comment
    |if_statement
    |while_statement;

def_var: define NAME SEMI_COLON;
assign_var: NAME ASSIGN operation SEMI_COLON;
read: READ NAME SEMI_COLON;
print: PRINT NAME SEMI_COLON;
comment: COMMENT;

if_statement: IF condition_block (ELSE IF condition_block)* (ELSE statement_block);

condition_block: expr statement_block;

statement_block: LBRACE block RBRACE | statement;

while_statement: WHILE expr statement_block;

block: statement*;

expr
    : NOT expr
    | expr op=(MULT | DIV | MOD) expr
    | expr op=(PLUS | MINUS) expr
    | expr op=(EQ|NEQ) expr
    | expr AND expr
    | expr OR expr
    | TRUE
    | FALSE;

define: (DEF_INT|DEF_FLOAT|DEF_STRING);
operation: init_var|math_module;
init_var: value;

// ==== MATH ====
numeric_value: (INT|FLOAT);
math_var: (numeric_value|NAME);
value: (STRING|NAME|numeric_value);

math_module
    :   math_var op=('*'|'/'|'%'|'+'|'-') math_var;
//math_module
//    :   math_module mult=('*'|'/'|'%') math_module
//    |   math_module add=('+'|'-') math_module
//    |   '(' math_module ')'
//    |   math_var
//    ;
// ==== END MATH ====

READ: 'READ';
PRINT: 'PRINT';

// ==== IF ELSE ====
IF: 'IF';
ELSE: 'ELSE';
LBRACE: '{';
RBRACE: '}';

// ==== LOOPS ====
WHILE: 'WHILE';

// ==== LOGIC ====
NOT: '!';
EQ: '==';
NEQ: '!=';
AND: '&&';
OR: '||';
TRUE:  'TRUE';
FALSE: 'FALSE';

// ==== SYMBOLS ====
ASSIGN: '=';
SEMI_COLON: ';';

// ==== TYPES ====
INT: [0-9]+;
FLOAT: ([0]|[1-9]{1}[0-9]*).[0-9]*[1-9]+;
STRING: '"' ( ~('\\'|'"') )* '"';

// ==== MATH ====
PLUS:  '+';
MINUS: '-';
DIV:   '/';
MULT:  '*';
MOD:   '%';

// ==== TYPES ====
DEF_INT:    'INT';
DEF_FLOAT:  'FLOAT';
DEF_STRING:  'STRING';
NAME: NAME_PREFIX [0-9]+;
NAME_PREFIX: 'V_';
BLANK: [ \t]+ -> channel(HIDDEN);
//COMMENT: '#'[a-z]* NEXT_LINE;
COMMENT : '#' ~[\r\n\f]* NEXT_LINE -> skip;
//COMMENT: '#'[^\n]* NEXT_LINE;

NEXT_LINE : [\n]+ -> skip;

UNKNOWN_CHAR : . ;