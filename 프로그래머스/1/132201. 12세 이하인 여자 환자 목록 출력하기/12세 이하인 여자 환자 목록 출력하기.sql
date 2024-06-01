# 여자환자의 환자이름, 환자번호, 성별코드, 나이, 전화번호를 조회
SELECT
	PT_NAME, PT_NO, GEND_CD ,AGE ,  
# 이때 전화번호가 없는 경우, 'NONE'으로 출력시켜 주시고
    IFNULL(TLNO, 'NONE') as TLNO

# PATIENT 테이블에서
from PATIENT

# 12세 이하인 여자환자의
where AGE <13 and GEND_CD = "W"

# 결과는 나이를 기준으로 내림차순 정렬하고, 나이 같다면 환자이름을 기준으로 오름차순 정렬해주세요.
order by AGE desc, PT_NAME