# 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름
# 결과는 보호 시작일이 빠른 순
select a.animal_id, a.name
from animal_ins a join animal_outs b on a.animal_id = b.animal_id
where a.datetime > b.datetime
order by a.datetime asc