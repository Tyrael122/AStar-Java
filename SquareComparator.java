import java.util.Comparator;

public class SquareComparator implements Comparator<Square> {

    @Override
    public int compare(Square o1, Square o2) {
        return Double.compare(o1.fScore, o2.fScore); // Compares based on the fScore of each square.
        // Returns 0 if they are equal,
        // -1 is the second is greater and
        // 1 if the first is greater.
    }
}
