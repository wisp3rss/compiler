;if(!false)
@.str = private unnamed_addr constant [3 x i8] c"a\0A\00", align 1

define i32 @main() #0 {
  %1 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  %2 = load i32, i32* %1, align 4
  %3 = icmp ne i32 %2, 0
  br i1 %3, label %end_if_1, label %if_1  ;odwrocilo kolejnosc

if_1:                                                ; preds = %0
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0))
  br label %end_if_1

end_if_1:                                                ; preds = %5, %0
  ret i32 0
}

declare i32 @printf(i8*, ...) #1
