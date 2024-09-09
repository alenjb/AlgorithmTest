SELECT USER_ID,	PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID , PRODUCT_ID
HAVING COUNT(USER_ID) >=2
ORDER BY USER_ID ASC, PRODUCT_ID DESC
# 유저 아이디가 같고, 상품 아이디가 같은데 세일즈 아이디가 다른 경우
