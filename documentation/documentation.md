#News

##Kuvaus
Tavoitteena oli rakentaa oma uutissivusto, josta löytyy erilaisia toiminnallisuuksia uutisiin liittyen.
Toteuttamassani sovelluksessa etusivulla näkyy viisi uusinta uutista (otsikko ja ingressi) 
ja niitä klikkaamalla pääsee näkemään itse uutisen. Yläpalkissa on toiminnallisuus uutisen ja kategorian 
lisäämiseen sekä kaikki kategoriat, jotka on haluttu näyttää erikseen yläpalkissa. 
Näiden toiminnallisuuksien lisäksi yläpalkista löytyy linkit, 
joista voi tarkastella kaikkia tietokannassa olevia kategorioita ja uutisia.
Ulkoasuun käytin boostrap- kirjastoa.

##Yleisimmät käyttötapaukset:
Uutisia ja kategorioita pystyy lisäämään (yläpalkista "Lisää uutinen/kategoria" ja poistamaan 
(tämä toiminnallisuus löytyy, kun kyseisen uutisen/kategorian avaa). 
Kategoriaa lisätessä voi myös valita, näkyykö kategoria yläpalkissa vai ei.
(myös muokkausnappi löytyy mutta sitä ei pysty klikkaamaan eli muokkausmahdollisuutta ei ole.)
Käyttäjä pystyy tarkastelemaan uutisia yläpalkista löytyvän navigaatiopalkin avulla kategorioittain.
Käyttäjä pystyy listaamaan kaikki uutiset ja kaikki kategoriat 
(myös ne kategoriat, joita ei yläpalkissa näytetä) navigaatiopalkin linkkien avulla.
Käyttäjä pystyy lukemaan uutisia (uutisten otsikot ovat linkkejä itse uutiseen). 
Jokaisella uutissivustolla on myös listattuna 5 uusinta uutista linkkeinä, 
joiden kautta pääsee lukemaan kyseisiä uutisia.

En ehtinyt toteuttamaan kirjoittaja luokkaa juurikaan, joten sovelluksestani löytyy tietokannat uutiselle sekä kategorialle. 
Kategorialla on pelkästään nimi ja uutisella otsikko, ingressi ja teksti. 
Yhteen uutiseen voi liittyä monta kategoriaa ja yhteen kategoriaan voi liittyä monta uutista.

##Toteuttamatta jääneet ominaisuudet
Projekti oli työläs ja joitakin toiminnalisuuksia jäi puuttumaan: 
kuvan lisääminen uutiselle (tätä on aloitettu hieman), 
kirjautuminen uutissivustolle sisään niin, ettei kuka tahansa pysty lisäämään uutisia (tätäkin on aloitettu SecurityConfiguration luokassa), 
uutisen liittäminen kirjoittajaan,
ja listaus lukukertojen mukaan. 
Myös testit puuttuvat. 
Näistä toiminnallisuuksita kirjoittajan lisääminen olisi mielestäni pelkkää copypastea jo projektiin lisätystä kategoria- ominaisuudesta.