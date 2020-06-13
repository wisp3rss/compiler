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
store i32 4, i32* %V_1
%V_2 = alloca i32
store i32 1, i32* %V_2
store i32 1, i32* %V_2
%V_0 = alloca i32
store i32 0, i32* %V_0
br label %for_1_cond
for_1_cond:
%1 = load i32, i32* %V_0
%2 = icmp slt i32 %1, 3
br i1 %2, label %for_1_body, label %end_for_1
for_1_operation:
%3 = load i32, i32* %V_0
%4 = add i32 %3, 1
store i32 %4, i32* %V_0
br label %for_1_cond
for_1_body:
%5 = load i32, i32* %V_0
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
br label %for_1_operation
end_for_1:
%7 = load i32, i32* %V_0
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
ret i32 0 }
