WITH book_stats AS (
    SELECT
        b.book_id,
        b.title,
        b.author,
        b.genre,
        b.pages,

        COUNT(*) AS total_sessions,

        MAX(rs.session_rating) - MIN(rs.session_rating)
            AS rating_spread,

        SUM(
            CASE
                WHEN rs.session_rating <= 2
                  OR rs.session_rating >= 4
                THEN 1
                ELSE 0
            END
        ) * 1.0 / COUNT(*) AS raw_polarization_score,

        MAX(
            CASE WHEN rs.session_rating >= 4
                 THEN 1 ELSE 0
            END
        ) AS has_high_rating,

        MAX(
            CASE WHEN rs.session_rating <= 2
                 THEN 1 ELSE 0
            END
        ) AS has_low_rating

    FROM books b
    JOIN reading_sessions rs
        ON b.book_id = rs.book_id

    GROUP BY
        b.book_id,
        b.title,
        b.author,
        b.genre,
        b.pages
)

SELECT
    book_id,
    title,
    author,
    genre,
    pages,
    rating_spread,
    ROUND(raw_polarization_score, 2) AS polarization_score

FROM book_stats

WHERE total_sessions >= 5
  AND has_high_rating = 1
  AND has_low_rating = 1
  AND raw_polarization_score >= 0.6

ORDER BY
    polarization_score DESC,
    title DESC;