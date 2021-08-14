package kr.or.connect.spring;

/**
 * [Bean 클래스의 규칙]
 * 1. 기본 생성자를 가지고 있다.
 * 2. 필드는 private하게 선언한다.
 * 3. Getter, Setter 메소드를 가지고 있다.
 * - getName(), setName() 메소드를 name 프로퍼티(property)라고 한다.
 */
public class UserBean {

    //필드는 private한다.
    private String name;
    private int age;
    private boolean male;

    //기본생성자를 반드시 가지고 있어야 한다.
    public UserBean() {
    }

    public UserBean(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    //setter, getter 메소드는 프로퍼티라고 한다.
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }
}
