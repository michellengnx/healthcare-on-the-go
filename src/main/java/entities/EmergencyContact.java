package entities;
//TODO: relationship could be enum
public class EmergencyContact {
    String name;
    String phoneNumber;
    String relationship;

    public EmergencyContact(String name, String phoneNumber, String relationship) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
