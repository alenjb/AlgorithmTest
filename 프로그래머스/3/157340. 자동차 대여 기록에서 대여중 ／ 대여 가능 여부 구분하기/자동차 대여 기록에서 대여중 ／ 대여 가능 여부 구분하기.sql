
SELECT 
    CAR_ID,
    CASE 
        WHEN EXISTS (
            SELECT 1 
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
            WHERE CAR_ID = A.CAR_ID
            AND '2022-10-16' BETWEEN START_DATE AND END_DATE
        ) THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;
# # -- 코드를 입력하세요

# ((SELECT A.CAR_ID, 
# IFNULL((SELECT "대여 가능" FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B
#  WHERE B.HISTORY_ID = A.HISTORY_ID AND ( START_DATE >'2022-10-16' OR END_DATE < '2022-10-16')), "대여중") AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
# GROUP BY A.CAR_ID HAVING AVAILABILITY = "대여중"
# ORDER BY CAR_ID DESC)
# UNION ALL
# (SELECT A.CAR_ID, 
# IFNULL((SELECT "대여 가능" FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B
#  WHERE B.HISTORY_ID = A.HISTORY_ID AND ( START_DATE >'2022-10-16' OR END_DATE < '2022-10-16')), "대여중") AS AVAILABILITY
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
# GROUP BY A.CAR_ID HAVING AVAILABILITY = "대여 가능"
# ORDER BY CAR_ID DESC)

# ORDER BY CAR_ID DESC
# )


# # SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE START_DATE >'2022-10-16' OR END_DATE > '2022-10-16'