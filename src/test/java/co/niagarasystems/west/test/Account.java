package co.niagarasystems.west.test;

public class Account implements java.io.Serializable {

    /**
     * ID
     */
    private static final long serialVersionUID = 1600446427355803778L;

    private String user;
    private String password;
    private Person person;


    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Account withUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Account withPassword(String password) {
        this.password = password;
        return this;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Account withPerson(Person person) {
        this.person = person;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (user != null && !"".equals(user))
            sb.append("\"user\":\"").append(user).append("\", ");
        if (password != null && !"".equals(password))
            sb.append("\"password\":\"").append(password).append("\", ");
        if (person != null) {
            sb.append("\"person\":").append(person.toString()).append(", ");
        }
        sb.delete(sb.toString().length() - 2, sb.toString().length()).append("}");
        return sb.toString();
    }

}
