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
%V_0 = alloca i32
store i32 2, i32* %V_0
%V_1 = alloca i32
store i32 4, i32* %V_1
br label %while_0_c
while_0_c:
%1 = load i32, i32* %V_1
%2 = icmp sge i32 %1, 0
br i1 %2, label %while_0, label %end_while_0
while_0:
%3 = load i32, i32* %V_0
%4 = icmp ne i32 %3, 2
br i1 %4, label %if_1, label %else_1
if_1:
%5 = load i32, i32* %V_0
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
br label %end_else_1
else_1:
%7 = load i32, i32* %V_0
%8 = icmp ne i32 2, %7
br i1 %8, label %if_2, label %else_2
if_2:
%9 = load i32, i32* %V_0
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
br label %end_else_2
else_2:
%11 = load i32, i32* %V_1
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
br label %end_else_2
end_else_2:
br label %end_else_1
end_else_1:
%13 = load i32, i32* %V_1
%14 = sub i32 %13, 1
store i32 %14, i32* %V_1
br label %while_0_c
end_while_0:
ret i32 0 }
