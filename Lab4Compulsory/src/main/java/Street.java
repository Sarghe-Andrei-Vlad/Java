import java.util.Objects;

public class Street implements Comparable<Street> {

    private String name;
    private Integer length;
    private Intersection node1,node2;

    public Street(String name, Integer length, Intersection node1, Intersection node2) {
        this.name = name;
        this.length = length;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Intersection getNode1() {
        return node1;
    }

    public void setNode1(Intersection i1) {
        this.node1 = node1;
    }

    public Intersection getNode2() {
        return node2;
    }

    public void setI2(Intersection i2) {
        this.node2 = node2;
    }

    @Override
    public int compareTo(Street other) {
        if(this.length>other.length)
            return 1;
        else
        if(this.length<other.length)
            return -1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name) && Objects.equals(length, street.length) && Objects.equals(node1, street.node1) && Objects.equals(node2, street.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, node1, node2);
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", node1=" + node1 +
                ", node2=" + node2 +
                '}';
    }
}
