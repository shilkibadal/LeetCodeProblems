# Write your MySQL query statement below
Select MAX(num) as num
from(
    select num
    from MyNumbers
    group by num
    Having count(*)=1
)as test;