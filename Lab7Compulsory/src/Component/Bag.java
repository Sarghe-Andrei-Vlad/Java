package Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        Random random = new Random();

        for (char c = 'a'; c <= 'z'; c++) {
            Tile tile = new Tile(c,random.nextInt(10));
            for(int i=0; i<10; i++){
                letters.add(tile);
            }
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random random= new Random();

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            int extractedLetterNumber = random.nextInt(letters.size());
            extracted.add(letters.get(extractedLetterNumber));
            letters.remove(extractedLetterNumber);
        }

        return extracted;
    }
}