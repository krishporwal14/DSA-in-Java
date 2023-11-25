package Drafts;
class Human {
    String name;
    int age;
    String gender;
    Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void  setAge(int age) {
        this.age = age;
    }
    public void  setGender(String gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
class Student extends Human {
    int rollno;
    String class1;
    int semester;
    float cpi;
    Student(String name, int age, String gender, int rollno, String class1, int semester, float cpi) {
        super(name, age, gender);
        this.rollno = rollno;
        this.class1 = class1;
        this.semester = semester;
        this.cpi = cpi;
    }
    public void  setName(String name) {
        super.setName(name);
    }
    public void  setAge(int age) {
        super.setAge(age);
    }
    public void  setGender(String gender) {
        super.setGender(gender);
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public void setClass1(String class1) {
        this.class1 = class1;
    }
    public void setSem(int semester) {
        this.semester = semester;
    }
    public void setCpi(float cpi) {
        this.cpi = cpi;
    }
    public String getInfo() {
        return "Name= " + getName() + "\n" +
               "Age= " + getAge() + "\n" +
               "Gender= " + getGender() + "\n" +
               "Roll No= " + rollno + "\n" +
               "Class= " + class1 + "\n" +
               "Sem= " + semester + "\n" +
               "CPi= " + cpi;
    }
}

class Faculty extends Human {
    int empid;
    float salary;
    String spec;
    Faculty(String name, int age, String gender, int empid, float salary, String spec) {
        super(name, age, gender);
        this.empid = empid;
        this.salary = salary;
        this.spec = spec;
    }
    public void  setName(String name) {
        super.setName(name);
    }
    public void  setAge(int age) {
        super.setAge(age);
    }
    public void  setGender(String gender) {
        super.setGender(gender);
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public void setSpec(String spec) {
        this.spec = spec;
    }
    public String getInfo() {
        return "Name= " + getName() + "\n" +
               "Age= " + getAge() + "\n" +
               "Gender= " + getGender() + "\n" +
               "Emp ID= " + empid + "\n" +
               "Salary= " + salary + "\n" +
               "Specification= " + spec + "\n";
    }
}

class OopInJava {
    public static void main(String arg[]) {
        Student s1 = new Student("Krish", 18, "Male", 19, "IT", 3, 9.0f);
        System.out.println(s1.getInfo() + "\n");
        System.out.println("----------------------------------------------------------------");
        s1.setAge(22);
        System.out.println(s1.getInfo() + "\n");
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");

        Faculty f1 = new Faculty("Keyur", 21, "Male", 201, 1000000.0f, "Web dev");
        System.out.println(f1.getInfo() + "\n");
        System.out.println("----------------------------------------------------------------");
        f1.setSpec("DBMS");
        System.out.println(f1.getInfo());
        System.out.println("----------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------");
    }
}