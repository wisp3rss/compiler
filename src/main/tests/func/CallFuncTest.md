#Handling call function and calling error
##Test 1: 
```
INT a;

func INT getFoo(){
    return a;
}

foo();
```


Wynik po uruchomieniu: 
```
Error: Function foo is undefined.
```

##Test 2
Test: 
```
INT a;

func INT getFoo(){
    a = 2;
    PRINT a;
    return a;
}

getFoo();

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
	%1 = call i32 @getFoo()
	ret i32 0 
}

define i32 @getFoo() nounwind{
    %a = alloca i32
	store i32 2, i32* %a
	%1 = load i32, i32* %a
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
	%3 = load i32, i32* %a
	ret i32 %3
}
```

Wynik po uruchomieniu: 
```
2
```

##Test 3: 
```
INT a;

func INT getFoo(){
    a = 2;
    PRINT a;
    return a;
}

FLOAT b;
b = 45.2;

STRING abBc;
abBc = "napis";

getFoo(a,b, abBc);

```


Wynik po uruchomieniu: 
```
Error: Function getFoo[INT, FLOAT, STRING] is undefined.
```
