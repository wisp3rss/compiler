##If, If else with true/false value
Test: 
```
INT a;
a = 2;

INT b;
b = 4;

IF (true) {
    IF(false){
        PRINT a;
    }
    ELSE {
        PRINT b;
    }
    PRINT a;
}
ELSE {
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
	%a = alloca i32
	store i32 2, i32* %a
	%b = alloca i32
	store i32 4, i32* %b
	%1 = alloca i32
	store i32 1, i32* %1
	%2 = load i32, i32* %1
	%3 = icmp ne i32 %2, 0
	br i1 %3, label %if_1, label %else_1

if_1:
	%4 = alloca i32
	store i32 0, i32* %4
	%5 = load i32, i32* %4
	%6 = icmp ne i32 %5, 0
	br i1 %6, label %if_2, label %else_2

if_2:
	%7 = load i32, i32* %a
	%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
	br label %end_else_2

else_2:
	%9 = load i32, i32* %b
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
	br label %end_else_2

end_else_2:
	%11 = load i32, i32* %a
	%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
	br label %end_else_1

else_1:
	%13 = load i32, i32* %b
	%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
	br label %end_else_1

end_else_1:
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
4
2
```