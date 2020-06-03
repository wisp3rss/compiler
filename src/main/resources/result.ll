declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
declare i8* @__strcpy_chk(i8*, i8*, i64) #1
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@.strdouble = private unnamed_addr constant [4 x i8] c"%lf\00"
@.stringScan = private unnamed_addr constant [3 x i8] c"%s\00"
@.stringPrint = private unnamed_addr constant [4 x i8] c"%s\0A\00"
define i32 @main() nounwind{
%V_4 = alloca i32
store i32 6, i32* %V_4
%1 = alloca i32
store i32 0, i32* %1
br label %cond1
cond1:
%2 = load i32, i32* %1
%3 = add i32 %2, 1
store i32 %3, i32* %1
%4 = icmp slt i32 %2, 4
br i1 %4, label %true1, label %false1
true1:
%5 = load i32, i32* %V_4
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
br label %cond1
false1:
%7 = load i32, i32* %V_4
%8 = icmp eq i32 %7, 5
br i1 %8, label %true2, label %false2
true2:
%9 = load i32, i32* %V_4
%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
br label %false2
false2:
ret i32 0 }
