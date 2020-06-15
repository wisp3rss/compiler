##If, If else with math operation and constance value
Test: 
```
INT a;
READ a;

INT b;
b = 4;

IF ( a + 5 == 7) {
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
	%1 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %a)
	%b = alloca i32
	store i32 4, i32* %b
	%math_var_0 = alloca i32
	%2 = load i32, i32* %a
	%3 = add i32 %2, 5
	store i32 %3, i32* %math_var_0
	%4 = load i32, i32* %math_var_0
	%5 = icmp eq i32 %4, 7
	br i1 %5, label %if_1, label %else_1

if_1:
	%6 = load i32, i32* %a
	%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %6)
	br label %end_else_1

else_1:
	%8 = load i32, i32* %b
	%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %8)
	br label %end_else_1

end_else_1:
	ret i32 0 
}
```

podajemy wartość z klawiatury: `7`

Wynik po uruchomieniu: 
```
4
```