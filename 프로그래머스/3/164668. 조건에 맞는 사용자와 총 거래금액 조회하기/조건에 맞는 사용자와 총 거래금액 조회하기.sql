-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD a join USED_GOODS_USER b on a.writer_id = b.user_id
where status = 'DONE'
group by a.writer_id
having total_sales >= 700000
order by total_sales