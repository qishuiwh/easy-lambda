package pers.fancy.lambda.basic;

/**
 * 作用描述：
 *
 * @auther: Administrator
 * @date: 2018/10/26 0026 21:52
 */
public class Person {
    private int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
