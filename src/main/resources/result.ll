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
%3 = add i32 V_0, V_1
store i32 3, i32* %V_0
%3 = add i32 2, 3
store i32 3, i32* %V_1
%3 = load i32, i32* %V_1
%4 = load i32, i32* %2
%5 = sub i32 V_1, 2
store i32 5, i32* %V_1
%5 = load i32, i32* %V_1
%6 = load i32, i32* %3
%7 = mul i32 V_1, 3
store i32 7, i32* %V_1
%7 = load i32, i32* %V_0
%8 = sdiv i32 10, V_0
store i32 8, i32* %V_0
%V_2 = alloca float
store float 4.2, float* %V_2
%8 = load float, float* %V_2
%9 = load float, float* %4.2
%10 = fadd float V_2, 4.2
store float 10, float* %V_2
%V_3 = alloca str
store str "ABC", str* %V_3
%10 = load i32, i32* %V_0
%11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %10)
%12 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %V_0)
%13 = load i32, i32* %V_0
%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %13)
ret i32 0 }
