package com.asia.compiler.parser.gen;// Generated from /Users/annakonieczna/IdeaProjects/compiler/src/main/antlr4/lang.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link langParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface langVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link langParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(langParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(langParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#def_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_var(langParser.Def_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#assign_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_var(langParser.Assign_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(langParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(langParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(langParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(langParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#fparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFparam(langParser.FparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#fblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFblock(langParser.FblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(langParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#blockif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockif(langParser.BlockifContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(langParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#repeat_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeat_statement(langParser.Repeat_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(langParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(langParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(langParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#init_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_var(langParser.Init_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#numeric_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_value(langParser.Numeric_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#math_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_var(langParser.Math_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(langParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#math_module}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath_module(langParser.Math_moduleContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#equal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(langParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link langParser#repeatitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatitions(langParser.RepeatitionsContext ctx);
}