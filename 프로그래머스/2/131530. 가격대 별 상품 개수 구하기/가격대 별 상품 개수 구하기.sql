select 
    case when (0 <=PRICE and 10000>PRICE) then 0
        when (10000 <= PRICE and 20000>PRICE) then 10000
        when (20000 <=PRICE and 30000>PRICE) then 20000
        when (30000 <=PRICE and 40000>PRICE) then 30000
        when (40000 <=PRICE and 50000>PRICE) then 40000
        when (50000 <=PRICE and 60000>PRICE) then 50000
        when (60000 <=PRICE and 70000>PRICE) then 60000
        when (70000 <=PRICE and 80000>PRICE) then 70000
       when (80000 <=PRICE and 90000>PRICE) then 80000
       end as PRICE_GROUP, count(*) as PRODUCTS
       
       from PRODUCT
       
       group by PRICE_GROUP
       order by PRICE_GROUP 
