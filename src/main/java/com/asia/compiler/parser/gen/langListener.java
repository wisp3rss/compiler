package com.asia.compiler.parser.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by {@link langParser}.
 */
public interface langListener extends ParseTreeListener {

    /**
     * Enter a parse tree produced by {@link langParser#program}.
     *
     * @param ctx the parse tree
     */
    void enterProgram(langParser.ProgramContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#program}.
     *
     * @param ctx the parse tree
     */
    void exitProgram(langParser.ProgramContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(langParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(langParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#def_var}.
     *
     * @param ctx the parse tree
     */
    void enterDef_var(langParser.Def_varContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#def_var}.
     *
     * @param ctx the parse tree
     */
    void exitDef_var(langParser.Def_varContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#assign_var}.
     *
     * @param ctx the parse tree
     */
    void enterAssign_var(langParser.Assign_varContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#assign_var}.
     *
     * @param ctx the parse tree
     */
    void exitAssign_var(langParser.Assign_varContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#for_loop_assign}.
     *
     * @param ctx the parse tree
     */
    void enterFor_loop_assign(langParser.For_loop_assignContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#for_loop_assign}.
     *
     * @param ctx the parse tree
     */
    void exitFor_loop_assign(langParser.For_loop_assignContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#read}.
     *
     * @param ctx the parse tree
     */
    void enterRead(langParser.ReadContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#read}.
     *
     * @param ctx the parse tree
     */
    void exitRead(langParser.ReadContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#print}.
     *
     * @param ctx the parse tree
     */
    void enterPrint(langParser.PrintContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#print}.
     *
     * @param ctx the parse tree
     */
    void exitPrint(langParser.PrintContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#comment}.
     *
     * @param ctx the parse tree
     */
    void enterComment(langParser.CommentContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#comment}.
     *
     * @param ctx the parse tree
     */
    void exitComment(langParser.CommentContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#define}.
     *
     * @param ctx the parse tree
     */
    void enterDefine(langParser.DefineContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#define}.
     *
     * @param ctx the parse tree
     */
    void exitDefine(langParser.DefineContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#operation}.
     *
     * @param ctx the parse tree
     */
    void enterOperation(langParser.OperationContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#operation}.
     *
     * @param ctx the parse tree
     */
    void exitOperation(langParser.OperationContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#init_var}.
     *
     * @param ctx the parse tree
     */
    void enterInit_var(langParser.Init_varContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#init_var}.
     *
     * @param ctx the parse tree
     */
    void exitInit_var(langParser.Init_varContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#def_class}.
     *
     * @param ctx the parse tree
     */
    void enterDef_class(langParser.Def_classContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#def_class}.
     *
     * @param ctx the parse tree
     */
    void exitDef_class(langParser.Def_classContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#class_}.
     *
     * @param ctx the parse tree
     */
    void enterClass_(langParser.Class_Context ctx);

    /**
     * Exit a parse tree produced by {@link langParser#class_}.
     *
     * @param ctx the parse tree
     */
    void exitClass_(langParser.Class_Context ctx);

    /**
     * Enter a parse tree produced by {@link langParser#create_class}.
     *
     * @param ctx the parse tree
     */
    void enterCreate_class(langParser.Create_classContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#create_class}.
     *
     * @param ctx the parse tree
     */
    void exitCreate_class(langParser.Create_classContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#call_class_field}.
     *
     * @param ctx the parse tree
     */
    void enterCall_class_field(langParser.Call_class_fieldContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#call_class_field}.
     *
     * @param ctx the parse tree
     */
    void exitCall_class_field(langParser.Call_class_fieldContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#call_class_func}.
     *
     * @param ctx the parse tree
     */
    void enterCall_class_func(langParser.Call_class_funcContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#call_class_func}.
     *
     * @param ctx the parse tree
     */
    void exitCall_class_func(langParser.Call_class_funcContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#struct}.
     *
     * @param ctx the parse tree
     */
    void enterStruct(langParser.StructContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#struct}.
     *
     * @param ctx the parse tree
     */
    void exitStruct(langParser.StructContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#create_struct}.
     *
     * @param ctx the parse tree
     */
    void enterCreate_struct(langParser.Create_structContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#create_struct}.
     *
     * @param ctx the parse tree
     */
    void exitCreate_struct(langParser.Create_structContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#call_struct}.
     *
     * @param ctx the parse tree
     */
    void enterCall_struct(langParser.Call_structContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#call_struct}.
     *
     * @param ctx the parse tree
     */
    void exitCall_struct(langParser.Call_structContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#def_func}.
     *
     * @param ctx the parse tree
     */
    void enterDef_func(langParser.Def_funcContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#def_func}.
     *
     * @param ctx the parse tree
     */
    void exitDef_func(langParser.Def_funcContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#def_args}.
     *
     * @param ctx the parse tree
     */
    void enterDef_args(langParser.Def_argsContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#def_args}.
     *
     * @param ctx the parse tree
     */
    void exitDef_args(langParser.Def_argsContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#args}.
     *
     * @param ctx the parse tree
     */
    void enterArgs(langParser.ArgsContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#args}.
     *
     * @param ctx the parse tree
     */
    void exitArgs(langParser.ArgsContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#call_func}.
     *
     * @param ctx the parse tree
     */
    void enterCall_func(langParser.Call_funcContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#call_func}.
     *
     * @param ctx the parse tree
     */
    void exitCall_func(langParser.Call_funcContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#ret}.
     *
     * @param ctx the parse tree
     */
    void enterRet(langParser.RetContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#ret}.
     *
     * @param ctx the parse tree
     */
    void exitRet(langParser.RetContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#for_loop}.
     *
     * @param ctx the parse tree
     */
    void enterFor_loop(langParser.For_loopContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#for_loop}.
     *
     * @param ctx the parse tree
     */
    void exitFor_loop(langParser.For_loopContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#do_while_loop}.
     *
     * @param ctx the parse tree
     */
    void enterDo_while_loop(langParser.Do_while_loopContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#do_while_loop}.
     *
     * @param ctx the parse tree
     */
    void exitDo_while_loop(langParser.Do_while_loopContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#while_loop}.
     *
     * @param ctx the parse tree
     */
    void enterWhile_loop(langParser.While_loopContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#while_loop}.
     *
     * @param ctx the parse tree
     */
    void exitWhile_loop(langParser.While_loopContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#if_begin}.
     *
     * @param ctx the parse tree
     */
    void enterIf_begin(langParser.If_beginContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#if_begin}.
     *
     * @param ctx the parse tree
     */
    void exitIf_begin(langParser.If_beginContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#if_statement}.
     *
     * @param ctx the parse tree
     */
    void enterIf_statement(langParser.If_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#if_statement}.
     *
     * @param ctx the parse tree
     */
    void exitIf_statement(langParser.If_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#else_statement}.
     *
     * @param ctx the parse tree
     */
    void enterElse_statement(langParser.Else_statementContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#else_statement}.
     *
     * @param ctx the parse tree
     */
    void exitElse_statement(langParser.Else_statementContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#numeric_value}.
     *
     * @param ctx the parse tree
     */
    void enterNumeric_value(langParser.Numeric_valueContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#numeric_value}.
     *
     * @param ctx the parse tree
     */
    void exitNumeric_value(langParser.Numeric_valueContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#math_var}.
     *
     * @param ctx the parse tree
     */
    void enterMath_var(langParser.Math_varContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#math_var}.
     *
     * @param ctx the parse tree
     */
    void exitMath_var(langParser.Math_varContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#bool}.
     *
     * @param ctx the parse tree
     */
    void enterBool(langParser.BoolContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#bool}.
     *
     * @param ctx the parse tree
     */
    void exitBool(langParser.BoolContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#value}.
     *
     * @param ctx the parse tree
     */
    void enterValue(langParser.ValueContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#value}.
     *
     * @param ctx the parse tree
     */
    void exitValue(langParser.ValueContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#call_external}.
     *
     * @param ctx the parse tree
     */
    void enterCall_external(langParser.Call_externalContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#call_external}.
     *
     * @param ctx the parse tree
     */
    void exitCall_external(langParser.Call_externalContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#math_module}.
     *
     * @param ctx the parse tree
     */
    void enterMath_module(langParser.Math_moduleContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#math_module}.
     *
     * @param ctx the parse tree
     */
    void exitMath_module(langParser.Math_moduleContext ctx);

    /**
     * Enter a parse tree produced by {@link langParser#condition}.
     *
     * @param ctx the parse tree
     */
    void enterCondition(langParser.ConditionContext ctx);

    /**
     * Exit a parse tree produced by {@link langParser#condition}.
     *
     * @param ctx the parse tree
     */
    void exitCondition(langParser.ConditionContext ctx);
}