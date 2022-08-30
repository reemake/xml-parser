import validation.FilenameNotSpecifiedException;
import entity.PatientRepository;
import jaxb.JAXBConverter;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Application {

    private static void validateArgs(String[] args) throws FilenameNotSpecifiedException {
        if (args.length == 0) {
            throw new FilenameNotSpecifiedException("Параметры не заданы!");
        }
        else if (args.length == 1)
            if (args[0].equals("age") || args[0].equals("name"))
                throw new FilenameNotSpecifiedException("Имя файла не указано!");
    }

    public static void main(String[] args) throws FilenameNotSpecifiedException, FileNotFoundException, JAXBException {

        try {
            validateArgs(args);

            JAXBConverter jaxbConverter;
            PatientRepository patients;

            String filename = args[0];
            jaxbConverter = new JAXBConverter(PatientRepository.class);
            patients = jaxbConverter.unmarshall("src/main/resources/" + filename + ".xml");

            if (args.length == 2) {
                String sortBy = args[1];
                if (sortBy.equals("name")) {
                    patients.sortByLastName();
                } else if (sortBy.equals("age")) {
                    patients.sortByAge();
                }
            }

            patients.printInfo();

        } catch (JAXBException e) {
            System.out.println(e);;
        } catch (FileNotFoundException e) {
            System.out.println(e);;
        }

    }
}
