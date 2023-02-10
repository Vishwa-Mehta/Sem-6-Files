// 
// Decompiled by Procyon v0.5.36
// 

//package classPrograms;

public class Employee
{
    private String name;
    private int id;
    private double salary;
    
    public Employee(final String n, final int i, final double s) {
        this.name = n;
        this.id = i;
        this.salary = s;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String n) {
        this.name = n;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int i) {
        this.id = i;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(final double s) {
        this.salary = s;
    }
    
    public void raise(final double per) {
        this.salary += this.salary * per;
    }
    
    public static void main(final String[] args) {
    }
}
