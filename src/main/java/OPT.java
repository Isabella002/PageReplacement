import java.util.ArrayList;
import java.util.List;

public class OPT extends ReplacementAlgorithm {
    private List<Integer> pageFrames;

    public OPT(int pageFrameCount) {
        super(pageFrameCount);
        pageFrames = new ArrayList<>();
    }

    @Override
    public void insert(int pageNumber) {
        if (!pageFrames.contains(pageNumber)) {
            if (pageFrames.size() >= pageFrameCount) {
                int index = findOptimalPage(pageNumber);
                pageFrames.set(index, pageNumber);
            } else {
                pageFrames.add(pageNumber);
            }
            pageFaultCount++;
        }
    }

    private int findOptimalPage(int pageNumber) {
        int optimalIndex = -1;
        int farthestDistance = -1;

        for (int i = 0; i < pageFrames.size(); i++) {
            int currentPage = pageFrames.get(i);
            int distance = findDistanceToNextReference(pageNumber, i);

            if (distance == -1) {
                return i; // if the current page will not be referenced again then return its index
            } else if (distance > farthestDistance) {
                farthestDistance = distance;
                optimalIndex = i;
            }
        }

        return optimalIndex;
    }

    private int findDistanceToNextReference(int pageNumber, int startIndex) {
        for (int i = startIndex; i < pageFrameCount; i++) {
            if (pageFrames.get(i) == pageNumber) {
                return i - startIndex;
            }
        }
        return -1; // if the page will not be referenced again then return -1
    }

    @Override
    public List<Integer> getPageFrames() {
        return new ArrayList<>(pageFrames);
    }
}
