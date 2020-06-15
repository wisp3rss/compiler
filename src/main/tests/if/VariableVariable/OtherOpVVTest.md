##If, If else with two variables, operations: <, >, <=, >=
Test: 
```
INT a;
a = 1;

INT b;
b = 2;

IF (a < b) {                #true
    PRINT a;                  #1
    IF(a > b){              #false
        PRINT a;
    }
    ELSE {
        PRINT b;              #2
        IF(a <= b){         #true
            PRINT a;          #1
         }
        ELSE {
            PRINT b;
        }
    }
}
ELSE {
    PRINT b;
}

IF(a > b){                  #false
    PRINT a;
}
ELSE {
    PRINT b;                  #2
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %a = alloca i32
    store i32 1, i32* %a
    %b = alloca i32
    store i32 2, i32* %b
    %1 = load i32, i32* %a
    %2 = load i32, i32* %b
    %3 = icmp slt i32 %1, %2
    br i1 %3, label %if_1, label %else_1

if_1: 
    %4 = load i32, i32* %a
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
    %6 = load i32, i32* %a
    %7 = load i32, i32* %b
    %8 = icmp sgt i32 %6, %7
    br i1 %8, label %if_2, label %else_2

if_2:
    %9 = load i32, i32* %a
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_2

else_2:
    %11 = load i32, i32* %b
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
    %13 = load i32, i32* %a
    %14 = load i32, i32* %b
    %15 = icmp sle i32 %13, %14
    br i1 %15, label %if_3, label %else_3

if_3:
    %16 = load i32, i32* %a
    %17 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %16)
    br label %end_else_2

else_3:
    %18 = load i32, i32* %b
    %19 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %18)
    br label %end_else_2

end_else_2:
    br label %end_else_3

end_else_3:
    br label %end_else_1

else_1:
    %20 = load i32, i32* %b
    %21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %20)
    br label %end_else_1

end_else_1:
    %22 = load i32, i32* %a
    %23 = load i32, i32* %b
    %24 = icmp sgt i32 %22, %23
    br i1 %24, label %if_4, label %else_4

if_4:
    %25 = load i32, i32* %a
    %26 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %25)
    br label %end_else_4

else_4:
    %27 = load i32, i32* %b
    %28 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %27)
    br label %end_else_4

end_else_4:
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
1
2
1
2
```