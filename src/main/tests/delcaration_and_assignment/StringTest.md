##Deklaracja zmiennych i przypisanie wartości
###String
Test:
```
#declaration
STRING a;
STRING b;

#assigning
a = "ABC";
b = "DEF";
```

W pliku result.ll:
```llvm
@.strAssignString_a = private unnamed_addr constant [ 4 x i8] c"ABC\00"
@.strAssignString_b = private unnamed_addr constant [ 4 x i8] c"DEF\00"
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
	%tmp_a = alloca [256 x i8]
store i32 0, i32* %a
	%b = alloca i32
	%tmp_b = alloca [256 x i8]
store i32 0, i32* %b
	%1 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_a, i64 0, i64 0
	%2 = call i8* @__strcpy_chk(i8* %1, i8* getelementptr inbounds ([ 4 x i8], [ 4 x i8]* @.strAssignString_a, i64 0, i64 0), i64 256)
	%3 = getelementptr inbounds [256 x i8], [256 x i8]* %tmp_b, i64 0, i64 0
	%4 = call i8* @__strcpy_chk(i8* %3, i8* getelementptr inbounds ([ 4 x i8], [ 4 x i8]* @.strAssignString_b, i64 0, i64 0), i64 256)
	ret i32 0 
}
```