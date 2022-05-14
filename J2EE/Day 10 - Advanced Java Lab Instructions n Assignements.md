# Day 10

1. import day10.1 , as existing maven project . Edit hibernate.cfg.xml , as per your DB settings.
    Revise all basic APIs of hibernate using  :Tester--DAO--POJO --DB  layers

2. Mandatory Assignment , after revision.

    2.1 Copy from day8_hibernate (as maven template project) into day10_lab or can start from scratch.
    2.2 Take a look at this table.

    ```sql
    create table books(
        id int(5) primary key auto_increment,
        title varchar(20) unique,
        author varchar(20),
        category varchar(20),
        price double,
        available_stock int,
        pub_date date);
    ```

    Create a Book POJO.

    2.3 Add <mapping> entry in hibernate.cfg.xml

    2.4  Create DAO layer n separate simple testers for the following.
        1. Add new book details
        2. Find book details for specific book id.

            i/p : book id
            o/p : book details or error mesg.

        3.Display all books written by a specific author , published after specific date , sorted in desc order of price.

            i/p author , date
            o/p : sorted book details

        4. Apply specific discount on all the books published before specific date.(i.e on old books)

            i/p  date , discount (in %)
            o/p : message.
