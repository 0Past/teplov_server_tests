--
-- Дамп данных таблицы `brand`
--

INSERT INTO brand (id, title) VALUES (1, 'SONY') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (2, 'AMD') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (3, 'Intel') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (4, 'Samsung') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (5, 'Huawei') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (6, 'Apple') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (7, 'Asus') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (8, 'MSI') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (9, 'LG') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (10, 'Nvidia') ON CONFLICT DO NOTHING;
INSERT INTO brand (id, title) VALUES (11, 'BORK') ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `category`
--

INSERT INTO category (id, title) VALUES (1, 'TV') ON CONFLICT DO NOTHING;
INSERT INTO category (id, title) VALUES (2, 'Phone') ON CONFLICT DO NOTHING;
INSERT INTO category (id, title) VALUES (3, 'Camera') ON CONFLICT DO NOTHING;
INSERT INTO category (id, title) VALUES (4, 'Computer accessories') ON CONFLICT DO NOTHING;
INSERT INTO category (id, title) VALUES (5, 'Appliances') ON CONFLICT DO NOTHING;
INSERT INTO category (id, title) VALUES (6, 'Laptop') ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `job`
--
INSERT INTO job (id, title) VALUES (1, 'Manager') ON CONFLICT DO NOTHING;
INSERT INTO job (id, title) VALUES (2, 'Sales consultant') ON CONFLICT DO NOTHING;
INSERT INTO job (id, title) VALUES (3, 'Security') ON CONFLICT DO NOTHING;
INSERT INTO job (id, title) VALUES (4, 'Cleaner') ON CONFLICT DO NOTHING;


--
-- Дамп данных таблицы `employee`
--
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (2, 'ilya.var@mail.ru', 'Илья', '2020-11-15', 'Варламов', 4507110302, 2500.25, 4) ON CONFLICT DO NOTHING;
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (1, 'rob.stone@mail.ru', 'Роберт', '2019-05-11', 'Каменев', 9035110302, 150001, 1) ON CONFLICT DO NOTHING;
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (3, 'alex.krav@mail.ru', 'Алексей', '2018-12-08', 'Кравчук', 9071467302, 70001, 2) ON CONFLICT DO NOTHING;
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (4, 'misha.silence@mail.ru', 'Михаил', '2020-02-10', 'Тихомиров', 9088869302, 35001, 3) ON CONFLICT DO NOTHING;
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (5, 'sumail.eg@mail.ru', 'Сумаил', '2019-12-12', 'Байрамов', 9310860302, 75001, 2) ON CONFLICT DO NOTHING;
INSERT INTO employee (id, email, first_name, hire_date, last_name, phone_number, salary, job_id) VALUES (6, 'anastasia,osipova@mail.ru', 'Анастасия', '2019-08-04', 'Осипова', 9009800302, 88001, 2) ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `customer`
--
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (1, '101C', 145, 'Москва', 'nick.mark@gmail.com', 'Николай', 'Марков', 9098001122, 'Ленинградская,55') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (2, '2218', 0, 'Москва', 'anna.kolos@gmail.com', 'Анна', 'Колосова', 2336622613, 'Гримау,9') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (3, '714', 0, 'Люберцы', 'sofia.zybova@gmail.com', 'Софья', 'Зубова', 2880254096, 'Южная,31А') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (4, '212', 0, 'Москва', 'artem.teplov@gmail.com', 'Артем', 'Теплов', 3108663106, 'Голубинская,24к1') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (6, '901', 1450, 'Москва', 'max.kas@gmail.com', 'Максим', 'Касьянов', 6191600214, 'Песчаная,10') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (7, '66', 1118, 'Москва', 'alex.kozlovski@gmail.com', 'Алексей', 'Козловский', 1307728372, 'Юных Ленинцев,99') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (8, '1A1', 890, 'Москва', 'pavel.belikov@gmail.com', 'Павел', 'Беликов', 9908886952, '1-й Дорожный,3с2') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (9, 'B220', 79, 'Химки', 'kris.mart@gmail.com', 'Кристина', 'Мартынова', 5365496827, 'Маяковского,7') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (10, '511', 12, 'Химки', 'varvara.samo@gmail.com', 'Варвара', 'Самойлова', 3585423673, 'Энгельса,10/21') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (12, '34', 618, 'Москва', 'vlad.chet@gmail.com', 'Владислав', 'Теплов', 7385350219, 'Голубинская,32/2') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (13, '12C', 903, 'Москва', 'farhod.sad@gmail.com', 'Фарход', 'Содиков', 1235550219, 'Ленинградская,49') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (14, '1001', 2140, 'Люберцы', 'bair.badmaev@gmail.com', 'Баир', 'Бадмаев', 4507168875, 'Строителей,4') ON CONFLICT DO NOTHING;
INSERT INTO customer (id, apart, bonus, city, email, first_name, last_name, phone_number, street) VALUES (15, 'A11', 11, 'Москва', 'sergo.maximov@gmail.com', 'Сергей', 'Максимов', 5151183034, 'Советская, 17') ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `delivery_type`
--

