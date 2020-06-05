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
br label %while_0_c
while_0_c:
%1 = alloca i32
store i32 1, i32* %1
%2 = load i32, i32* %1
%3 = icmp ne i32 %2, 0
br i1 %3, label %while_0, label %end_while_0
while_0:
%4 = load i32, i32* %V_0
%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
br label %while_0_c
end_while_0:
ret i32 0 }
