CREATE TABLE PUBLISHER
(
   ID INT PRIMARY KEY AUTO_INCREMENT,
   NAME           TEXT    NOT NULL,
   LOGOIMAGE           TEXT    NOT NULL
);

CREATE TABLE BOOK
(
  ID            INT PRIMARY KEY AUTO_INCREMENT,
  TITLE          TEXT,
  AUTHOR          TEXT,
  COVER           TEXT NOT NULL,
  VIEW           TEXT,
  PRICE         INTEGER NOT NULL,
  PUBLISHER_ID INT REFERENCES PUBLISHER
);
INSERT INTO PUBLIC.PUBLISHER(ID, NAME, LOGOIMAGE) VALUES
(1, 'Helion', 'http://www.komputerswiat.pl/media/902570/helion-logo-panorama.jpg'),
(2, 'PWN', 'http://it.pwn.pl/design/plain_site/images/logo-it-pwn.png');

INSERT INTO PUBLIC.BOOK(TITLE, AUTHOR, COVER, PRICE, PUBLISHER_ID) VALUES
('Python. Podstawy nauki o danych.', 'Alberto Boschetti, Luca Massaron', 'https://static01.helion.com.pl/global/okladki/326x466/cce76081c5c79abe2b80a93b1d32a5e5,pypod2.jpg' ,59, 1),
('Testowanie i jakosc oprogramowania', 'Adam Roman', 'https://static01.helion.com.pl/global/okladki/326x466/a89754a151df50f28adc111b40af7d4e,e_1oe0.jpg' ,103, 1),
('Alogrytmy', 'Sanjoy Dasgupta', '/var/plain_site/storage/images/media/images/algorytmy_37554/1582-1-pol-PL/algorytmy_37554_article_list_article_thumb.jpg' ,39, 2),
('Bezpieczenstwo informacyjne', 'Krzysztof Liderman', 'http://it.pwn.pl/var/plain_site/storage/images/media/images/bezpieczestwo-informacyjne_167865/1563-1-pol-PL/bezpieczestwo-informacyjne_167865_article_list_article_thumb.jpg' ,33, 2);


