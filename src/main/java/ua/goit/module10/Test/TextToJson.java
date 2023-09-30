package ua.goit.module10.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TextToJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

}
class Customer {
    private String name;
    private Integer age;

    public Customer(String name, Integer age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}



