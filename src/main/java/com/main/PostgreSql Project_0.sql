create table users (
	user_id serial PRIMARY KEY,
	first_name text,
	last_name text,
	username text,
	pword text
);

CREATE TABLE accounts(
	account_id serial PRIMARY KEY,
	user_id int,
	balance decimal
);

create table transactions(
	account_id int,
	user_id int,
	transaction_id serial PRIMARY KEY,
	transaction_type text,
	amount decimal,
	opening_balance decimal,
	ending_balance decimal
);

insert into users (first_name , last_name, username, pword) values ('Chris', 'Proutt', 'cproutt', '1234');

insert into users (first_name, last_name, username, pword) values ('DaQuan', 'Dunn', 'ddunn', '5678');

insert into users (first_name, last_name, username, pword) values ('Sharmita', 'Bhattacharya', 'shay', 'Password');

insert into accounts (account_id, user_id, balance) values (1, (select user_id from users where username = 'cproutt'), 50.00);

insert into accounts (account_id, user_id, balance) values (2, (select user_id from users where username = 'ddunn'), 550.00);

delete from users where pword = '';

create function new_balance()
returns trigger as $$
begin
	-- check that new balance is above 0
	if new.ending_balace is null then
		raise exception 'new_balance cannot be null';
	end if;
	if new.ending_balance < 0 then
		raise exception 'cannot have a negative balance';
	end if;

	new.date := current_timestamp;
	return new;
end
$$ language plpgsql;


create trigger new_balance
after insert on transactions
	for each row execute procedure new_balance();
	