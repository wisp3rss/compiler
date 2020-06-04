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
%V_1 = alloca i32
store i32 5, i32* %V_0
store i32 3, i32* %V_1
%1 = load i32, i32* %V_0
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
%3 = load i32, i32* %V_1
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
%5 = load i32, i32* %V_1
%6 = add i32 %5, 3
store i32 %6, i32* %V_1
%7 = load i32, i32* %V_1
%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
%9 = load i32, i32* %V_1
%10 = load i32, i32* %V_0
%11 = mul i32 %9, %10
store i32 %11, i32* %V_1
%12 = load i32, i32* %V_1
%13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
%14 = load i32, i32* %V_1
%15 = sdiv i32 90, %14
store i32 %15, i32* %V_1
%16 = load i32, i32* %V_1
%17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %16)
%18 = sub i32 3, 2
store i32 %18, i32* %V_0
%19 = load i32, i32* %V_0
%20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %19)
%V_2 = alloca double
%V_3 = alloca double
store double 5.1, double* %V_2
store double 3.3, double* %V_3
%21 = load double, double* %V_2
%22 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %21)
%23 = load double, double* %V_3
%24 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %23)
%25 = load double, double* %V_2
%26 = load double, double* %V_3
%27 = fsub double %25, %26
store double %27, double* %V_2
%28 = load double, double* %V_2
%29 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %28)
%30 = load double, double* %V_2
%31 = fmul double %30, 3.1
store double %31, double* %V_2
%32 = load double, double* %V_2
%33 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %32)
%34 = load double, double* %V_3
%35 = fdiv double 9.9, %34
store double %35, double* %V_3
%36 = load double, double* %V_3
%37 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %36)
%tmp_V_6 = alloca i32
%V_6 = alloca i32
store i32 0, i32* %tmp_V_6
store i32 1, i32* %V_6
%38 = load i32, i32* %V_6
%39 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %38)
store i32 0, i32* %V_6
%40 = load i32, i32* %V_6
%41 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %40)
%V_11 = alloca i32
%42 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %V_11)
%43 = load i32, i32* %V_11
%44 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %43)
%V_12 = alloca double
%45 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strdouble, i64 0, i64 0), double* %V_12)
%46 = load double, double* %V_12
%47 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %46)
%V_13 = alloca i32
%tmp_V_13 = alloca [256 x i8]
store i32 0, i32* %V_13
%48  = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_13, i64 0, i64 0
%49  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %48)
%50 = load i32, i32* %V_13
%51 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_V_13, i64 0, i64 0
%52 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %51)
ret i32 0 }
