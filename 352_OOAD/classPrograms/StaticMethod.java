// 
// Decompiled by Procyon v0.5.36
// 

// package classPrograms;

public class StaticMethod
{
    int a;
    static int b;
    
    void printinfo() {
        System.out.print("a=" + this.a);
        System.out.print("b=" + StaticMethod.b);
    }
}
