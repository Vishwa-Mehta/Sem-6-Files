## Secondary Storage:
### Acclerating Access:
- Disk access charac:
	- seek time: positon at cylinder
	- rotational latency: first sector of the block
	- transfer time: time to cross sectors and gaps b/w them
	- **LATENCY**: sum of all 3
- techniques to speed up the access:
	- place blocks together on the same cylinder
		- avoid seek time and rotational latency
	- divide data among several smaller disks than 1 large one
		- more head assemblies increases no of block access/time
	- **mirror** a disk
		- making 2 or more copies
		- for failure
	- use disk-scheduling algo
		- in the OS/DBMS/disk controller to select the order of read/write
		- ex: **elevator algo**
	- pre-fetch blocks to main memory
		- double buffering
- Dominance of I/O Cost:
	- time takeen to perform a disk access >>> time used to manipulate data in main memory
	- no. of access is good approx to the time needed by the I/O

### Index Structure:
- auxiliary stuct used for **faster retrieval** of records based on search criteria
- data file -> to store records of a relation
- may have one or more index files
- each **index associates** values for the **attr of the search key**
- Example:
	- no. of records = 30000
	- record len = 100 bytes
	- block size = 1024 bytes <br>
		blocking factor = 1024/100 = ~10
		no of blocks to store 30000 records = 30000/10 = 3000
		for a **binary search** of 3000 blocks -> no of access = log<sub>2</sub>3000 = ~12 block access
	With ordering key:
	- len of ordering key = 9 bytes
	- len of block addr field = 6 bytes
	- total record len = 9+6 = 15 bytes<br>
		blocking factor for index file = 1024/15 = 68
		no of entries in index file = no of blocks = 3000
		no of blocks req for storing index info = 3000/68 = 45
		**binary search** needs log<sub>2</sub>45 = 6 block access
		total access = 6 + 1 (to retrieve data from data file) = 7 block access
		**this is lesser than serching without an ordering key**
- dense indexing - all entries are mapped in the data file
	- same order in index as in the data file
	- binary sorting is used - on an avg **half** the index blocks are searched to find a key
- sparse index - only the starting of the block in the data files is mapped by the index file
	- less space than dense indexing

### Multiple levels of index:
- putting index on an index to use the first level indexing more efficiently
- Secondary index: when we search using a key that is not a primary key
	- has duplicate values in index
	- unordered
	- does not determine the placement of records in the data file
	- tells curr location of records that was decided by the primary index on some other field
	- **always DENSE**
- repeated values need more space to in the index and data file
- to reduce these values we use indirect secondary index - bucketing that are between the index and the data file
- the buckets have the repeated values together mapped to single index
### Document retrieval and Inverted indexes:
- documents - tuples - has many attributes - each attr has bool value - corresponding to each possible word in the doc 
- sec index on each of the attr
- Instead of creating a separate index for each attribute, the indexes are combined into one, called an **inverted index**
- index uses **indirect buckets** for space eﬃciency
### Index Structure - B-trees:
- balanced tree: all paths from root to leaf have same length
- 3 layers:
	- root
	- intermediate layer
	- leaves
- levels of index = size of file being indexed
- any no of layers possible
- n keys, n+1 pointers
- atleast half the node space in the tree should be full
- read slides

### Hash Tables:
- hash function **h** takes a search/hash key as an argument and computes an integer in the range 0 - B-1 (B - no of buckets)
- bucket array -> array indexed from 0 - B-1 holds headers of B linked lists (one for each bucket)
- if search key = **K**, then record stored by linking to bucket no **h(K)**
> h(K) - [0 - B-1]
- when keys are integers - K mod B, B is a prime or power of 2
- Insertion:
	- get h(K)
	- if space occupied then add an "overflow" block/bucket to the chain and store
- Deletion:
	- remove 
	- check if overflow bucket is there
	- move the key into the actual bucket if exists
- If buckets are fit on one block then only 1 I/O access for lookup and 2 I/Os for insertion and deletion
- If it's more then it takes more I/Os thus we need to keep it no. of blocks per bucket low
- Extensible Hash Table:
	- dynamic hashing - B varies
	- array of pointers to buckets instead of data blocks itself
	- array of pointers can grow
	- len is always a power of 2
	- buckets can share a block if no of records can fit in a block
	- h computes a sequence of k bits for each key
	- buckets = i, no. of values in all buckets = 2<sup>i</sup> 
- Linear Hash Table:
	- no of buckets grow slowly
	- only **one** overflow bucket
	- if more then we increase i value
	- no of bits = ceil(log<sub>2</sub>n)
	- we take the lsb bits here (rightmost)
	- r ~ 1.7n -> to get only 85% of filled buckets
	- m - i-bit binary integer
	- m < n -> insert record
	- m >= n put in the bucket m - 2<sup>i-1</sup>
	- if no room then add overflow bucket
	- if r goes above 1.7n then we increment n and therefore i by 1
- 