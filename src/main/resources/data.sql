INSERT INTO NFZ (ID, NAZWA, MIASTO) VALUES (1, 'LUBESLKI ODDZIAL WOJEWODZKI','LUBLIN');
INSERT INTO LEKARZ (ID, IMIE, NAZWISKO, MIASTO, ID_NFZ) VALUES (1, 'ADAM','NOWAK', 'LUBLIN',1);
INSERT INTO NA_RECEPTE (ID, NAZWA, CZY_DLA_DZIECI, CENA, PROCENT_REFUNDACJI, ID_LEKARZA, ZDJECIE, OPIS) VALUES (1, 'Ketonal',FALSE , 99, 0.90,1, FILE_READ('src/main/resources/zdjecia/ketonal.png'), 'Leczenie objawowe zapalnych i zwyrodnieniowych schorzeń reumatycznych (reumatoidalne zapalenie stawów, osteoartrozy). Łagodzenie niektórych zespołów bólowych (bóle o umiarkowanym nasileniu, bolesne miesiączkowanie). Dawkę i częstotliwość przyjmowania leku ustala lekarz. Nie należy stosować u dzieci. W trakcie leczenia nie wolno spożywać alkoholu. Aby leczenie było skuteczne i jak najbardziej bezpieczne należy przestrzegać zaleceń lekarza prowadzącego. Zapoznaj się z właściwościami leku opisanymi w ulotce przed jego zastosowaniem.
');
INSERT INTO BEZ_RECEPTY (ID, NAZWA, CZY_DLA_DZIECI, CENA, ZDJECIE, OPIS) VALUES (1, 'Apap', true, 19, FILE_READ('src/main/resources/zdjecia/apap.jpg'), 'Preparat zawiera paracetamol, lek przeciwbólowy i przeciwgorączkowy. Preparat jest wskazany do stosowania u dorosłych i młodzieży po 12. roku życia w bólach różnego pochodzenia:
·	bóle głowy (w tym bóle migrenowe)
·	nerwobóle
·	bóle mięśni, kości i stawów
·	bóle zębów
·	bóle gardła
·	bolesne miesiączkowanie
oraz przeciwgorączkowo:
· w przebiegu przeziębienia i grypy.');

INSERT INTO USERS VALUES (1, 'adam', 'qwerty', 'USER');