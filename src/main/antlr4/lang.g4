grammar lang;

program : statement+ |;

statement
    :def_var
    |assign_var
    |read
    |print;

def_var: define NAME SEMI_COLON;
assign_var: NAME ASSIGN operation SEMI_COLON;
read: READ NAME numeric_value SEMI_COLON;
print: PRINT NAME SEMI_COLON;

define: (DEF_INT|DEF_FLOAT);
operation: init_var|math_module;
init_var: value;

// ==== MATH ====
numeric_value: (INT|FLOAT);
math_var: (numeric_value|NAME);
value: (NAME|numeric_value);

math_module
    :   math_module mult=('*'|'/'|'%') math_module
    |   math_module add=('+'|'-') math_module
    |   '(' math_module ')'
    |   math_var
    ;
// ==== END MATH ====

READ: 'READ';
PRINT: 'PRINT';

// ==== SYMBOLS ====
ASSIGN: '=';
SEMI_COLON: ';';

// ==== TYPES ====
INT: [0-9]+;
FLOAT: ([0]|[1-9]{1}[0-9]*).[0-9]*[1-9]+;
//STRING: '"' ( ~('\\'|'"') )* '"';

// ==== MATH ====
PLUS:  '+';
MINUS: '-';
DIV:   '/';
MULT:  '*';
MOD:   '%';

// ==== TYPES ====
DEF_INT:    'INT';
DEF_FLOAT:  'FLOAT';
NAME: NAME_PREFIX [0-9]+;
NAME_PREFIX: 'V_';
BLANK: [ \t]+ -> channel(HIDDEN);

NEXT_LINE : [\n]+; // -> skip;

UNKNOWN_CHAR : . ;