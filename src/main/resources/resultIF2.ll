
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

define i32 @main() #0 {
  %1 = alloca i32, align 4
  %2 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  store i32 5, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = icmp eq i32 %3, 5
  br i1 %4, label %if_1, label %if_2

if_1:                                                ; preds = %0
  %6 = load i32, i32* %2, align 4
  %7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 %6)
  br label %if_2

if_2:                                                ; preds = %5, %0
  %9 = load i32, i32* %2, align 4
  %10 = icmp eq i32 %9, 6
  br i1 %10, label %if_3, label %end

if_3:                                               ; preds = %8
  %12 = load i32, i32* %2, align 4
  %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 %12)
  br label %end

end:                                               ; preds = %11, %8
  ret i32 0
}

declare i32 @printf(i8*, ...) #1
