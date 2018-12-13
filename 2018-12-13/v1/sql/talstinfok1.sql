select * from (
select * from tb_con_contract_info 
) where rownum<=5 order by rownum asc
