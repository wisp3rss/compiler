##If, If else with two variables, operations: <, >, <=, >=
Test: 
```
INT a;
a = 1;

INT b;
b = 2;

IF (a < b) {                    #false
    PRINT a;
}
ELSE {
    PRINT b;                    #2
    IF(a > b){                  #false
        PRINT a;
    }
    ELSE {
        PRINT b;                #2
        IF(a <= b){             #true
            PRINT a;            #1
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
	%1 = load i32, i32* %b
	%2 = load i32, i32* %a
	%3 = icmp slt i32 %1, %2
	br i1 %3, label %if_1, label %else_1

if_1:
	%4 = load i32, i32* %a
	%5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
	br label %end_else_1

else_1:
	%6 = load i32, i32* %b
	%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %6)
	%8 = load i32, i32* %a
	%9 = load i32, i32* %b
	%10 = icmp sgt i32 %8, %9
	br i1 %10, label %if_2, label %else_2

if_2:
	%11 = load i32, i32* %a
	%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
	br label %end_else_2

else_2:
	%13 = load i32, i32* %b
	%14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
	%15 = load i32, i32* %a
	%16 = load i32, i32* %b
	%17 = icmp sle i32 %15, %16
	br i1 %17, label %if_3, label %else_3

if_3:
	%18 = load i32, i32* %a
	%19 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %18)
	br label %end_else_3

else_3:
	%20 = load i32, i32* %b
	%21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %20)
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