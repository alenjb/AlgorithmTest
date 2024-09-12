# 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요. 자식이 없다면 자식의 수는 0으로 출력해주세요

# PARENT_ID를 기준으로 group으로 묶기
# cnt로 해서 출력
SELECT A.ID, IFNULL((select COUNT(B.PARENT_ID) FROM ECOLI_DATA B WHERE A.ID = B.PARENT_ID GROUP BY B.PARENT_ID),0) AS CHILD_COUNT
# , 0)
FROM ECOLI_DATA A

