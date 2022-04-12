1. I chose a 500 board size because it's easy to distinguish where the maximum lies and also doesn't take too long to run.
2. I chose 25 reps because I didn't want it to take too long to run and it still produced values close to the ones of when I used higher repititions.
3. Changing the board size changes the tick amount rougly linearly.
4. The maximum burn time is about 2.0-2.5x the board size and I tested this by going through board sizes until 1500 in 100 increments while comparing the largest tick and the size.
5. A density of 0.60 yields the maximum burn time.

25 reps 500x500

<table>
<tr><td>

Density | Ticks                     
--- | ---
0.05    |       1.52
0.10    |       3.12
0.15    |       4.36
0.20    |       5.32
0.25    |       7.24
0.30    |       10.04
0.35    |       13.40
0.40    |       20.68
0.45    |       28.08
0.50    |       50.56
0.55    |       125.52
0.60    |       1235.96
0.65    |       767.28
0.70    |       669.24
0.75    |       620.04
0.80    |       584.16
0.85    |       559.20
0.90    |       538.08
0.95    |       520.24

</td><td>

Density |       Ticks
---|---
0.55    |       116.56
0.56    |       173.68
0.57    |       222.76
0.58    |       341.64
0.59    |       773.16
0.60    |       1345.36
0.61    |       1095.08
0.62    |       923.24
0.63    |       852.60
0.64    |       804.88

</td></tr> </table>
