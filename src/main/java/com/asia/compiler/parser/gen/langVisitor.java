package com.asia.compiler.parser.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link langParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return type.
 */
public interface langVisitor<T> extends ParseTreeVisitor<T> {

    /**
     * Visit a parse tree produced by {@link langParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProgram(langParser.ProgramContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStatement(langParser.StatementContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#def_var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDef_var(langParser.Def_varContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#assign_var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssign_var(langParser.Assign_varContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#for_loop_assign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_loop_assign(langParser.For_loop_assignContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#read}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRead(langParser.ReadContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#print}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrint(langParser.PrintContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#comment}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitComment(langParser.CommentContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#define}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDefine(langParser.DefineContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#operation}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitOperation(langParser.OperationContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#init_var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInit_var(langParser.Init_varContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#for_loop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFor_loop(langParser.For_loopContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#do_while_loop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDo_while_loop(langParser.Do_while_loopContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#while_loop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhile_loop(langParser.While_loopContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#if_begin}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf_begin(langParser.If_beginContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#if_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIf_statement(langParser.If_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#else_statement}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitElse_statement(langParser.Else_statementContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#numeric_value}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumeric_value(langParser.Numeric_valueContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#math_var}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMath_var(langParser.Math_varContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#bool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBool(langParser.BoolContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#value}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValue(langParser.ValueContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#math_module}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMath_module(langParser.Math_moduleContext ctx);

    /**
     * Visit a parse tree produced by {@link langParser#condition}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCondition(langParser.ConditionContext ctx);
}