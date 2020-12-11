# Project Elim

A simple application that reads various graph representations and reports a
range of properties about the graph.


## Usage

Build with `mvn package`

Usage:

```
Usage: java GraphsApp.jar FILE TYPE
	FILE - a file containing valid JSON graph representation
	TYPE - one of the supported graph representations: ADJACENCY_LIST ADJACENCY_MATRIX EDGE_LIST
```

Example: `java -jar .\target\graphs-0.0.1.jar konigsberg.json ADJACENCY_LIST`

Reporting:

Run `mvn site`
See documentation at {project-dir}\target\site\index.html


## Graphs Overview

A graph G is an ordered pair G = (V, E) where V is a finite set of elements (generally referred to as vertices) and E is a set of 2-subsets of V (generally referred to as edges).

It is common to refer to vertices by number, rather than the specific value or object it represents.
These numeric values may then be linked to actual data values elsewhere.

Example graph from the 7 bridges of Konigsberg, 4 land masses (or vertices) and 7 bridges (or edges).

Representing graphs
https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs

Graph variations:
- Weighted
- Directed
- Loops
- Multiple edges

### Edge Lists
Four vertices indexed 0-4 with 7 edges.

[
    [0, 1],
    [0, 1],
    [1, 2],
    [1, 2],
    [0, 3],
    [1, 3],
    [2, 3]
]

Notes:
- A weighted version would have a third element to the array.
- A loop (node connected to itself), can be represented as [0, 0] for example
- Multiple edges can be represented by duplicate entries (as above).
- Directed interprets the order of the pair as one direction.
- Cannot represent a disconnected graph with an isolated vertex.  Similarly, cannot represent a k1 connected graph.

### Adjacency Matrices
Four vertices represented by 4x4 matrix. Entries are typically 0 (not connected) or 1 (connected).
A weighted graph may include the weight value for connected, or null for not connected.
Undirected graph would be symmetric
Directed graph need not be symmetric

[
    [0, 1, 0, 1],
    [1, 0, 1, 1],
    [0, 1, 0, 1],
    [1, 1, 1, 0]
]

Notes:
- A weighted version would represent the edge weight value in each entry, rather than just 0 or 1 to indicate a connection or not

Problem:
How to represent multiple and/or weighted edges?
A weighted graph can use a value or null.  Multiple edges can represent numbers greater than 1.  How could a program distinguish if a graph was weighted or had multiple edges if using this technique?  How could a graph that is both weighted and has multiple edges be represented?  What if the the multiple edges have different weight?


### Adjacency Lists

[
    [1, 1, 3],
    [0, 0, 2, 2, 3],
    [1, 1, 3],
    [0, 1, 2]
]

Weighted could again use pair of values
multiple edges  ... represented ^
Directed - represented ^

