insert into CUSTOMERS (name, surname, age, phone_number) VALUES ('Alexey', 'Fefelov', 25, '+7(923)0030988');
insert into CUSTOMERS (name, surname, age, phone_number) VALUES ('Maxim', 'Semenov', 34, '+7(909)0440986');
insert into CUSTOMERS (name, surname, age, phone_number) VALUES ('Nadezda', 'Ignatova', 44, '+7(808)0986644');

insert into ORDERS (date, customer_id, product_name, amount) VALUES (now(), 1, 'toys', '7500');
insert into ORDERS (date, customer_id, product_name, amount) VALUES (now(), 1, 'tools', '37500');
insert into ORDERS (date, customer_id, product_name, amount) VALUES (now(), 2, 'books', '500');
insert into ORDERS (date, customer_id, product_name, amount) VALUES (now(), 3, 'books', '300');
insert into ORDERS (date, customer_id, product_name, amount) VALUES (now(), 3, 'foods', '1500');