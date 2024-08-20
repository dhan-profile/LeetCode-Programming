# Write your MySQL query statement below
select t1.firstName, t1.lastName, t2.city, t2.state from Person t1 left join Address t2 on t1.personId = t2.personId;