package StartAtGoogle.VisitorDesignPattern;

public class Group implements Data{
    private final int id;
    private final int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public void exportToJson(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
