SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(B.PRICE * S.SALES) 
FROM AUTHOR A JOIN BOOK B JOIN BOOK_SALES S
WHERE A.AUTHOR_ID = B.AUTHOR_ID AND B.BOOK_ID = S.BOOK_ID AND S.SALES_DATE LIKE '2022-01-%'
GROUP BY B.CATEGORY, A.AUTHOR_ID
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC

