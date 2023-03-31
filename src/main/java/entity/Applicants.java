package entity;

public class Applicants {

    private String name;
    private Integer age;


    public Applicants (String name, Integer age) {
        this.name = name;
        this.age = age;
        //this.hired = hired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

