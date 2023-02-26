import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WriteAndReadObject {
    public static void main(String[] args) {
        WriteAndReadObject tester = new WriteAndReadObject();
        try {
            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            tester.writeJSON(student);

            Student student1 = tester.readJSON();
            System.out.println(student1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeJSON(Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("src/main/resources/student.json"), student);
    }

    private Student readJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File("src/main/resources/student.json"), Student.class);
    }
}