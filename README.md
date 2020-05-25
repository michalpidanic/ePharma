Projekt:
Softvér na správu a automatizáciu procesov v lekárni - ePharma

Michal Pidanič ID: 103090

1. Popis projektu

1.1. Úvod

Môj projekt ePharma na predmet Objektovo orientované programovanie je ako už z názvu vyplýva softvér pre automatizáciu lekárne.
Chcem vytvoriť simuláciu bežných procesov v lekárni, ako je predaj liekov zo strany lekárne, resp. ich nákup zo strany zákazníka. V simulácii chcem ukázať, že v dnešnej dobe už v prípade preplnenej lekárne zákazník nemusí čakať na výdaj lieku v rade - stačí pristúpiť k výdajnému automatu, prihlásiť sa pod číslom poistenca a jednoducho si požadovaný voľnopredajný liek zakúpiť prípadne pomocou e-receptu vybrať liek na ktorý máme predpis.
Súčasne môžu registrovaní zamestnanci lekárne sledovať stav jednotlivých položiek v sklade a priebežne dopĺňať zásoby.

1.2. Popis jednotlivých tried

User - užívatelia sa v mojom programe delia na dve hlavné časti a to zákazníci(Customer)  a pracovníci lekárne (Pharmacist). Zákazníci sa do systému prihlasujú pomocou čísla poistenca a zamestnanci pomocou im prideleným prihlasovacím údajom tj. meno a heslo.  V princípe program pre obe skupiny užívateľov funguje skoro rovnako. Zákazníci majú prístup k ponuke liekov odkiaľ si môžu lieky pridávať do košíka, resp. pre zamestnancov táto časť slúži ako pokladňa. Zamestnanci navyše majú prístup k skladu, ktorý môžu sledovať a následne dopĺňať lieky, ktoré chýbajú, prípadne nové lieky, ktoré sa v sklade ešte nenachádzajú. Zamestnanci majú aj svojho nadriadeného (Headpharmacist), ktorý môže do systému registrovať nových zamestnancov.

Medicine - jedna z hlavných tried, s ktorými program pracuje. Medicine má niekoľko atribútov ako je názov lieku, jeho cena a informácia o tom ci liek je alebo nie je určený na voľný predaj.

Order - ďalšia trieda, ktorá slúži na pridávanie Medicine, ktoré chce Customer kúpiť. Ak sa v Order nachádzajú lieky na predpis, očakáva sa, že Customer má e-recept. Ak e-recept nie je priradený k danému číslu poistenca, môže tento liek predať len Pharmacist. V prípade, že objednávku nechceme z nejakého dôvodu dokončiť, Order môžeme zrušiť.

Storage - sklad jednotlivých položiek Medicine. Informuje zamestancov o počte jednotlivých liekov. Vieme do neho lieky pridávať alebo ich odoberať, napr. ak pridávame Medicine do Order, automaticky sa počet kusov ktoré pridáme do Order odoberie zo Storage.

2. Návod na spustenie

Program spustíme v prostredí InteliJ alebo Eclipse, spustením triedy App. Po spustení aplikácie sa nám zobrazí následujúca obrazovka:

3. Požiadavky na projekt

- dedenie:
	- User <- Customer https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Customer.java#L5
	- User <- Pharmacist https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Pharmacist.java#L5
	- dvojité dedenie - Pharmacist <- Headpharmacist https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/HeadPharmacist.java#L5

- polymorfizmus:
	- interface Payment s metodou payOrder() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Payment.java#L5
	- class Pharmacist implementuje Payment a využíva metódu payOrder() na zaplatenie objednávky https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/80ee13d981643e8ee972badfb66bdec48a3d7c26/ePharma/src/Users/Pharmacist.java#L17
	- class Customer implementuje  Payment a využíva metódu payOrder() na zaplatenie objednávky, pričom metóda kontroluje či zákazník má eRecept, ak nie, nie je možné objednávku zaplatiť  https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/80ee13d981643e8ee972badfb66bdec48a3d7c26/ePharma/src/Users/Customer.java#L15
	- využitie metód payOrder() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/controllers/HomeController.java#L234

- agregácia:
	- Pharmacy agreguje Order https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L13
	- Pharmacy agreguje User https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L11
	- Pharmacy agreguje Storage https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Pharmacy/Pharmacy.java#L12
	
- serializácia:
	- definovaná metóda serialize() v SerializationService https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/services/SerializationService.java#L14
	- volanie metódy serialize() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/controllers/LoginCustomerController.java#L66
	- definovaná metóda deserialize() v SerializationService https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/services/SerializationService.java#L28
	- volanie metódy deserialize() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/controllers/App.java#L43
	
-implicitná implementácia metódy v rozhraní:
	- rozhranie Payment s metódou payOrder() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/8bdc97a62ae286206df9762f424cc86baa049101/ePharma/src/Users/Payment.java#L5

- lambda výraz:
	- trieda Order metóda cancelOrder() https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/model/pharmacy/Order.java#L93
	
- použitie RTTI:
	- controller Home na zistenie typu prihláseného Usera a prispôsobenie view podľa typu https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/controllers/HomeController.java#L112
	
- poskytnutie grafického používateľského rozhrania oddelene od aplikačnej logiky 
	- manuálne vytvorený alert box, zvyšok cez fxml súbory https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/views/AlertBox.java#L14

- vlastná výnimka:
	- EmptyTextFieldException https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/services/EmptyTextFieldException.java#L6
	- vyhadzovaná v prípade prázdneho textového poľa https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/controllers/HomeController.java#L183
	
- využitý návrhový vzor MVC (Model View Controller):
	- odkaz na priečinok kde to môžeme vidieť https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/tree/master/ePharma/src
	
- zapuzdrenie:
	- všetky atribúty sú private https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/model/pharmacy/Pharmacy.java#L12
	- prístup cez gettery https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/b0f9b72cefde5fbeb5667a2189ce842ea9d56dcb/ePharma/src/model/pharmacy/Pharmacy.java#L75
	
4. UML diagram

![alt text](https://github.com/OOP-FIIT/oop-2020-uto-16-c-kovacik-michalpidanic/blob/master/images/UML.png "UML.png")

5. Záver

Práca na tomto projekte ma nazoaj bavila (oveľa viac ako zadania z DSA) a môžem povedať, že som sa naučil veľa nových vecí. Netvrdím, že odovzdávam bezchybný program, ktorý 100% funguje, to nie. Nazval by som to beta verziou :) Niekoľko vecí, ktoré by sa dali vylepšiť ak by sme mali ešte týždeň (alebo ak by som na tomto projekte pracoval viac) - v prípade, že odstránime všetky veci z košíka, prípade inak zmeníme niektoré dynamic scroll view, je potrebné kliknúť znova na button košík (prípadne iný) aby sa view refreshol. Ďalší bug je, že keď program ukončíme, bez toho aby sme sa odhlásili, serializuje to Pharmacy s prihláseným Userom a pri opätovnom prihlasovaní to padá (ak nastane tento prípad, treba spustiť main v triede Reset a inštancia Pharmacy sa nanovo nainicializuje a serializuje). Z mojej strany je to asi všetko, možno už iba malé poďakovanie za predmet, ktorý ma bavil a vďaka, ktorému som sa mohol realizovať a naučiť sa nové veci. Možno si tento projekt vo voľnom čase dotiahnem do dokonalosti...
