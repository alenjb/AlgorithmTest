SELECT C.ID, D.FISH_NAME, D.LENGTH FROM FISH_INFO C JOIN 
(SELECT B.FISH_NAME, MAX(A.LENGTH) AS LENGTH, A.FISH_TYPE FROM FISH_INFO A JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
GROUP BY A.FISH_TYPE) D
ON C.LENGTH = D.LENGTH AND C.FISH_TYPE = D.FISH_TYPE
ORDER BY C.ID
















# # 물고기 종류별로 가장 큰 물고기의 id, 이름 길이
# select c.id, d.fish_name, c.length
# from fish_name_info d
# join
# (
#     SELECT A.LENGTH, A.Id, a.fish_type
#     FROM FISH_INFO A
#     JOIN 
#     (
#         SELECT FISH_TYPE, MAX(LENGTH) as length
#         FROM FISH_INFO
#         GROUP BY FISH_TYPE
#     ) B ON A.LENGTH = B.LENGTH and a.fish_type = b.fish_type
# ) c on d.fish_type = c.fish_type