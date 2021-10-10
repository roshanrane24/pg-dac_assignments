# Assignment 7

## Q1 Need of memory management?

In CPU scheduling we see that how the CPU can be shared by a set of processes.
As a result of this CPU Utilization, as well as speed of the computer's response
to its users could be improved.  To realize this increase in performance , however,
we must keep several processes in memory that is, we must share memory.
For this Memory management is necessary.

- This technique decides which process will get memory at what time.
- It also keeps the count of how much memory can be allocated to a process.
- It tracks when memory is freed or unallocated and updates the status.
- The memory management function keeps track of the status of each memory locatian,
    either allocated or free
- Subdividing memory to accommodate multiple processes
- Memory needs to be allocated to ensure a reasonable supply of ready processes
    to consume available processor time

## Q2 Assignment: Given free memory partitions of 100K, 500K, 200K, 300K &
## 600K (in order), how would each of the First-fit, Best-fit, and Worst-fit
## algorithms place processes of 212K, 417K, 112K, and 426K (in order)?

### *First Fit*

```
100K    
500K    ***212K***
200K    ***112K***
300K    
600K    ***417K***
```

**426K** Will have to wait util partitions is free.

### *Best Fit*

```
100K    
500K    ***417K***
200K    ***112K***
300K    ***212K***
600K    ***426K***
```

### *Worst Fit* 

```
100K    
500K    ***417K***
200K    
300K    ***112K***
600K    ***212K***
```
**426K** Will have to wait util partitions is free.

## Q3 Which algorithm makes the most efficient use of memory?

Best fit algorithm makes efficient use of memory.
