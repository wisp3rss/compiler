##Operacje arytmetyczne
###Int
Test:
```
INT a;
INT b;

a = 5;
b = 3;

b = b + 3;
PRINT b;

b = b * a;
PRINT b;

b = 90 / b;
PRINT b;

a = 3 % 2;
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
	%a = alloca i32
	%b = alloca i32
	store i32 5, i32* %a
	store i32 3, i32* %b
	%1 = load i32, i32* %b
	%2 = add i32 %1, 3
	store i32 %2, i32* %b
	%3 = load i32, i32* %b
	%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
	%5 = load i32, i32* %b
	%6 = load i32, i32* %a
	%7 = mul i32 %5, %6
	store i32 %7, i32* %b
	%8 = load i32, i32* %b
	%9 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %8)
	%10 = load i32, i32* %b
	%11 = sdiv i32 90, %10
	store i32 %11, i32* %b
	%12 = load i32, i32* %b
	%13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
	%14 = sub i32 3, 2
	store i32 %14, i32* %a
	%15 = load i32, i32* %a
	%16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %15)
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
6
30
3
1
```

######Pozostałe operacje arytmetyczne działają analogicznie do powyższych przykładów.