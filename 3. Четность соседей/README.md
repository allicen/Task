<h1 class="title">3. Четность соседей</h1>
      <table>
         <tr class="time-limit">
            <td class="property-title">Ограничение времени</td>
            <td>1&nbsp;секунда</td>
         </tr>
         <tr class="memory-limit">
            <td class="property-title">Ограничение памяти</td>
            <td>256Mb</td>
         </tr>
         <tr class="input-file">
            <td class="property-title">Ввод</td>
            <td colspan="1">стандартный ввод или input.txt</td>
         </tr>
         <tr class="output-file">
            <td class="property-title">Вывод</td>
            <td colspan="1">стандартный вывод или output.txt</td>
         </tr>
      </table>
   </div>
   <h2></h2>
   <div class="legend"><span style="">
         <p>В последовательности целых чисел <span class="tex-math-text">A</span> требуется переставить <span style="font-weight:bold;">минимальное</span> число элементов так, чтобы никакие два соседних числа не были одной четности.
         </p></span></div>
   <h2>Формат ввода</h2>
   <div class="input-specification"><span style="">
         <p>В первой строке входных данных записано целое число <span class="tex-math-text">n</span> (<span class="tex-math-text">1 &le; n &le; 100&#8239;000</span>)&nbsp;&mdash; количество элементов в последовательности.
         </p></span><p>Во второй строке записаны <span class="tex-math-text">n</span> целых чисел <span class="tex-math-text">a<sub>i</sub></span> (<span class="tex-math-text">0 &le; a<sub>i</sub> &le; 1&#8239;000&#8239;000&#8239;000</span>)&nbsp;&mdash; элементы последовательности.
      </p>
   </div>
   <h2>Формат вывода</h2>
   <div class="output-specification"><span style="">
         <p>В первой строке выведите число <span class="tex-math-text">k</span> (<span class="tex-math-text">0 &le; k &le; n</span>)&nbsp;&mdash; количество элементов последовательности, которые были переставлены.
         </p></span><p>Во второй строке выведите <span class="tex-math-text">n</span> чисел <span class="tex-math-text">b<sub>i</sub></span>. Все числа последовательности <span class="tex-math-text">A</span> должны быть выведены. Любые два соседних элемента последовательности должны быть различной четности. Ровно <span class="tex-math-text">k</span> индексов последовательности <span class="tex-math-text">B</span> должны отличаться от последовательности <span class="tex-math-text">A</span>. Если подходящих последовательностей <span class="tex-math-text">B</span> несколько, то выведите любую из них.
      </p>
      <p>Если переставить элементы последовательности с требуемым условием невозможно, то выведите одно число -1.</p>
   </div>
   <h3>Пример 1</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>3
1 2 3
</pre></td>
            <td><pre>0
1 2 3
</pre></td>
         </tr>
      </tbody>
   </table>
   <h3>Пример 2</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>2
1 1
</pre></td>
            <td><pre>-1
</pre></td>
         </tr>
      </tbody>
   </table>
   <h3>Пример 3</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>6
1 3 5 2 2 2
</pre></td>
            <td><pre>2
1 2 5 2 3 2
</pre></td>
         </tr>
      </tbody>
   </table>
   <h3>Пример 4</h3>
   <table class="sample-tests">
      <thead>
         <tr>
            <th>Ввод</th>
            <th>Вывод</th>
         </tr>
      </thead>
      <tbody>
         <tr>
            <td><pre>10
1 0 0 0 1 1 0 1 1 0
</pre></td>
            <td><pre>4
1 0 1 0 1 0 1 0 1 0
</pre></td>
         </tr>
      </tbody>
   </table>