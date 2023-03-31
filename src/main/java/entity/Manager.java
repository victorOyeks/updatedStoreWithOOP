package entity;

public class Manager extends StaffProp {
    private String designation;

    public Manager(String name, String position) {
        super(name, position);
    }

    public void hire (Applicants applicant) {
        if (applicant.getAge() >= 25) {
            System.out.println("Congratulations " + applicant.getName()+ ", you have been hired.");
        } else {
            System.out.println("Thank you " + applicant.getName() + ", but you cannot work with us.");
        }
    }

    public void fire(Cashier cashier) {
        if(cashier.getStrikeCount()==2) {
            cashier.setFired(true);
            System.out.println(cashier.getName() + " has been fired.");
        } else {
            System.out.println(cashier.getName() + " cannot be fired.");
        }
    }
}


