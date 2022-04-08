import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GameOfBones {
    static List<Integer> getPossibleStates(int noOfBonesInHeap,int kCubes) {
        return IntStream.of(1,2,kCubes).boxed()
          .map(i -> noOfBonesInHeap - i)
          .filter(newHeapCount -> newHeapCount >= 0)
          .collect(Collectors.toList());
    }
}