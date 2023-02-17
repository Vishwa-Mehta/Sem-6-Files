public class Inheritance{
    public static void main(String[] args){
        Base oBase  = new Base();
        oBase.a = 10;
        oBase.basemethod();
        Derived oDerived = new Derived();
        oDerived.a = 20;
        oDerived.basemethod();
        oDerived.b = 30;
        oDerived.derivedmethod();
        Base oDerBase = new Derived();  // can't access derived class members of Base type,gives err
        oDerBase.a = 20;
        oDerBase.basemethod();
        // oDerBase.b = 30;
        // oDerBase.derivedmethod();
        //Derived oBaseDer = new Base(); Base class objects cannot be stored in derived class        
    }
}
class Base{
    int a;
    void basemethod(){
        System.out.println("Base Class");
    }
}  
class Derived extends Base{
    int b;
    void derivedmethod(){
        System.out.println("Derived Class");
    }
} 
