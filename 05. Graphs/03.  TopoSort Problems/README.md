####  If at any point the queue becomes empty before all nodes are processed, it indicates a cycle

Start with a queue containing nodes with no incoming edges. 
While the queue is not empty:
Dequeue a node and add it to the topological order. 
For each outgoing edge from the dequeued node, remove the edge.
If removing the edge results in a node having no incoming edges, add that node to the queue. 
