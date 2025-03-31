UPDATE products
SET img = CASE
    WHEN id = 90 THEN 'https://mcdonalds.ge/c43cf6656f14-resized.png'
    WHEN id = 91 THEN 'https://mcdonalds.ge/48735a93998f-resized.png'
    WHEN id = 92 THEN 'https://mcdonalds.ge/5ed06a01d913-resized.png'
    WHEN id = 93 THEN 'https://mcdonalds.ge/355f9728d4ef-resized.png'
    WHEN id = 94 THEN 'https://mcdonalds.ge/b545b053a3f3-resized.png'
    WHEN id = 104 THEN 'https://mcdonalds.ge/ac705e059bb2-resized.png'
    WHEN id = 105 THEN 'https://mcdonalds.ge/eba6c3332f42-resized.png'
    WHEN id = 106 THEN 'https://mcdonalds.ge/eb852abd07dd-resized.png'
    WHEN id = 107 THEN 'https://mcdonalds.ge/48842e2729b4-resized.png'
    WHEN id = 108 THEN 'https://mcdonalds.ge/b545b053a3f3-resized.png'
    WHEN id = 109 THEN 'https://mcdonalds.ge/187db452b9ef-resized.png'
    WHEN id = 110 THEN 'https://mcdonalds.ge/12fc8df0ac32-resized.png'
    WHEN id = 111 THEN 'https://mcdonalds.ge/assets/images/mccafe-marker.png'
    WHEN id = 112 THEN 'https://mcdonalds.ge/58c8eced1bb0-resized.png'
    WHEN id = 113 THEN 'https://mcdonalds.ge/ac7dfc8ef111-resized.png'
    WHEN id = 114 THEN 'https://mcdonalds.ge/976bd5d4b60e-resized.png'
    WHEN id = 115 THEN 'https://mcdonalds.ge/ed054e17c7c4-resized.png'
    WHEN id = 116 THEN 'https://mcdonalds.ge/d9a256dbfbc5-resized.png'
    WHEN id = 117 THEN 'https://mcdonalds.ge/56ef28db8ead-resized.png'
    WHEN id = 118 THEN 'https://mcdonalds.ge/48735a93998f-resized.png'
    WHEN id = 119 THEN 'https://mcdonalds.ge/c43cf6656f14-resized.png'
    ELSE img
END
WHERE id IN (90, 91, 92, 93, 94, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119);
