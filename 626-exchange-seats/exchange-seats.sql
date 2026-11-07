SELECT case 
when id % 2 = 1 and id!= (SELECT MAX(id) FROM Seat)
    then id + 1
when id % 2 =0
    then id-1
ELSE id
END AS id,
    student
FROM Seat
ORDER BY id;