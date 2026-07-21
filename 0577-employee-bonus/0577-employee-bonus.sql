SELECT 
    Employee.name,
    Bonus.bonus
FROM Employee
LEFT JOIN BONUS
ON Employee.empID = Bonus.empID
WHERE Bonus.empID IS NULL OR
Bonus.bonus < 1000;