INSERT INTO delivery_type (id, title) VALUES (1, 'Курьером до квартиры') ON CONFLICT DO NOTHING;
INSERT INTO delivery_type (id, title) VALUES (2, 'До пункта выдачи') ON CONFLICT DO NOTHING;
INSERT INTO delivery_type (id, title) VALUES (3, 'Самовывоз') ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `item`
--

INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (1, 'золотой', '8K RESOLUTION', NULL, NULL, 'SONY BRAVIA', 649990.9, '7680x4320', 'KD-75ZH8', NULL, NULL, 'Smart TV', '43.1 кг', 1, 1, '960*1672*61') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (2, NULL, 'RTX ядра нового поколения', '1755 МГц', '8 ГБ', 'MSI GeForce RTX 3070 VENTUS 2X OC', 54999.99, '7680x4320', 'MSI VENTUS', NULL, '8 нм', 'Видеокарта', '1.1 кг', 8, 4, '232*52') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (3, NULL, 'TURBO BOOST', '3600 МГц', NULL, 'AMD Ryzen 7 3700X OEM', 23799.99, NULL, 'AMD RYZEN 3000', 'AM4', '7 нм', 'Процессор ', '75 г', 2, 4, '40*40') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (4, 'черный', 'IPS матрица', NULL, NULL, '27\" Монитор LG UltraGear', 27999.99, '2560x1440', '27GL83A-B', NULL, NULL, 'Монитор', '4.2 кг', 9, 4, '615*465*574') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (5, 'белый', 'Ultra HD 4K)', NULL, NULL, 'экшн Sony FDR-X3000R/W', 41699.99, '3840x2160', 'Action Cam', NULL, NULL, 'Экшн-камеры', '114 г', 1, 3, '47*30*83') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (6, 'нерж. сталь/черный', 'Поддон для капель', NULL, NULL, 'Электрогриль Bork G800', 22999.99, NULL, 'Professional', NULL, NULL, 'Электрогриль', '10 кг', 11, 5, '380*490*160') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (7, 'черный', 'Распознавание лиц', NULL, NULL, 'Фотоаппарат системный Sony Alpha 7R III', 199999.99, '7952х5304', 'Alpha A7 M3', NULL, NULL, 'Фотоаппарат', '657 г', 1, 3, '96*127*74') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (8, 'золотой', 'Работа от аккумулятора до 18 часов', '4 ГГц', '512 ГБ', 'Apple MacBook Air 13 M1/16/512 Gold', 138999.99, '2560x1600', 'Z12A', NULL, '5 нм', 'MacBook', '1.29 кг', 6, 6, '16*304*212') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (9, 'тихоокеанский синий', 'Поддержка сетей 5G', '2.99 ГГц', '128 ГБ', 'Apple iPhone 12 Pro Max 128 ГБ синий', 101199.99, '2778×1284', 'iPhone 12', NULL, '5 нм', 'Smart Phone', '226 г', 6, 2, '78*160*7') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (10, NULL, 'Интегрированное графическое ядро', '3700 МГц', NULL, 'Intel Core i9-10900K OEM', 43999.99, NULL, 'Coffee Lake S', 'LGA 1200', '14 нм', 'Процессор', '75 г', 3, 4, '1600') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (11, 'серый', 'Веб-камера под клавиатурой', '2.3 ГГц', '512 ГБ', 'Huawei MateBook D 14', 56999.99, '1920x1080', 'Nbl-WAP9R', NULL, '12 нм', 'ультрабук', '1.38 кг', 5, 6, '214*322*15') ON CONFLICT DO NOTHING;
INSERT INTO item (id, color, feature, frequency, memory_size, name, price, resolution, series, soket, tech_process, type, weight, brand_id, category_id, _size ) VALUES (12, 'черный фантом', '2 SIM', '2.8 ГГц', '128 ГБ', 'Samsung Galaxy S21 Ultra 128 ГБ черный', 109999.99, '3200x1440', 'Galaxy S21', NULL, '5 нм', 'Smart Phone', '226 г', 4, 2, '75*165*9') ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `inventory`
--

