-- 코드를 입력하
# 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역
SELECT b.APNT_NO, a.PT_NAME, a.PT_NO, b.MCDP_CD, c.DR_NAME, b.APNT_YMD
from PATIENT a join appointment b on a.pt_no = b.pt_no
join DOCTOR c on b.mddr_id = c.dr_id
where b.APNT_CNCL_YN = 'N' and date_format(APNT_YMD, "%Y-%m-%d") = "2022-04-13"
order by b.APNT_YMD asc
