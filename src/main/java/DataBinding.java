import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataBinding {
    public static void main(String[] args) {
        DataBinding tester = new DataBinding();
        try {
            ObjectMapper mapper = new ObjectMapper();

            Map<String, Object> studentDataMap = new HashMap<>();
            int[] marks = {1, 2, 3};

            Student student = new Student();
            student.setAge(10);
            student.setName("Mahesh");
            // JAVA Object
            studentDataMap.put("student", student);
            // JAVA String
            studentDataMap.put("name", "Mahesh Kumar");
            // JAVA Boolean
            studentDataMap.put("verified", Boolean.FALSE);
            // Array
            studentDataMap.put("marks", marks);

            mapper.writeValue(new File("src/main/resources/studentBinding.json"), studentDataMap);
            //result student.json
            //{
            //   "student":{"name":"Mahesh","age":10},
            //   "marks":[1,2,3],
            //   "verified":false,
            //   "name":"Mahesh Kumar"
            //}
            studentDataMap = mapper.readValue(new File("src/main/resources/studentBinding.json"), Map.class);

            System.out.println(studentDataMap.get("student"));
            System.out.println(studentDataMap.get("name"));
            System.out.println(studentDataMap.get("verified"));
            System.out.println(studentDataMap.get("marks"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}