SELECT HOUR(DATETIME) AS 'HOUR', COUNT(*) AS COUNT FROM ANIMAL_OUTS GROUP BY HOUR(DATETIME) HAVING HOUR BETWEEN 9 AND 20 ORDER BY HOUR