**Приложение для онлайн-бронирования репетиций**

_Предметная область и базовый функционал._

На репетиционной базе есть несколько комнат (Room). У комнат есть статусы (RoomStatus).
Пользователи могут бронировать только доступные (Active) комнаты. Администраторы могут иметь доступ 
ко всем видам комнат, в том числе закрытым на ремонт (Closed).

Есть два типа пользователей (ArtistType) - одиночные музыканты (Musician) и группы (Band).
Соответственно по этому типу разделены и комнаты, причем минимальное время для одиночной репетиции - 1ч, для группы - 3ч.

Пользователь (Artist) имеет возможность забронировать ("создать") новую репетицию (Rehearsal) 
в выбранной им комнате (Room) и в свободное на выбранный день время (Rehearsal -> startDatetime).
Помимо комнаты пользователь может арендовать для репетиции несколько единиц оборудования (Gear).
При бронировании репетиция создается в статусе Reserved. В дальнейшем пользователь может отменить 
бронирование (она перейдет в статус Cancelled), но только до определенного срока (например, 24ч до начала репетиции).
Пользователь может внести изменение в бронирование - изменить оборудование.

Если репетиция не отменена, то после ее завершения она переходит в статус Finished.

У приложения два вида пользователей - имеющие аккаунт (непосредственно Artist) и админы.

Пользователь может получить историю только своих бронирований, админ - всех.
Пользователь может получить данные о том, занята комната или нет, админ - кем именно занята в то или иное время.

_Стек технологий_ 
 
- Spring Boot (каркас)
- SpringData (БД, наверное все-таки Postgres)
- SpringSecurity (аутентификация, авторизация)
- SpringBatch (заносим пользователей, не оплативших репетицию, в таблицу должников)
- Микросервисы, Rest - приложение можно разбить на 
    - сервис отправки кода подтверждения при создании аккаунта
    - непосредственно сервис бронирования
    - сервис оплаты
    
- Интерфейс(выбор дня и времени на календаре)

_Возможные расширения функционала_

- Цена на репетицию зависит от дня (будни/выходные) и времени (утро, день, вечер)
- Выбор времени оплаты (при бронировании/ после репетиции)
- Должников заставляем заплатить долг + оплатить новую репетицию до бронирования
- Функционал горячих репетиций (в текущий день есть "окна" - они дешевле)
- Постоянные репетиции

  




 