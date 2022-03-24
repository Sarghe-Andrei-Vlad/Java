import java.util.*;

public class City {

    private String name;
    private Set<Intersection> intersectionSet = new HashSet<>();
    private Set<Street> streetSet = new HashSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStreet(Street street) {
        streetSet.add(street);
    }

    public void setIntersectionSet(Set<Intersection> intersectionSet) {
        this.intersectionSet = intersectionSet;
    }

    public void setStreetSet(Set<Street> streetSet) {
        this.streetSet = streetSet;
    }

    public Set<Intersection> getIntersectionSet() {
        return intersectionSet;
    }

    public Set<Street> getStreetSet() {
        return streetSet;
    }

}
