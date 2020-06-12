##If, If else
Test: 
```
INT V_0;
V_0 = 1;

INT V_1;
V_1 = 2;

IF (V_0 < 3) {                  #true
    PRINT V_0;                  #1
    IF(V_0>=5){                 #false
        PRINT V_0;
    }
    ELSE {
        PRINT V_1;              #2
        IF(V_1<=2){             #true
            PRINT V_0;          #1
         }
        ELSE {
            PRINT V_1;
        }
    }
}
ELSE {
    PRINT V_1;
}

IF(V_0 > 5){                    #false
    PRINT V_0;
}
ELSE {
    PRINT V_1;                  #2
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    store i32 1, i32* %V_0
    %V_1 = alloca i32
    store i32 2, i32* %V_1
    %1 = load i32, i32* %V_0
    %2 = icmp slt i32 %1, 3
    br i1 %2, label %if_1, label %else_1

if_1:
    %3 = load i32, i32* %V_0
    %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
    %5 = load i32, i32* %V_0
    %6 = icmp sge i32 %5, 5
    br i1 %6, label %if_2, label %else_2

if_2:
    %7 = load i32, i32* %V_0
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    br label %end_else_2

else_2:
    %9 = load i32, i32* %V_1
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    %11 = load i32, i32* %V_1
    %12 = icmp sle i32 %11, 2
    br i1 %12, label %if_3, label %else_3

if_3:
    %13 = load i32, i32* %V_0
    %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %13)
    br label %end_else_2

else_3:
    %15 = load i32, i32* %V_1
    %16 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %15)
    br label %end_else_2

end_else_2:
    br label %end_else_3

end_else_3:
    br label %end_else_1

else_1:
    %17 = load i32, i32* %V_1
    %18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %17)
    br label %end_else_1

end_else_1:
    %19 = load i32, i32* %V_0
    %20 = icmp sgt i32 %19, 5
    br i1 %20, label %if_4, label %else_4

if_4:
    %21 = load i32, i32* %V_0
    %22 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %21)
    br label %end_else_4

else_4:
    %23 = load i32, i32* %V_1
    %24 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %23)
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