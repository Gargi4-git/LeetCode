WITH ranked_scores AS (
    SELECT
        student_id,
        subject,
        score,
        ROW_NUMBER() OVER (
            PARTITION BY student_id, subject
            ORDER BY exam_date ASC
        ) AS rn_first,
        ROW_NUMBER() OVER (
            PARTITION BY student_id, subject
            ORDER BY exam_date DESC
        ) AS rn_latest,
        COUNT(*) OVER (
            PARTITION BY student_id, subject
        ) AS exam_count
    FROM Scores
)
SELECT
    student_id,
    subject,
    MAX(CASE WHEN rn_first = 1 THEN score END) AS first_score,
    MAX(CASE WHEN rn_latest = 1 THEN score END) AS latest_score
FROM ranked_scores
WHERE exam_count >= 2
GROUP BY student_id, subject
HAVING
    MAX(CASE WHEN rn_latest = 1 THEN score END) >
    MAX(CASE WHEN rn_first = 1 THEN score END)
ORDER BY student_id, subject;