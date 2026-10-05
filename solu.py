from collections import defaultdict, deque

def social_influence(n, edges, activated, k):
    graph = defaultdict(list)
    indegree = defaultdict(list)
    
    for u, v in edges:
        graph[u].append(v)
        indegree[v].append(u)
    
    active = set(activated)
    steps = 0
    
    while True:
        new_active = set()
        for node in range(n):
            if node not in active:
                count = sum(1 for nei in indegree[node] if nei in active)
                if count >= k:
                    new_active.add(node)
        if not new_active:
            break
        active |= new_active
        steps += 1
    
    return steps, len(active)

# Example Run
print(social_influence(6, [[0,1],[0,2],[1,3],[2,3],[3,4],[4,5]], [0], 2))
# Output: (3, 5)
