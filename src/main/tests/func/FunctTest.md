##Func Test
Test: 
```
INT a;
func INT foo(){
    PRINT a;
    return 1;
}

func INT foo(INT a){
    return a;
}

func INT foo(INT a, BOOL b){
    return a;
}

foo();
foo(a);
foo(a,true);

a = foo();
a = foo(2);
a = foo(3,true);
a = foo(a,true);

a = foo() + 5;
a = foo(2) + foo(3,true);

IF(!foo(3)){}
IF(foo() >= 0){}
IF(foo(a,true) != 0){}
IF(foo() < foo(5)){}

```

W pliku result.ll:
```llvm

```

Wynik po uruchomieniu: 
```

```