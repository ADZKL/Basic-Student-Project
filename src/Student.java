public class Student {
    private String name;
    private String streetAddress;
    private String phoneNumber;

    public Student(String name, String streetAddress, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
