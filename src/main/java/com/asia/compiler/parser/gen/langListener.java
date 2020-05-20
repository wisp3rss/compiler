package com.asia.compiler.parser.gen;// Generated from /Users/annakonieczna/IdeaProjects/compiler/src/main/antlr4/lang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link langParser}.
 */
public interface langListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(langParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(langParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(langParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(langParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#def_var}.
	 * @param ctx the parse tree
	 */
	void enterDef_var(langParser.Def_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#def_var}.
	 * @param ctx the parse tree
	 */
	void exitDef_var(langParser.Def_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#assign_var}.
	 * @param ctx the parse tree
	 */
	void enterAssign_var(langParser.Assign_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#assign_var}.
	 * @param ctx the parse tree
	 */
	void exitAssign_var(langParser.Assign_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(langParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(langParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(langParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(langParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(langParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(langParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(langParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(langParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void enterCondition_block(langParser.Condition_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#condition_block}.
	 * @param ctx the parse tree
	 */
	void exitCondition_block(langParser.Condition_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block(langParser.Statement_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block(langParser.Statement_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(langParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(langParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(langParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(langParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(langParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(langParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(langParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(langParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(langParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(langParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#init_var}.
	 * @param ctx the parse tree
	 */
	void enterInit_var(langParser.Init_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#init_var}.
	 * @param ctx the parse tree
	 */
	void exitInit_var(langParser.Init_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#numeric_value}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_value(langParser.Numeric_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#numeric_value}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_value(langParser.Numeric_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#math_var}.
	 * @param ctx the parse tree
	 */
	void enterMath_var(langParser.Math_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#math_var}.
	 * @param ctx the parse tree
	 */
	void exitMath_var(langParser.Math_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(langParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(langParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link langParser#math_module}.
	 * @param ctx the parse tree
	 */
	void enterMath_module(langParser.Math_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link langParser#math_module}.
	 * @param ctx the parse tree
	 */
	void exitMath_module(langParser.Math_moduleContext ctx);
}