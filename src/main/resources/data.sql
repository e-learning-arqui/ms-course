-- Insertando categoría(s
INSERT INTO CATEGORY (CATEGORY_NAME, DESCRIPTION)
VALUES
    ('Tecnología', 'Cursos relacionados con la tecnología'),
    ('Ciencias Sociales', 'Cursos relacionados con ciencias sociales'),
    ('Arte y Diseño', 'Cursos de arte y diseño'),
    ('Idiomas', 'Cursos relacionados con la enseñanza de idiomas'),
    ('Matemáticas', 'Cursos de matemáticas avanzadas y básicas'),
    ('Ciencias Naturales', 'Cursos sobre biología, química, física y más'),
    ('Negocios y Finanzas', 'Cursos sobre administración, finanzas y negocios'),
    ('Salud y Bienestar', 'Cursos relacionados con la salud física y mental');

-- Insertando subcategorías. Asegurándonos de que los IDs de categoría sean correctos.

-- Tecnología
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Programación', 'Cursos de programación', 1),
    ('Diseño Web', 'Cursos de diseño web', 1),
    ('Redes', 'Cursos de redes y comunicación', 1),
    ('Seguridad Informática', 'Cursos sobre seguridad en la red', 1);

-- Ciencias Sociales
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Historia', 'Cursos de historia', 2);

-- Arte y Diseño
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Dibujo', 'Cursos de dibujo', 3),
    ('Pintura', 'Cursos de pintura', 3);

-- Idiomas
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Inglés', 'Cursos de inglés para todos los niveles', 4),
    ('Francés', 'Cursos de francés', 4),
    ('Mandarín', 'Cursos de mandarín', 4);

-- Matemáticas
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Álgebra', 'Cursos de álgebra básica y avanzada', 5),
    ('Cálculo', 'Cursos de cálculo diferencial e integral', 5);

-- Ciencias Naturales
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Biología', 'Cursos de biología general', 6),
    ('Física Cuántica', 'Cursos avanzados de física', 6);

-- Negocios y Finanzas
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Administración de Empresas', 'Cursos sobre administración y gestión', 7),
    ('Contabilidad', 'Cursos sobre contabilidad y auditoría', 7);

-- Salud y Bienestar
INSERT INTO SUB_CATEGORY (SUB_CATEGORY_NAME, DESCRIPTION, CATEGORY_ID)
VALUES
    ('Yoga', 'Cursos para practicar y aprender yoga', 8),
    ('Meditación', 'Cursos para aprender a meditar', 8);



-- languages
INSERT INTO LANGUAGE (NAME)
VALUES
    ('Mandarín'),
    ('Español'),
    ('Inglés'),
    ('Hindi'),
    ('Árabe'),
    ('Bengalí'),
    ('Portugués'),
    ('Ruso'),
    ('Japonés'),
    ('Panyabí');

-- level
INSERT INTO LEVEL_COURSE (LEVEL_NAME, DESCRIPTION)
VALUES
    ('Básico', 'Para quienes están comenzando o tienen un conocimiento mínimo del tema.'),
    ('Inicial', 'Para quienes tienen una comprensión básica y buscan consolidar fundamentos.'),
    ('Medio', 'Para quienes ya tienen una buena base y buscan profundizar en el tema.'),
    ('Avanzado', 'Para quienes ya tienen un dominio considerable y buscan especializarse o perfeccionarse.');
-- SUBSCRIPTION_TYPE
INSERT INTO SUBSCRIPTION_TYPE (SUBSCRIPTION_TYPE, PRICE, DURATION, DESCRIPTION)
VALUES
    ('Free tryal', 0.00, 'WK', 'Full access for 1 week.'),
    ('1 Month Pass', 19.99, 'MTH', 'Full access for 1 month.'),
    ('3 Month Pass', 49.99, 'QTR', 'Full access for 3 months.'),
    ('Annual Pass', 199.99, 'YR', 'Full access for 1 year.');
INSERT INTO ASSIGNMENT_TYPE (DESCRIPTION)
VALUES
    ('EXAMEN'),
    ('CUESTIONARIO'),
    ('TAREA');

