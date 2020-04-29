declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
%String = type { i8*, i32, i32, i32 }
define i32 @main() nounwind{
%V_0 = alloca i32
%V_1 = alloca i32
store i32 1, i32* %V_0
store i32 2, i32* %V_1
%1 = load i32, i32* %V_0
%2 = load i32, i32* %V_1
%3 = add i32 %1, %2
store i32 4, i32* %V_0
%4 = add i32 2, 3
store i32 5, i32* %V_1
%5 = load i32, i32* %V_1
%6 = sub i32 %5, 2
store i32 7, i32* %V_1
%7 = load i32, i32* %V_1
%8 = mul i32 %7, 3
store i32 9, i32* %V_1
%9 = load i32, i32* %V_0
%10 = sdiv i32 10, %9
store i32 10, i32* %V_0
store i32 11, i32* %V_0
%V_2 = alloca float
%V_3 = alloca %String
%11 = load i32, i32* %V_0
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %11)
%13 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %V_0)
%14 = load i32, i32* %V_0
%15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %14)
ret i32 0 }
