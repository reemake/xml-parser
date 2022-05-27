import entity.PatientRepository;
import exception.FilenameNotSpecifiedException;
import jaxb.JAXBConverter;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FilenameNotSpecifiedException, JAXBException, FileNotFoundException {

        JAXBConverter jaxbConverter;
        PatientRepository patients;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя XML-файла: ");
        String filename = in.nextLine();
        if (filename.equals(""))
            throw new FilenameNotSpecifiedException("Имя файла не указано!");
        else {
            jaxbConverter = new JAXBConverter(PatientRepository.class);
            patients = jaxbConverter.unmarshall("src/main/resources/" + filename + ".xml");
        }
        System.out.println("Укажите способ сортировки: ");
        String sortBy = in.nextLine();
        if (sortBy.equals("name")) {
            patients.sortByLastName();
        }
        else if (sortBy.equals("age")) {
            patients.sortByAge();
        }

        patients.printInfo();
    }
}
