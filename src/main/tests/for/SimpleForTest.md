##Simple For loop test
Test: 
```
INT V_0;

FOR (V_0 = 0; V_0 < 3; V_0 = V_0 + 1){
    PRINT V_0;
}

PRINT V_0;
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
define i32 @main() nounwind{
    %V_0 = alloca i32
    store i32 0, i32* %V_0
    br label %for_1_cond

for_1_cond:
    %1 = load i32, i32* %V_0
    %2 = icmp slt i32 %1, 3
    br i1 %2, label %for_1_body, label %end_for_1

for_1_operation:
    %3 = load i32, i32* %V_0
    %4 = add i32 %3, 1
    store i32 %4, i32* %V_0
    br label %for_1_cond

for_1_body:
    %5 = load i32, i32* %V_0
    %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
    br label %for_1_operation

end_for_1:
    %7 = load i32, i32* %V_0
    %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
    ret i32 0 
}
```

Wynik po uruchomieniu: 
```
0
1
2
3
```