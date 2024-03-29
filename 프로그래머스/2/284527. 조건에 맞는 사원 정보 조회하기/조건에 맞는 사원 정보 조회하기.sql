SELECT SUM(G.SCORE) AS SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL 
FROM HR_EMPLOYEES AS E 
INNER JOIN HR_DEPARTMENT AS D ON E.DEPT_ID = D.DEPT_ID 
INNER JOIN HR_GRADE AS G ON E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO ORDER BY SCORE DESC LIMIT 1