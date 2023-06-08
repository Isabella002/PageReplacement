public class Test {
    public static void main(String[] args) {
        // creating reference strings & configurations
        PageGenerator pageGenerator = new PageGenerator();
        int[][] configurations      = {{10, 3}, {15, 3}, {20, 3}, {10, 5}, {15, 5}, {20, 5}, {10, 7}, {15, 7}, {20, 7}};

        // test for each config
        for (int[] config : configurations) {
            int referenceStringSize = config[0];
            int numPageFrames       = config[1];
            System.out.println("Configuration: Reference String Size=" + referenceStringSize + ", Number of Page Frames=" + numPageFrames);

            int[] referenceString = pageGenerator.getReferenceString();
            // creating instances of each algorithm
            ReplacementAlgorithm fifo = new FIFO(numPageFrames);
            ReplacementAlgorithm lru  = new LRU(numPageFrames);
            ReplacementAlgorithm opt  = new OPT(numPageFrames);
            // process the reference string w/ each algorithm
            for (int i = 0; i < referenceStringSize; i++) {
                fifo.insert(referenceString[i]);
                lru.insert(referenceString[i]);
                opt.insert(referenceString[i]);
            }
            // print page fault count & page frames for each algorithm
            // FIFO
            System.out.println("FIFO - Page Fault Count: " + fifo.getPageFaultCount());
            System.out.println("FIFO - Page Frames: " + fifo.getPageFrames());
            // LRU
            System.out.println("LRU - Page Fault Count: " + lru.getPageFaultCount());
            System.out.println("LRU - Page Frames: " + lru.getPageFrames());
            // OPT
            System.out.println("OPT - Page Fault Count: " + opt.getPageFaultCount());
            System.out.println("OPT - Page Frames: " + opt.getPageFrames());

            System.out.println();
        }
    }
}
