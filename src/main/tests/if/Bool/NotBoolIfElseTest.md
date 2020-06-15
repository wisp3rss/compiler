##If, If else with true/false and NOT
Test: 
```
FLOAT a;
a = 2.1;

FLOAT b;
b = 4.2;

IF (!true) {
    PRINT a;
}
ELSE {
    IF(!false){
        PRINT a;
    }
    ELSE {
        PRINT b;
    }
    PRINT b;
}
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
	%a = alloca double
	store double 2.1, double* %a
	%b = alloca double
	store double 4.2, double* %b
	%1 = alloca i32
	store i32 0, i32* %1
	%2 = load i32, i32* %1
	%3 = icmp ne i32 %2, 0
	br i1 %3, label %if_1, label %else_1

if_1:
	%4 = load double, double* %a
	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
	br label %end_else_1

else_1:
	%6 = alloca i32
	store i32 1, i32* %6
	%7 = load i32, i32* %6
	%8 = icmp ne i32 %7, 0
	br i1 %8, label %if_2, label %else_2

if_2:
	%9 = load double, double* %a
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %9)
	br label %end_else_2

else_2:
	%11 = load double, double* %b
	%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %11)
	br label %end_else_2

end_else_2:
	%13 = load double, double* %b
	%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %13)
	br label %end_else_1

end_else_1:
	ret i32 0 
}

```

Wynik po uruchomieniu: 
```
2.100000
4.200000
```
