/*
 * Advantages of Inheritance:
 * Reusability and saves time
 * Enhances Readbility
 * Overriding
 */


public class InheritanceTypes{
    public static void main(String[] args){
        A o1 = new A();
        B o2 = new B();
        C o3 = new C();
        D o4 = new D();
        o2.a = 5;
        o2.b = 10;
        o3.a = 20;
        o3.b = 25;
        o3.c = 25;
        o4.a = 30;
        o4.d = 35;
        o2.methodB();
        //o4.methodA();
        //o3.methodA();
        //o2.methodA();
    }
}
class A{
    int a;
    A(){
        System.out.println("Class A");
    }
    void methodA(){
        System.out.println("Method from Class A");
    }
}
class B extends A{// Single level Inheritance
    int b;
    B(){
        System.out.println("Class B");
    }
    void methodA(){ // overrides the method of the parent class
        super.methodA(); //To access variables and methods from base class i.e A
        System.out.println("Method from Class B");
    }
    void methodB(){
        methodA(); // calls the methodA() in class B
        System.out.println("Method from Class B");
    }

}
class C extends B{ // Multi level Inheritance
    int c;
    C(){
        System.out.println("Class C");
    }
}
class D extends A{ //Hierarchical inheritance : multiple child classes from the same parent
    int d;
    D(){
        System.out.println("Class D");
    }
    void methodA(){
        System.out.println("Method from Class D");
    }
}

