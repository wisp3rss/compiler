##If, If else with two constance value, operations: <, >, <=, >=
Test: 
```
INT a;
a = 1;

INT b;
b = 2;

IF (2>=5) {                #false
    PRINT a;               #1
}
ELSE {
    PRINT b;
    IF(1 > 3){             #false
        PRINT a;
    }
    ELSE {
       PRINT b;            #2
       IF(5<=5){           #true
           PRINT a;        #1
        }
        ELSE {
            PRINT b;
        }
    }
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
	store i32 1, i32* %a
	%b = alloca i32
	store i32 2, i32* %b
	%1 = icmp sge i32 2, 5
	br i1 %1, label %if_1, label %else_1

if_1:
	%2 = load i32, i32* %a
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %2)
	br label %end_else_1

else_1:
	%4 = load i32, i32* %b
	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
	%6 = icmp sgt i32 1, 3
	br i1 %6, label %if_2, label %else_2

if_2:
	%7 = load i32, i32* %a
	%8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
	br label %end_else_2

else_2:
	%9 = load i32, i32* %b
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
	%11 = icmp sle i32 5, 5
	br i1 %11, label %if_3, label %else_3

if_3:
	%12 = load i32, i32* %a
	%13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
	br label %end_else_3

else_3:
	%14 = load i32, i32* %b
	%15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %14)
	br label %end_else_3

end_else_3:
	br label %end_else_2

end_else_2:
	br label %end_else_1

end_else_1:
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
2
2
1
```