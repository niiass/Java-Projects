UPDATE products
SET img = CASE
    WHEN id = 11 THEN 'https://mcdonalds.ge/b9934c9b6e56-resized.png'
    WHEN id = 12 THEN 'https://mcdonalds.ge/f91b2aa18a00-resized.png'
    WHEN id = 13 THEN 'https://mcdonalds.ge/c44b58b83bc2-resized.png'
    WHEN id = 14 THEN 'https://mcdonalds.ge/c7d14ea17c4e-resized.png'
    WHEN id = 15 THEN 'https://mcdonalds.ge/c82755417e61-resized.png'
    WHEN id = 16 THEN 'https://mcdonalds.ge/a08c47be3bd6-resized.png'
    WHEN id = 17 THEN 'https://mcdonalds.ge/01212dc34ff8-resized.png'
    WHEN id = 18 THEN 'https://mcdonalds.ge/7dfd49e1d85f-resized.png'
    WHEN id = 19 THEN 'https://mcdonalds.ge/bb09989baf72-resized.png'
    WHEN id = 20 THEN 'https://mcdonalds.ge/01212dc34ff8-resized.png'
    WHEN id = 21 THEN 'https://mcdonalds.ge/61fb6640a557-resized.png'
    WHEN id = 22 THEN 'https://mcdonalds.ge/1480d991a1b5-resized.png'
    WHEN id = 23 THEN 'https://mcdonalds.ge/da0267c13485-resized.png'
    WHEN id = 24 THEN 'https://mcdonalds.ge/868f7d6fbfa3-resized.png'
    WHEN id = 25 THEN 'https://mcdonalds.ge/94e69e25c389-resized.png'
    WHEN id = 26 THEN 'https://mcdonalds.ge/880ce8f77068-resized.png'
    ELSE img
END
WHERE id IN (11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);
