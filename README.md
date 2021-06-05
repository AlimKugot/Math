# Проект

**Что это** 👷 : Программа решает задачи алгебры и дискретной математики 

**Цель** 🎯: моей целью не является найти оптимальный и самый быстрый алгоритм в мире.
Я пытаюсь перевести в язык программирования то, с чем я знакомлюсь в математике.

**Развитие** 📈 : данный проект мне бы хотелось перевести в веб-проект, чтоб
другие могли воспользоваться моим приложением. Планирую использовать
фреймворк Spring Boot.

#Навигация
1. [Кодеры(шифраторы)] (#Кодеры(шифраторы)
2. [Матрицы 🧱] (#Матрицы 🧱) 


## Кодеры(шифраторы) 🔐

### Код Рида-Соломона

На данный момент ещё в разработке. Ожидаю закончить к 10-15 июня.


### Код Грея 

Алгоритм довольно прост, однако добавил множество имплементаций, чтоб 
была возможность удобно передавать, например, двоичное число в виде строки 
и прочие удобные дополнения. Код см в файле `Coders`.


## Матрицы 🧱

В классе `Matrix` я прописал основные действия над матрицами:
- ✅ умножение матриц
- ✅ умножение на число 
- ✅ сложение матриц

<br>
  
Также немало вспомогательных функций (копирование, перестановка, удаление...).
Однако более интересным мне представляются эти алгоритмы:
- ✅ решение СЛАУ методом Крамера
- ✅ решение СЛАУ методом Гаусса (в разработке)
- ✅ нахождение определителя
- ✅ приведение к треугольному виду (LU-разложение в разработке)

### СЛАУ Крамером

Алгоритм вышел довольно жёстким и сложным, однако же я его закончил, хехе)). 
Чтоб понять, что происходит, давайте решим пример, как мы обычно это
делаем на листочке 📝:

![matrix A](/img/slauCramer/matrix A.png)

Далее мы находим детерминанту `матрицы А` **без** последнего столбца 
(`det All`):

![detAll](/img/slauCramer/detAll.png)

И дальше, каждый раз меняя последний столбец, с `i-ым` номером, мы находим 
det A с индексом i:

![detA123](/img/slauCramer/detA123.png)

Всё, осталось разделить `det All / det Ai`.  Чтобы красиво выглядел ответ, 
найдём НОД у этих чисел и запишем в таком же виде (если они сократятся, просто нужно будет убрать 
строку "x / 1", проще простого):

![res](/img/slauCramer/result.png)

<br>

В итоге имеем:

![all](/img/slauCramer/all.png)





## Полиномы 

В классе `Polynomial` я прописал команды для работы с полиномами. 
Среди них умножение полиномов, умножение на число, сложение 
полиномов и тд.

Полиномы же я представляю в виде словаря(`Map`) и для привычного вывода, 
где мы сначала выписываем одночлены с большей степенью,
использую сортированный словарь (`TreeMap`). В словаре ключом является 
степень каждого одночлена, значением — коэффициент перед одночленом.

Рассмотрим на примере:
```
f(x) = x^4 + 2x^3 - x^2 + x - 11
```
Для нас же он выглядит так:

| Одночлен | Степень (ключ) | Коэф-т (значение)|
| -------- |:--------------:| ----------------:|
|   x^4    |       4        |        1         |
|  2x^3    |       3        |        2         |
|  -x^2    |       2        |       -1         |
|   x      |       1        |        1         |
|  -11     |       0        |       -11        |

`!` Проблема может возникнуть, когда выражение не до конца упрощено: \
`x^2 + 3x^2 - 1 = 0`. Этот случай пока не встречается в коде.

# Результат

Для красивого вывода рез-та использую `RegEx`(**от Java**)
и `LaTex`(**JLaTexMath**). После выполнения программы, обрабатывается
мапа регулярными выражениями и в конце библиотека JLatexMath создаёт PNG
файл в папке `target`, куда закидывает ответ.