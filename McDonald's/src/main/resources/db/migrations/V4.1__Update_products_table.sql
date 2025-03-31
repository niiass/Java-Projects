UPDATE products
SET img = CASE 
    WHEN id = 100 THEN 'https://mcdonalds.ge/7b38c2fb71e7.-BEEF%20(1)-resized.png'
    WHEN id = 101 THEN 'https://mcdonalds.ge/f3e068a61b2a.-BEEF%20(1)-resized.png'
    WHEN id = 102 THEN 'https://mcdonalds.ge/b8be68fecff6-resized.png'
    WHEN id = 103 THEN 'https://mcdonalds.ge/423cb56bd4e4-resized.png'
    ELSE img
END
WHERE id IN (100, 101, 102, 103);
