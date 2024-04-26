select count(*) as FISH_count
from FISH_INFO
where DATE_FORMAT(TIME, '%Y') = '2021'