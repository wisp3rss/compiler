##If, If else with two constance value, operations: <, >, <=, >=
Test: 
```
INT a;
a = 1;

INT b;
b = 2;

IF (1 < 3) {                    #true
    PRINT a;                    #1
    IF(2>=5){                   #false
        PRINT a;
    }
    ELSE {
        PRINT b;                #2
        IF(5<=5){               #true
            PRINT a;            #1
         }
        ELSE {
            PRINT b;
        }
    }
}
ELSE {
    PRINT b;
}

IF(2 > 5){                       #false
    PRINT a;
}
ELSE {
    PRINT b;                     #2
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
    %1 = icmp slt i32 1, 3
    br i1 %1, label %if_1, label %else_1

if_1:
    %2 = load i32, i32* %a
    %3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %2)
    %4 = icmp sge i32 2, 5
    br i1 %4, label %if_2, label %else_2

if_2:
    %5 = load i32, i32* %a
    %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
    br label %end_else_2

else_2:
    %7 = load i32, i32* %b
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    %9 = icmp sle i32 5, 5
    br i1 %9, label %if_3, label %else_3

if_3:
    %10 = load i32, i32* %a
    %11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %10)
    br label %end_else_2

else_3:
    %12 = load i32, i32* %b
    %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
    br label %end_else_2

end_else_2:
    br label %end_else_3

end_else_3:
    br label %end_else_1

else_1:
    %14 = load i32, i32* %b
    %15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %14)
    br label %end_else_1

end_else_1:
    %16 = icmp sgt i32 2, 5
    br i1 %16, label %if_4, label %else_4

if_4:
    %17 = load i32, i32* %a
    %18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %17)
    br label %end_else_4

else_4:
    %19 = load i32, i32* %b
    %20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %19)
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