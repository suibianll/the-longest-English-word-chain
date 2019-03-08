计算最长英语单词链
用 C++语言实现一个命令行程序 Wordlist.exe，对于包含有 N 个不同的英语单词的文
本，要求程序可以快速找出最长的能首尾相连的英语单词链，注意每个单词最多使用一
次，且单词大小写不敏感：
其中，单词的定义为：被非英文字符间隔的连续英文字符序列
单词链的定义为：由至少 2 个单词组成，前一单词的尾字母为后一单词的首字母，且不存
在重复单词
例如，给出单词文本为：
Hello WoRld! Softw
are_eng1neer
从文本中可以提取出的单词为(统一转化为小写)：
hello world softw are eng neer
我们对最长的定义分为两种：最多单词数量和最多字母数量。
基本需求 1：计算最多单词数量的单词链（25'）
在命令行中使用 -w 参数加文件名的形式计算最多单词数量的英语单词链，并将结果输出
至文件，例如：
> Wordlist.exe -w absolute_path_of_word_list
程序将从路径中读取单词文本，并将最长单词链输出至与 Wordlist.exe 同目录的
solution.txt 中，每次生成的 txt 文件需要覆盖上次生成的 txt 文件。
假如可能有多组最长的相连英语单词串，选取其中任意一组作为结果即可
程序需要对异常情况进行处理，包括但不限于：文件不存在、文件不合法等，对于上述异
常情况，程序需要向用户返回提示信息
输入示例
Algebra
Apple
Zoo
Elephant
Under
Fox
Dog
Moon
Leaf
Trick
Pseudopseudohypoparathyroidism
输出示例
将结果输出到文件中，每行仅包含一个单词，单词为小写，例如：
algebra
apple
elephant
trick
基本需求 2：计算字母最多的单词链（25'）
在命令行中使用 -c 参数加文件名的形式计算字母最多的英语单词链，并将结果输出至文
件，例如：
> Wordlist.exe -c absolute_path_of_word_list
输出示例
pseudopseudohypoparathyroidism
moon
基本需求 3：指定单词链开头或结尾字母（25'）
在命令行中使用 -h 参数加字母的形式，指定单词链的首字母，例如：
> Wordlist.exe -h e -w absolute_path_of_word_list
输出示例
elephant
trick
在命令行中使用 -t 参数加字母的形式，指定单词链的尾字母，例如：
> Wordlist.exe -t t -w absolute_path_of_word_list
输出示例
algebra
apple
elephant
需要注意的是，-h 和-t 参数允许复合使用，此时需要同时满足首字母和尾字母的条件。
基本需求 4：指定单词链的单词个数（25'）
在命令行中使用 -n 参数加数字的形式，指定单词链的单词个数，要求输出所有满足要求
的单词链个数(第一行)和所有满足要求的单词链(第二行开始每行一个单词，不同单词链之
间用空行间隔)。
输入示例
WoRd
LisT
digiTal
> Wordlist.exe -n 3 -w absolute_path_of_word_list
输出示例
1
word
digital
list
> Wordlist.exe -n 2 -w absolute_path_of_word_list
2
word
digital
digital
list
本需求为性能测试部分主要考察内容，请同学们选取合适的算法并进行优化
附加需求：用户交互界面绘制（10'）
现在已经有了一个单词链计算程序的命令行版本，如果想让大家都能实际使用它，还需要一
个简单的界面。请为你们的程序做一个 GUI 界面，并附上一个简单的使用说明。界面需正
确实现下述功能，会按点给分：
1. 支持两种导入单词文本的方式：①导入单词文本文件，②直接在界面上输入单词
并提交（3'）
2. 提供可供用户交互的按钮和，实现-w -c -h -t -n 这五个参数的功能，对于异
常情况需要给予用户提示（3'）
3. 将结果直接输出到界面上，并提供“导出”按钮，将结果保存到用户指定的位置
（3'）
以上功能全部正确完成，可以获得 10 分满分。
【注意】选择完成本附加题目的同学，需要将 GUI 与单词计算模块作为两个工程开发，后
者可以作为依赖库为前者提供调用接口，但不可以把两个工程直接混在一起。提交作业时在
目录下新建 GUI/路径，将 GUI 相关的内容放在该路径下。