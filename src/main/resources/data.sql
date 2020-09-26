insert into users (user_id, password, roles, is_active)
values ('vinujadaun', 'vinujadaun', 'ROLE_USER', true);

insert into users (user_id, password, roles, is_active)
values ('admin', 'admin', 'ROLE_ADMIN', true);


insert into user_details (user_id, full_name, phone_no, mail_id, birth_date, wallet_money)
values ('vinujadaun', 'Vinu Jadaun', '9634043707', 'vinujadaun@gmail.com', 19901025 ,100);

insert into user_details (user_id, full_name, phone_no, mail_id, birth_date, wallet_money)
values ('admin', 'Vipin Jadaun', '9982748648', 'vipin@gmail.com', 19900810 ,100);

insert into trips (trip_id, user_id, start_time, end_time, pickup_location, drop_location, fare, distance, offer, trip_completed)
values (1, 'vinujadaun', '2020-09-15 09:35:00', '2020-09-15 10:15:00', 2, 8, 36, 6, null, true);



