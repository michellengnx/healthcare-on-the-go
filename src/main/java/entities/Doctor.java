package entities;


import java.util.*;

public class Doctor extends User {
    private final Integer id_;
    private final String location;
    // have one default location or use a random variable?
    // use a location type instead of string?
    private final List<String> certifications;
    // would you use a random method to make up certifications based on request?
    private final List<Service> qualifiedServices;
    // may delete this later on or raise a NonImplemented error
    // as doctors are generated as soon as a request is made
    private final Map<Doctor, List<Review>> reviews = new HashMap<>();

    /**
     * Requires each doctor to have a unique id.
     * @param id_
     * @param location
     */
    public Doctor(String username, String password, String email, String phoneNumber, String gender, Date birthday, Integer id_, String location, List<String> certifications, List<Service> qualifiedServices) {
        super(username, password, email, phoneNumber, gender, birthday);
        this.id_ = id_;
        this.location = location;
        this.certifications = certifications;
        this.qualifiedServices = qualifiedServices;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public List<Service> getQualifiedServices() {
        return qualifiedServices;
    }


}
