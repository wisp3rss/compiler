;if(a)
@.str = private unnamed_addr constant [3 x i8] c"a\0A\00", align 1

define i32 @main() #0 {
  %1 = alloca i32, align 4
  %2 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  store i32 2, i32* %2, align 4 ;zmienna a
  %3 = load i32, i32* %2, align 4
  %4 = icmp sgt i32 %3, 3       ;
  br i1 %4, label %5, label %7

5:                                                ; preds = %0
  %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0))
  br label %7

7:                                                ; preds = %5, %0
  ret i32 0
}

declare i32 @printf(i8*, ...) #1
