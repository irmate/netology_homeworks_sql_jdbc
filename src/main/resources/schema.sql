create table CUSTOMERS
(
    id int primary key auto_increment,
    name varchar(255),
    surname varchar (255),
    age int,
    phone_number varchar(20)
);

create table ORDERS
(
    id int PRIMARY KEY auto_increment,
    date varchar(50),
    customer_id int,
    product_name varchar(255),
    amount varchar(255),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (id)
);