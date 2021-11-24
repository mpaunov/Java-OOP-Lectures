package inheritance.randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<E> extends ArrayList<E> {

    public E getRandomElement() {
        int end = super.size();
        Random rand = new Random();
        int randIndex = rand.nextInt(end); // [0, end)
        return remove(randIndex);
    }
}
