// Generated from java-escape by ANTLR 4.11.1

package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PrismParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PrismVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgramDecl}
	 * labeled alternative in {@link PrismParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramDecl(PrismParser.ProgramDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDecl}
	 * labeled alternative in {@link PrismParser#variable_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(PrismParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link PrismParser#function_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(PrismParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(PrismParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassDecl}
	 * labeled alternative in {@link PrismParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(PrismParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassBodyDecl}
	 * labeled alternative in {@link PrismParser#class_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBodyDecl(PrismParser.ClassBodyDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#attributes_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes_decl(PrismParser.Attributes_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#methods_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethods_decl(PrismParser.Methods_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PrismParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParamDecl}
	 * labeled alternative in {@link PrismParser#param_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParamDecl(PrismParser.FunctionParamDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(PrismParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StmtBlockStmt}
	 * labeled alternative in {@link PrismParser#stmt_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBlockStmt(PrismParser.StmtBlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(PrismParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(PrismParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(PrismParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclStmt(PrismParser.VariableDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElseStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(PrismParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(PrismParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(PrismParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStmt(PrismParser.ContinueStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(PrismParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link PrismParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(PrismParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#continue_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue_stmt(PrismParser.Continue_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#break_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak_stmt(PrismParser.Break_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableAssignmentStmt}
	 * labeled alternative in {@link PrismParser#variable_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAssignmentStmt(PrismParser.VariableAssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoopStmt}
	 * labeled alternative in {@link PrismParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoopStmt(PrismParser.WhileLoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLoopStmt}
	 * labeled alternative in {@link PrismParser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopStmt(PrismParser.ForLoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopInitBlockStmt}
	 * labeled alternative in {@link PrismParser#loop_decl_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopInitBlockStmt(PrismParser.LoopInitBlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopConditionStmt}
	 * labeled alternative in {@link PrismParser#loop_condition_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopConditionStmt(PrismParser.LoopConditionStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopUpdationStmt}
	 * labeled alternative in {@link PrismParser#loop_updation_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopUpdationStmt(PrismParser.LoopUpdationStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUpdateStmt}
	 * labeled alternative in {@link PrismParser#loop_updation_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUpdateStmt(PrismParser.ExprUpdateStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectCreationExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreationExpr(PrismParser.ObjectCreationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AndExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(PrismParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectInvocationExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInvocationExpr(PrismParser.ObjectInvocationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessthanEqExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthanEqExpr(PrismParser.LessthanEqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntAtomExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAtomExpr(PrismParser.IntAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessthanExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessthanExpr(PrismParser.LessthanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracketExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketExpr(PrismParser.BracketExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(PrismParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayCreationExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreationExpr(PrismParser.ArrayCreationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinFunctionCallExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinFunctionCallExpr(PrismParser.BuiltinFunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableAtomExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableAtomExpr(PrismParser.VariableAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtomExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtomExpr(PrismParser.StringAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolAtomExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAtomExpr(PrismParser.BoolAtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterthanExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthanExpr(PrismParser.GreaterthanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayOperationExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOperationExpr(PrismParser.ArrayOperationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(PrismParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(PrismParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(PrismParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqExpr(PrismParser.NotEqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(PrismParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterthanEqExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterthanEqExpr(PrismParser.GreaterthanEqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(PrismParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixAdditionExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixAdditionExpr(PrismParser.PostfixAdditionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostfixSubtractionExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixSubtractionExpr(PrismParser.PostfixSubtractionExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinusExpr}
	 * labeled alternative in {@link PrismParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpr(PrismParser.UnaryMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayOperationExpression}
	 * labeled alternative in {@link PrismParser#array_operation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayOperationExpression(PrismParser.ArrayOperationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#array_creation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_creation_expr(PrismParser.Array_creation_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#array_operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_operations(PrismParser.Array_operationsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaxFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxFunctionCallExpression(PrismParser.MaxFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinFunctionCallExpression(PrismParser.MinFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PowFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowFunctionCallExpression(PrismParser.PowFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFunctionCallExpression(PrismParser.PrintFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintlnFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlnFunctionCallExpression(PrismParser.PrintlnFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExitFunctionCallExpression}
	 * labeled alternative in {@link PrismParser#builtin_function_call_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitFunctionCallExpression(PrismParser.ExitFunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectCreationExpression}
	 * labeled alternative in {@link PrismParser#object_creation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreationExpression(PrismParser.ObjectCreationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectInvocationExpression}
	 * labeled alternative in {@link PrismParser#object_invocation_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInvocationExpression(PrismParser.ObjectInvocationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PrismParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(PrismParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionParamExpr}
	 * labeled alternative in {@link PrismParser#expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParamExpr(PrismParser.FunctionParamExprContext ctx);
}