# Dynamic-Social-Influence-Network
You are given a directed graph representing a social network of n users (nodes). Each edge (u → v) means user u can influence user v.
Initially, a set of users are "activated" (influenced). At each step:
Any user who has at least k activated incoming neighbors becomes activated.
Once activated, a user stays activated forever.
Return the minimum number of steps required until no new activations occur, and the final count of activated users.

Example
Input:
Code
n = 6, k = 2
edges = [[0,1],[0,2],[1,3],[2,3],[3,4],[4,5]]
activated = [0]

Output:
Code
Steps = 3
Final Activated Count = 5


Explanation:

Step 0: Activated = {0}
Step 1: Users 1,2 get activated (since 0 influences them).
Step 2: User 3 gets activated (since 1 and 2 are active, ≥k=2).
Step 3: User 4 gets activated (since 3 is active).
User 5 never reaches k=2 active neighbors → not activated.
