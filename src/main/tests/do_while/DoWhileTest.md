##simple do while test
Test: 
```
INT a;
a = 4;

DO {
    PRINT a;
    a = a - 1;
}
WHILE (a >= 0);
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
	store i32 4, i32* %a
	br label %dowhile_1

dowhile_1:
	%1 = load i32, i32* %a
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
	%3 = load i32, i32* %a
	%4 = sub i32 %3, 1
	store i32 %4, i32* %a
	br label %dowhile_1_c

dowhile_1_c:
	%5 = load i32, i32* %a
	%6 = icmp sge i32 %5, 0
	br i1 %6, label %dowhile_1, label %end_dowhile_1

end_dowhile_1:
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
4
3
2
1
0
```