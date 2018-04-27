# TestTaskAppA
Необходимо сделать два приложения:

Приложение А

Состоит из двух табов (тест и история).

На табе «тест» есть поле ввода и кнопка «ок». В поле нужно ввести ссылку на изображение. При нажатии на «ок» должно открыться приложение В.

В табе «история» содержится список открытых ссылок. Важно: приложение А не должно вносить изменения в этот список (вставку/удаление/изменение).

В action bar должна быть кнопка сортировки ссылок – по дате добавления (от новых к старым) и по статусу. Бекграунд ссылок должен быть зеленым для статуса 1, красным - для статуса 2, серым – для статуса 3.

Нажатие на ссылку должно также открывать приложение В.

Список «история» должен автоматически изменятся при изменениях в базе.


Приложение В

Если приложение В открыто нажатием кнопки «ок» с таба «тест» в приложении А, то приложение В должно сохранить эту ссылку в базу данных А с полями ссылка, статус (1 – загружено, 2 – ошибка, 3 – неизвестно) и время (время открытия В) и вывести эту картинку.

Если приложение В открыто по ссылки из таба «история», то нужно показать эту картинку , и при открытии зеленой ссылки – эта ссылка должна удалиться через 15 секунд из базы А, и показать сообщение, что ссылка была удалена, даже, если приложение В закрыто; а также сохранить эту картинку в пути /sdcard/customPath/test/B

При открытии красной или серой ссылки – их статус должен обновиться, если он изменился.

Если приложение В открыто из ланчера, то на экране нужно вывести сообщение, что приложение В не является самостоятельным приложением и будет закрыто через n секунд (обратный таймер). Нужно отсчитать обратно 10 секунд и закрыть приложение.
