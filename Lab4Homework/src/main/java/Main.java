import com.github.javafaker.Faker;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.GraphType;
/*import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.SimpleGraph;*/

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        City city = new City();

        var nodes = IntStream.rangeClosed(0, 3)
                .mapToObj(index -> new Intersection(faker.address().city()))
                .toArray(Intersection[]::new);
        List<Intersection> nodeList = new ArrayList<>(Arrays.asList(nodes));

        var streets = IntStream.rangeClosed(0,8)
                .mapToObj(index -> new Street(faker.address().streetName(), index % 3))
                .toArray(Street[]::new);
        List<Street> streetList = new LinkedList<>(Arrays.asList(streets));

        List<Intersection> newSortedList = nodeList.stream()
                .sorted(Comparator.comparing(Intersection::getName)).toList();

        List<Street> sortedStreets = streetList.stream()
                .sorted(Comparator.comparing(Street::getLength)).toList();

        Set<Intersection> intersectionSet = new HashSet<>(Arrays.asList(nodes));

        Map<Intersection, List<Street>> cityMap = new HashMap<>();
        cityMap.put(nodes[0], Arrays.asList(streets));
        System.out.println(cityMap.get(nodes[0]).toString());

        System.out.println(isDuplicateInIntersections(intersectionSet));
        System.out.println(getStreetsLongerThan(streetList, 1).toString());

        Graph<Intersection,Street> graph = new Graph<Intersection, Street>() {
            @Override
            public Set<Street> getAllEdges(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public Street getEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public Supplier<Intersection> getVertexSupplier() {
                return null;
            }

            @Override
            public Supplier<Street> getEdgeSupplier() {
                return null;
            }

            @Override
            public Street addEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean addEdge(Intersection intersection, Intersection v1, Street street) {
                return false;
            }

            @Override
            public Intersection addVertex() {
                return null;
            }

            @Override
            public boolean addVertex(Intersection intersection) {
                return false;
            }

            @Override
            public boolean containsEdge(Intersection intersection, Intersection v1) {
                return false;
            }

            @Override
            public boolean containsEdge(Street street) {
                return false;
            }

            @Override
            public boolean containsVertex(Intersection intersection) {
                return false;
            }

            @Override
            public Set<Street> edgeSet() {
                return null;
            }

            @Override
            public int degreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> edgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public int inDegreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> incomingEdgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public int outDegreeOf(Intersection intersection) {
                return 0;
            }

            @Override
            public Set<Street> outgoingEdgesOf(Intersection intersection) {
                return null;
            }

            @Override
            public boolean removeAllEdges(Collection<? extends Street> collection) {
                return false;
            }

            @Override
            public Set<Street> removeAllEdges(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean removeAllVertices(Collection<? extends Intersection> collection) {
                return false;
            }

            @Override
            public Street removeEdge(Intersection intersection, Intersection v1) {
                return null;
            }

            @Override
            public boolean removeEdge(Street street) {
                return false;
            }

            @Override
            public boolean removeVertex(Intersection intersection) {
                return false;
            }

            @Override
            public Set<Intersection> vertexSet() {
                return null;
            }

            @Override
            public Intersection getEdgeSource(Street street) {
                return null;
            }

            @Override
            public Intersection getEdgeTarget(Street street) {
                return null;
            }

            @Override
            public GraphType getType() {
                return null;
            }

            @Override
            public double getEdgeWeight(Street street) {
                return 0;
            }

            @Override
            public void setEdgeWeight(Street street, double v) {

            }
        };

        for(Intersection x : newSortedList){
            graph.addVertex(x);
        }

        /*for(Intersection x : city.getIntersectionSet()){
            graph.addVertex(x);
        }*/

        System.out.println("The shortest path that we can create is: " + graph.getVertexSupplier());

    }

    public static boolean isDuplicateInIntersections(Set<Intersection> intersections){
        return !(intersections.stream().distinct().toList().size() == intersections.size());
    }

    public static List<Street> getStreetsLongerThan (List<Street> streets, Integer length){
        return streets.stream()
                .filter(street -> street.getLength() > length)
                .collect(Collectors.toList());
    }

}
