##Operaje wejścia-wyjścia
###String
Test:
```
STRING a;
a = "abc";

#----print test----
PRINT a;

#----read test----
READ a;
PRINT a;
```

W pliku result.ll:
```llvm
@.strAssignString_a = private unnamed_addr constant [ 4 x i8] c"abc\00"
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
	%a = alloca i32
	%tmp_a = alloca [256 x i8]
store i32 0, i32* %a
	%1 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_a, i64 0, i64 0
	%2 = call i8* @__strcpy_chk(i8* %1, i8* getelementptr inbounds ([ 4 x i8], [ 4 x i8]* @.strAssignString_a, i64 0, i64 0), i64 256)
	%3 = load i32, i32* %a
	%4 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_a, i64 0, i64 0
	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %4)
	%6  = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_a, i64 0, i64 0
	%7  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %6)
	%8 = load i32, i32* %a
	%9 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_a, i64 0, i64 0
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %9)
	ret i32 0 
}

```

podajemy wartość z klawiatury: `JFIK`

Wynik po uruchomieniu: 
```
abc
JFIK
```