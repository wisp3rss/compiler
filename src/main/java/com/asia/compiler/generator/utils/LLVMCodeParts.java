package com.asia.compiler.generator.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LLVMCodeParts {

    PRINT_INT("%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), %s %s)\n"),
    PRINT_FLOAT( "%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), %s %s)\n"),
    PRINT_STRING_LINE_1( "%s = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n"),
    PRINT_STRING_LINE_2( "%s = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %s)\n"),
    PRINT_BOOL( "%s = call %s (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), %s %s)\n"),

    READ_INT( "%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), %s* %s)\n"),
    READ_FLOAT( "%s = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), %s* %s)\n"),
    READ_STRING_LNE_1( "%s  = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n"),
    READ_STRING_LNE_2( "%s  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %s)\n"),
    READ_BOOL( "%s = call %s (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), %s* %s)\n"),

    DEFINE_INT_FLOAT( "%s = alloca %s\n"),
    DEFINE_STRING( "%s = alloca [256 x i8]\nstore i32 0, i32* %s\n"),

    ASSIGN_STRING_DECLARATION( "@.strAssignString_%s = private unnamed_addr constant [ %s x i8] c\"%s\\00\"\n"),
    ASSIGN_STRING_LINE_1( "%s = getelementptr inbounds [256 x i8], [256 x i8]* %s, i64 0, i64 0\n"),
    ASSIGN_STRING_LINE_2( "%s = call i8* @__strcpy_chk(i8* %s, i8* getelementptr inbounds ([ %s x i8], [ %s x i8]* @.strAssignString_%s, i64 0, i64 0), i64 256)\n"),
    STORE( "store %s %s, %s* %s\n"),

    LOAD( "%s = load %s, %s* %s\n"),

    MATH_OPERATION( "%s = %s %s %s, %s\n");

    @Getter
    private String value;
}

