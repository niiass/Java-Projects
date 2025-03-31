UPDATE products
SET img = CASE
    WHEN id = 46 THEN 'https://mcdonalds.ge/c93189d085a1-resized.png'
    WHEN id = 47 THEN 'https://mcdonalds.ge/b4e6062a042d-resized.png'
    WHEN id = 48 THEN 'https://mcdonalds.ge/91be61ac9d4f-resized.png'
    WHEN id = 49 THEN 'https://mcdonalds.ge/b8b429c876c2-resized.png'
    WHEN id = 50 THEN 'https://mcdonalds.ge/faaa4671627b-resized.png'
    WHEN id = 51 THEN 'https://mcdonalds.ge/19d61c624e93-resized.png'
    WHEN id = 52 THEN 'https://mcdonalds.ge/c06e07801bd1-resized.png'
    ELSE img
END
WHERE id IN (46, 47, 48, 49, 50, 51, 52);