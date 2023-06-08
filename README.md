# PageReplacement

Based on the output for this project, we can analyze the performance of each configuration & even discuss which one performed the best.
In each of the outputs it can be noticed that the OPT algorithm performed the best consistently in the page fault count across the different configurations. OPT uses knowledge of future page references & selects the optimal page to replace it with, which results in fewer page faults. 

**Runtime Complexity:**

**FIFO:** O(n)
**LRU:** O(n)
**OPT:** O(n^2)

Overall, OPT performs the best in terms of page fault count. However, its runtime complexity makes it less practical for larger reference strings. FIFO & LRU algorithms provide reasonable performance & have linear time complexity, making them suitable for most scenarios. The best algorithm depends on the specific requirements & constraints of the system in which it will be executed.
