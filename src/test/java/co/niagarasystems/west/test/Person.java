package co.niagarasystems.west.test;


public class Person implements java.io.Serializable {

    /**
     * ID
     */
    private static final long serialVersionUID = 3807272414541776324L;


    private String name;
    private String id;
    private String email;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Person withId(String id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Person withEmail(String email) {
        this.email = email;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (name != null && !"".equals(name))
            sb.append("\"name\":\"").append(name).append("\", ");
        if (id != null && !"".equals(id))
            sb.append("\"id\":\"").append(id).append("\", ");
        if (email != null && !"".equals(email))
            sb.append("\"email\":\"").append(email).append("\", ");
        sb.delete(sb.toString().length() - 2, sb.toString().length()).append("}");
        return sb.toString();
    }

}
