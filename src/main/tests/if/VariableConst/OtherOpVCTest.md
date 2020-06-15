##If, If else with constance value and variable, operations: <, >, <=, >=
Test: 
```
INT a;
a = 1;

INT b;
b = 2;

IF (a > 3) {                  #false
    PRINT a;                  #1
}
ELSE {
    PRINT b;                  #2
    IF(a>=5){                 #false
        PRINT a;
    }
    ELSE {
        PRINT b;              #2
        IF(b<=2){             #true
            PRINT a;          #1
         }
        ELSE {
            PRINT b;
        }
    }
}

IF(a > 0){                    #true
    PRINT a;
}

IF(a >= 0){                   #true
    PRINT a;
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
	%1 = load i32, i32* %a
	%2 = icmp sgt i32 %1, 3
	br i1 %2, label %if_1, label %else_1

if_1:
	%3 = load i32, i32* %a
	%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
	br label %end_else_1

else_1:
	%5 = load i32, i32* %b
	%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
	%7 = load i32, i32* %a
	%8 = icmp sge i32 %7, 5
	br i1 %8, label %if_2, label %else_2

if_2:
	%9 = load i32, i32* %a
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
	br label %end_else_2

else_2:
	%11 = load i32, i32* %b
	%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
	%13 = load i32, i32* %b
	%14 = icmp sle i32 %13, 2
	br i1 %14, label %if_3, label %else_3

if_3:
	%15 = load i32, i32* %a
	%16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %15)
	br label %end_else_3

else_3:
	%17 = load i32, i32* %b
	%18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %17)
	br label %end_else_3

end_else_3:
	br label %end_else_2

end_else_2:
	br label %end_else_1

end_else_1:
	%19 = load i32, i32* %a
	%20 = icmp sgt i32 %19, 0
	br i1 %20, label %if_4, label %end_if_4

if_4:
	%21 = load i32, i32* %a
	%22 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %21)
	br label %end_if_4

end_if_4:
	%23 = load i32, i32* %a
	%24 = icmp sge i32 %23, 0
	br i1 %24, label %if_5, label %end_if_5

if_5:
	%25 = load i32, i32* %a
	%26 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %25)
	br label %end_if_5

end_if_5:
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
2
2
1
1
1
```