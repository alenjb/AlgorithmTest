select a.PRODUCT_ID, a.PRODUCT_NAME, a.PRODUCT_CD, a.CATEGORY, a.PRICE
from FOOD_PRODUCT a
where a.price = (select MAX(b.price) from FOOD_PRODUCT b)
