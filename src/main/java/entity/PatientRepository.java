package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientRepository {

    @XmlElement(name = "patient")
    private ArrayList<Patient> patients;

    public void sortByLastName() {
        Collections.sort(patients, Comparator.comparing(Patient::getLastName));
    }

    public void sortByAge() {
        Collections.sort(patients, Comparator.comparing(Patient::getAge));
    }

    public void printInfo() {
        for (int i = 0; i < patients.size(); i++)
            System.out.println(patients.get(i));
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }
}
