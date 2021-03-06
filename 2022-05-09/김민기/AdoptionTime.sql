-- 프로그래머스
-- 입양 시각 구하기(2)

WITH RECURSIVE TIME AS(
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR+1 FROM TIME WHERE HOUR<23
)

SELECT HOUR, COUNT(ANIMAL_ID)
FROM TIME
LEFT OUTER JOIN ANIMAL_OUTS
ON HOUR(DATETIME) = TIME.HOUR
GROUP BY HOUR
ORDER BY HOUR
