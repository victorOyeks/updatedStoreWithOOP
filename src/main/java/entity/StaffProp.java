package entity;

public class StaffProp {
    private String name;
    private String position;

    public StaffProp (String name, String position) {
        this.name = name;
        this.position = position;
    }

    public StaffProp() {

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

}
