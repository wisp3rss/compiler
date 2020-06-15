##Example Test
Test: 
```
INT a;
a = 2;

func INT foo2(INT x, INT y){
    INT b;
    b = 4;
    FLOAT c;
    c = 4.27;

    PRINT b;
    PRINT c;

    STRING abc;
    READ abc;
    PRINT abc;

    return b;
}

foo2(a, a);

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
	%1 = load i32, i32* %a
	%2 = load i32, i32* %a
	%3 = call i32 @foo2(i32 %1,i32 %2)
	%4 = alloca i32
	store i32 1, i32* %4
	%5 = load i32, i32* %4
	%6 = icmp ne i32 %5, 0
	br i1 %6, label %if_1, label %end_if_1

if_1:
	%7 = load i32, i32* %a
	%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
	br label %end_if_1

end_if_1:
	ret i32 0 
}

define i32 @foo2(i32,i32) nounwind{
	%b = alloca i32
	store i32 4, i32* %b
	%c = alloca double
	store double 4.27, double* %c
	%3 = load i32, i32* %b
	%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
	%5 = load double, double* %c
	%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %5)
	%abc = alloca i32
	%tmp_abc = alloca [256 x i8]
        store i32 0, i32* %abc
	%7  = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_abc, i64 0, i64 0
	%8  = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.stringScan, i64 0, i64 0), i8* %7)
	%9 = load i32, i32* %abc
	%10 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_abc, i64 0, i64 0
	%11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.stringPrint, i64 0, i64 0), i8* %10)
	%12 = load i32, i32* %b
	ret i32 %12
}

```

podajemy wartość z klawiatury: `abcAbc`

Wynik po uruchomieniu: 
```
4
4.270000
abcAbc
abcAbc
```