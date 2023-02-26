import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonObjectMapper {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Dmytro\", \"age\":27}";

        try {
            Student student = mapper.readValue(jsonString, Student.class);
            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}