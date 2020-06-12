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
store i32 0, i32* %V_0
%V_1 = alloca i32
store i32 1, i32* %V_1
%1 = alloca i32
store i32 1, i32* %1
%2 = load i32, i32* %1
%3 = icmp ne i32 %2, 0
br i1 %3, label %if_1, label %else_1
if_1:
%4 = load i32, i32* %V_0
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
br label %end_else_1
else_1:
%6 = load i32, i32* %V_1
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %6)
br label %end_else_1
end_else_1:
ret i32 0 }
