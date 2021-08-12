package Users;

public class Persona {
    Integer id;
    String name;
    String lastName;
    Integer age;
    Long phone;
    String mail;
    Float weight;
    Integer height;

    public Persona(Integer id, String name, String lastName, Integer age, Long phone, String mail, Float weight, Integer height) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.mail = mail;
        this.weight = weight;
        this.height = height;
    }







//GETTERS Y SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
