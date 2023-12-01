package data_access;

import entities.Doctor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorDataAccessObjectTest {
    private DoctorDataAccessObject dataAccessObject = new DoctorDataAccessObject(
            "src/test/java/data_access/doctor_data.csv",
            "src/test/java/data_access/service_data.csv");

    @AfterEach
    void resetFile() {
        try {
            String content = Files.readString(Paths.get("src/test/java/data_access/immutable_doctor_data.csv"));
            PrintWriter out = new PrintWriter("src/test/java/data_access/doctor_data.csv");
            out.println(content);
            out.close();
        } catch (IOException e) {
            System.out.println("Error restoring file");
        }
    }

    @Test
    void testGetAvailableDoctors() {
        List<Doctor> availableDoctors = dataAccessObject.getAvailableDoctors();
        Doctor doc1 = availableDoctors.get(0);
        Doctor doc2 = availableDoctors.get(1);
        assertEquals(2, availableDoctors.size());
        assertEquals("doc1", doc1.getUsername());
        assertEquals("doc3", doc2.getUsername());
        assertEquals("X-Ray", doc1.getQualifiedServices().get(0).getName());
        assertEquals("Check", doc1.getQualifiedServices().get(1).getName());
        assertTrue(doc2.getQualifiedServices().isEmpty());
    }

    @Test
    void testSetBusy() {
        List<Doctor> availableDoctors = dataAccessObject.getAvailableDoctors();
        assertEquals(2, availableDoctors.size());
        Doctor doc1 = availableDoctors.get(0);
        dataAccessObject.markAsBusy(doc1);
        availableDoctors = dataAccessObject.getAvailableDoctors();
        assertEquals(1, availableDoctors.size());
        assertEquals("doc3", availableDoctors.get(0).getUsername());
        assertTrue(doc1.isBusy());
    }
}