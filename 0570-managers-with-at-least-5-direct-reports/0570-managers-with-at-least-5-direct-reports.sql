SELECT
    a.name
FROM Employee a
JOIN Employee b
ON a.id = b.managerID
GROUP BY a.name, a.id
HAVING COUNT(b.id) >= 5;