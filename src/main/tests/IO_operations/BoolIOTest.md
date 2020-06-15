##Operaje wejścia-wyjścia
###Bool
Test:
```
BOOL a;
a = true;

#----print test----
PRINT a;

#----read test----
READ a;
PRINT a;
```

W pliku result.ll:
```llvm
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
	%tmp_a = alloca i32
	%a = alloca i32
	store i32 0, i32* %tmp_a
	store i32 1, i32* %a
	%1 = load i32, i32* %a
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %1)
	%3 = load i32, i32* %a
	%4 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32* %a)
	%5 = load i32, i32* %a
	%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.strbool, i64 0, i64 0), i32 %5)
	ret i32 0 
}
```