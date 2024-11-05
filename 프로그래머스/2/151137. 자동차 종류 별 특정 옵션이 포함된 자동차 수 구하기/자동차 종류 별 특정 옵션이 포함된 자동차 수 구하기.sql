select CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS LIKE "%통풍시트%" OR OPTIONS LIKE "%열선시트%" or OPTIONS LIKE "%가죽시트%"
group by CAR_TYPE
ORDER BY CAR_TYPE