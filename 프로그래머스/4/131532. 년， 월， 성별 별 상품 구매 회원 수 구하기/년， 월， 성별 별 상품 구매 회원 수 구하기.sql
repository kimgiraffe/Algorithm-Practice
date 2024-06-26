SELECT YEAR(S.SALES_DATE) AS YEAR, MONTH(S.SALES_DATE) AS MONTH, GENDER, COUNT(DISTINCT U.USER_ID) AS USERS
FROM USER_INFO U
JOIN ONLINE_SALE S
ON U.USER_ID = S.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR, MONTH, GENDER
ORDER BY YEAR, MONTH, GENDER