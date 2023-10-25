# ArithmeticProgramm / Арифметическая Программая-тестовое задание 
## Описание программы
 Консольное Java приложение, выполняющие набор заданных арифметических операций в 3х режимах (консоль/файл/БД).  
Операции:
1) Сложение 2х и более чисел (команда add)
2) Умножение 2х и более чисел (команда mul)
3) Умножение первых 2х чисел и сложение с 3м числом (команда mul_add)
4) Вычисление корня (команда sqrt)
## Стек технологий
* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
* ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
* ![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
* Clean Architecture
  
## Свойства
- Приложение может получать параметры либо из файла, либо вводом из консоли, либо из БД.

- Приложение может выводить результат либо в файл, либо в консоль, либо в БД.

- Режим работы определяется аргументами командной строки.

- Если значение аргумента задано как `-`, то это означает работу с консолью, иначе с файлом.
-  Задаются два аргумента, один для режима ввода (`имя входного файла`), другой для режима 
вывода (`имя результирующего файла`).

- Для того чтобы программа работала в режиме работы с БД нужно указать `db`
## Проверка работоспособности
 Для проверки работоспособности приложения необходимо запустить jar файл.  
 Исходные данные для jar-файла (дамп БД, input-файл,путь к БД)  находится в директории `jartest`.  
 ### Этапы проверки
1. Необходимо перенести БД из файла `dump_DB` [таким образом](https://info-comp.ru/migrating-postgresql-database-to-another-server)
2. Внести изменения в `jartest/db_prop.txt`, а именно необходимо указать: 1я строка - логин, 2я - пароль, 3я - местрополоение БД (`url` подключения формата: `'jdbc:postgresql://localhost:5432/db_name'`).
3. Открыв консоль `cmd` из директории `jarTest` исполнить следующие команды:
*  `java -jar arithmeticTask.jar -`
*  `java -jar arithmeticTask.jar input.txt out.txt`
*  `java -jar arithmeticTask.jar db`
4. Все выходные данные будут появлять в указанном `out.txt` файле или в БД. 
 
 
