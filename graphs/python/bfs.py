# Current version is flimsy & unrefactored code to practice algorithm design

# Lists do not dequeue effeciently (requires position updates)
from collections import deque

# Graph is implemented using an adjacency list (instead of adj matrix)
class Graph:

    def __init__(self):
        self.adj_list = {}

    def add_edge(self, start, end):
        if start in self.adj_list:
            self.adj_list[start].append(end)
        else:
            self.adj_list[start] = [end]

    # Print nodes using a bfs, starting from s
    # s is the index of the node in adj_list
    def print_bfs(self, s = 0):
        # Discovered is a list tracking if nodes have been explored
        discovered = [False] * len(self.adj_list)
        # Create to-explore queue with starting node
        queue = deque([s])
        # Continue exploring until to-explore queue is empty
        while len(queue) > 0:
            # Get next node to explore in this layer
            explore = queue.popleft()
            # Mark node as explored so it is not re-entered into the queue
            discovered[explore] = True
            print('exploring: ' + str(explore))
            # Add all unexplored adj nodes for discovery in next layer
            for adj in self.adj_list[explore]:
                if (discovered[adj] == False):
                    queue.append(adj)

print('---FIRST TEST---')
first = Graph()
first.add_edge(0, 1)
first.add_edge(1, 0)
first.add_edge(1, 2)
first.add_edge(2, 1)
first.add_edge(2, 3)
first.add_edge(3, 2)
first.print_bfs()

print('---SECOND TEST---')
second = Graph()
second.add_edge(0, 1)
second.add_edge(0, 2)
second.add_edge(1, 2)
second.add_edge(2, 0)
second.add_edge(2, 3)
second.add_edge(3, 3)
second.print_bfs(2)
