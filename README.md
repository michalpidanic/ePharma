Projekt:
Softvér na správu a automatizáciu procesov v lekárni - ePharma

Michal Pidanič ID: 103090

Môj projekt ePharma na predmet Objektovo orientované programovanie je ako už z názvu vyplýva softvér pre automatizáciu lekárne.
Chcem vytvoriť simuláciu bežných procesov v lekárni, ako je predaj liekov zo strany lekárne, resp. ich nákup zo strany zákazníka. V simulácii chcem ukázať, že v dnešnej dobe už v prípade preplnenej lekárne zákazník nemusí čakať na výdaj lieku v rade - stačí pristúpiť k výdajnému automatu, prihlásiť sa pod číslom poistenca a jednoducho si požadovaný voľnopredajný liek zakúpiť prípadne pomocou e-receptu vybrať liek na ktorý máme predpis.
Súčasne môžu pracovníci registrovaní pracovníci lekárne sledovať stav jednotlivých položiek v sklade a priebežne dopĺňať zásoby.

User - užívatelia sa v mojom programe delia na dve hlavné časti a to zákazníci(Customer)  a pracovníci lekárne (Pharmacist). Zákazníci sa do systému prihlasujú pomocou čísla poistenca a zamestnanci pomocou im prideleným prihlasovacím údajom tj. meno a heslo.  V princípe program pre obe skupiny užívateľov funguje kvázi rovnako. Zákazníci majú prístup k ponuke liekov odkiaľ si môžu lieky pridávať do košíka, resp. pre zamestnancov táto časť slúži ako pokladňa. Zamestnanci navyše majú prístup k skladu, ktorý môžu sledovať a následne dopĺňať lieky, ktoré chýbajú, prípadne nové lieky, ktoré sa v sklade ešte nenachádzajú. Zamestnanci majú aj svojho nadriadeného (Headpharmacist), ktorý môže do systému registrovať nových zamestnancov.

Medicine - jedna z hlavných tried, s ktorými program pracuje. Medicine má niekoľko atribútov ako je názov lieku, jeho cena a informácia o tom ci liek je alebo nie je určený na voľný predaj.

Order - ďalšia trieda, ktorá slúži na pridávanie Medicine, ktoré chce Customer kúpiť. Ak sa v Order nachádzajú lieky na predpis, očakáva sa, že Customer má e-recept. Ak e-recept nie je priradený k danému číslu poistenca, môže tento liek predať len Pharmacist. V prípade, že objednávku nechceme z nejakého dôvodu dokončiť, Order môžeme zrušiť.

Storage - sklad jednotlivých položiek Medicine. Informuje zamestancov o počte jednotlivých liekov. Vieme do neho lieky pridávať alebo ich odtiaľ brať, napr. ak pridávame Medicine do Order, automaticky sa počet kusov ktoré pridáme do Order odoberie zo Storage.

Návod na spustenie:
Pracovnú verziu programu spustíme v prostredí InteliJ alebo Eclipse, spustením classy Main v ktorej sa nachádzajú rôzne simulácie volaní metód pre jednotlivé objekty, vytváranie inštancií liekov, userov, vytvorenie singleton objektu phramacy v ktorej sú uložený jednotlivý useri, storage atd.

Požiadavky na projekt:
- dedenie:
	- User <- Customer https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Customer.java#L5
	- User <- Pharmacist https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Pharmacist.java#L5
	- Pharmacist <- Headpharmacist https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/HeadPharmacist.java#L5

- polymorfizmus:
	- interface Payment https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Payment.java#L5
	- class Pharmacist implements Payment https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Pharmacist.java#L5
	- class Customer implements Payment https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Customer.java#L5

- agregacia:
	- Pharmacy agreguje Order https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L13
	- Pharmacy agreguje User https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L11
	- Pharmacy agreguje Storage https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L12
	
	
