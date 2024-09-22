select count(*) as FISH_COUNT
from FISH_INFO
where LENGTH is NULL or LENGTH < 10
