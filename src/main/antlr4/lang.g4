grammar lang;

program
    :(  statement
        |def_func
        |class_
        |struct
    )*;

statement
    :def_var
    |assign_var
    |if_statement
    |while_loop
    |do_while_loop
    |for_loop
    |read
    |print
    |comment
    |(call_func SEMI_COLON)
    |(call_struct SEMI_COLON)
    |(call_class_field SEMI_COLON)
    |(call_class_func SEMI_COLON)
    |create_class
    |create_struct;

def_var: define NAME SEMI_COLON;
assign_var: for_loop_assign;
for_loop_assign: NAME ASSIGN operation;
read: READ NAME SEMI_COLON;
print: PRINT NAME SEMI_COLON;
comment: COMMENT;

define: (DEF_INT|DEF_FLOAT|DEF_STRING|DEF_BOOL);
operation: ((init_var|math_module|call_func) SEMI_COLON)|call_struct|call_class_func|call_class_field;
init_var: value;

// ==== CLASS ===
def_class: CLASS CLASS_NAME;
class_: def_class OPEN_BRACE (def_var|def_func|create_struct|create_class)* CLOSE_BRACE;
create_class: CLASS_NAME NAME ASSIGN NEW CLASS CLASS_NAME OPEN_PAREN CLOSE_PAREN SEMI_COLON;
call_class_field: NAME '.' NAME;
call_class_func: NAME '.' call_func;
// ==== END CLASS ===

// ==== STRUCT ===
struct: STRUCT CLASS_NAME OPEN_BRACE def_var* CLOSE_BRACE;
create_struct: CLASS_NAME NAME ASSIGN NEW STRUCT CLASS_NAME OPEN_PAREN CLOSE_PAREN SEMI_COLON;
call_struct: NAME '.' NAME;
// ==== END STRUCT ===

// ==== FUNCTION ===
def_func: FUNCTION define NAME '(' def_args ')' OPEN_BRACE statement* ret CLOSE_BRACE;
def_args: (def_arg?|((def_arg ',')+ def_arg));
def_arg: define NAME;
//def_args: define NAME (|(',' def_args));
args: (value?|((value ',')+ value));
call_func: NAME '(' args ')';
ret: RETURN value SEMI_COLON;
// ==== END FUNCTION =====

// ==== FOR LOOP ====
for_loop: FOR OPEN_PAREN for_loop_assign SEMI_COLON condition SEMI_COLON for_loop_assign CLOSE_PAREN OPEN_BRACE statement* CLOSE_BRACE;
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
math_var: (call_external|numeric_value|NAME);
bool: (TRUE|FALSE);
value: (STRING|NAME|TRUE|FALSE|numeric_value|call_struct|call_class_field);
call_external: call_func|call_struct|call_class_func|call_class_field;

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
    : (value|math_module|call_external) comp=(GT|LT|GT_EQ|LT_EQ|EQUAL|NEQ) (value|math_module|call_external)
    | NOT? (bool|call_external){1}
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

FUNCTION: 'func';
RETURN: 'return';

CLASS: 'class';
STRUCT: 'struct';
NEW: 'new';

// ==== TYPES ====
DEF_INT:    'INT';
DEF_FLOAT:  'FLOAT';
DEF_STRING:  'STRING';
DEF_BOOL:   'BOOL';
//NAME: NAME_PREFIX [0-9]+;
//NAME_PREFIX: 'V_';
CLASS_NAME: [A-Z]+[_a-zA-Z0-9]*;
NAME: [a-zA-Z]+[_a-zA-Z0-9]*;
BLANK: [ \t]+ -> channel(HIDDEN);
COMMENT : '#' ~[\r\n\f]* NEXT_LINE -> skip;

NEXT_LINE : [\n]+ -> skip;

UNKNOWN_CHAR : . ;