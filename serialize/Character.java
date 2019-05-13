package serialize;

import java.io.Serializable;
import java.util.Random;

public class Character implements Serializable {
    private final String name;
    private int age;
    private transient int accesscode;
    static Random random = new Random();

    public Character(String name, int age){
        this.name = name;
        this.age = age;
        this.accesscode = random.nextInt(999999);
    }

    public String getName() {
        return name;
    }

    public int getAccesscode() {
        return accesscode;
    }

    public int getAge() {
        return age;
    }
}
