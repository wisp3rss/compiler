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
%1 = alloca i32
store i32 1, i32* %1
%2 = load i32, i32* %1
%3 = icmp ne i32 %2, 0
br i1 %3, label %if_1, label %else_1
if_1:
%4 = alloca i32
store i32 1, i32* %4
%5 = load i32, i32* %4
%6 = icmp ne i32 %5, 0
br i1 %6, label %if_2, label %else_2
if_2:
%7 = load i32, i32* %V_0
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
br label %end_else_2
else_2:
%9 = load i32, i32* %V_1
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
br label %end_else_2
end_else_2:
%11 = load i32, i32* %V_0
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
br label %end_else_1
else_1:
%13 = load i32, i32* %V_1
%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
br label %end_else_1
end_else_1:
ret i32 0 }
