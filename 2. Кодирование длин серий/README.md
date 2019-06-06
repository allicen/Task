<h1 class="title">2. Кодирование длин серий</h1>
      <table>
         <tr class="time-limit">
            <td class="property-title">Ограничение времени</td>
            <td>2&nbsp;секунды</td>
         </tr>
         <tr class="memory-limit">
            <td class="property-title">Ограничение памяти</td>
            <td>64Mb</td>
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
         <p>Кодирование длин серий (RLE)&nbsp;&mdash; алгоритм сжатия данных, заменяющий повторяющиеся символы на один символ и число его повторов. Серией называется последовательность,
            состоящая из нескольких одинаковых символов (более одного). При кодировании строка одинаковых символов, составляющих серию,
            заменяется строкой, содержащей сам повторяющийся символ и количество его повторов. 
         </p></span><p>Например, строка <span class="tex-monospace">AAAABBB</span> будет сжата в строку <span class="tex-monospace">A4B3</span>, а строка <span class="tex-monospace">AAAAAAAAAAAAAAABAAAAA</span>&nbsp;&mdash; в строку <span class="tex-monospace">A15BA5</span>. 
      </p>
      <p>Вам дана сжатая строка, найдите длину исходной строки. Длина исходной строки не превосходит 1000 символов, все символы исходной
         строки заглавные большие буквы латинского алфавита.
      </p>
   </div>
   <h2>Формат ввода</h2>
   <div class="input-specification"><span style="">
         <p>В единственной строке входных данных содержится непустая строка <span class="tex-math-text">s</span>. Гарантируется, что <span class="tex-math-text">s</span> результат корректного сжатия некоторой строки.
         </p></span></div>
   <h2>Формат вывода</h2>
   <div class="output-specification"><span style="">
         <p>Выведите длину исходной строки.</p></span></div>
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
            <td><pre>A15BA5
</pre></td>
            <td><pre>21
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
            <td><pre>ABCDR
</pre></td>
            <td><pre>5
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
            <td><pre>Z123XY
</pre></td>
            <td><pre>125
</pre></td>
         </tr>
      </tbody>
   </table>