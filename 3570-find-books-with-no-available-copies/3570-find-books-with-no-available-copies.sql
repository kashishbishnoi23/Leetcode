# Write your MySQL query statement below
SELECT
   L.book_id,  
   L.title,
   L.author,
   L.genre,
   L.publication_year,
   B.borrowed_copies as current_borrowers
   from library_books L INNER JOIN 
   (select book_id, count(*) as borrowed_copies from borrowing_records where return_date is NULL group by book_id) B ON
   L.book_id = B.book_id AND L.total_copies = B.borrowed_copies order by current_borrowers desc, title; 

