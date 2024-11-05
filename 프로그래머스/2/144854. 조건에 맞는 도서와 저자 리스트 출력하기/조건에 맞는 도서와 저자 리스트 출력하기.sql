-- 코드를 입력하세요
SELECT B.BOOK_ID, A.AUTHOR_NAME, DATE_FORMAT(B.PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from BOOK B JOIN AUTHOR A on B.AUTHOR_ID = A.AUTHOR_ID
where B.CATEGORY like '경제'
ORDER BY B.PUBLISHED_DATE