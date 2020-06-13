declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @__strcpy_chk(i8*, i8*, i64) #1
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strbool = private unnamed_addr constant [4 x i8] c"%u\0A\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
@.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
@.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
define i32 @main() nounwind{
%V_1 = alloca i32
store i32 4, i32* %V_1
%math_var_0 = alloca i32
%1 = load i32, i32* %V_1
%2 = add i32 %1, 2
store i32 %2, i32* %math_var_0
br label %while_0_c
while_0_c:
%3 = load i32, i32* %V_1
%4 = add i32 %3, 2
store i32 %4, i32* %math_var_0
%5 = load i32, i32* %math_var_0
%6 = icmp sge i32 %5, 0
br i1 %6, label %while_0, label %end_while_0
while_0:
%7 = load i32, i32* %V_1
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
%9 = load i32, i32* %V_1
%10 = sub i32 %9, 1
store i32 %10, i32* %V_1
br label %while_0_c
end_while_0:
ret i32 0 }
