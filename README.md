# Многомодульный maven. Многопоточность. XML. Веб сервисы. Удаленное взаимодействие

### Структура памяти: куча, стек, permanent/metaspace
  - <a href="https://www.slideshare.net/solit/jvm-16948708">JVM изнутри - оптимизация и профилирование</a>.
  - <a href="http://stackoverflow.com/questions/79923/what-and-where-are-the-stack-and-heap#24171266">Stack and Heap</a>
  - Дополнительно:
    - <a href="http://habrahabr.ru/post/117274/">Из каких частей состоит память java процесса</a>.
    - <a href="http://www.javaspecialist.ru/2011/04/permanent.html">Permanent область памяти</a>
    - <a href="http://www.javaspecialist.ru/2011/04/java-thread-stack.html">Java thread stack </a>
    - <a href="http://habrahabr.ru/post/134102/">Размер Java объектов</a>

### Ленивая инициализация
- <a href="https://habrahabr.ru/post/27108/">Реализация Singleton в JAVA</a>
- <a href="https://ru.wikipedia.org/wiki/Double_checked_locking">Double checked locking</a>
- <a href="https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom</a>
- <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton</a>

## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. <a href="https://www.youtube.com/watch?v=8bFF-5r_Kig">Реализация многопоточности в Java</a>
- <a href="https://ru.wikipedia.org/wiki/Параллелизм_в_Java">Параллелизм в Java</a>
- <a href="https://ru.wikipedia.org/wiki/Монитор_(синхронизация)">Монитор (синхронизация)</a>
- <a href="https://en.wikipedia.org/wiki/Compare-and-swap">Compare-and-swap</a>
- <a href="http://www.javaspecialist.ru/2011/06/java-memory-model.html">Java Memory Model</a>
- <a href="http://www.skipy.ru/technics/synchronization.html">Синхронизация потоков</a>
- <a href="https://habrahabr.ru/company/luxoft/blog/157273">Обзор java.util.concurrent.*</a>
- <a href="https://habrahabr.ru/post/132884/">Как работает ConcurrentHashMap</a>
- <a href="https://habrahabr.ru/post/277669/"> Справочник по синхронизаторам java.util.concurrent.*</a>
- <a href="http://articles.javatalks.ru/articles/17">Использование ThreadLocal переменных</a>
- <a href="https://www.youtube.com/watch?v=8piqauDj2yo">Николай Алименков — Прикладная многопоточность</a>
- <a href="http://stackoverflow.com/questions/20163056/in-java-can-thread-switching-happen-in-the-synchronized-block">Can thread switching happen in the synchronized block?</a>

#### Tproger: Многопоточное программирование в Java 8
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-1/">1. Параллельное выполнение кода с помощью потоков</a>
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-2/">2. Синхронизация доступа к изменяемым объектам</a>
- <a href="https://tproger.ru/translations/java8-concurrency-tutorial-3/">3. Атомарные переменные и конкурентные таблицы</a>
----------------------------

### Ресурсы (основы)
- Intuit, <a href="http://www.intuit.ru/studies/courses/16/16/lecture/27127">Потоки выполнения. Синхронизация</a>
- Алексей Владыкин, <a href="https://www.youtube.com/watch?v=zxZ0BXlTys0&list=PLlb7e2G7aSpRSBWi5jbGjIe-v_CjRO_Ug">Основы многопоточность в Java</a>
- Виталий Чибриков, <a href="https://www.youtube.com/watch?v=dLDhB6SRXzw&list=PLrCZzMib1e9qkzxEuU_huxtSAxrW1t9NZ">Java. Многопоточность</a>
- Computer Science Center, курс <a href="https://compscicenter.ru/courses/hp-course/2016-spring">Параллельное программирование</a>
- Юрий Ткач, курс <a href="https://www.youtube.com/playlist?list=PL6jg6AGdCNaXo06LjCBmRao-qJdf38oKp">Advanced Java - Concurrency</a>
- Головач, курс <a href="https://www.youtube.com/playlist?list=PLoij6udfBncgVRq487Me6yQa1kqtxobZS">Java Multithreading</a>