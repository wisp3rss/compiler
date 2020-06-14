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
%x = alloca i32
store i32 2, i32* %x
store i32 2, i32* %x
%a = alloca i32
%tmp_b = alloca i32
%b = alloca i32
store i32 0, i32* %tmp_b
%a = alloca i32
%tmp_b = alloca i32
%b = alloca i32
store i32 0, i32* %tmp_b
ret i32 0 }
