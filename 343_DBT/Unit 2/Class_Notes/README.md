# Query compilation:
1. Parsing - parse tree created
2. Query rewrite - algebraic expression representation of the query
3. physical plan generated based on the logical plan
4. execute the query plan

Ex. 
```sql
SELECT Name, Salary FROM Employee WHERE ID = 123;
```
Logical plan: 
```math
$\pi Pi/Sigma notation
```
Physical plan: 