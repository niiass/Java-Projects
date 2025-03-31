UPDATE products
SET img = CASE
    WHEN id = 27 THEN 'https://mcdonalds.ge/987aafa8815b-resized.png'
    WHEN id = 28 THEN 'https://mcdonalds.ge/16e800db68f9-resized.png'
    WHEN id = 29 THEN 'https://mcdonalds.ge/f752f17ec039-resized.png'
    WHEN id = 30 THEN 'https://mcdonalds.ge/e0265fd25ab8-resized.png'
    WHEN id = 31 THEN 'https://mcdonalds.ge/10af9661c2bf-resized.png'
    ELSE img
END
WHERE id IN (27, 28, 29, 30, 31);