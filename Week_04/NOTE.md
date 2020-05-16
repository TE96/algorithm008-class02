# 学习笔记

## BFS 代码模板

```python
def BFS(graph, start, end):
    visited = set()
	queue = [] 
	queue.append([start]) 

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```

## DFS 代码模板

```python
visited = set() 

"""递归写法"""
def dfs(node, visited):
    if node in visited: # terminator
    	# already visited 
    	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)

"""非递归写法"""
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```

## 二分查找代码模板

```python
left, right = 0, len(array) - 1 
while left <= right: 
    mid = (left + right) / 2 
    if array[mid] == target: 
        # find the target!! 
        break or return result 
    elif array[mid] < target: 
        left = mid + 1 
    else: 
        right = mid - 1
```

关于二分查找边界条件：

1. 中间索引mid可以写成`mid = left + (right - left) / 2 `防止整数溢出
2. 如果递增序列A有重复元素，需要找到第一个大于等于给定值x的位置L以及第一个大于x的位置R，即x的存在区间为左闭右开[L, R)，这两个问题都是在寻找有序序列中**第一个**满足某条件的元素位置（如果要寻找**最后一个**满足条件C的元素位置，可以先求第一个满足条件!C的元素位置，然后将位置-1），在进行比较时：
   - 求解L时（lower_bound问题）：
     - `A[mid] ≥ x`，则第一个≥x的元素一定在mid或mid左侧，继续查找有`right = mid`
     - `A[mid] < x`，则继续查找有`left = mid + 1`，由于没有等号，可以排除mid。
     - 循环条件为`left < right`，因为不需要假定x存在，当`left == right`时就是需要的结果，返回值可以选择其中一个
     - 二分查找的下界一定是0，上界根据问题判断是n还是n-1，如果要查询的元素可能比序列中所有元素都大，则选择n（此时n为应该在的位置）
   - 求解R时（upper_bound问题）：
     - `A[mid] > x`，则第一个大于x的元素一定在mid处或者mid左侧，继续查找有`right = mid`
     - `A[mid] ≤ x`时，则第一个大于x的元素一定在mid的右侧，继续查找有`left = mid + 1`
     - 循环条件与上面相同，`left == right`时就是要找的位置
     - 上下界和上面相同

