package StartAtGoogle.VisitorDesignPattern;

class User implements Data {
    private final int id;
    private final String name;
    private final String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public void exportToJson(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
