package data_access;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import entities.Doctor;
import entities.Review;
import entities.Service;

import javax.print.Doc;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DoctorDataAccessObject {
    private final String doctorFilePath;
    private final String servicesFilePath;
    private final List<Doctor> doctorList = new ArrayList<>();


    /**
     * Create a DoctorDataAccessObject
     *
     * @param doctorFilePath The file path where doctor entities are stored.
     * @param servicesFilePath The file path where available services are stored.
     */
    public DoctorDataAccessObject(String doctorFilePath, String servicesFilePath) {
        this.doctorFilePath = doctorFilePath;
        this.servicesFilePath = servicesFilePath;

        try {
            Map<String, Service> availableServices = getServices();
            FileReader filereader = new FileReader(doctorFilePath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                String username = nextRecord[0];
                String password = nextRecord[1];
                String gender = nextRecord[2];
                Date birthday = new SimpleDateFormat("MM/dd/yyyy").parse(nextRecord[3]);
                String email = nextRecord[4];
                String number = nextRecord[5];
                int id = Integer.parseInt(nextRecord[6]);
                String location = nextRecord[7];
                List<String> certifications = Arrays.asList(nextRecord[8].split(";"));
                boolean isBusy = Boolean.parseBoolean(nextRecord[9]);

                // Only add the service to the doctor's available service if it is also in the service data file
                List<Service> qualifiedServices = new ArrayList<>();
                Service currentSerivce;
                for (String serviceName : nextRecord[10].split(";")) {
                    currentSerivce = availableServices.get(serviceName);
                    if (currentSerivce != null) {
                        qualifiedServices.add(currentSerivce);
                    }
                }

                Doctor newDoctor = new Doctor(
                        username,
                        password,
                        email,
                        number,
                        gender,
                        birthday,
                        id,
                        location,
                        certifications,
                        qualifiedServices
                        );
                newDoctor.setBusy(isBusy);
                doctorList.add(newDoctor);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error accessing doctor data file");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Service> getServices() {
        Map<String, Service> serviceList = new HashMap<>();
        try {
            FileReader filereader = new FileReader(this.servicesFilePath);
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;
            csvReader.readNext();

            while ((nextRecord = csvReader.readNext()) != null) {
                String serviceName = nextRecord[0];
                float servicePrice = Float.parseFloat(nextRecord[1]);
                serviceList.put(serviceName, new Service(serviceName, servicePrice));
            }
            return serviceList;
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save() {
        File file = new File(this.doctorFilePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            String[] header = {
                    "username",
                    "password",
                    "gender",
                    "birthday",
                    "email",
                    "number",
                    "id",
                    "location",
                    "certifications",
                    "isBusy",
                    "qualifiedServices"
            };
            writer.writeNext(header);

            for (Doctor doctor : this.doctorList) {
                String username = doctor.getUsername();
                String password = doctor.getPassword();
                String gender = doctor.getGender();
                String birthday = new SimpleDateFormat("MM/dd/yyyy").format(doctor.getBirthday());
                String email = doctor.getEmail();
                String number = doctor.getPhoneNumber();
                String id = doctor.getId_().toString();
                String location = doctor.getLocation();
                StringBuilder certificationsBuilder = new StringBuilder();
                String certifications;
                for (String certification : doctor.getCertifications()) {
                    certificationsBuilder.append(";").append(certification);
                }
                if (!certificationsBuilder.toString().isEmpty()) {
                    certifications = certificationsBuilder.toString().substring(1);
                } else {
                    certifications = "";
                }
                String isBusy = String.valueOf(doctor.isBusy());
                StringBuilder servicesBuilder = new StringBuilder();
                String qualifiedServices;
                for (Service service : doctor.getQualifiedServices()) {
                    certificationsBuilder.append(";").append(service.getName());
                }
                if (!certificationsBuilder.toString().isEmpty()) {
                    qualifiedServices = certificationsBuilder.toString().substring(1);
                } else {
                    qualifiedServices = "";
                }
                String[] doctorData = {
                        username,
                        password,
                        gender,
                        birthday,
                        email,
                        number,
                        id,
                        location,
                        certifications,
                        isBusy,
                        qualifiedServices };
                writer.writeNext(doctorData);

            }
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Set a doctor's status to bust, both in memory, and in persistent data.
     *
     * @param doctor Doctor to be marked as busy.
     */
    public void markAsBusy(Doctor doctor) {
        doctor.setBusy(true);
        save();
    }

    /**
     * Get a list of all doctors that aren't marked as busy.
     *
     * @return A list of all doctors that aren't marked as busy.
     */
    public List<Doctor> getAvailableDoctors() {
        List<Doctor> availableDoctors = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (!doctor.isBusy()) {
                availableDoctors.add(doctor);
            }
        }
        return availableDoctors;
    }
}
