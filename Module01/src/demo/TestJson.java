package demo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJson {
    @Test
    public void testJsonBean(){
        Person person = new Person(1, "周三");
        Gson gson = new Gson();
        String toJson = gson.toJson(person);
        System.out.println(toJson);
        Person person1 = gson.fromJson(toJson, Person.class);
        System.out.println(person1);
    }

    @Test
    public void testJsonList(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "周三"));
        list.add(new Person(2, "周五"));
        list.add(new Person(3, "周六"));
        Gson gson = new Gson();
        String toJson = gson.toJson(list);
        System.out.println(toJson);
        List<Person> list2 = gson.fromJson(toJson, new TypeToken<ArrayList<Person>>() {}.getType());
        System.out.println(list2);
    }

    @Test
    public void testJsonMap(){
        Map<String, Person> map = new HashMap<>();
        map.put("p1", new Person(1, "周三"));
        map.put("p2", new Person(2, "周五"));
        map.put("p3", new Person(3, "周六"));
        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        System.out.println(toJson);
        Map<String, Person> list2 = gson.fromJson(toJson, new TypeToken<HashMap<String, Person>>() {}.getType());
        Person p2 = list2.get("p2");
        System.out.println(p2);
    }
}