INSERT INTO inventory (id, purchase_price, item_id) VALUES (1, 499990.9, 1) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (2, 44999.9, 2) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (3, 13799.9, 3) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (4, 22999.9, 4) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (5, 31699.9, 5) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (6, 17999.9, 6) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (7, 179999.9, 7) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (8, 124999.9, 8) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (9, 99199.9, 9) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (10, 38999.9, 10) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (11, 49999.9, 11) ON CONFLICT DO NOTHING;
INSERT INTO inventory (id, purchase_price, item_id) VALUES (12, 101999.9, 12) ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `payment`
--

INSERT INTO payment (id, title) VALUES (1, 'Card') ON CONFLICT DO NOTHING;
INSERT INTO payment (id, title) VALUES (2, 'ApplePay') ON CONFLICT DO NOTHING;
INSERT INTO payment (id, title) VALUES (3, 'Online') ON CONFLICT DO NOTHING;
INSERT INTO payment (id, title) VALUES (4, 'Cash') ON CONFLICT DO NOTHING;


--
-- Дамп данных таблицы `orders`
--

INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (1, '2021-04-14 21:42:54', 7, 3, 1, 'В обработке', 1) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (3, '2021-04-14 20:25:27', 2, 2, 3, 'В обработке', 2) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (4, '2021-04-14 21:02:51', 10, 3, 1, 'В обработке', 2) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (9, '2021-04-14 20:28:34', 1, 3, 2, 'В обработке', 1) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (15, '2021-04-14 21:48:43', 1, 1, 1, 'Выполнено', 2) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (12, '2021-04-14 21:41:50', 3, 2, 1, 'Выполнено', 5) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (16, '2021-04-14 21:33:18', 2, 1, 2, 'В обработке', 1) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (17, '2021-04-14 21:38:34', 1, 1, 2, 'В обработке', 1) ON CONFLICT DO NOTHING;
INSERT INTO orders (id, date_time, customer_id, delivery_type_id, payment_id, status, employee_id) VALUES (18, '2021-04-14 21:50:03', 2, 1, 1, 'В обработке', 1) ON CONFLICT DO NOTHING;

--
-- Дамп данных таблицы `ordered_item`
--

INSERT INTO ordered_item (id, item_id, order_id) VALUES (1, 4, 1) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (2, 5, 1) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (3, 2, 15) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (4, 1, 15) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (12, 4, 15) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (11, 6, 1) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (9, 1, 12) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (10, 2, 12) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (13, 4, 15) ON CONFLICT DO NOTHING;
INSERT INTO ordered_item (id, item_id, order_id) VALUES (14, 5, 18) ON CONFLICT DO NOTHING;


