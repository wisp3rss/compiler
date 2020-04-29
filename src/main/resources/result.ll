declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
%V_0 = alloca i32
%V_1 = alloca i32
store i32 1, i32* %V_0
store i32 2, i32* %V_1
%1 = load i32, i32* %V_0
%2 = load i32, i32* %V_1
%3 = add i32 %1, %2
store i32 %3, i32* %V_0
%4 = add i32 2, 3
store i32 %4, i32* %V_1
%5 = load i32, i32* %V_1
%6 = sub i32 %5, 2
store i32 %6, i32* %V_1
%7 = load i32, i32* %V_1
%8 = mul i32 %7, 3
store i32 %8, i32* %V_1
%9 = load i32, i32* %V_0
%10 = sdiv i32 10, %9
store i32 %10, i32* %V_0
%11 = sub i32 2, 3
store i32 %11, i32* %V_1
%V_2 = alloca double
store double 4.2, double* %V_2
%12 = load double, double* %V_2
%13 = fsub double %12, 2.1
store double %13, double* %V_2
%14 = load i32, i32* %V_0
%15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %14)
%16 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %V_0)
%17 = load i32, i32* %V_0
%18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %17)
ret i32 0 }
