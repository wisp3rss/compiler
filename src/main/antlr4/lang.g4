grammar lang;

program : statement+ |;

statement
    :def_var
    |assign_var
    |if_statement
    |while_loop
    |do_while_loop
    |for_loop
    |read
    |print
    |comment;

def_var: define NAME SEMI_COLON;
assign_var: NAME ASSIGN operation SEMI_COLON;
for_loop_assign: NAME ASSIGN operation;
read: READ NAME SEMI_COLON;
print: PRINT NAME SEMI_COLON;
comment: COMMENT;

define: (DEF_INT|DEF_FLOAT|DEF_STRING|DEF_BOOL);
operation: init_var|math_module;
init_var: value;

// ==== FOR LOOP ====
for_loop: FOR OPEN_PAREN (|for_loop_assign) SEMI_COLON condition SEMI_COLON (|for_loop_assign) CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE;
// ==== END FOR LOOP ====

// ==== DO WHILE LOOP ====
do_while_loop: DO OPEN_BRACE statement* CLOSE_BRACE WHILE '(' condition ')' SEMI_COLON;
// ==== END DO WHILE LOOP ====

// ==== WHILE LOOP ====
while_loop: WHILE '(' condition ')' OPEN_BRACE statement* CLOSE_BRACE;
// ==== END WHILE LOOP ====


// ==== IF STATEMENT ====
if_begin: IF '(' condition ')' OPEN_BRACE statement*;
if_statement: if_begin CLOSE_BRACE (|else_statement);
else_statement: ELSE ( OPEN_BRACE statement* CLOSE_BRACE
    | if_statement);
// ==== END IF STATEMENT ====

// ==== MATH ====
numeric_value: (INT|FLOAT);
math_var: (numeric_value|NAME);
bool: (TRUE|FALSE);
value: (STRING|NAME|TRUE|FALSE|numeric_value);

math_module
    :   math_var op=('*'|'/'|'%'|'+'|'-') math_var;
//math_module
//    :   math_module mult=('*'|'/'|'%') math_module
//    |   math_module add=('+'|'-') math_module
//    |   '(' math_module ')'
//    |   math_var
//    ;
// ==== END MATH ====

// ==== CONDITION ====
condition
    : (value|math_module) comp=(GT|LT|GT_EQ|LT_EQ|EQUAL|NEQ) (value|math_module)
    | NOT? bool
//    | condition log=(AND|OR) condition
//    | '(' condition ')'
//    | (bool|value|math_module)
    ;
// ==== END CONDITION ====

READ: 'READ';
PRINT: 'PRINT';

// ==== SYMBOLS ====
ASSIGN: '=';
SEMI_COLON: ';';
COLON: ':';
OPEN_PAREN: '(';
CLOSE_PAREN: ')';
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
OPEN_BRACKET: '[';
CLOSE_BRACKET: ']';

// ==== TYPES ====
INT: [0-9]+;
FLOAT: ([0]|[1-9]{1}[0-9]*).[0-9]*[1-9]+;
STRING: '"' ( ~('\\'|'"') )* '"';

// ==== COMPARE ====
GT:    '>';
LT:    '<';
GT_EQ: '>=';
LT_EQ: '<=';
EQUAL: '==';
NEQ:   '!=';
NOT:   '!';

// ==== MATH ====
PLUS:  '+';
MINUS: '-';
DIV:   '/';
MULT:  '*';
MOD:   '%';

// ==== BOOL ====
TRUE:  'true';
FALSE: 'false';
AND:   'AND';
OR:    'OR';

// ==== CODE ====
IF: 'IF';
END_IF: 'END IF';
ELSE: 'ELSE';

WHILE: 'WHILE';
DO:    'DO';
FOR:   'FOR';

// ==== TYPES ====
DEF_INT:    'INT';
DEF_FLOAT:  'FLOAT';
DEF_STRING:  'STRING';
DEF_BOOL:   'BOOL';
NAME: NAME_PREFIX [0-9]+;
NAME_PREFIX: 'V_';
BLANK: [ \t]+ -> channel(HIDDEN);
COMMENT : '#' ~[\r\n\f]* NEXT_LINE -> skip;

NEXT_LINE : [\n]+ -> skip;

UNKNOWN_CHAR : . ;