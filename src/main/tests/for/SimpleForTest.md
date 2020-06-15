#Simple For loop test
##Test 1: 
```
INT a;

FOR (a = 0; a < 3; a = a + 1;){
    PRINT a;
}

PRINT a;
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
	store i32 0, i32* %a
	br label %for_1_cond

for_1_cond:
	%1 = load i32, i32* %a
	%2 = icmp slt i32 %1, 3
	br i1 %2, label %for_1_body, label %end_for_1

for_1_operation:
	%3 = load i32, i32* %a
	%4 = add i32 %3, 1
	store i32 %4, i32* %a
	br label %for_1_cond

for_1_body:
	%5 = load i32, i32* %a
	%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %5)
	br label %for_1_operation

end_for_1:
	%7 = load i32, i32* %a
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

##Test 2: 
```
INT a;

FOR (a = 0; a < 6; a = a + 1;){
    IF(a % 3 == 0 ){
        PRINT a;
    }
}

PRINT a;
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
	store i32 0, i32* %a
	br label %for_1_cond

for_1_cond:
	%1 = load i32, i32* %a
	%2 = icmp slt i32 %1, 6
	br i1 %2, label %for_1_body, label %end_for_1

for_1_operation:
	%3 = load i32, i32* %a
	%4 = add i32 %3, 1
	store i32 %4, i32* %a
	br label %for_1_cond

for_1_body:
	%math_var_0 = alloca i32
	%5 = load i32, i32* %a
	%6 = sub i32 %5, 3
	store i32 %6, i32* %math_var_0
	%7 = load i32, i32* %math_var_0
	%8 = icmp eq i32 %7, 0
	br i1 %8, label %if_1, label %end_if_1

if_1:
	%9 = load i32, i32* %a
	%10 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %9)
	br label %end_if_1

end_if_1:
	br label %for_1_operation

end_for_1:
	%11 = load i32, i32* %a
	%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
	ret i32 0 
}
```

Wynik po uruchomieniu: 
```
3
6
```


