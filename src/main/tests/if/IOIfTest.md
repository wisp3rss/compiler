##If, If else
Test: 
```
INT a;
READ a;

INT b;
b = 4;

IF ( a == 7) {
    PRINT a;
}
```

W pliku result.ll:
```llvm
declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
define i32 @main() nounwind{
    %a = alloca i32
    %1 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i64 0, i64 0), i32* %a)
    %b = alloca i32
    store i32 4, i32* %b
    %2 = load i32, i32* %a
    %3 = icmp eq i32 %2, 7
    br i1 %3, label %if_1, label %end_if_1

if_1:
    %4 = load i32, i32* %a
    %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
    br label %end_if_1

end_if_1:
    ret i32 0 
}
```

podajemy wartość z klawiatury: `7`

Wynik po uruchomieniu: 
```
7
```