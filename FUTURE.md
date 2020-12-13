# Future tasks

- Research Incidence Matrix representation
- Calculate vertex degree (number of edges connected to a vertex)
- Determine if graph has Eulerian Walk (number of odd degree vertices is 0 or 2)
- Export one representation to another
- Optimize graph properties
	- save property so it isn't calculated on every read
	- use lazy init on graph properties
- Implement graph structure
- Implement path finding algorithms
- Implement weighted graph representations
	- find minimum spanning trees
- Implement directed graph representations
- Research Hypergraph representation


# BFS

Pseudocode

```
BFS(startV)   
   Push startV to frontierQueue
   Add  startV to discoveredSet

   while ( frontierQueue is not empty )
      currentV = Pop frontierQueue
      "Visit" currentV
      for each vertex adjV adjacent to currentV
         if ( adjV is not in discoveredSet )
            Push adjV to frontierQueue
            Add  adjV to discoveredSet
```


# DFS

Pseudocode

```
DFS(startV)
   Push startV to stack

   while ( stack is not empty )
      currentV = Pop stack
      "Visit" currentV
      if ( currentV is not in visitedSet )
         Add currentV to visitedSet
         for each vertex adjV adjacent to currentV
               Push adjV to stack
```

Recursive

```
RecursiveDFS(currentV)
   if ( currentV is not in visitedSet )
      Add currentV to visitedSet
      "Visit" currentV
      for each vertex adjV adjacent to currentV
         RecursiveDFS(adjV)
```
