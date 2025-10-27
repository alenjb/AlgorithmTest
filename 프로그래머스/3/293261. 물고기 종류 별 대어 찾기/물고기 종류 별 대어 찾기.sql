# 물고기 종류별로 가장 큰 물고기의 id, 이름 길이
select c.id, d.fish_name, c.length
from fish_name_info d
join
(
    SELECT A.LENGTH, A.Id, a.fish_type
    FROM FISH_INFO A
    JOIN 
    (
        SELECT FISH_TYPE, MAX(LENGTH) as length
        FROM FISH_INFO
        GROUP BY FISH_TYPE
    ) B ON A.LENGTH = B.LENGTH and a.fish_type = b.fish_type
) c on d.fish_type = c.fish_type