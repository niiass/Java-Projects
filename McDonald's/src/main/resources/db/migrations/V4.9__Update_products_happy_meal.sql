UPDATE products
SET img = CASE
    WHEN id = 95 THEN 'https://mcdonalds.ge/86454fd1a4db-resized.png'
    WHEN id = 96 THEN 'https://mcdonalds.ge/add819b2b523-resized.png'
    WHEN id = 97 THEN 'https://mcdonalds.ge/3a047c095c26-resized.png'
    WHEN id = 98 THEN 'https://mcdonalds.ge/a6cd3a446f06-resized.png'
    WHEN id = 99 THEN 'https://mcdonalds.ge/9f43a864d99d-resized.png'
    ELSE img
END
WHERE id IN (95, 96, 97, 98, 99);