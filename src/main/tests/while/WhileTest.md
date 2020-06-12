##While
Test:
```
INT V_1;
V_1 = 4;

WHILE (V_1 >= 0) {
    PRINT V_1;
    V_1 = V_1 - 1;
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
    store i32 4, i32* %V_1
    br label %while_0_c

while_0_c:
    %1 = load i32, i32* %V_1
    %2 = icmp sge i32 %1, 0
    br i1 %2, label %while_0, label %end_while_0

while_0:
    %3 = load i32, i32* %V_1
    %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
    %5 = load i32, i32* %V_1
    %6 = sub i32 %5, 1
    store i32 %6, i32* %V_1
    br label %while_0_c

end_while_0:
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

##Test 2
Test:
```
INT V_0;
V_0 = 2;

INT V_1;
V_1 = 4;

WHILE (V_1 >= 0) {
    IF (V_0 != 2) {             #false
        PRINT V_0;              #2

    }
    ELSE {
        IF(2 != V_0){           #false
                PRINT V_0;      #2
            }
            ELSE {
                PRINT V_1;      #4,3,2,1,0
            }
    }
    V_1 = V_1 - 1;
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    store i32 2, i32* %V_0
    %V_1 = alloca i32
    store i32 4, i32* %V_1
    br label %while_0_c

while_0_c:
    %1 = load i32, i32* %V_1
    %2 = icmp sge i32 %1, 0
    br i1 %2, label %while_0, label %end_while_0

while_0:
    %3 = load i32, i32* %V_0
    %4 = icmp ne i32 %3, 2
    br i1 %4, label %if_1, label %else_1

if_1:
    %5 = load i32, i32* %V_0
    %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
    br label %end_else_1

else_1:
    %7 = load i32, i32* %V_0
    %8 = icmp ne i32 2, %7
    br i1 %8, label %if_2, label %else_2

if_2:
    %9 = load i32, i32* %V_0
    %10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
    br label %end_else_2

else_2:
    %11 = load i32, i32* %V_1
    %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
    br label %end_else_2

end_else_2:
    br label %end_else_1

end_else_1:
    %13 = load i32, i32* %V_1
    %14 = sub i32 %13, 1
    store i32 %14, i32* %V_1
    br label %while_0_c

end_while_0:
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