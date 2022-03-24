import java.util.AbstractMap;
import java.util.List;
import java.util.Objects;

public class Street implements Comparable<Street>{
    private String name;
    private Integer length;

    AbstractMap.SimpleEntry<Intersection, Intersection> intersectionPair;

    public Street(String name){
        this.name = name;
    }

    public Street(String name, Integer length){
        this.name = name;
        this.length = length;
    }

    public void setIntersectionPair(AbstractMap.SimpleEntry<Intersection, Intersection> intersectionPair) {
        this.intersectionPair = intersectionPair;
    }

    public AbstractMap.SimpleEntry<Intersection, Intersection> getIntersectionPair() {
        return intersectionPair;
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

    @Override
    public int compareTo(Street o) {
        return this.length.compareTo(o.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name) && Objects.equals(length, street.length) && Objects.equals(intersectionPair, street.intersectionPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, length, intersectionPair);
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", intersectionPair=" + intersectionPair +
                '}';
    }
}
