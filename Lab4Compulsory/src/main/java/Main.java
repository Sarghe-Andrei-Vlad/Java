import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);

        var streets = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> new Street("street"+i,0,nodes[i],nodes[i+1]))
                .toArray(Street[]::new);

        List<Street> streetList = new LinkedList<>();
        for (Street v : streets){
            streetList.add(v);
        }

        streetList.get(0).setLength(3);
        streetList.get(1).setLength(3);
        streetList.get(2).setLength(2);
        streetList.get(3).setLength(2);
        streetList.get(4).setLength(3);
        streetList.get(5).setLength(1);
        streetList.get(6).setLength(1);
        streetList.add(new Street("street7",1,nodes[0],nodes[7]));
        streetList.add(new Street("street8",1,nodes[6],nodes[7]));
        streetList.add(new Street("street9",2,nodes[5],nodes[0]));
        streetList.add(new Street("street10",2,nodes[7],nodes[8]));
        streetList.add(new Street("street11",1,nodes[5],nodes[1]));
        streetList.add(new Street("street12",2,nodes[1],nodes[8]));
        streetList.add(new Street("street13",1,nodes[2],nodes[8]));
        streetList.add(new Street("street14",2,nodes[3],nodes[8]));
        streetList.add(new Street("street15",2,nodes[4],nodes[8]));

        streetList.sort(Street::compareTo);
        streetList.forEach(System.out::println);

        Set<Intersection> nodeSet = new HashSet<>();

        for (Intersection v : nodes) { nodeSet.add(v); }
        nodeSet.add(new Intersection("v0")); //check for duplicates
        nodeSet.forEach(System.out::println);

    }

}
