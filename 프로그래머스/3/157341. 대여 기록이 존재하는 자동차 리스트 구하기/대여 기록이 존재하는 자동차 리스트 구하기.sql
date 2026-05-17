-- 코드를 입력하세요
SELECT distinct a.CAR_ID
from CAR_RENTAL_COMPANY_CAR a join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
on a.car_id = b.car_id
where car_type = "세단" and month(start_date) = 10
order by a.car_id desc
