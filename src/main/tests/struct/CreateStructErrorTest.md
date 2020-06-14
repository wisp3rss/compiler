##Error handling in creating struct
Test: 
```
struct SFoo {
    INT a;
    FLOAT b;
    FLOAT a;
}
```


Wynik po uruchomieniu: 
```
Error: In struct "SFoo" variable already defined.
```