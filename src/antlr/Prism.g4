grammar Prism;

@header {
package antlr;
}

/* Lexical elements */

ID          :       [a-z][a-zA-Z0-9_]*;
INT         :       '0' | '-'?[1-9][0-9]*;
FUNCTION    :       'FUNCTION';
CLASS       :       'CLASS';
IF          :       'IF';
ELSE        :       'ELSE';
METHODS     :       'METHODS';
ATTRIBUTES  :       'ATTRIBUTES';
RETURN      :       'RETURN';
NEW         :       'NEW';
CONTINUE    :       'CONTINUE';
BREAK       :       'BREAK';
INSERT      :       'INSERT';
INSERTAT    :       'INSERTAT';
AT          :       'AT';
SIZE        :       'SIZE';
REMOVEAT    :       'REMOVEAT';
REMOVEALL   :       'REMOVEALL';
COMMENT     :       '//' ~[\r\n]* -> skip;
WS          :       [ \t\n]+ -> skip;
LCURLY      :       '{';
RCURLY      :       '}';
LPAREN      :       '(';
RPAREN      :       ')';
SEMICOLON   :       ';';
MUL         :       '*';
DIV         :       '/';
ADD         :       '+';
SUB         :       '-';
MAX		  :		'MAX';
MIN		  :		'MIN';
POW		  : 		'POW';
PRINT	  :       'PRINT';
PRINTLN     :		'PRINTLN';
EXIT        :       'EXIT';
STRING      :       '"' ~["]* '"'
            |       '\'' ~[']* '\''
            ;
			
/* Parser elements */

prog : (function_decl | variable_decl | class_decl)+ EOF                   #ProgramDecl
     ;

variable_decl : type ID '=' expr SEMICOLON                                 #VariableDecl
              ;

function_decl : FUNCTION type ID LPAREN param_list? RPAREN function_body   #FunctionDecl
              ;

function_body : stmt_block
              ;

class_decl : CLASS ID LCURLY class_body RCURLY                          #ClassDecl
           ;

class_body : ATTRIBUTES attributes_decl METHODS methods_decl            #ClassBodyDecl
           ;

attributes_decl : variable_decl+
                ;

methods_decl : function_decl+
             ;

type : 'INT' | 'BOOL' | 'VOID' | 'STRING' | ID | type '[]'
     ;

param_list : param (',' param)*                         #FunctionParamDecl               
           ;

param : type ID
      ;

stmt_block : LCURLY stmt* RCURLY                        #StmtBlockStmt
           ;             

stmt : stmt_block                                       #BlockStmt
     | while_loop                                       #WhileStmt
     | for_loop                                         #ForStmt
     | variable_decl                                    #VariableDeclStmt
     | IF LPAREN expr RPAREN stmt (ELSE stmt)?          #IfElseStmt
     | RETURN expr? SEMICOLON                           #ReturnStmt
     | variable_assignment                              #AssignmentStmt
     | continue_stmt                                    #ContinueStmt
     | break_stmt                                       #BreakStmt
     | expr SEMICOLON                                   #ExprStmt
     ;

continue_stmt : CONTINUE SEMICOLON
              ;

break_stmt : BREAK SEMICOLON
           ;

variable_assignment : expr '=' expr SEMICOLON           #VariableAssignmentStmt
                    ;

while_loop : 'WHILE' '(' expr ')' stmt_block            #WhileLoopStmt
           ;

for_loop : 'FOR' '(' loop_decl_block loop_condition_block loop_updation_block ')' stmt_block #ForLoopStmt
         ;

loop_decl_block : type ID '=' expr SEMICOLON                         #LoopInitBlockStmt
                   ;

loop_condition_block : expr SEMICOLON                                #LoopConditionStmt
                     ;

loop_updation_block : variable_assignment                            #LoopUpdationStmt
                    | expr SEMICOLON                                 #ExprUpdateStmt
                    ;

expr : expr '++'                   #PostfixAdditionExpr
     | expr '--'                   #PostfixSubtractionExpr
     | ID LPAREN expr_list? RPAREN #FunctionCallExpr // function invocation, fn(3, 2), fn(), fn(var1)
	| builtin_function_call_expr  #BuiltinFunctionCallExpr
     | '-' expr                    #UnaryMinusExpr
     | '!' expr                    #NotExpr
     | expr op=('*' | '/') expr    #MulDivExpr
     | expr op=('+' | '-') expr    #AddSubExpr
     | expr '==' expr              #EqExpr
     | expr '!=' expr              #NotEqExpr
     | expr '||' expr              #OrExpr
     | expr '&&' expr              #AndExpr
     | expr '>' expr               #GreaterthanExpr
     | expr '<' expr               #LessthanExpr
     | expr '>=' expr              #GreaterthanEqExpr
     | expr '<=' expr              #LessthanEqExpr
     | array_operation_expr        #ArrayOperationExpr
     | array_creation_expr         #ArrayCreationExpr
     | object_creation_expr        #ObjectCreationExpr
     | object_invocation_expr      #ObjectInvocationExpr
     | bool                        #BoolAtomExpr
     | ID                          #VariableAtomExpr
     | INT                         #IntAtomExpr
     | STRING                      #StringAtomExpr
     | LPAREN expr RPAREN          #BracketExpr
     ;
     
array_operation_expr : ID '.' array_operations LPAREN expr_list? RPAREN #ArrayOperationExpression
                     ;

array_creation_expr : NEW type
                    ;
     
array_operations : INSERT | INSERTAT | AT | SIZE | REMOVEAT | REMOVEALL
                 ;
     
builtin_function_call_expr : MAX LPAREN expr ',' expr RPAREN #MaxFunctionCallExpression
					  | MIN LPAREN expr ',' expr RPAREN #MinFunctionCallExpression
					  | POW LPAREN expr ',' expr RPAREN #PowFunctionCallExpression
					  | PRINT LPAREN expr RPAREN        #PrintFunctionCallExpression
					  | PRINTLN LPAREN expr RPAREN      #PrintlnFunctionCallExpression
                           | EXIT LPAREN expr RPAREN         #ExitFunctionCallExpression
				       ;

object_creation_expr : NEW ID LPAREN expr_list? RPAREN              #ObjectCreationExpression
                     ;

object_invocation_expr : ID '.' ID (LPAREN expr_list? RPAREN)?      #ObjectInvocationExpression
                       ;

bool : 'true' | 'false'
     ;

expr_list : expr (',' expr)*       #FunctionParamExpr // function argument list
          ;