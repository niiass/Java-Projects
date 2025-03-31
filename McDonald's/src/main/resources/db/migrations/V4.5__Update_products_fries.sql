UPDATE products
SET img = CASE
    WHEN id = 32 THEN 'https://mcdonalds.ge/e6741386bab0-resized.png'
    WHEN id = 33 THEN 'https://mcdonalds.ge/96d42909af64-resized.png'
    WHEN id = 34 THEN 'https://mcdonalds.ge/23ae553a886d-resized.png'
    WHEN id = 35 THEN 'https://mcdonalds.ge/8645b24f4fa1-resized.png'
    WHEN id = 36 THEN 'https://mcdonalds.ge/94b6026fcd42-resized.png'
    WHEN id = 37 THEN 'https://mcdonalds.ge/2aa93dfd302d-resized.png'
    WHEN id = 38 THEN 'https://mcdonalds.ge/022a3b043b1e-resized.png'
    WHEN id = 39 THEN 'https://mcdonalds.ge/a7c4e04b95e1-resized.png'
    WHEN id = 40 THEN 'https://mcdonalds.ge/63ef9cc11871-resized.png'
    WHEN id = 41 THEN 'https://mcdonalds.ge/9d32cf2319f6-resized.png'
    WHEN id = 42 THEN 'https://mcdonalds.ge/f8fa79a0fa25-resized.png'
    WHEN id = 43 THEN 'https://mcdonalds.ge/beeed646f451-resized.png'
    WHEN id = 44 THEN 'https://mcdonalds.ge/dd5a508efaf7-resized.png'
    WHEN id = 45 THEN 'https://mcdonalds.ge/da1c1d6a351e-resized.png'
    ELSE img
END
WHERE id IN (32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45);
