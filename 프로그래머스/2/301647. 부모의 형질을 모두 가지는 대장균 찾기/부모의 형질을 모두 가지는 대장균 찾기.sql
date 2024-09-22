select o.ID, o.GENOTYPE, (select e.GENOTYPE from ECOLI_DATA e where e.ID = o.PARENT_ID) as PARENT_GENOTYPE
from ECOLI_DATA o
where 
# 부모의 형질을 
(select e.GENOTYPE from ECOLI_DATA e where e.ID = o.PARENT_ID)  & o.GENOTYPE
= (select e.GENOTYPE from ECOLI_DATA e where e.ID = o.PARENT_ID) 
order by ID