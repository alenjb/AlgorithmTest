-- 코드를 입력하세요
SELECT a.ANIMAL_ID, a.NAME
from ANIMAL_INS a join ANIMAL_OUTS b on a.animal_id = b.animal_id
order by (b.datetime - a.datetime) desc
limit 2