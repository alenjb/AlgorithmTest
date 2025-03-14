-- 코드를 입력하세요
# SELECT
# 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로

select B. INGREDIENT_TYPE, SUM(TOTAL_ORDER) as TOATL_ORDER
from FIRST_HALF A, ICECREAM_INFO B 
WHERE A.FLAVOR = B.FLAVOR
group by B.INGREDIENT_TYPE
order by TOTAL_ORDER

# select * from ICECREAM_INFO