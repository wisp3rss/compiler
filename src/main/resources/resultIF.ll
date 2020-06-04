
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

define i32 @main() #0 {
  %1 = alloca i32, align 4
  %2 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  store i32 5, i32* %2, align 4
  %3 = load i32, i32* %2, align 4

    ; condition
  %4 = icmp eq i32 %3, 5
  br i1 %4, label %if_1, label %end_if_1

    ; if body
if_1:
  %5 = load i32, i32* %2, align 4
  %6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str, i64 0, i64 0), i32 %5)
  br label %end_if_1

    ; next code
end_if_1:
  ret i32 0
}

declare i32 @printf(i8*, ...) #1
