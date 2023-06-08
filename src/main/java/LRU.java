import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LRU extends ReplacementAlgorithm {
    private Map<Integer, Integer> pageFrames;

    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        pageFrames = new LinkedHashMap<>(pageFrameCount, 0.75f, true);
    }

    @Override
    public void insert(int pageNumber) {
        if (!pageFrames.containsKey(pageNumber)) {
            if (pageFrames.size() >= pageFrameCount) {
                int leastRecentlyUsedPage = pageFrames.keySet().iterator().next();
                pageFrames.remove(leastRecentlyUsedPage);
            }
            pageFrames.put(pageNumber, pageNumber);
            pageFaultCount++;
        }
    }

    @Override
    public List<Integer> getPageFrames() {
        return new ArrayList<>(pageFrames.values());
    }
}
