##Func Test
Test: 
```
INT a;
a = 2;

func INT foo(){
    PRINT a;
    return 1;
}

func INT foo(INT x){
    FLOAT b;
    b = 4.273;
    PRINT b;
    return b;
}

a = 10;

func INT foo(INT x, BOOL y){
    FLOAT b;
    b = 4.273;
    
    IF(b >= 4.2){
        PRINT b;
    }
    ELSE {
        PRINT 
    }
    
    return a;
}

foo();
foo(a);
foo(a,true);

=====

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