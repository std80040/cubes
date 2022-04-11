import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GameOfCubes {
    static List<Integer> getPossibleStates(int noOfCubesOnTable,int kCubes) {
        return IntStream.of(1,2,kCubes).boxed()
          .map(i -> noOfCubesOnTable - i)
          .filter(newTableCount -> newTableCount >= 0)
          .collect(Collectors.toList());
    }
}