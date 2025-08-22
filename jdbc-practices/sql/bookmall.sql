-- 
-- bookmall
-- 

select * from orders;
 
select a.orders_no, a.quantity, a.price, b.title
from orders_book a, book b
where a.book_no = b.no
and a.orders_no = (select no from orders where user_no = 1)
and a.orders_no = 1;

delete from book where no = 1;
