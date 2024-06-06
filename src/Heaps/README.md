# Let's Understand Heap

## Table Of Contents:
1. [Full and Complete BT](#full-binary-tree)  
2. [Heaps](#heaps)
3. [Heap Misconception](#heap-misconception)
4. [Representation of Heap](#representation-of-heap)
5. [Deletion in a Heap](#deletion-in-a-heap)
6. [Heapify](#the-heapify-method)
7. [HeapSort](#heapsort)
***
Before getting into `heap` let's first understand
 - Full binary tree
 - Complete binary tree

### Full Binary Tree:

- A tree is said to be full binary tree if `Every node has either 0 or 2 children only`  
Eg:  
```text
            6                                       1
        /       \                               /       \
       4         5                             4         5
    /     \    /     \                      /     \
   2       0  1       3                    6       7 

```  
  
### Complete Binary Tree:

- A tree is said to be a `complete binary tree` if:
1. All the levels are fully filled but the last level is an exception, it may or may not be filled.
2. It has to be filled from left to right (i.e) there must exist no right node without left node.  

Example of `CBT`:
```text
            6                                       1
        /       \                               /       \
       4         5                             4         5
    /     \                                  /     
   2       0                                6       
```  
Example for not a `CBT`:
```text
1.       6                             2.          1
        /                                      /       \
       4                                      4         5
    /     \                                    \      /   \
   2       0                                    6    7     8
```    
- `1` is not a `CBT` because it doesn't satisfy the 1st condition as the 2nd level is not fully filled.
- `2` is ont a `CBT` because it doesn't satisfy the 2nd condition which is there's no left node for the node `4`.  

**Since we're now aware of `complete` and `full` binary tree's let's move on to `Heaps`.**
***
# Heaps

- Heaps are `complete binary tree`.
- There are two types of `heap` which are `min` and `max` heap.
1. **Min Heap**:  
- The condition for `min heap` is **For every node the parent must be less than all child.**
- The minimum node is the root node.  
Eg: 
```text
         0                                         1
        /                                      /       \
       3                                      4         5
    /     \                                    \      /   \
   4       6                                    6    7     8
```  
2. **Max Heap**:  
- The condition for `max heap` is **For every node the parent node must be greater than all child.**  
- The maximum node is the root node  
Eg:  
```text
            6                                       8
        /       \                               /       \
       4         5                             7         6
    /     \    /     \                      /     \
   2       0  1       3                    5       3 

```   
***
## Heap Misconception:
```text
         60
       /    \
     50     40
    / \    /  \
   45  5  20   30
  / \
 10  30
```

Here we may think that `5` is less than `10` and `30`, so is it not a valid `heap`?   
Here 5 is a child node, the condition for a `max heap` is that **A node must be lesser than all ***it's parent*** node**.  
The parent's of `10` and `30` are `[45, 50, 60]`, and they are lesser than all it's parent.  
So this is a valid heap.
***
## Representation of Heap:
By know you are familiar with `Queue` and `Stack`. Both are themselves a data structures but internally they use array for their implementation.  
Eg:
```java
Queue<Interger> q = new ArrayList<>();
```
  
Similary `Heap` is a **Data Structure** that internally implements `Array`.  
  
**But until now we have seen heap in a tree structure, then how does it implement array? Just doesn't make sense? Yes, just go through and it will make sense.**

Let's take a tree and write it in an array format.
```text
    The Tree:
            A                                       
        /       \                               
       B         C                             
    /     \    /                           
   D       E  F                        
``` 
It is a `CBT`, so it can be qualified as a `Heap`. (leave about min and max)  
Now let's traverse level order and add the elements to an array.  
```text
array = [ A, B, C, D, E, F ]
```  
Now forget about the tree, yes forget it. Now you have this array and if I say we need to convert this array to a tree, how many possibilities do you think exist? Many right.  
Eg:
```text
The Tree:
            A                                       
        /       \                               
       B         C                             
    /     \                               
   D       E 
  /
 F            
```
```text
The Tree:
                           A                                       
                          /                                     
                         B                                      
                        /                                    
                       C        
                      /
                     D
                    /
                   E
                  /
                 F              
```
and a few more.    

**But if I say you need to form only a `Complete Binary Tree` using the array, then? Then there's just one possibility which is:**
```text
            A                                       
        /       \                               
       B         C                             
    /     \    /                           
   D       E  F                        
```  
Because for a `CBT` you form it according to the condition of `CBT`.  

Okayyy.. but what do I infer from this?  
  
When you look at the array 
```text
array = [ A, B, C, D, E, F ]
```  
you can just imagine the tree by just looking at the array. Like  

- 'B' and 'C' are children of 'A'.
- 'D' and 'E' are children of 'B'.
- 'F' is the child of 'C'.
  
We also have formula to find this:  

**Left Child: (2 * i) + 1  
Right Child: (2 * i) + 2  
Parent of a node: (i - 1)/2**  
where 'i' is the index of the node.    

***Now you access the left child, right child or parent of the node just by using the formula.***

**Hence we actually don't need a tree structure for a `Heap`. We can imagine the heap as a tree by implementing it using an array**
***
## Deletion In a Heap:
**Insertion** in a heap is very simple:
1. Add the element to the last
2. Keep pushing the element down until it reaches it's correct place.
  
  
**Deletion** of root is also somewhat similar:
1. Swap the root element with the last element. (because deleting from last is more easier).
2. Now delete the last element.
3. Keep pushing the element down until it reaches it's place.  
Let's look at an example for deletion in max heap.
```text
[*60, 50, 40, 45, 5, 20, 30, 10, 30]

                         60
                       /    \
                     50     40
                    / \    /  \
                   45  5  20   30
                  / \
                 10  30

```

**Step 1.**  
```text
    [30, 50, 40, 45, 5, 20, 30, 10, *60]
    
                             30
                           /    \
                         50     40
                        / \    /  \
                       45  5  20   30
                      / \
                     10  *60
```  
**Step 2.** 
```text
                        [30, 50, 40, 45, 5, 20, 30, 10]
            
                                     30
                                   /    \
                                 50     40
                                / \    /  \
                               45  5  20   30
                              / 
                             10  
```   
**Step 3.**  
Iteration 1:
```text
                        [*30, 50, 40, 45, 5, 20, 30, 10]              
                            
                                *30                                                                               
                               /    \                                             
                             50     40                               
                            / \    /  \                                    
                           45  5  20   30                                  
                          /                                            
                         10                                              
```   
Iteration 2:  
```text
                     [50, *30, 40, 45, 5, 20, 30, 10]
            
                                 50                                                                               
                               /    \                                             
                            *30     40                               
                            / \    /  \                                    
                           45  5  20   30                                  
                          /                                            
                         10                     
```
Iteration 3:  
```text
                     [50, 45, 40, *30, 5, 20, 30, 10]
                     
                                 50                                                                               
                               /    \                                             
                             45     40                               
                            / \    /  \                                    
                          *30  5  20   30                                  
                          /                                            
                         10                     
```  
Same steps is followed for `min heap` as well. Just the push down condition changes.  
***

## The `Heapify` Method:  

- The term for constructing heap is known as `heapify`.   

We were building a perfect heap by just insertion, then why heapify?  
**The time Complexity for insertion method is `O(nlogn)` because a node has to move `logn` steps to reach it's place and it had to be done for all the `n` elements**  

We can optimize it using `heapify` which has time complexity of just `O(n)` 
  
### How heapify works?    
1. Iteratre backwards and get the first **non-leaf element**. (the first non-leaf is the parent of the first leaf).
2. Perform `pushDown` operation on the first **non-leaf element**.
3. Now move to the next element (in reverse ofc) and perform `pushDown`.
4. Keep performing `pushDown` until you reach the root element.

Let's take an example to understand heapify to build a `min heap`:  
```text
                     [90, 80, 70, 20, 10, 50, 60]              
                            
                                 90                                                                               
                               /    \                                             
                             80     70                               
                            /  \   /  \                                    
                           20  10 50   60                                  
                                              
```     
- The first non-leaf node is parent of first leaf node = `(heap.size()-1)-1 / 2` (index of last leaf node's parent).
- Start the operation from this node.  
- `pushDown` - compare the parent node with child nodes, if a child node is greater, then swap.  
```text
                      [90, 80, *70, 20, 10, 50, 60]                          
                            
                                 90                                                                               
                               /    \                                             
                             80    *70                               
                            /  \   /  \                                    
                           20  10 50   60                                                                
```    
- Compare `70` with `50` and `60`. `50` is lesser than `70`, so swap.
```text
                      [90, *80, 50, 20, 10, 70, 60]                             
                            
                                 90                                                                               
                               /    \                                             
                            *80      50                               
                            /  \    /  \                                    
                           20  10  70   60                                                      
```        
`50` is lesser than both it's child, so stop.  

- Now move the next element `80`
- Compare `80` with `20` and `10`. `10` is lesser, so swap.  
```text
                      [90, *10, 70, 20, 10, 50, 60]                               
                            
                                 90                                                                               
                               /    \                                             
                            *10      50                               
                            /  \    /  \                                    
                           20  80  70   60                                                     
```          

- Take the next element `90`.
```text
                      [*90, 10, 70, 20, 10, 50, 60]                               
                            
                                *90                                                                               
                               /    \                                             
                             10      50                               
                            /  \    /  \                                    
                           20  80  70   60                                                     
```     
- Compare `90` with its children and keep performing `pushDown` until its in right position
```text
                      [*10, 90, 70, 20, 10, 50, 60]                               
                            
                                *10                                                                               
                               /    \                                             
                             90      50                               
                            /  \    /  \                                    
                           20  80  70   60                                                     
``` 
```text
                      [*10, 90, 70, 20, 10, 50, 60]                               
                            
                                *10                                                                               
                               /    \                                             
                             20      50                               
                            /  \    /  \                                    
                           90  80  70   60                                                     
```   
Now we have our final `min heap`
***

## HeapSort:  
To perform heapsort you first need to know `heapify` and `deletion` in a heap.  
We have come across both the methods, so let's move on to `heapsort`.  

### Steps in `HeapSort`.  
1. First `heapify` the array to `min heap` for `Descending order` or `max heap` for `Ascending order`.  
2. Now perform the same methods as in `Deletion` but don't remove the last element.  
Eg:  
```text 
//min heap
[10, 20, 50, 90, 80, 70, 60] 

//first iteration
[60, 20, 50, 90, 80, 70, 10]  - after swapping with last idx (size-1)
now in deletion we would remove this 10
But for heapsort keep the 10 and go for next iteration upto (i < size-1)

//2nd iteration
[20, 60, 50, 90, 80, 70, 10] - after pushDown
[70, 60, 50, 90, 80, 20, 10] - after swapping with last idx (as here last idx should be size-2)
.
.
[90, 80, 70, 60, 50, 20, 10] - this will how the array look after heap sort
```  
This happens because after every iteration we are moving the min element to the last.