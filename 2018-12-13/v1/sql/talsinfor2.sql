SELECT count(*) from tb_con_contract_info

--tblstinfo table
select * from (
select * from TB_LST_INFO 
) where rownum<=5 order by rownum asc

select * from tb_con_contract_info t where t.contract_id='5AF812FCFC2100CAE05010AC57DD7D12'






--contract table info±í

select 'ÒµÎñcontract' biz_type,
            t.product_type,
            '' apply_id,
            t.amount_detail_id,
                 t.CONTRACT_ID,
                 t.CONTRACT_NUM,
                 t.CONTRACT_AMT,
                 t.CON_BALANCE,
                 t.CREDIT_MODE,
                 nvl(tls.con_yu_e,0) as con_yu_e,
                 t.CURRENCY_CD as CURRENCY_CD,
                 to_char(t.BEGIN_DATE, 'yyyy-mm-dd') as BEGIN_DATE,
                 to_char(t.END_DATE, 'yyyy-mm-dd') as END_DATE
		        from tb_con_contract_info t
		        left join (select sum(nvl(jjye,0)) as con_yu_e,CONTRACT_ID from tb_loan_summary where summary_status_cd!='09'  group by CONTRACT_ID) tls on t.CONTRACT_ID=tls.CONTRACT_ID
		       where t.CON_STATUS = '03'
           
--print contract table


SELECT * FROM (

  SELECT 
    '' PERIOD_NUM,
    CONTRACT_NUM num,
    '00' con_type,
    PRODUCT_TYPE,
    CONTRACT_AMT amt,
    TO_CHAR( BEGIN_DATE, 'yyyy-MM-dd' ) BEGIN_DATE,
    TO_CHAR( END_DATE, 'yyyy-MM-dd' ) END_DATE,
    contract.currency_cd,
    contract.CONTRACT_DATE,
    tcp.party_name
  FROM
    tb_con_contract_info contract
    LEFT JOIN tb_csm_party tcp ON contract.party_id = tcp.party_id
  WHERE
    contract.CON_STATUS = '03'
    --AND contract.PARTY_ID = #partyId#
  UNION ALL 
   SELECT DISTINCT 
     '' PERIOD_NUM,
     a.subcontract_num num,
     a.subcontract_type con_type,
    '' product_type,
    DECODE( a.if_top_subcon, '1', a.zgbjxe, DECODE( a.subcontract_type, '03', a.bzjje, a.subcontract_amt )) amt,
    TO_CHAR( DECODE( a.if_top_subcon, '1', a.begin_date, c.begin_date ), 'yyyy-mm-dd' ) begin_date,
    TO_CHAR( DECODE( a.if_top_subcon, '1', a.end_date, c.end_date ), 'yyyy-mm-dd' ) end_date,
    a.bz currency_cd,
    c.contract_date,
    tcp.party_name 
  FROM
    tb_con_subcontract a
  INNER JOIN tb_con_subcontract_rel b ON a.subcontract_id = b.subcontract_id
  LEFT JOIN tb_con_contract_info c ON b.contract_id = c.contract_id
  LEFT JOIN tb_csm_party tcp ON a.party_id = tcp.party_id 
  --WHERE  a.CON_PARTY_ID = #partyId#
  AND a.subcontract_status = '03' 
  and a.subcontract_type !='04'
  union all
  SELECT DISTINCT 
     '' PERIOD_NUM,
     a.subcontract_num num,
     a.subcontract_type con_type,
    '' product_type,
    DECODE( a.if_top_subcon, '1', a.zgbjxe, DECODE( a.subcontract_type, '03', a.bzjje, a.subcontract_amt )) amt,
    TO_CHAR( DECODE( a.if_top_subcon, '1', a.begin_date, c.begin_date ), 'yyyy-mm-dd' ) begin_date,
    TO_CHAR( DECODE( a.if_top_subcon, '1', a.end_date, c.end_date ), 'yyyy-mm-dd' ) end_date,
    a.bz currency_cd,
    c.contract_date,
    tc.party_name
  FROM
    tb_con_subcontract a
  INNER JOIN tb_con_subcontract_rel b ON a.subcontract_id = b.subcontract_id
  LEFT JOIN tb_con_contract_info c ON b.contract_id = c.contract_id
  LEFT JOIN (select listagg(tx.party_name,',') within group(order by party_name) as party_name,
                listagg(tx.party_id,',') within group(order by party_name) as party_id, ty.subcontract_id   
            from tb_grt_guarantee_basic tz,
            tb_con_sub_grt_rel ty,tb_csm_party tx
            where tz.surety_id=ty.surety_id
            and tz.party_id=tx.party_id
            and (ty.grt_status !='04' or ty.grt_status is null)
            group by ty.subcontract_id
            ) tc on a.subcontract_id=tc.subcontract_id
  --WHERE  a.CON_PARTY_ID = #partyId#
  AND a.subcontract_status = '03' 
  and a.subcontract_type ='04' 
  UNION ALL 
  SELECT 
    clc.PERIOD_NUM,
    CONTRACT_NUM num,
    clc.LOAN_CHANGE_TYPE con_type,
    ci.PRODUCT_TYPE PRODUCT_TYPE,
    ci.RMB_AMT amt,
    TO_CHAR( ci.BEGIN_DATE, 'yyyy-MM-dd' ) BEGIN_DATE,
    TO_CHAR( ci.END_DATE, 'yyyy-MM-dd' ) END_DATE,
    ci.CURRENCY_CD,
    ci.contract_date,
    tcp.party_name
  FROM
    TB_CON_LOAN_CHANGE clc
  INNER JOIN TB_CON_CONTRACT_INFO ci ON clc.CONTRACT_ID = ci.CONTRACT_ID
  LEFT JOIN tb_csm_party tcp ON ci.party_id = tcp.party_id 
  --WHERE ci.PARTY_ID = #partyId#
  AND clc.CHANGE_STATUS in ('02','03') 
  AND ci.CON_STATUS = '03'
  AND clc.LOAN_CHANGE_TYPE='06'
  UNION ALL
  SELECT 
    '' PERIOD_NUM,
    ci.CONTRACT_NUM num,
      '07' con_type,
      ci.PRODUCT_TYPE PRODUCT_TYPE,
      ci.RMB_AMT amt,
      TO_CHAR( ci.BEGIN_DATE, 'yyyy-MM-dd' ) BEGIN_DATE,
      TO_CHAR( ci.END_DATE, 'yyyy-MM-dd' ) END_DATE,
      ci.CURRENCY_CD,
      ci.contract_date,
      tcp.party_name
    FROM
      tb_Adjust_Margincalls tam
    INNER JOIN TB_CON_CONTRACT_INFO ci ON tam.CONTRACT_ID = ci.CONTRACT_ID
    LEFT JOIN tb_csm_party tcp ON ci.party_id = tcp.party_id 
  --WHERE ci.PARTY_ID = #partyId#
  AND tam.MARGIN_STATUS = '03'     
) t WHERE 1 = 1 

		order by contract_date desc
