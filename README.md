# Sudoku-Java-

### 产生数独终局和解数独

* 简单写一写再改成 C# 或者 C++ (=,=)
* 利用回溯法产生一个数独终局（其实可以手动写一个数独终局）
* 利用数字交换和魔方变换（行列变换）实现数独终局的改变
* 不变换第一行和第一列（不改变学号尾数产生的数字） 也存在 (2×6×6)×(2×6×6)×(8×7×6×5×4×3×2)=209018880 种终局

### Generator
  * generator 初始化
  * generateOne 回溯产生一个数独终局
  * generate 用来递归
  * generateN 产生N个数独终局
  * isValid 判断某个值在 Sudoku board 上的某个位置是否合适
  * swapnum, swapcol, swaprow 数字交换和行列变换
  * assign 数组赋值
  * change 随机进行各种变换
  
### Solution
  * solveSudoku 回溯解决数独问题
  * solve 用来递归
  * isValid 判断某个值在 Sudoku board 上的某个位置是否合适
  * 惊了 回溯会不会太慢了 可以改进 然而leetcode上的做法略不懂啊
  
### FileHandle
  * 读文件和写文件
  * 放到 C# 里解决
